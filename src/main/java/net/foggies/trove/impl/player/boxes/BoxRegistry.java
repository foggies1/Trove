package net.foggies.trove.impl.player.boxes;

import lombok.Getter;
import net.foggies.trove.Trove;
import net.foggies.trove.impl.player.boxes.types.GemBoxImpl;
import net.foggies.trove.impl.player.boxes.types.WeaponBoxImpl;
import net.foggies.trove.utils.PDUtils;
import org.bukkit.inventory.ItemStack;
import org.bukkit.persistence.PersistentDataType;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Getter
public class BoxRegistry {

    private final Trove plugin;
    private final Map<String, Box> boxMap;

    public BoxRegistry(Trove plugin) {
        this.plugin = plugin;
        this.boxMap = new ConcurrentHashMap<>();
        loadBoxes();
    }

    public Box getBox(ItemStack itemStack){
        return getBox(new PDUtils(plugin, itemStack).get("box", PersistentDataType.STRING));
    }

    public boolean isBox(ItemStack itemStack){
        return new PDUtils(plugin, itemStack).has("box", PersistentDataType.STRING);
    }

    public Box getBox(String identifier){
        return this.boxMap.get(identifier);
    }

    private void loadBoxes(){
        this.boxMap.put("gem_box", new GemBoxImpl(plugin));
        this.boxMap.put("weapon_box", new WeaponBoxImpl(plugin));
    }

}
