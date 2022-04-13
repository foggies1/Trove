package net.foggies.trove.impl.player.weapon.weapons.ubereight;

import net.foggies.trove.api.TroveBoss;
import net.foggies.trove.api.UberType;
import net.foggies.trove.api.Weapon;
import net.foggies.trove.api.WeaponAttackResult;
import net.foggies.trove.impl.player.trovian.Trovian;
import org.bukkit.event.player.PlayerItemHeldEvent;

import java.util.ArrayList;

public class SpellShard extends Weapon {

    public SpellShard() {
        super(
                "Spell Shard",
                "STONE",
                "&6Spell Shard",
                new ArrayList<>(),
                1950.0D,
                50.0D,
                UberType.UBER_EIGHT
        );
    }

    @Override
    public WeaponAttackResult onAttack(TroveBoss boss, Trovian trovian) {
        return new WeaponAttackResult(
                150.0D,
                getDamage(),
                18.75D
        );
    }

    @Override
    public void onEquip(PlayerItemHeldEvent e) {

    }
}
