package net.foggies.trove.impl.player.weapon.weapons.uberfour;

import net.foggies.trove.api.TroveBoss;
import net.foggies.trove.api.UberType;
import net.foggies.trove.api.Weapon;
import net.foggies.trove.api.WeaponAttackResult;
import net.foggies.trove.impl.player.trovian.Trovian;
import org.bukkit.event.player.PlayerItemHeldEvent;

import java.util.ArrayList;

public class Carbine extends Weapon {

    public Carbine() {
        super(
                "Carbine",
                "STONE",
                "&5Carbine",
                new ArrayList<>(),
                35.0D,
                50.0D,
                UberType.UBER_FOUR
        );
    }

    @Override
    public WeaponAttackResult onAttack(TroveBoss boss, Trovian trovian) {
        return new WeaponAttackResult(
                35.0D,
                getDamage(),
                6.0D
        );
    }

    @Override
    public void onEquip(PlayerItemHeldEvent e) {

    }
}
