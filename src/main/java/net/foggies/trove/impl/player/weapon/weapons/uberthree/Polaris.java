package net.foggies.trove.impl.player.weapon.weapons.uberthree;

import net.foggies.trove.api.TroveBoss;
import net.foggies.trove.api.UberType;
import net.foggies.trove.api.Weapon;
import net.foggies.trove.api.WeaponAttackResult;
import net.foggies.trove.impl.player.trovian.Trovian;
import org.bukkit.event.player.PlayerItemHeldEvent;

import java.util.ArrayList;

public class Polaris extends Weapon {

    public Polaris() {
        super(
                "Polaris",
                "STONE",
                "&ePolaris",
                new ArrayList<>(),
                22.5D,
                20.0D,
                UberType.UBER_THREE
        );
    }

    @Override
    public WeaponAttackResult onAttack(TroveBoss boss, Trovian trovian) {
        return new WeaponAttackResult(
                28.0D,
                getDamage(),
                4.8D
        );
    }

    @Override
    public void onEquip(PlayerItemHeldEvent e) {

    }
}
