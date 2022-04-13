package net.foggies.trove.impl.player.weapon.weapons.ubertwo;

import net.foggies.trove.api.TroveBoss;
import net.foggies.trove.api.UberType;
import net.foggies.trove.api.Weapon;
import net.foggies.trove.api.WeaponAttackResult;
import net.foggies.trove.impl.player.trovian.Trovian;
import org.bukkit.event.player.PlayerItemHeldEvent;

import java.util.ArrayList;

public class Club extends Weapon {

    public Club() {
        super(
                "Club",
                "STONE",
                "&bClub",
                new ArrayList<>(),
                6.75D,
                50.0D,
                UberType.UBER_TWO
        );
    }

    @Override
    public WeaponAttackResult onAttack(TroveBoss boss, Trovian trovian) {
        return new WeaponAttackResult(
                12.0D,
                getDamage(),
                2.3D
        );
    }

    @Override
    public void onEquip(PlayerItemHeldEvent e) {

    }
}
