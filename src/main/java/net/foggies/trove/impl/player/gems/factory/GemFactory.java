package net.foggies.trove.impl.player.gems.factory;

import lombok.Getter;
import me.lucko.helper.random.RandomSelector;
import net.foggies.trove.Trove;
import net.foggies.trove.impl.player.gems.obj.Gem;
import net.foggies.trove.impl.player.gems.constant.GemRarity;
import net.foggies.trove.impl.player.gems.obj.GemStat;
import net.foggies.trove.impl.player.gems.constant.StatType;
import net.foggies.trove.utils.ItemBuilder;
import net.foggies.trove.utils.Number;
import net.foggies.trove.utils.PDUtils;
import net.foggies.trove.utils.SerializeUtils;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.persistence.PersistentDataType;

import java.io.IOException;
import java.util.Arrays;

@Getter
public class GemFactory {

    private final Trove plugin;

    public GemFactory(Trove plugin) {
        this.plugin = plugin;
    }

    public ItemStack makeGemItem(GemRarity gemRarity) throws IOException {
        Gem gem = makeGem(gemRarity);
        return new ItemBuilder(plugin, Material.BEACON)
                .setAmount(1)
                .setDisplayName(gemRarity.getDisplayName() + " Gem")
                .setLore(
                        gem.getGemLore(plugin)
                )
                .putData("gem", PersistentDataType.STRING, SerializeUtils.toString(gem))
                .addEnchantment(Enchantment.DIG_SPEED, 1)
                .hideFlags(true)
                .makeItem();
    }

    public Gem makeGem(GemRarity gemRarity){
        return new Gem(
                new GemStat(RandomSelector.weighted(Arrays.stream(StatType.values()).toList()).pick(), Number.getRandom(gemRarity.getMin(), gemRarity.getMax())),
                gemRarity
        );
    }

    public boolean isGem(ItemStack itemStack){
        return new PDUtils(plugin, itemStack).has("gem", PersistentDataType.STRING);
    }

    public Gem toGem(ItemStack itemStack) throws IOException, ClassNotFoundException {
        return (Gem) SerializeUtils.fromString(
                new PDUtils(plugin, itemStack).get("gem", PersistentDataType.STRING)
        );
    }

}
