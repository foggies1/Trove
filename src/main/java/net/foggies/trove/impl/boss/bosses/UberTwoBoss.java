package net.foggies.trove.impl.boss.bosses;

import net.foggies.trove.api.TroveBoss;
import org.bukkit.Location;
import org.bukkit.entity.EntityType;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

public class UberTwoBoss extends TroveBoss {

    public UberTwoBoss(Location location) {
        super(
                location,
                "&b&lUber Two",
                15D,
                15D,
                0.5,
                15.0D,
                7.5D,
                EntityType.ZOMBIE
        );
    }

    @Override
    public void onDamage(EntityDamageByEntityEvent e) {

    }
}
