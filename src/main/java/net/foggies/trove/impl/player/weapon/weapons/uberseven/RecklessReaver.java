package net.foggies.trove.impl.player.weapon.weapons.uberseven;

import net.foggies.trove.api.TroveBoss;
import net.foggies.trove.api.UberType;
import net.foggies.trove.api.Weapon;
import net.foggies.trove.api.WeaponAttackResult;
import net.foggies.trove.impl.player.trovian.Trovian;
import org.bukkit.event.player.PlayerItemHeldEvent;

import java.util.ArrayList;

public class RecklessReaver extends Weapon {

    public RecklessReaver() {
        super(
                "Reckless Reaver",
                "STONE",
                "&dReckless Reaver",
                new ArrayList<>(),
                950.0D,
                20.0D,
                UberType.UBER_SEVEN
        );
    }

    @Override
    public WeaponAttackResult onAttack(TroveBoss boss, Trovian trovian) {
        return new WeaponAttackResult(
                120.0D,
                getDamage(),
                16.9D
        );
    }

    @Override
    public void onEquip(PlayerItemHeldEvent e) {

    }
}
