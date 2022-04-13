package net.foggies.trove.impl.player.gems.commands;

import me.lucko.helper.Commands;
import net.foggies.trove.Trove;
import net.foggies.trove.impl.player.shop.GemBoxShopUI;
import org.bukkit.entity.Player;

public class GemShopUICommand {

    public GemShopUICommand(Trove plugin) {

        Commands.create()
                .assertPlayer()
                .handler(c -> {
                    final Player player = c.sender();
                    new GemBoxShopUI(player, plugin).open();
                })
                .register("boxshop");

    }
}
