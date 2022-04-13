package net.foggies.trove.impl.player.weapon.weapons.uberone;

import net.foggies.trove.api.TroveBoss;
import net.foggies.trove.api.UberType;
import net.foggies.trove.api.Weapon;
import net.foggies.trove.api.WeaponAttackResult;
import net.foggies.trove.impl.player.trovian.Trovian;
import org.bukkit.event.player.PlayerItemHeldEvent;

import java.util.ArrayList;

public class Plague extends Weapon {

    public Plague() {
        super(
                "Plague",
                "STONE",
                "&aPlague",
                new ArrayList<>(),
                2.5D,
                25.0D,
                UberType.UBER_ONE
        );
    }

    @Override
    public WeaponAttackResult onAttack(TroveBoss boss, Trovian trovian) {
        return new WeaponAttackResult(
                5.0D,
                getDamage(),
                1.3D
        );
    }

    @Override
    public void onEquip(PlayerItemHeldEvent e) {

    }
}
