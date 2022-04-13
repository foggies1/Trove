package net.foggies.trove.impl.player.gems.commands;

import me.lucko.helper.Commands;
import net.foggies.trove.Trove;
import net.foggies.trove.impl.player.gems.ui.GemUI;
import org.bukkit.entity.Player;

public class GemUICommand {

    public GemUICommand(final Trove plugin) {

        Commands.create()
                .assertPlayer()
                .handler(c -> {
                    final Player player = c.sender();
                    new GemUI(player, plugin).open();
                })
                .register("gems");

    }
}
