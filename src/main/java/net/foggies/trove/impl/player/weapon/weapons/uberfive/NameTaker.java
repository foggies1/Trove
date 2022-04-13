package net.foggies.trove.impl.player.weapon.weapons.uberfive;

import net.foggies.trove.api.TroveBoss;
import net.foggies.trove.api.UberType;
import net.foggies.trove.api.Weapon;
import net.foggies.trove.api.WeaponAttackResult;
import net.foggies.trove.impl.player.trovian.Trovian;
import org.bukkit.event.player.PlayerItemHeldEvent;

import java.util.ArrayList;

public class NameTaker extends Weapon {

    public NameTaker() {
        super(
                "Name Taker",
                "STONE",
                "&9Name Taker",
                new ArrayList<>(),
                115.0D,
                50.0D,
                UberType.UBER_FIVE
        );
    }

    @Override
    public WeaponAttackResult onAttack(TroveBoss boss, Trovian trovian) {
        return new WeaponAttackResult(
                63.0D,
                getDamage(),
                8.9D
        );
    }

    @Override
    public void onEquip(PlayerItemHeldEvent e) {

    }
}
