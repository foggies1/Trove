package net.foggies.trove.impl.player.shop;

import me.lucko.helper.item.ItemStackBuilder;
import me.lucko.helper.menu.Gui;
import me.lucko.helper.menu.scheme.MenuPopulator;
import me.lucko.helper.menu.scheme.MenuScheme;
import me.lucko.helper.utils.Players;
import net.foggies.trove.Trove;
import net.foggies.trove.impl.player.boxes.BoxRegistry;
import net.foggies.trove.impl.player.boxes.GemBox;
import net.foggies.trove.impl.player.gems.constant.GemRarity;
import net.foggies.trove.utils.Number;
import net.milkbowl.vault.economy.Economy;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;

import java.io.IOException;
import java.util.Arrays;

public class GemBoxShopUI extends Gui {

    private final Trove plugin;
    private final Economy economy;
    private final BoxRegistry boxRegistry;

    public GemBoxShopUI(Player player, Trove plugin) {
        super(player, 5, "&aGem Box Store");
        this.plugin = plugin;
        this.economy = plugin.getEconomy();
        this.boxRegistry = plugin.getBoxRegistry();
    }

    private static final MenuScheme OUTLINE = new MenuScheme()
            .mask("111111111")
            .mask("110010011")
            .mask("111111111")
            .mask("111000111")
            .mask("111111111");

    private static final MenuScheme BOXES = new MenuScheme()
            .mask("000000000")
            .mask("001101100")
            .mask("000000000")
            .mask("000111000")
            .mask("000000000");

    @Override
    public void redraw() {
        final MenuPopulator outlinePopulator = new MenuPopulator(this, OUTLINE);
        final MenuPopulator boxPopulator = new MenuPopulator(this, BOXES);

        outlinePopulator.getSlots().forEach(slot -> outlinePopulator.accept(ItemStackBuilder.of(Material.YELLOW_STAINED_GLASS_PANE).buildItem().build()));
        Arrays.stream(GemRarity.values()).forEach(rarity -> {
            boxPopulator.accept(
                    ItemStackBuilder.of(Material.HOPPER)
                            .name(rarity.getDisplayName() + " Box")
                            .lore(
                                    "&7Click here to purchase a Box.",
                                    "",
                                    "&aCost: $" + Number.pretty(rarity.getBoxCost())
                            )
                            .enchant(Enchantment.DIG_SPEED)
                            .hideAttributes()
                            .build(() -> {
                                final Player player = getPlayer();

                                if (this.economy.getBalance(player) < rarity.getBoxCost()) {
                                    Players.msg(player, "&cYou do not have enough Coins to purchase this.");
                                    return;
                                }

                                try {
                                    player.getInventory().addItem(((GemBox) this.boxRegistry.getBox("gem_box")).makeBox(rarity));
                                } catch (IOException e) {
                                    e.printStackTrace();
                                }

                                this.economy.withdrawPlayer(player, rarity.getBoxCost());
                                Players.msg(player, "&aYou've successfully purchased a " + rarity.getDisplayName() + " Box&a.");
                            })
            );
        });

    }
}
