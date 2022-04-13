package net.foggies.trove.impl.player.gems.constant;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import me.lucko.helper.random.Weighted;

import java.io.Serializable;

@RequiredArgsConstructor
@Getter
public enum StatType implements Weighted, Serializable {

    COINS("Coins", 1),
    EXPERIENCE("Skill Exp", 10),
    DAMAGE("Physical Damage", 5);

    private final String displayName;
    private final double weight;

}
