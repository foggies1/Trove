package net.foggies.trove.impl.player.weapon.weapons.uberone;

import net.foggies.trove.api.TroveBoss;
import net.foggies.trove.api.UberType;
import net.foggies.trove.api.Weapon;
import net.foggies.trove.api.WeaponAttackResult;
import net.foggies.trove.impl.player.trovian.Trovian;
import org.bukkit.event.player.PlayerItemHeldEvent;

import java.util.ArrayList;

public class YellowRain extends Weapon {

    public YellowRain() {
        super(
                "Yellow Rain",
                "STONE",
                "&aYellow Rain",
                new ArrayList<>(),
                4.75D,
                10.0D,
                UberType.UBER_ONE
        );
    }

    @Override
    public WeaponAttackResult onAttack(TroveBoss boss, Trovian trovian) {
        return new WeaponAttackResult(
                7.5D,
                getDamage(),
                1.7D
        );
    }

    @Override
    public void onEquip(PlayerItemHeldEvent e) {

    }
}
