package net.foggies.trove.impl.player.skills;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Map;

@AllArgsConstructor
@Getter
public class SkillData {

    private Map<SkillType, Skill> skillMap;

    public Skill getSkill(SkillType skillType){
        return this.skillMap.get(skillType);
    }

    public double getLevel(SkillType skillType) {
        return this.skillMap.get(skillType).getCurrentLevel();
    }

}
