package net.foggies.trove.impl.boss.data;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import net.foggies.trove.api.TroveBoss;

@RequiredArgsConstructor
@Getter
public class BossInfo {

    private final TroveBoss parent;
    private final double baseCoins;
    private final double baseDamage;
    private final double baseExperience;

}
