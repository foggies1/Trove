package net.foggies.trove.impl.player.weapon.weapons.uberfour;

import net.foggies.trove.api.TroveBoss;
import net.foggies.trove.api.UberType;
import net.foggies.trove.api.Weapon;
import net.foggies.trove.api.WeaponAttackResult;
import net.foggies.trove.impl.player.trovian.Trovian;
import org.bukkit.event.player.PlayerItemHeldEvent;

import java.util.ArrayList;

public class BigBertha extends Weapon {

    public BigBertha() {
        super(
                "Big Bertha",
                "STONE",
                "&5Big Bertha",
                new ArrayList<>(),
                77.5D,
                15.0D,
                UberType.UBER_FOUR
        );
    }

    @Override
    public WeaponAttackResult onAttack(TroveBoss boss, Trovian trovian) {
        return new WeaponAttackResult(
                50.0D,
                getDamage(),
                7.3D
        );
    }

    @Override
    public void onEquip(PlayerItemHeldEvent e) {

    }
}
