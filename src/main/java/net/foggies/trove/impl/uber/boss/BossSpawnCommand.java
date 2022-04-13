package net.foggies.trove.impl.uber.boss;

import me.lucko.helper.Commands;
import net.foggies.trove.Trove;
import net.foggies.trove.api.TroveWorld;
import net.foggies.trove.impl.uber.registry.TroveWorldRegistry;
import org.bukkit.entity.Player;

public class BossSpawnCommand {

    public BossSpawnCommand(final Trove plugin) {
        final TroveWorldRegistry uberRegistry = plugin.getUberRegistry();

        Commands.create()
                .assertPlayer()
                .handler(c -> {
                    final Player player = c.sender();
                    final TroveWorld uberWorld = uberRegistry.get(player.getWorld().getName());
                    uberWorld.spawnBosses(100);
                })
                .register("spawnboss");

    }
}
