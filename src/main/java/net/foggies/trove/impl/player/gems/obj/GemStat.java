package net.foggies.trove.impl.player.gems.obj;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import net.foggies.trove.impl.player.gems.constant.GemRarity;
import net.foggies.trove.impl.player.gems.constant.StatType;
import net.foggies.trove.utils.Number;

import java.io.Serial;
import java.io.Serializable;

@AllArgsConstructor
@Getter
@Setter
public class GemStat implements Serializable {

    @Serial
    private static final long serialVersionUID = 42L;

    private StatType type;
    private double percentage;

    public boolean addPercentage(GemRarity gemRarity, double amount){

        final double statMax = gemRarity.getStatMax();

        if(getPercentage() == statMax) return false;
        if(getPercentage() + amount > statMax) amount = statMax - getPercentage();
        setPercentage(getPercentage() + amount);

        return true;
    }

    public String toString(){
        return Number.pretty(percentage) + "% " + type.getDisplayName();
    }

}
