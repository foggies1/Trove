package net.foggies.trove.impl.player.weapon.weapons.ubertwo;

import net.foggies.trove.api.TroveBoss;
import net.foggies.trove.api.UberType;
import net.foggies.trove.api.Weapon;
import net.foggies.trove.api.WeaponAttackResult;
import net.foggies.trove.impl.player.trovian.Trovian;
import org.bukkit.event.player.PlayerItemHeldEvent;

import java.util.ArrayList;

public class Shrapnel extends Weapon {

    public Shrapnel() {
        super(
                "Shrapnel",
                "STONE",
                "&bShrapnel",
                new ArrayList<>(),
                13.0D,
                3.0D,
                UberType.UBER_TWO
        );
    }

    @Override
    public WeaponAttackResult onAttack(TroveBoss boss, Trovian trovian) {
        return new WeaponAttackResult(
                19.0D,
                getDamage(),
                3.5D
        );
    }

    @Override
    public void onEquip(PlayerItemHeldEvent e) {

    }
}
