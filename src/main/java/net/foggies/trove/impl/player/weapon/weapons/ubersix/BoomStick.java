package net.foggies.trove.impl.player.weapon.weapons.ubersix;

import net.foggies.trove.api.TroveBoss;
import net.foggies.trove.api.UberType;
import net.foggies.trove.api.Weapon;
import net.foggies.trove.api.WeaponAttackResult;
import net.foggies.trove.impl.player.trovian.Trovian;
import org.bukkit.event.player.PlayerItemHeldEvent;

import java.util.ArrayList;

public class BoomStick extends Weapon {

    public BoomStick() {
        super(
                "Boom Stick",
                "STONE",
                "&4Boom Stick",
                new ArrayList<>(),
                333.0D,
                10.0D,
                UberType.UBER_SIX
        );
    }

    @Override
    public WeaponAttackResult onAttack(TroveBoss boss, Trovian trovian) {
        return new WeaponAttackResult(
                99.0D,
                getDamage(),
                14.4D
        );
    }

    @Override
    public void onEquip(PlayerItemHeldEvent e) {

    }
}
