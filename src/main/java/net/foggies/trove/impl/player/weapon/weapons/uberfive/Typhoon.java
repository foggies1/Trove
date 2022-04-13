package net.foggies.trove.impl.player.weapon.weapons.uberfive;

import net.foggies.trove.api.TroveBoss;
import net.foggies.trove.api.UberType;
import net.foggies.trove.api.Weapon;
import net.foggies.trove.api.WeaponAttackResult;
import net.foggies.trove.impl.player.trovian.Trovian;
import org.bukkit.event.player.PlayerItemHeldEvent;

import java.util.ArrayList;

public class Typhoon extends Weapon {

    public Typhoon() {
        super(
                "Typhoon",
                "STONE",
                "&9Typhoon",
                new ArrayList<>(),
                135.0D,
                25.0D,
                UberType.UBER_FIVE
        );
    }

    @Override
    public WeaponAttackResult onAttack(TroveBoss boss, Trovian trovian) {
        return new WeaponAttackResult(
                64.0D,
                getDamage(),
                9.5D
        );
    }

    @Override
    public void onEquip(PlayerItemHeldEvent e) {

    }
}
