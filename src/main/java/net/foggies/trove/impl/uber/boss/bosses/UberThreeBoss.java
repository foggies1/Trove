package net.foggies.trove.impl.uber.boss.bosses;

import net.foggies.trove.api.TroveBoss;
import org.bukkit.Location;
import org.bukkit.entity.EntityType;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

public class UberThreeBoss extends TroveBoss {

    public UberThreeBoss(Location location) {
        super(
                location,
                "&c&lUber Three",
                35D,
                35D,
                1.5D,
                25.0D,
                10.5D,
                EntityType.DROWNED
        );
    }

    @Override
    public void onDamage(EntityDamageByEntityEvent e) {

    }
}
