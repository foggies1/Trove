package net.foggies.trove.impl.player.gems.requirements;

import net.foggies.trove.impl.player.trovian.Trovian;

public interface GemUpgradeRequirement  {

    boolean hasRequirements(Trovian player);

    void removeRequirements(Trovian player);

    String getDisplayName();

}
