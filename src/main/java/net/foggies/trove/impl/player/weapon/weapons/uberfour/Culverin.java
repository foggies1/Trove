package net.foggies.trove.impl.player.weapon.weapons.uberfour;

import net.foggies.trove.api.TroveBoss;
import net.foggies.trove.api.UberType;
import net.foggies.trove.api.Weapon;
import net.foggies.trove.api.WeaponAttackResult;
import net.foggies.trove.impl.player.trovian.Trovian;
import org.bukkit.event.player.PlayerItemHeldEvent;

import java.util.ArrayList;

public class Culverin extends Weapon {

    public Culverin() {
        super(
                "Culverin",
                "STONE",
                "&5Culverin",
                new ArrayList<>(),
                100.0D,
                10.0D,
                UberType.UBER_FOUR
        );
    }

    @Override
    public WeaponAttackResult onAttack(TroveBoss boss, Trovian trovian) {
        return new WeaponAttackResult(
                53.0D,
                getDamage(),
                7.8D
        );
    }

    @Override
    public void onEquip(PlayerItemHeldEvent e) {

    }
}
