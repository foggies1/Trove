package net.foggies.trove.utils;

import net.foggies.trove.Trove;
import org.bukkit.NamespacedKey;
import org.bukkit.entity.Entity;
import org.bukkit.persistence.PersistentDataType;

import java.util.UUID;

public class EntityUtils {

    public static UUID getUUID(Entity e, String key){
        return UUID.fromString(e.getPersistentDataContainer().get(
                new NamespacedKey(Trove.getPlugin(), key),
                PersistentDataType.STRING
        ));
    }

}
