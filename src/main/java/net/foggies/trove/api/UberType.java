package net.foggies.trove.api;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import net.foggies.trove.impl.uber.boss.bosses.*;
import org.bukkit.Location;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RequiredArgsConstructor
@Getter
public enum UberType {

    UBER_ONE("&aUber 1"),
    UBER_TWO("&bUber 2"),
    UBER_THREE("&cUber 3"),
    UBER_FOUR("&dUber 4"),
    UBER_FIVE("&6Uber 5"),
    UBER_SIX("&2Uber 6"),
    UBER_SEVEN("&1Uber 7"),
    UBER_EIGHT("&9Uber 8"),
    UBER_NINE("&5Uber 9");

    private final String displayName;

    public static List<String> getNames() {
        List<String> names = new ArrayList<>();
        Arrays.stream(UberType.values()).forEach(uberType -> names.add(uberType.name()));
        return names;
    }

    public TroveBoss toTroveBoss(Location location) {
        switch (this) {
            case UBER_ONE -> {
                return new UberOneBoss(location);
            }
            case UBER_TWO -> {
                return new UberTwoBoss(location);
            }
            case UBER_THREE -> {
                return new UberThreeBoss(location);
            }
            case UBER_FOUR -> {
                return new UberFourBoss(location);
            }
            case UBER_FIVE -> {
                return new UberFiveBoss(location);
            }
            case UBER_SIX -> {
                return new UberSixBoss(location);
            }
            case UBER_SEVEN -> {
                return new UberSevenBoss(location);
            }
            case UBER_EIGHT -> {
                return new UberEightBoss(location);
            }
            case UBER_NINE -> {
                return new UberNineBoss(location);
            }
        }
        return null;
    }

}
