package net.foggies.trove.impl.player.gems.obj;

import lombok.AllArgsConstructor;
import lombok.Getter;
import net.foggies.trove.impl.player.gems.constant.StatType;
import net.foggies.trove.utils.Number;

import java.util.List;

@AllArgsConstructor
@Getter
public class GemData {

    private final int MAX_GEMS = 18;
    private List<Gem> gemList;

    public boolean addGem(Gem gem) {
        if (gemList.size() == MAX_GEMS) return false;
        gemList.add(gem);
        return true;
    }

    public void removeGem(Gem gem) {
        gemList.remove(gem);
    }

    public double calculate(StatType statType, double original) {
        return Number.calculatePercentage(original, getStatPercentage(statType));
    }

    public double getStatPercentage(StatType statType) {
        if (!hasStat(statType)) return 0.0D;
        return gemList.stream().filter(gem -> gem.getGemStat().getType() == statType).mapToDouble(gem -> gem.getGemStat().getPercentage()).sum();
    }

    public boolean hasStat(StatType statType) {
        return gemList.stream().anyMatch(gem -> gem.getGemStat().getType() == statType);
    }

}
