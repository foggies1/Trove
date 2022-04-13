package net.foggies.trove.impl.player.boxes.types;

import me.lucko.helper.random.RandomSelector;
import net.foggies.trove.Trove;
import net.foggies.trove.api.UberType;
import net.foggies.trove.api.Weapon;
import net.foggies.trove.impl.player.boxes.WeaponBox;
import net.foggies.trove.impl.player.trovian.Trovian;
import net.foggies.trove.utils.ItemBuilder;
import net.foggies.trove.utils.PDUtils;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.persistence.PersistentDataType;

import java.io.IOException;

public class WeaponBoxImpl extends WeaponBox {

    public WeaponBoxImpl(Trove plugin) {
        super(plugin);
    }

    @Override
    public void boxOpen(Trovian trovian, ItemStack boxItem) throws IOException {
        final Player player = trovian.toBukkit();

        Weapon weapon = RandomSelector.weighted(getPlugin().getWeaponRegistry().getAllFromUber(
                getBoxUber(boxItem)
        )).pick();

        player.getInventory().addItem(weapon.makeWeapon());
        boxItem.setAmount(boxItem.getAmount() - 1);
    }

    @Override
    public ItemStack makeBox(UberType uberType) throws IOException {
        return new ItemBuilder(getPlugin(), Material.ANVIL)
                .setAmount(1)
                .setDisplayName(uberType.getDisplayName() + " Box")
                .setLore(
                        "&7Right Click while holding to open this Box",
                        "&7and receive a random " + uberType.getDisplayName() + " Item."
                )
                .putData("box", PersistentDataType.STRING, "weapon_box")
                .putData("uber", PersistentDataType.STRING, uberType.name())
                .hideFlags(true)
                .addEnchantment(Enchantment.DIG_SPEED, 1)
                .makeItem();
    }

    private UberType getBoxUber(ItemStack itemStack) {
        return UberType.valueOf(new PDUtils(getPlugin(), itemStack).get("uber", PersistentDataType.STRING));
    }

}
