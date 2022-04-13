package net.foggies.trove.impl.player.boxes;

import lombok.Getter;
import net.foggies.trove.Trove;
import net.foggies.trove.impl.player.gems.constant.GemRarity;
import org.bukkit.inventory.ItemStack;

import java.io.IOException;

@Getter
public abstract class GemBox extends Box {

    public GemBox(Trove plugin) {
        super(plugin);
    }

    public abstract ItemStack makeBox(GemRarity gemRarity) throws IOException;



}
