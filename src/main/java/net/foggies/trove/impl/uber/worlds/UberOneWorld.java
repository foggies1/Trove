package net.foggies.trove.impl.uber.worlds;

import net.foggies.trove.api.BossType;
import net.foggies.trove.api.TroveWorld;
import net.foggies.trove.utils.Cuboid;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;

public class UberOneWorld extends TroveWorld {

    private static final String WORLD_IDENTIFIER = "UberOne";
    private static final World WORLD = Bukkit.getWorld(WORLD_IDENTIFIER);

    public UberOneWorld() {
        super(
                WORLD_IDENTIFIER,
                WORLD,
                new Cuboid(
                        new Location(WORLD, -56, 77, -60),
                        new Location(WORLD, 56, 66, 59)
                ),
                BossType.UBER_ONE
        );
    }

    @Override
    public void onBossSpawn() {

    }
}
