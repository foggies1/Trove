package net.foggies.trove.impl.player.gems.constant;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RequiredArgsConstructor
@Getter
public enum GemRarity implements Serializable {

    COMMON("&aCommon", 1, 10, 25, 1, 100),
    RARE("&bRare", 10, 25, 50, 2, 300),
    LEGENDARY("&6Legendary", 25, 50, 100, 3, 500),
    RELIC("&4Relic", 50, 100, 175, 4, 1000),
    SHADOW("&5Shadow", 100, 175, 300, 5, 5000),
    RADIANT("&fRadiant", 175, 300, 500, 6, 10000),
    STELLAR("&eStellar", 300, 500, 750, 7, 100000);

    private final String displayName;
    private final double min;
    private final double max;
    private final double statMax;
    private final double modifier;
    private final double boxCost;

    public static List<String> getNames() {
        List<String> names = new ArrayList<>();
        Arrays.stream(GemRarity.values()).forEach(gemRarity -> names.add(gemRarity.name()));
        return names;
    }

}
