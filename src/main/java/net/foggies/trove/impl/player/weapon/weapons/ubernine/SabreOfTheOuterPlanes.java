package net.foggies.trove.impl.player.weapon.weapons.ubernine;

import net.foggies.trove.api.TroveBoss;
import net.foggies.trove.api.UberType;
import net.foggies.trove.api.Weapon;
import net.foggies.trove.api.WeaponAttackResult;
import net.foggies.trove.impl.player.trovian.Trovian;
import org.bukkit.event.player.PlayerItemHeldEvent;

import java.util.ArrayList;

public class SabreOfTheOuterPlanes extends Weapon {

    public SabreOfTheOuterPlanes() {
        super(
                "Sabre Of The Outer Planes",
                "STONE",
                "&2Sabre Of The Outer Planes",
                new ArrayList<>(),
                40000.0D,
                5.0D,
                UberType.UBER_NINE
        );
    }

    @Override
    public WeaponAttackResult onAttack(TroveBoss boss, Trovian trovian) {
        return new WeaponAttackResult(
                300.0D,
                getDamage(),
                27.5D
        );
    }

    @Override
    public void onEquip(PlayerItemHeldEvent e) {

    }
}
