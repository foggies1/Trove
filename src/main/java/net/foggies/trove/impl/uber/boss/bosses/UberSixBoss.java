package net.foggies.trove.impl.uber.boss.bosses;

import net.foggies.trove.api.TroveBoss;
import org.bukkit.Location;
import org.bukkit.entity.EntityType;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

public class UberSixBoss extends TroveBoss {

    public UberSixBoss(Location location) {
        super(
                location,
                "&2&lUber Six",
                550D,
                550D,
                7.5D,
                150.0D,
                20.0D,
                EntityType.SLIME
        );
    }

    @Override
    public void onDamage(EntityDamageByEntityEvent e) {

    }
}
