package net.foggies.trove.impl.player.gems;

import me.lucko.helper.Commands;
import net.foggies.trove.Trove;
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
