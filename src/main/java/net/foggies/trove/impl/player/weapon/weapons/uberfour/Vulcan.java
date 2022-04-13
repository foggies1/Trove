package net.foggies.trove.impl.player.weapon.weapons.uberfour;

import net.foggies.trove.api.TroveBoss;
import net.foggies.trove.api.UberType;
import net.foggies.trove.api.Weapon;
import net.foggies.trove.api.WeaponAttackResult;
import net.foggies.trove.impl.player.trovian.Trovian;
import org.bukkit.event.player.PlayerItemHeldEvent;

import java.util.ArrayList;

public class Vulcan extends Weapon {

    public Vulcan() {
        super(
                "Vulcan",
                "STONE",
                "&5Vulcan",
                new ArrayList<>(),
                105.0D,
                3.0D,
                UberType.UBER_FOUR
        );
    }

    @Override
    public WeaponAttackResult onAttack(TroveBoss boss, Trovian trovian) {
        return new WeaponAttackResult(
                60.0D,
                getDamage(),
                8.3D
        );
    }

    @Override
    public void onEquip(PlayerItemHeldEvent e) {

    }
}
