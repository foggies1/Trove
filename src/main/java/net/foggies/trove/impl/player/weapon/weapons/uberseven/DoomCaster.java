package net.foggies.trove.impl.player.weapon.weapons.uberseven;

import net.foggies.trove.api.TroveBoss;
import net.foggies.trove.api.UberType;
import net.foggies.trove.api.Weapon;
import net.foggies.trove.api.WeaponAttackResult;
import net.foggies.trove.impl.player.trovian.Trovian;
import org.bukkit.event.player.PlayerItemHeldEvent;

import java.util.ArrayList;

public class DoomCaster extends Weapon {

    public DoomCaster() {
        super(
                "Doom Caster",
                "STONE",
                "&dDoom Caster",
                new ArrayList<>(),
                1200.0D,
                10.0D,
                UberType.UBER_SEVEN
        );
    }

    @Override
    public WeaponAttackResult onAttack(TroveBoss boss, Trovian trovian) {
        return new WeaponAttackResult(
                125.0D,
                getDamage(),
                17.5D
        );
    }

    @Override
    public void onEquip(PlayerItemHeldEvent e) {

    }
}
