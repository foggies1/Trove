package net.foggies.trove.impl.player.weapon.weapons.ubersix;

import net.foggies.trove.api.TroveBoss;
import net.foggies.trove.api.UberType;
import net.foggies.trove.api.Weapon;
import net.foggies.trove.api.WeaponAttackResult;
import net.foggies.trove.impl.player.trovian.Trovian;
import org.bukkit.event.player.PlayerItemHeldEvent;

import java.util.ArrayList;

public class Reflector extends Weapon {

    public Reflector() {
        super(
                "Reflector",
                "STONE",
                "&4Reflector",
                new ArrayList<>(),
                275.0D,
                25.0D,
                UberType.UBER_SIX
        );
    }

    @Override
    public WeaponAttackResult onAttack(TroveBoss boss, Trovian trovian) {
        return new WeaponAttackResult(
                90.0D,
                getDamage(),
                13.2D
        );
    }

    @Override
    public void onEquip(PlayerItemHeldEvent e) {

    }
}
