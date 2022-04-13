package net.foggies.trove.impl.player.weapon.weapons.ubernine;

import net.foggies.trove.api.TroveBoss;
import net.foggies.trove.api.UberType;
import net.foggies.trove.api.Weapon;
import net.foggies.trove.api.WeaponAttackResult;
import net.foggies.trove.impl.player.trovian.Trovian;
import org.bukkit.event.player.PlayerItemHeldEvent;

import java.util.ArrayList;

public class SplinterCaster extends Weapon {

    public SplinterCaster() {
        super(
                "Splinter Caster",
                "STONE",
                "&2Splinter Caster",
                new ArrayList<>(),
                25000.0D,
                8.0D,
                UberType.UBER_NINE
        );
    }

    @Override
    public WeaponAttackResult onAttack(TroveBoss boss, Trovian trovian) {
        return new WeaponAttackResult(
                290.0D,
                getDamage(),
                25.6D
        );
    }

    @Override
    public void onEquip(PlayerItemHeldEvent e) {

    }
}
