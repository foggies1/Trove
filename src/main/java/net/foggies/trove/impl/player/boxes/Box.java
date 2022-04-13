package net.foggies.trove.impl.player.boxes;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import net.foggies.trove.Trove;
import net.foggies.trove.impl.player.trovian.Trovian;
import org.bukkit.inventory.ItemStack;

import java.io.IOException;

@RequiredArgsConstructor
@Getter
public abstract class Box {

    private final Trove plugin;

    public abstract void boxOpen(Trovian trovian, ItemStack itemStack) throws IOException;

}
