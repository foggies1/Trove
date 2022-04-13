package net.foggies.trove.impl.player.weapon.weapons.ubertwo;

import net.foggies.trove.api.TroveBoss;
import net.foggies.trove.api.UberType;
import net.foggies.trove.api.Weapon;
import net.foggies.trove.api.WeaponAttackResult;
import net.foggies.trove.impl.player.trovian.Trovian;
import org.bukkit.event.player.PlayerItemHeldEvent;

import java.util.ArrayList;

public class Pike extends Weapon {

    public Pike() {
        super(
                "Pike",
                "STONE",
                "&bPike",
                new ArrayList<>(),
                7.5D,
                25.0D,
                UberType.UBER_TWO
        );
    }

    @Override
    public WeaponAttackResult onAttack(TroveBoss boss, Trovian trovian) {
        return new WeaponAttackResult(
                12.25D,
                getDamage(),
                2.6D
        );
    }

    @Override
    public void onEquip(PlayerItemHeldEvent e) {

    }
}
