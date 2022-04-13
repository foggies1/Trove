package net.foggies.trove.impl.uber.boss.bosses;

import net.foggies.trove.api.TroveBoss;
import org.bukkit.Location;
import org.bukkit.entity.EntityType;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

public class UberEightBoss extends TroveBoss {

    public UberEightBoss(Location location) {
        super(
                location,
                "&9&lUber Eight",
                5000D,
                5000D,
                50.0D,
                500.0D,
                75.75D,
                EntityType.ZOMBIE
        );
    }

    @Override
    public void onDamage(EntityDamageByEntityEvent e) {

    }
}
