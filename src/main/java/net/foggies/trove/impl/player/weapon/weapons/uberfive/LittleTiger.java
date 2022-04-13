package net.foggies.trove.impl.player.weapon.weapons.uberfive;

import net.foggies.trove.api.TroveBoss;
import net.foggies.trove.api.UberType;
import net.foggies.trove.api.Weapon;
import net.foggies.trove.api.WeaponAttackResult;
import net.foggies.trove.impl.player.trovian.Trovian;
import org.bukkit.event.player.PlayerItemHeldEvent;

import java.util.ArrayList;

public class LittleTiger extends Weapon {

    public LittleTiger() {
        super(
                "Little Tiger",
                "STONE",
                "&9Little Tiger",
                new ArrayList<>(),
                175.0D,
                10.0D,
                UberType.UBER_FIVE
        );
    }

    @Override
    public WeaponAttackResult onAttack(TroveBoss boss, Trovian trovian) {
        return new WeaponAttackResult(
                73.0D,
                getDamage(),
                10.9D
        );
    }

    @Override
    public void onEquip(PlayerItemHeldEvent e) {

    }
}
