package net.foggies.trove.impl.player.weapon.weapons.ubertwo;

import net.foggies.trove.api.TroveBoss;
import net.foggies.trove.api.UberType;
import net.foggies.trove.api.Weapon;
import net.foggies.trove.api.WeaponAttackResult;
import net.foggies.trove.impl.player.trovian.Trovian;
import org.bukkit.event.player.PlayerItemHeldEvent;

import java.util.ArrayList;

public class Sabre extends Weapon {

    public Sabre() {
        super(
                "Sabre",
                "STONE",
                "&bSabre",
                new ArrayList<>(),
                9.0D,
                20.0D,
                UberType.UBER_TWO
        );
    }

    @Override
    public WeaponAttackResult onAttack(TroveBoss boss, Trovian trovian) {
        return new WeaponAttackResult(
                12.5D,
                getDamage(),
                2.8D
        );
    }

    @Override
    public void onEquip(PlayerItemHeldEvent e) {

    }
}
