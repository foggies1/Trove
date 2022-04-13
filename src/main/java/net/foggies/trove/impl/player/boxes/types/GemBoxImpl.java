package net.foggies.trove.impl.player.boxes.types;

import net.foggies.trove.Trove;
import net.foggies.trove.impl.player.boxes.GemBox;
import net.foggies.trove.impl.player.gems.constant.GemRarity;
import net.foggies.trove.impl.player.trovian.Trovian;
import net.foggies.trove.utils.ItemBuilder;
import net.foggies.trove.utils.PDUtils;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.persistence.PersistentDataType;

import java.io.IOException;

public class GemBoxImpl extends GemBox {

    public GemBoxImpl(Trove plugin) {
        super(plugin);
    }

    @Override
    public void boxOpen(Trovian trovian, ItemStack boxItem) throws IOException {
        final Player player = trovian.toBukkit();
        player.getInventory().addItem(getPlugin().getGemFactory().makeGemItem(getGemRarity(boxItem)));
        boxItem.setAmount(boxItem.getAmount() - 1);
    }

    @Override
    public ItemStack makeBox(GemRarity gemRarity) throws IOException {
        return new ItemBuilder(getPlugin(), Material.HOPPER)
                .setAmount(1)
                .setDisplayName(gemRarity.getDisplayName() + " Box")
                .setLore(
                        "&7Right Click while holding to open this Box",
                        "&7and receive a random Gem."
                )
                .putData("box", PersistentDataType.STRING, "gem_box")
                .putData("gem_rarity", PersistentDataType.STRING, gemRarity.name())
                .hideFlags(true)
                .addEnchantment(Enchantment.DIG_SPEED, 1)
                .makeItem();
    }

    private GemRarity getGemRarity(ItemStack itemStack){
        return GemRarity.valueOf(new PDUtils(getPlugin(), itemStack).get("gem_rarity", PersistentDataType.STRING));
    }

}
