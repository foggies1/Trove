package net.foggies.trove.impl.uber.boss.bosses;

import net.foggies.trove.api.TroveBoss;
import org.bukkit.Location;
import org.bukkit.entity.EntityType;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

public class UberFourBoss extends TroveBoss {

    public UberFourBoss(Location location) {
        super(
                location,
                "&d&lUber Four",
                100D,
                100D,
                3.0D,
                65.0D,
                13.75D,
                EntityType.PIGLIN
        );
    }

    @Override
    public void onDamage(EntityDamageByEntityEvent e) {

    }
}
