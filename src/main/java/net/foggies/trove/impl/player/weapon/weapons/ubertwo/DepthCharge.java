package net.foggies.trove.impl.player.weapon.weapons.ubertwo;

import net.foggies.trove.api.TroveBoss;
import net.foggies.trove.api.UberType;
import net.foggies.trove.api.Weapon;
import net.foggies.trove.api.WeaponAttackResult;
import net.foggies.trove.impl.player.trovian.Trovian;
import org.bukkit.event.player.PlayerItemHeldEvent;

import java.util.ArrayList;

public class DepthCharge extends Weapon {

    public DepthCharge() {
        super(
                "Depth Charge",
                "STONE",
                "&bDepth Charge",
                new ArrayList<>(),
                11.5D,
                10.0D,
                UberType.UBER_TWO
        );
    }

    @Override
    public WeaponAttackResult onAttack(TroveBoss boss, Trovian trovian) {
        return new WeaponAttackResult(
                15.0D,
                getDamage(),
                3.2D
        );
    }

    @Override
    public void onEquip(PlayerItemHeldEvent e) {

    }
}
