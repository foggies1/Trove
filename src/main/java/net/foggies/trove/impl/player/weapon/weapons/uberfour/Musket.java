package net.foggies.trove.impl.player.weapon.weapons.uberfour;

import net.foggies.trove.api.TroveBoss;
import net.foggies.trove.api.UberType;
import net.foggies.trove.api.Weapon;
import net.foggies.trove.api.WeaponAttackResult;
import net.foggies.trove.impl.player.trovian.Trovian;
import org.bukkit.event.player.PlayerItemHeldEvent;

import java.util.ArrayList;

public class Musket extends Weapon {

    public Musket() {
        super(
                "Musket",
                "STONE",
                "&5Musket",
                new ArrayList<>(),
                65.0D,
                20.0D,
                UberType.UBER_FOUR
        );
    }

    @Override
    public WeaponAttackResult onAttack(TroveBoss boss, Trovian trovian) {
        return new WeaponAttackResult(
                43.0D,
                getDamage(),
                6.8D
        );
    }

    @Override
    public void onEquip(PlayerItemHeldEvent e) {

    }
}
