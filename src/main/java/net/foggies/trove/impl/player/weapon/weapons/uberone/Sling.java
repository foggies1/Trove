package net.foggies.trove.impl.player.weapon.weapons.uberone;

import net.foggies.trove.api.TroveBoss;
import net.foggies.trove.api.UberType;
import net.foggies.trove.api.Weapon;
import net.foggies.trove.api.WeaponAttackResult;
import net.foggies.trove.impl.player.trovian.Trovian;
import org.bukkit.event.player.PlayerItemHeldEvent;

import java.util.ArrayList;

public class Sling extends Weapon {

    public Sling() {
        super(
                "Sling",
                "STONE",
                "&aSling",
                new ArrayList<>(),
                5.25D,
                3.0D,
                UberType.UBER_ONE
        );
    }

    @Override
    public WeaponAttackResult onAttack(TroveBoss boss, Trovian trovian) {
        return new WeaponAttackResult(
                10.0D,
                getDamage(),
                2.0D
        );
    }

    @Override
    public void onEquip(PlayerItemHeldEvent e) {

    }
}
