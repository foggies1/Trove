package net.foggies.trove.impl.player.weapon.weapons.uberthree;

import net.foggies.trove.api.TroveBoss;
import net.foggies.trove.api.UberType;
import net.foggies.trove.api.Weapon;
import net.foggies.trove.api.WeaponAttackResult;
import net.foggies.trove.impl.player.trovian.Trovian;
import org.bukkit.event.player.PlayerItemHeldEvent;

import java.util.ArrayList;

public class Torpedo extends Weapon {

    public Torpedo() {
        super(
                "Torpedo",
                "STONE",
                "&eTorpedo",
                new ArrayList<>(),
                17.0D,
                50.0D,
                UberType.UBER_THREE
        );
    }

    @Override
    public WeaponAttackResult onAttack(TroveBoss boss, Trovian trovian) {
        return new WeaponAttackResult(
                22.0D,
                getDamage(),
                3.9D
        );
    }

    @Override
    public void onEquip(PlayerItemHeldEvent e) {

    }
}
