package net.foggies.trove.impl.player.weapon.weapons.ubersix;

import net.foggies.trove.api.TroveBoss;
import net.foggies.trove.api.UberType;
import net.foggies.trove.api.Weapon;
import net.foggies.trove.api.WeaponAttackResult;
import net.foggies.trove.impl.player.trovian.Trovian;
import org.bukkit.event.player.PlayerItemHeldEvent;

import java.util.ArrayList;

public class JawBreaker extends Weapon {

    public JawBreaker() {
        super(
                "Jaw Breaker",
                "STONE",
                "&4Jaw Breaker",
                new ArrayList<>(),
                380.0D,
                3.0D,
                UberType.UBER_SIX
        );
    }

    @Override
    public WeaponAttackResult onAttack(TroveBoss boss, Trovian trovian) {
        return new WeaponAttackResult(
                103.0D,
                getDamage(),
                15.2D
        );
    }

    @Override
    public void onEquip(PlayerItemHeldEvent e) {

    }
}
