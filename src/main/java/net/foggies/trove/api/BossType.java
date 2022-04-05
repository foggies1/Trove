package net.foggies.trove.api;

import net.foggies.trove.impl.boss.bosses.UberOneBoss;
import net.foggies.trove.impl.boss.bosses.UberTwoBoss;
import org.bukkit.Location;

public enum BossType {

    UBER_ONE(),
    UBER_TWO();


    public TroveBoss toTroveBoss(Location location) {
        switch (this) {
            case UBER_ONE -> {
                return new UberOneBoss(location);
            }
            case UBER_TWO -> {
                return new UberTwoBoss(location);
            }
        }
        return null;
    }

}
