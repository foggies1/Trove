package net.foggies.trove.impl.uber.worlds;

import net.foggies.trove.api.BossType;
import net.foggies.trove.api.TroveWorld;
import net.foggies.trove.utils.Cuboid;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;

public class UberTwoWorld extends TroveWorld {

    private static final String WORLD_IDENTIFIER = "UberTwo";
    private static final World WORLD = Bukkit.getWorld(WORLD_IDENTIFIER);

    public UberTwoWorld() {
        super(
                WORLD_IDENTIFIER,
                WORLD,
                new Cuboid(
                        new Location(WORLD, -44, 83, -39),
                        new Location(WORLD, 45, 71, 38)
                ),
                BossType.UBER_TWO
        );
    }

    @Override
    public void onBossSpawn() {

    }
}
