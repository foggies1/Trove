package net.foggies.trove.impl.player.weapon.weapons.ubersix;

import net.foggies.trove.api.TroveBoss;
import net.foggies.trove.api.UberType;
import net.foggies.trove.api.Weapon;
import net.foggies.trove.api.WeaponAttackResult;
import net.foggies.trove.impl.player.trovian.Trovian;
import org.bukkit.event.player.PlayerItemHeldEvent;

import java.util.ArrayList;

public class Epilogue extends Weapon {

    public Epilogue() {
        super(
                "Epilogue",
                "STONE",
                "&4Epilogue",
                new ArrayList<>(),
                250.0D,
                50.0D,
                UberType.UBER_SIX
        );
    }

    @Override
    public WeaponAttackResult onAttack(TroveBoss boss, Trovian trovian) {
        return new WeaponAttackResult(
                83.0D,
                getDamage(),
                12.75D
        );
    }

    @Override
    public void onEquip(PlayerItemHeldEvent e) {

    }
}
