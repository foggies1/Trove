package net.foggies.trove.impl.player.weapon.weapons.uberfour;

import net.foggies.trove.api.TroveBoss;
import net.foggies.trove.api.UberType;
import net.foggies.trove.api.Weapon;
import net.foggies.trove.api.WeaponAttackResult;
import net.foggies.trove.impl.player.trovian.Trovian;
import org.bukkit.event.player.PlayerItemHeldEvent;

import java.util.ArrayList;

public class Gatling extends Weapon {

    public Gatling() {
        super(
                "Gatling",
                "STONE",
                "&5Gatling",
                new ArrayList<>(),
                50.0D,
                25.0D,
                UberType.UBER_FOUR
        );
    }

    @Override
    public WeaponAttackResult onAttack(TroveBoss boss, Trovian trovian) {
        return new WeaponAttackResult(
                37.0D,
                getDamage(),
                6.3D
        );
    }

    @Override
    public void onEquip(PlayerItemHeldEvent e) {

    }
}
