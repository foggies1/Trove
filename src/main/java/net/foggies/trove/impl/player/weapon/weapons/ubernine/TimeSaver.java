package net.foggies.trove.impl.player.weapon.weapons.ubernine;

import net.foggies.trove.api.TroveBoss;
import net.foggies.trove.api.UberType;
import net.foggies.trove.api.Weapon;
import net.foggies.trove.api.WeaponAttackResult;
import net.foggies.trove.impl.player.trovian.Trovian;
import org.bukkit.event.player.PlayerItemHeldEvent;

import java.util.ArrayList;

public class TimeSaver extends Weapon {

    public TimeSaver() {
        super(
                "Time Saver",
                "STONE",
                "&2Time Saver",
                new ArrayList<>(),
                9000.0D,
                50.0D,
                UberType.UBER_NINE
        );
    }

    @Override
    public WeaponAttackResult onAttack(TroveBoss boss, Trovian trovian) {
        return new WeaponAttackResult(
                240.0D,
                getDamage(),
                23.5D
        );
    }

    @Override
    public void onEquip(PlayerItemHeldEvent e) {

    }
}
