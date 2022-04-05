package net.foggies.trove.impl.boss.bosses;

import net.foggies.trove.api.TroveBoss;
import org.bukkit.Location;
import org.bukkit.entity.EntityType;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

public class UberOneBoss extends TroveBoss {

    public UberOneBoss(Location location) {
        super(
                location,
                "&a&lUber One",
                7.5D,
                7.5D,
                0.25,
                5.0D,
                5.0D,
                EntityType.SKELETON
        );
    }

    @Override
    public void onDamage(EntityDamageByEntityEvent e) {

    }
}
