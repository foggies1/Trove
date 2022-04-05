package net.foggies.trove.impl.player.skills;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum SkillType {

    COMBAT("Combat Skill"),
    MINING("Mining Skill"),
    FARMING("Farming Skill"),
    TREE_CHOPPING("Tree Chopping Skill");

    private final String prefix;

}
