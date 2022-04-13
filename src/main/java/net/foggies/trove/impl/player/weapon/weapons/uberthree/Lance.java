package net.foggies.trove.impl.player.weapon.weapons.uberthree;

import net.foggies.trove.api.TroveBoss;
import net.foggies.trove.api.UberType;
import net.foggies.trove.api.Weapon;
import net.foggies.trove.api.WeaponAttackResult;
import net.foggies.trove.impl.player.trovian.Trovian;
import org.bukkit.event.player.PlayerItemHeldEvent;

import java.util.ArrayList;

public class Lance extends Weapon {

    public Lance() {
        super(
                "Lance",
                "STONE",
                "&eLance",
                new ArrayList<>(),
                30.0D,
                3.0D,
                UberType.UBER_THREE
        );
    }

    @Override
    public WeaponAttackResult onAttack(TroveBoss boss, Trovian trovian) {
        return new WeaponAttackResult(
                32.0D,
                getDamage(),
                5.7D
        );
    }

    @Override
    public void onEquip(PlayerItemHeldEvent e) {

    }
}
