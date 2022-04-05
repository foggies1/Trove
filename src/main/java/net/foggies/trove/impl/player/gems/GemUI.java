package net.foggies.trove.impl.player.gems;

import me.lucko.helper.item.ItemStackBuilder;
import me.lucko.helper.menu.Gui;
import me.lucko.helper.menu.scheme.MenuPopulator;
import me.lucko.helper.menu.scheme.MenuScheme;
import me.lucko.helper.utils.Players;
import net.foggies.trove.Trove;
import net.foggies.trove.impl.player.Trovian;
import org.bukkit.Material;
import org.bukkit.entity.Player;

public class GemUI extends Gui {

    private final Trove plugin;
    private final Trovian trovian;

    public GemUI(Player player, Trove plugin) {
        super(player, 5, "&eGems");
        this.plugin = plugin;
        this.trovian = plugin.getTrovianRegistry().get(player.getUniqueId());
    }

    private static final MenuScheme GEMS = new MenuScheme()
            .mask("000000000")
            .mask("011111110")
            .mask("011111110")
            .mask("001101100")
            .mask("000000000");

    private static final MenuScheme OUTLINE = new MenuScheme()
            .mask("111111111")
            .mask("100000001")
            .mask("100000001")
            .mask("110010011")
            .mask("111111111");

    @Override
    public void redraw() {
        final MenuPopulator outlinePopulator = new MenuPopulator(this, OUTLINE);
        final MenuPopulator gemPopulator = new MenuPopulator(this, GEMS);

        outlinePopulator.getSlots().forEach(slot -> outlinePopulator.accept(ItemStackBuilder.of(Material.GRAY_STAINED_GLASS_PANE).buildItem().build()));
        trovian.getGemData().getGemList().forEach(gem -> {
            gemPopulator.accept(
                    ItemStackBuilder.of(gem.toItem(plugin, trovian))
                            .build(() -> {
                                trovian.getGemData().removeGem(gem);
                                redraw();
                            }, () -> {
                                boolean upgraded = gem.upgradeGem(plugin, trovian);
                                if(!upgraded){
                                    Players.msg(getPlayer(), "&cGem was not upgraded as you did not meet requirements or have maxed this Gem.");
                                    return;
                                }

                                Players.msg(getPlayer(), "&aSuccessfully upgraded your Gem!");
                                redraw();
                            })
            );
        });

    }
}
