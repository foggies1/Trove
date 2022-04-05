package net.foggies.trove.impl.player.gems;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;
import net.foggies.trove.impl.player.Trovian;
import net.foggies.trove.utils.Number;
import net.milkbowl.vault.economy.Economy;

@RequiredArgsConstructor
@Getter
@ToString
public class CoinRequirement implements GemUpgradeRequirement {

    private final Economy economy;
    private final double amountNeeded;

    @Override
    public boolean hasRequirements(Trovian player) {
        return economy.getBalance(player.toBukkit()) >= amountNeeded;
    }

    @Override
    public void removeRequirements(Trovian player) {
        economy.withdrawPlayer(player.toBukkit(), amountNeeded);
    }

    @Override
    public String getDisplayName() {
        return "$" + Number.pretty(this.amountNeeded) +  " Coin Requirement";
    }

}
