package net.foggies.trove.api;

import net.foggies.trove.impl.player.Trovian;

import java.io.Serializable;

public interface GemUpgradeRequirement extends Serializable {

    boolean meetsRequirements(Trovian trovian);

    void takeRequirements(Trovian trovian);

    String getRequirement();

}
