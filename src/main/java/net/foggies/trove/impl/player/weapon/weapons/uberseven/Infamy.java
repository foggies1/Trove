package net.foggies.trove.impl.player.weapon.weapons.uberseven;

import net.foggies.trove.api.TroveBoss;
import net.foggies.trove.api.UberType;
import net.foggies.trove.api.Weapon;
import net.foggies.trove.api.WeaponAttackResult;
import net.foggies.trove.impl.player.trovian.Trovian;
import org.bukkit.event.player.PlayerItemHeldEvent;

import java.util.ArrayList;

public class Infamy extends Weapon {

    public Infamy() {
        super(
                "Infamy",
                "STONE",
                "&dInfamy",
                new ArrayList<>(),
                500.0D,
                50.0D,
                UberType.UBER_SEVEN
        );
    }

    @Override
    public WeaponAttackResult onAttack(TroveBoss boss, Trovian trovian) {
        return new WeaponAttackResult(
                108.0D,
                getDamage(),
                15.9D
        );
    }

    @Override
    public void onEquip(PlayerItemHeldEvent e) {

    }
}
