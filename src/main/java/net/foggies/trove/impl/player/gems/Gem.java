package net.foggies.trove.impl.player.gems;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import me.lucko.helper.item.ItemStackBuilder;
import me.lucko.helper.utils.Players;
import net.foggies.trove.Trove;
import net.foggies.trove.impl.player.Trovian;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;

import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

@AllArgsConstructor
@Getter
@ToString
@EqualsAndHashCode
public class Gem implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    private GemStat gemStat;
    private GemRarity gemRarity;

    public boolean upgradeGem(Trove plugin, Trovian trovian) {
        if (!meetsAllRequirements(plugin, trovian)) return false;

        getRequirements(plugin).forEach(requirement -> requirement.removeRequirements(trovian));
        boolean upgraded = gemStat.addPercentage(gemRarity, ThreadLocalRandom.current().nextDouble(5.0D));

        if (!upgraded) Players.msg(trovian.toBukkit(), "&cYou've maxed this Gem!");

        return upgraded;
    }

    public ItemStack toItem(Trove plugin, Trovian trovian) {
        return ItemStackBuilder.of(Material.BEACON)
                .name("&aEquipped Gem")
                .lore(getGemLoreWithRequirements(plugin, trovian))
                .enchant(Enchantment.DIG_SPEED)
                .hideAttributes()
                .build();
    }

    public List<String> getGemLoreWithRequirements(Trove plugin, Trovian trovian) {
        List<String> lore = new ArrayList<>(getGemLore(plugin));
        lore.add("");
        lore.add("&e&lREQUIREMENTS");
        lore.addAll(getRequirementLore(plugin, trovian));
        return lore;
    }

    public List<String> getGemLore(Trove plugin) {
        List<String> lore = new ArrayList<>();
        lore.add("&7This Gem you currently have equipped");
        lore.add("&7is has a rarity of " + gemRarity.getDisplayName());
        lore.add("");
        lore.add("&e&lSTATS");
        lore.add("&7 - &a" + gemStat.toString());
        return lore;
    }

    public List<String> getRequirementLore(Trove plugin, Trovian trovian) {
        List<String> lore = new ArrayList<>();
        getRequirements(plugin).forEach(requirement -> {
            boolean hasRequirements = requirement.hasRequirements(trovian);
            String displayName = hasRequirements ? "&a" + requirement.getDisplayName() : "&c" + requirement.getDisplayName();
            lore.add("&7 - " + displayName);
        });
        return lore;
    }

    public boolean meetsAllRequirements(Trove plugin, Trovian trovian) {
        boolean meets = true;
        for (GemUpgradeRequirement requirement : getRequirements(plugin)) {
            if (!requirement.hasRequirements(trovian)) {
                meets = false;
                break;
            }
        }
        return meets;
    }

    public List<GemUpgradeRequirement> getRequirements(Trove plugin) {
        return new ArrayList<>(
                Arrays.asList(
                        new CoinRequirement(
                                plugin.getEconomy(),
                                100 * ((gemStat.getPercentage() * gemRarity.getModifier()) / gemStat.getType().getWeight())
                        )
                )
        );
    }


}
