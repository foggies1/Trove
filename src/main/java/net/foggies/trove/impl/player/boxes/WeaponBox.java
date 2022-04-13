package net.foggies.trove.impl.player.boxes;

import lombok.Getter;
import net.foggies.trove.Trove;
import net.foggies.trove.api.UberType;
import org.bukkit.inventory.ItemStack;

import java.io.IOException;

@Getter
public abstract class WeaponBox extends Box {

    public WeaponBox(Trove plugin) {
        super(plugin);
    }

    public abstract ItemStack makeBox(UberType uberType) throws IOException;



}
