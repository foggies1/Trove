package net.foggies.trove.impl.player.weapon.weapons.uberthree;

import net.foggies.trove.api.TroveBoss;
import net.foggies.trove.api.UberType;
import net.foggies.trove.api.Weapon;
import net.foggies.trove.api.WeaponAttackResult;
import net.foggies.trove.impl.player.trovian.Trovian;
import org.bukkit.event.player.PlayerItemHeldEvent;

import java.util.ArrayList;

public class Trident extends Weapon {

    public Trident() {
        super(
                "Trident",
                "STONE",
                "&eTrident",
                new ArrayList<>(),
                20.0D,
                25.0D,
                UberType.UBER_THREE
        );
    }

    @Override
    public WeaponAttackResult onAttack(TroveBoss boss, Trovian trovian) {
        return new WeaponAttackResult(
                23.75D,
                getDamage(),
                4.4D
        );
    }

    @Override
    public void onEquip(PlayerItemHeldEvent e) {

    }
}
