package net.foggies.trove.impl.player.weapon.weapons.uberfive;

import net.foggies.trove.api.TroveBoss;
import net.foggies.trove.api.UberType;
import net.foggies.trove.api.Weapon;
import net.foggies.trove.api.WeaponAttackResult;
import net.foggies.trove.impl.player.trovian.Trovian;
import org.bukkit.event.player.PlayerItemHeldEvent;

import java.util.ArrayList;

public class SoulSniper extends Weapon {

    public SoulSniper() {
        super(
                "Soul Sniper",
                "STONE",
                "&9Soul Sniper",
                new ArrayList<>(),
                155.75D,
                20.0D,
                UberType.UBER_FIVE
        );
    }

    @Override
    public WeaponAttackResult onAttack(TroveBoss boss, Trovian trovian) {
        return new WeaponAttackResult(
                68.0D,
                getDamage(),
                10.3D
        );
    }

    @Override
    public void onEquip(PlayerItemHeldEvent e) {

    }
}
