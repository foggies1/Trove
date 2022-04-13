package net.foggies.trove.impl.player.weapon.weapons.ubersix;

import net.foggies.trove.api.TroveBoss;
import net.foggies.trove.api.UberType;
import net.foggies.trove.api.Weapon;
import net.foggies.trove.api.WeaponAttackResult;
import net.foggies.trove.impl.player.trovian.Trovian;
import org.bukkit.event.player.PlayerItemHeldEvent;

import java.util.ArrayList;

public class Reaper extends Weapon {

    public Reaper() {
        super(
                "Reaper",
                "STONE",
                "&4Reaper",
                new ArrayList<>(),
                300.0D,
                20.0D,
                UberType.UBER_SIX
        );
    }

    @Override
    public WeaponAttackResult onAttack(TroveBoss boss, Trovian trovian) {
        return new WeaponAttackResult(
                94.0D,
                getDamage(),
                13.8D
        );
    }

    @Override
    public void onEquip(PlayerItemHeldEvent e) {

    }
}
