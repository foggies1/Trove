package net.foggies.trove.impl.uber.boss.bosses;

import net.foggies.trove.api.TroveBoss;
import org.bukkit.Location;
import org.bukkit.entity.EntityType;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

public class UberNineBoss extends TroveBoss {

    public UberNineBoss(Location location) {
        super(
                location,
                "&5&lUber Nine",
                12500D,
                12500D,
                150.0D,
                1000.0D,
                125.0D,
                EntityType.ZOMBIE
        );
    }

    @Override
    public void onDamage(EntityDamageByEntityEvent e) {

    }
}
