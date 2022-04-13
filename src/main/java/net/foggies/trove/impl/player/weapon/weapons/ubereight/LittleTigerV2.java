package net.foggies.trove.impl.player.weapon.weapons.ubereight;

import net.foggies.trove.api.TroveBoss;
import net.foggies.trove.api.UberType;
import net.foggies.trove.api.Weapon;
import net.foggies.trove.api.WeaponAttackResult;
import net.foggies.trove.impl.player.trovian.Trovian;
import org.bukkit.event.player.PlayerItemHeldEvent;

import java.util.ArrayList;

public class LittleTigerV2 extends Weapon {

    public LittleTigerV2() {
        super(
                "Little Tiger V2",
                "STONE",
                "&6Little Tiger V2",
                new ArrayList<>(),
                2750.0D,
                20.0D,
                UberType.UBER_EIGHT
        );
    }

    @Override
    public WeaponAttackResult onAttack(TroveBoss boss, Trovian trovian) {
        return new WeaponAttackResult(
                169.0D,
                getDamage(),
                19.5D
        );
    }

    @Override
    public void onEquip(PlayerItemHeldEvent e) {

    }
}
