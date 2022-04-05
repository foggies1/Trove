package net.foggies.trove.impl.player;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class TrovianStat {

    private double amount;

    public void add(double amount) {
        setAmount(getAmount() + amount);
    }

    public void take(double amount) {
        if (getAmount() - amount < 0) amount = getAmount();
        setAmount(getAmount() - amount);
    }

}
