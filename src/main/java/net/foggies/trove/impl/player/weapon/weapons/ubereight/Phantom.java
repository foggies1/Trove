package net.foggies.trove.impl.player.weapon.weapons.ubereight;

import net.foggies.trove.api.TroveBoss;
import net.foggies.trove.api.UberType;
import net.foggies.trove.api.Weapon;
import net.foggies.trove.api.WeaponAttackResult;
import net.foggies.trove.impl.player.trovian.Trovian;
import org.bukkit.event.player.PlayerItemHeldEvent;

import java.util.ArrayList;

public class Phantom extends Weapon {

    public Phantom() {
        super(
                "Phantom",
                "STONE",
                "&6Phantom",
                new ArrayList<>(),
                4000.0D,
                10.0D,
                UberType.UBER_EIGHT
        );
    }

    @Override
    public WeaponAttackResult onAttack(TroveBoss boss, Trovian trovian) {
        return new WeaponAttackResult(
                195.0D,
                getDamage(),
                22.5D
        );
    }

    @Override
    public void onEquip(PlayerItemHeldEvent e) {

    }
}
