package net.foggies.trove.impl.uber.boss.bosses;

import net.foggies.trove.api.TroveBoss;
import org.bukkit.Location;
import org.bukkit.entity.EntityType;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

public class UberSevenBoss extends TroveBoss {

    public UberSevenBoss(Location location) {
        super(
                location,
                "&1&lUber Seven",
                1250D,
                1250D,
                10.0D,
                250.0D,
                25.0D,
                EntityType.SLIME
        );
    }

    @Override
    public void onDamage(EntityDamageByEntityEvent e) {

    }
}
