package net.foggies.trove.impl.player.weapon.weapons.ubereight;

import net.foggies.trove.api.TroveBoss;
import net.foggies.trove.api.UberType;
import net.foggies.trove.api.Weapon;
import net.foggies.trove.api.WeaponAttackResult;
import net.foggies.trove.impl.player.trovian.Trovian;
import org.bukkit.event.player.PlayerItemHeldEvent;

import java.util.ArrayList;

public class Tome extends Weapon {

    public Tome() {
        super(
                "Tome",
                "STONE",
                "&6Tome",
                new ArrayList<>(),
                5000.0D,
                3.0D,
                UberType.UBER_EIGHT
        );
    }

    @Override
    public WeaponAttackResult onAttack(TroveBoss boss, Trovian trovian) {
        return new WeaponAttackResult(
                210.0D,
                getDamage(),
                22.9D
        );
    }

    @Override
    public void onEquip(PlayerItemHeldEvent e) {

    }
}
