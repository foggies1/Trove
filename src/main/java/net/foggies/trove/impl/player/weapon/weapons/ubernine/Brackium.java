package net.foggies.trove.impl.player.weapon.weapons.ubernine;

import net.foggies.trove.api.TroveBoss;
import net.foggies.trove.api.UberType;
import net.foggies.trove.api.Weapon;
import net.foggies.trove.api.WeaponAttackResult;
import net.foggies.trove.impl.player.trovian.Trovian;
import org.bukkit.event.player.PlayerItemHeldEvent;

import java.util.ArrayList;

public class Brackium extends Weapon {

    public Brackium() {
        super(
                "Brackium",
                "STONE",
                "&2Brackium",
                new ArrayList<>(),
                95000.0D,
                2.0D,
                UberType.UBER_NINE
        );
    }

    @Override
    public WeaponAttackResult onAttack(TroveBoss boss, Trovian trovian) {
        return new WeaponAttackResult(
                333.0D,
                getDamage(),
                30.0D
        );
    }

    @Override
    public void onEquip(PlayerItemHeldEvent e) {

    }
}
