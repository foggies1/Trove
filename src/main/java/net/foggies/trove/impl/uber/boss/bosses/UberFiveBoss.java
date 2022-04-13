package net.foggies.trove.impl.uber.boss.bosses;

import net.foggies.trove.api.TroveBoss;
import org.bukkit.Location;
import org.bukkit.entity.EntityType;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

public class UberFiveBoss extends TroveBoss {

    public UberFiveBoss(Location location) {
        super(
                location,
                "&6&lUber Five",
                250D,
                250D,
                5.0D,
                105.0D,
                16.75D,
                EntityType.SLIME
        );
    }

    @Override
    public void onDamage(EntityDamageByEntityEvent e) {

    }
}
