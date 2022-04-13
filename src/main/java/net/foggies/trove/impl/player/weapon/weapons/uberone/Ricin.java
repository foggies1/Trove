package net.foggies.trove.impl.player.weapon.weapons.uberone;

import net.foggies.trove.api.TroveBoss;
import net.foggies.trove.api.UberType;
import net.foggies.trove.api.Weapon;
import net.foggies.trove.api.WeaponAttackResult;
import net.foggies.trove.impl.player.trovian.Trovian;
import org.bukkit.event.player.PlayerItemHeldEvent;

import java.util.ArrayList;

public class Ricin extends Weapon {

    public Ricin() {
        super(
                "Ricin",
                "STONE",
                "&aRicin",
                new ArrayList<>(),
                3.5D,
                20.0D,
                UberType.UBER_ONE
        );
    }

    @Override
    public WeaponAttackResult onAttack(TroveBoss boss, Trovian trovian) {
        return new WeaponAttackResult(
                7.5D,
                getDamage(),
                1.5D
        );
    }

    @Override
    public void onEquip(PlayerItemHeldEvent e) {

    }
}
