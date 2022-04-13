package net.foggies.trove.impl.player.weapon.weapons.uberone;

import net.foggies.trove.api.TroveBoss;
import net.foggies.trove.api.UberType;
import net.foggies.trove.api.Weapon;
import net.foggies.trove.api.WeaponAttackResult;
import net.foggies.trove.impl.player.trovian.Trovian;
import org.bukkit.event.player.PlayerItemHeldEvent;

import java.util.ArrayList;

public class Anthrax extends Weapon {

    public Anthrax() {
        super(
                "Anthrax",
                "STONE",
                "&aAnthrax",
                new ArrayList<>(),
                2.0D,
                50.0D,
                UberType.UBER_ONE
        );
    }

    @Override
    public WeaponAttackResult onAttack(TroveBoss boss, Trovian trovian) {
        return new WeaponAttackResult(
                5.0D,
                getDamage(),
                1.0D
        );
    }

    @Override
    public void onEquip(PlayerItemHeldEvent e) {

    }
}
