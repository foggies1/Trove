package net.foggies.trove.impl.player.weapon.weapons.ubereight;

import net.foggies.trove.api.TroveBoss;
import net.foggies.trove.api.UberType;
import net.foggies.trove.api.Weapon;
import net.foggies.trove.api.WeaponAttackResult;
import net.foggies.trove.impl.player.trovian.Trovian;
import org.bukkit.event.player.PlayerItemHeldEvent;

import java.util.ArrayList;

public class Guard extends Weapon {

    public Guard() {
        super(
                "Guard",
                "STONE",
                "&6Guard",
                new ArrayList<>(),
                2500.0D,
                25.0D,
                UberType.UBER_EIGHT
        );
    }

    @Override
    public WeaponAttackResult onAttack(TroveBoss boss, Trovian trovian) {
        return new WeaponAttackResult(
                163.0D,
                getDamage(),
                19.0D
        );
    }

    @Override
    public void onEquip(PlayerItemHeldEvent e) {

    }
}
