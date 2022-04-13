package net.foggies.trove.impl.uber.boss;

import net.foggies.trove.Trove;
import net.foggies.trove.api.TroveBoss;
import net.foggies.trove.api.TroveWorld;
import net.foggies.trove.api.Weapon;
import net.foggies.trove.api.WeaponAttackResult;
import net.foggies.trove.impl.player.gems.constant.StatType;
import net.foggies.trove.impl.player.registry.TrovianRegistry;
import net.foggies.trove.impl.player.skills.SkillType;
import net.foggies.trove.impl.player.trovian.Trovian;
import net.foggies.trove.impl.player.weapon.WeaponRegistry;
import net.foggies.trove.impl.uber.registry.TroveWorldRegistry;
import net.foggies.trove.utils.HologramUtils;
import net.foggies.trove.utils.StringUtils;
import net.kyori.adventure.text.Component;
import net.milkbowl.vault.economy.Economy;
import org.bukkit.Bukkit;
import org.bukkit.EntityEffect;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityCombustEvent;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.persistence.PersistentDataType;

import java.util.List;

public class BossDamageEvent implements Listener {

    private final Trove plugin;
    private final TroveWorldRegistry uberRegistry;
    private final TrovianRegistry trovianRegistry;
    private final WeaponRegistry weaponRegistry;
    private final Economy economy;

    public BossDamageEvent(Trove plugin) {
        this.plugin = plugin;
        this.economy = plugin.getEconomy();
        this.trovianRegistry = plugin.getTrovianRegistry();
        this.uberRegistry = plugin.getUberRegistry();
        this.weaponRegistry = plugin.getWeaponRegistry();
    }

    @EventHandler
    public void onCombust(EntityCombustEvent e) {
        e.setCancelled(true);
    }

    @EventHandler
    public void onEntityDeath(EntityDeathEvent e) {
        if (e.getEntity() instanceof Player player) {
            List<ItemStack> items = e.getDrops();
            items.forEach(item -> player.getInventory().addItem(item));
            e.getDrops().forEach(drop -> drop.setAmount(0));
        }
    }

    @EventHandler
    public void onDamage(EntityDamageByEntityEvent e) {
        Entity damagedEntity = e.getEntity();
        Entity damager = e.getDamager();
        double damage = e.getDamage();

        final String worldName = damagedEntity.getWorld().getName();

        if (!uberRegistry.isTroveWorld(worldName)) return;
        TroveWorld troveWorld = this.uberRegistry.get(worldName);

        e.setCancelled(true);

        // Handles the Damaging of a Boss
        if (damagedEntity instanceof Player player) {

            Trovian trovian = this.trovianRegistry.get(player.getUniqueId());
            TroveBoss troveBoss = damager instanceof Arrow arrow
                    ? troveWorld.getBoss((Entity) arrow.getShooter())
                    : troveWorld.getBoss(damager);

            boolean isKilled = trovian.getTrovianHealth().takeCurrentHealth(troveBoss.getBossInfo().getBaseDamage());
            player.playEffect(EntityEffect.HURT);

            if (isKilled) {
                Bukkit.broadcast(Component.text(StringUtils.color("&c" + player.getName() + " was killed by a " + troveBoss.getName())));
                player.setHealth(0.0D);
                player.playEffect(EntityEffect.ENTITY_POOF);
            }

        } else if (damager instanceof Player player && isBoss(damagedEntity)) {

            ItemStack itemInHand = player.getInventory().getItemInMainHand();
            WeaponAttackResult attackResult = null;

            final Trovian trovian = this.trovianRegistry.get(player.getUniqueId());
            final TroveBoss troveBoss = troveWorld.getBoss(damagedEntity);
            double coinsGained = trovian.getGemData().calculate(StatType.COINS, troveBoss.getBossInfo().getBaseCoins());
            double experienceGained = trovian.getGemData().calculate(StatType.EXPERIENCE, troveBoss.getBossInfo().getBaseExperience());
            double damageDealt = trovian.getGemData().calculate(StatType.DAMAGE, damage);

            final boolean hasWeapon = (itemInHand.getType() != Material.AIR) || (this.weaponRegistry.isWeapon(itemInHand));

            if (hasWeapon) {
                final Weapon weapon = this.weaponRegistry.getWeapon(itemInHand);
                attackResult = weapon.onAttack(troveBoss, trovian);
                damageDealt += attackResult.damage();
            }

            final boolean bossIsDead = troveBoss.getBossHealth().takeHealth(damageDealt);

            if (bossIsDead) {

                if (attackResult != null) {
                    coinsGained += attackResult.coins();
                    experienceGained += attackResult.experience();
                }

                this.economy.depositPlayer(player, coinsGained);
                trovian.getTrovianStats().getCoinsGained().add(coinsGained);
                trovian.getTrovianStats().getDamageDealt().add(damageDealt);
                trovian.getSkillData().getSkill(SkillType.COMBAT).addExperience(player, experienceGained);
                trovian.getTrovianStats().getBossesKilled().add(1L);

                troveWorld.removeBoss(troveBoss);
                HologramUtils.spawnHologram(damagedEntity.getLocation(), "&2" + this.economy.format(coinsGained));
            }

        }


    }

    private boolean isArrow(Entity entity) {
        return entity instanceof Arrow;
    }

    private boolean isPlayer(Entity entity) {
        return entity instanceof Player;
    }

    private boolean isBoss(Entity entity) {
        return entity.getPersistentDataContainer().has(
                new NamespacedKey(plugin, "boss"),
                PersistentDataType.STRING
        );
    }

}
