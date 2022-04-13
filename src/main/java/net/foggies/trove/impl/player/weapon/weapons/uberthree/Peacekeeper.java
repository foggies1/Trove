package net.foggies.trove.impl.player.weapon.weapons.uberthree;

import net.foggies.trove.api.TroveBoss;
import net.foggies.trove.api.UberType;
import net.foggies.trove.api.Weapon;
import net.foggies.trove.api.WeaponAttackResult;
import net.foggies.trove.impl.player.trovian.Trovian;
import org.bukkit.event.player.PlayerItemHeldEvent;

import java.util.ArrayList;

public class Peacekeeper extends Weapon {

    public Peacekeeper() {
        super(
                "Peacekeeper",
                "STONE",
                "&ePeacekeeper",
                new ArrayList<>(),
                25.0D,
                10.0D,
                UberType.UBER_THREE
        );
    }

    @Override
    public WeaponAttackResult onAttack(TroveBoss boss, Trovian trovian) {
        return new WeaponAttackResult(
                30.0D,
                getDamage(),
                5.3D
        );
    }

    @Override
    public void onEquip(PlayerItemHeldEvent e) {

    }
}
