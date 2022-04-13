package net.foggies.trove.impl.player.weapon.weapons.uberseven;

import net.foggies.trove.api.TroveBoss;
import net.foggies.trove.api.UberType;
import net.foggies.trove.api.Weapon;
import net.foggies.trove.api.WeaponAttackResult;
import net.foggies.trove.impl.player.trovian.Trovian;
import org.bukkit.event.player.PlayerItemHeldEvent;

import java.util.ArrayList;

public class EbonBlade extends Weapon {

    public EbonBlade() {
        super(
                "Ebon Blade",
                "STONE",
                "&dEbon Blade",
                new ArrayList<>(),
                800.0D,
                25.0D,
                UberType.UBER_SEVEN
        );
    }

    @Override
    public WeaponAttackResult onAttack(TroveBoss boss, Trovian trovian) {
        return new WeaponAttackResult(
                113.0D,
                getDamage(),
                16.3D
        );
    }

    @Override
    public void onEquip(PlayerItemHeldEvent e) {

    }
}
