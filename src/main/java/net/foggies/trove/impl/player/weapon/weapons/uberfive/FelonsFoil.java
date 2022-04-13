package net.foggies.trove.impl.player.weapon.weapons.uberfive;

import net.foggies.trove.api.TroveBoss;
import net.foggies.trove.api.UberType;
import net.foggies.trove.api.Weapon;
import net.foggies.trove.api.WeaponAttackResult;
import net.foggies.trove.impl.player.trovian.Trovian;
import org.bukkit.event.player.PlayerItemHeldEvent;

import java.util.ArrayList;

public class FelonsFoil extends Weapon {

    public FelonsFoil() {
        super(
                "Felons Foil",
                "STONE",
                "&9Felon's Foil",
                new ArrayList<>(),
                200.0D,
                3.0D,
                UberType.UBER_FIVE
        );
    }

    @Override
    public WeaponAttackResult onAttack(TroveBoss boss, Trovian trovian) {
        return new WeaponAttackResult(
                77.0D,
                getDamage(),
                11.5D
        );
    }

    @Override
    public void onEquip(PlayerItemHeldEvent e) {

    }
}
