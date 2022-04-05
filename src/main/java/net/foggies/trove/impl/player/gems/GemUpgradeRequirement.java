package net.foggies.trove.impl.player.gems;

import net.foggies.trove.impl.player.Trovian;

public interface GemUpgradeRequirement  {

    boolean hasRequirements(Trovian player);

    void removeRequirements(Trovian player);

    String getDisplayName();

}
