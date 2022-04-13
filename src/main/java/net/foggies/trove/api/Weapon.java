package net.foggies.trove.api;

import lombok.AllArgsConstructor;
import lombok.Getter;
import me.lucko.helper.random.Weighted;
import net.foggies.trove.Trove;
import net.foggies.trove.impl.player.trovian.Trovian;
import net.foggies.trove.utils.ItemBuilder;
import net.foggies.trove.utils.Number;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.event.player.PlayerItemHeldEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.persistence.PersistentDataType;

import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Getter
public abstract class Weapon implements Serializable, Weighted {

    @Serial
    private static final long serialVersionUID = 1L;
    private final String identifier;
    private final String itemMaterial;
    private final String displayName;
    private final List<String> lore;
    private final double damage;
    private final double weight;
    private final UberType uberType;

    public ItemStack makeWeapon() {

        List<String> lore = new ArrayList<>();
        lore.add("&ePhysical Damage: " + Number.pretty(damage));
        lore.add("");
        lore.addAll(this.lore);

        return new ItemBuilder(Trove.getPlugin(), itemMaterial)
                .setAmount(1)
                .setDisplayName(this.displayName)
                .setLore(lore)
                .addEnchantment(Enchantment.DIG_SPEED, 1)
                .putData("weapon", PersistentDataType.STRING, this.identifier)
                .hideFlags(true)
                .makeItem();
    }

    public abstract WeaponAttackResult onAttack(TroveBoss boss, Trovian trovian);

    public abstract void onEquip(PlayerItemHeldEvent e);


}
