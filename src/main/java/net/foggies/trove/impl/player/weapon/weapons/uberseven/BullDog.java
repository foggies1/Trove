package net.foggies.trove.impl.player.weapon.weapons.uberseven;

import net.foggies.trove.api.TroveBoss;
import net.foggies.trove.api.UberType;
import net.foggies.trove.api.Weapon;
import net.foggies.trove.api.WeaponAttackResult;
import net.foggies.trove.impl.player.trovian.Trovian;
import org.bukkit.event.player.PlayerItemHeldEvent;

import java.util.ArrayList;

public class BullDog extends Weapon {

    public BullDog() {
        super(
                "Bull Dog",
                "STONE",
                "&dBull Dog",
                new ArrayList<>(),
                1500.0D,
                3.0D,
                UberType.UBER_SEVEN
        );
    }

    @Override
    public WeaponAttackResult onAttack(TroveBoss boss, Trovian trovian) {
        return new WeaponAttackResult(
                140.0D,
                getDamage(),
                18.0D
        );
    }

    @Override
    public void onEquip(PlayerItemHeldEvent e) {

    }
}
