package net.foggies.trove.impl.player.weapon.weapons.ubereight;

import net.foggies.trove.api.TroveBoss;
import net.foggies.trove.api.UberType;
import net.foggies.trove.api.Weapon;
import net.foggies.trove.api.WeaponAttackResult;
import net.foggies.trove.impl.player.trovian.Trovian;
import org.bukkit.event.player.PlayerItemHeldEvent;

import java.util.ArrayList;

public class FleshReaper extends Weapon {

    public FleshReaper() {
        super(
                "Flesh Reaper",
                "STONE",
                "&6Flesh Reaper",
                new ArrayList<>(),
                3500.0D,
                15.0D,
                UberType.UBER_EIGHT
        );
    }

    @Override
    public WeaponAttackResult onAttack(TroveBoss boss, Trovian trovian) {
        return new WeaponAttackResult(
                177.0D,
                getDamage(),
                21.2D
        );
    }

    @Override
    public void onEquip(PlayerItemHeldEvent e) {

    }
}
