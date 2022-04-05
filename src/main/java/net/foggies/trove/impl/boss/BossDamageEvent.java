package net.foggies.trove.impl.boss;

import com.google.gson.GsonBuilder;
import net.foggies.trove.Trove;
import net.foggies.trove.api.TroveBoss;
import net.foggies.trove.api.TroveWorld;
import net.foggies.trove.impl.player.Trovian;
import net.foggies.trove.impl.player.gems.StatType;
import net.foggies.trove.impl.player.registry.TrovianRegistry;
import net.foggies.trove.impl.player.skills.SkillType;
import net.foggies.trove.impl.uber.registry.TroveWorldRegistry;
import net.foggies.trove.utils.HologramUtils;
import net.kyori.adventure.text.Component;
import net.milkbowl.vault.economy.Economy;
import org.bukkit.Bukkit;
import org.bukkit.NamespacedKey;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityCombustEvent;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.persistence.PersistentDataType;

public class BossDamageEvent implements Listener {

    private final Trove plugin;
    private final TroveWorldRegistry uberRegistry;
    private final TrovianRegistry trovianRegistry;
    private final Economy economy;

    public BossDamageEvent(Trove plugin) {
        this.plugin = plugin;
        this.economy = plugin.getEconomy();
        this.trovianRegistry = plugin.getTrovianRegistry();
        this.uberRegistry = plugin.getUberRegistry();
    }

    @EventHandler
    public void onCombust(EntityCombustEvent e) {
        e.setCancelled(true);
    }

    @EventHandler
    public void onDamage(EntityDamageByEntityEvent e) {
        Entity damagedEntity = e.getEntity();
        Entity damager = e.getDamager();
        double damage = e.getDamage();
        TroveWorld troveWorld = this.uberRegistry.get(damagedEntity.getWorld().getName());


        if (isPlayer(damagedEntity)) { // Checks if the damaged Entity is a Player

            e.setCancelled(true);

            if (isArrow(damager)) { // Checks if the entity that damaged the player was an Arrow.

                final Arrow arrow = (Arrow) damager;
                final Entity arrowShooter = (Entity) arrow.getShooter(); // Gets the shooter of the arrow.

                if (!isBoss(arrowShooter)) return; // Checks if the entity that shot the arrow is a Boss.

                final TroveBoss boss = troveWorld.getBoss(arrowShooter); // Converts the shooter into a boss.
                damage = boss.getBossInfo().getBaseDamage();

            } else if (isBoss(damager)) {

                final TroveBoss boss = troveWorld.getBoss(damager);
                damage = boss.getBossInfo().getBaseDamage();

            }

            final Player player = (Player) damagedEntity;
            player.damage(damage);

        } else if (isBoss(damagedEntity)) {

            if (isPlayer(damager)) {

                e.setCancelled(true);

                final Player player = (Player) damager;
                final Trovian trovian = this.trovianRegistry.get(player.getUniqueId());
                damage = trovian.getGemData().calculate(StatType.DAMAGE, damage);

                final TroveBoss boss = troveWorld.getBoss(damagedEntity);
                final double coinsReceived = trovian.getGemData().calculate(StatType.COINS, boss.getBossInfo().getBaseCoins());
                final double experienceGained = trovian.getGemData().calculate(StatType.EXPERIENCE, boss.getBossInfo().getBaseExperience());
                boss.onDamage(e);

                boolean isDead = boss.getBossHealth().takeHealth(damage);

                if (isDead) {


                    this.economy.depositPlayer(player, coinsReceived);
                    trovian.getTrovianStats().getDamageDealt().add(damage);
                    trovian.getTrovianStats().getBossesKilled().add(1L);
                    trovian.getTrovianStats().getCoinsGained().add(coinsReceived);
                    trovian.getSkillData().getSkill(SkillType.COMBAT).addExperience(player, experienceGained);

                    Bukkit.broadcast(
                            Component.text(
                                    new GsonBuilder().setPrettyPrinting().create().toJson(trovian)
                            )
                    );

                    troveWorld.removeBoss(boss);
                    HologramUtils.spawnHologram(boss.getBossesCurrentLocation(), "&2" + economy.format(coinsReceived));
                }

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
