package net.foggies.trove.utils;

import me.lucko.helper.Schedulers;
import org.bukkit.Location;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.EntityType;

import java.util.concurrent.ThreadLocalRandom;

public class HologramUtils {

    public static void spawnHologram(Location location, String message){
        ArmorStand armorStand = (ArmorStand) location.getWorld().spawnEntity(
                location.clone().add(ThreadLocalRandom.current().nextInt(3), 0, ThreadLocalRandom.current().nextInt(3)),
                EntityType.ARMOR_STAND
        );

        armorStand.setCustomName(
                StringUtils.color(message)
        );

        armorStand.setCustomNameVisible(true);
        armorStand.setGravity(false);
        armorStand.setInvulnerable(true);
        armorStand.setVisible(false);

        Schedulers.sync().runLater(armorStand::remove, 20L * 2L);
    }

}
