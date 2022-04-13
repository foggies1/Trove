package net.foggies.trove.impl.player.weapon.weapons.ubernine;

import net.foggies.trove.api.TroveBoss;
import net.foggies.trove.api.UberType;
import net.foggies.trove.api.Weapon;
import net.foggies.trove.api.WeaponAttackResult;
import net.foggies.trove.impl.player.trovian.Trovian;
import org.bukkit.event.player.PlayerItemHeldEvent;

import java.util.ArrayList;

public class AngelMaker extends Weapon {

    public AngelMaker() {
        super(
                "Angel Maker",
                "STONE",
                "&2Angel Maker",
                new ArrayList<>(),
                15000.0D,
                12.0D,
                UberType.UBER_NINE
        );
    }

    @Override
    public WeaponAttackResult onAttack(TroveBoss boss, Trovian trovian) {
        return new WeaponAttackResult(
                260.0D,
                getDamage(),
                24.0D
        );
    }

    @Override
    public void onEquip(PlayerItemHeldEvent e) {

    }
}
