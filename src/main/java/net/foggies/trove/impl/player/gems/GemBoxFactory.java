package net.foggies.trove.impl.player.gems;

import net.foggies.trove.Trove;
import net.foggies.trove.utils.ItemBuilder;
import net.foggies.trove.utils.PDUtils;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.persistence.PersistentDataType;

import java.io.IOException;

public class GemBoxFactory {

    private final Trove plugin;
    private final GemFactory gemFactory;

    public GemBoxFactory(GemFactory gemFactory) {
        this.plugin = gemFactory.getPlugin();
        this.gemFactory = gemFactory;
    }

    public ItemStack makeBox(GemRarity gemRarity) {
        return new ItemBuilder(plugin, Material.HOPPER)
                .setAmount(1)
                .setDisplayName(gemRarity.getDisplayName() + " Box")
                .setLore(
                        "&7Right Click while holding to open this Box",
                        "&7and receive a random Gem."
                )
                .putData("gem_box", PersistentDataType.STRING, gemRarity.name())
                .hideFlags(true)
                .addEnchantment(Enchantment.DIG_SPEED, 1)
                .makeItem();
    }

    public ItemStack openBox(ItemStack itemStack) throws IOException {
        return gemFactory.makeGemItem(getBoxRarity(itemStack));
    }

    public GemRarity getBoxRarity(ItemStack itemStack){
        return GemRarity.valueOf(new PDUtils(plugin, itemStack).get("gem_box", PersistentDataType.STRING));
    }

    public boolean isGemBox(ItemStack itemStack){
        return new PDUtils(plugin, itemStack).has("gem_box", PersistentDataType.STRING);
    }


}
