package net.foggies.trove.impl.player.events;

import net.foggies.trove.Trove;
import net.foggies.trove.impl.player.boxes.Box;
import net.foggies.trove.impl.player.boxes.BoxRegistry;
import net.foggies.trove.impl.player.registry.TrovianRegistry;
import net.foggies.trove.impl.player.trovian.Trovian;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

import java.io.IOException;

public class BoxOpenEvent implements Listener {

    private final Trove plugin;
    private final BoxRegistry boxRegistry;
    private final TrovianRegistry trovianRegistry;

    public BoxOpenEvent(Trove plugin) {
        this.plugin = plugin;
        this.boxRegistry = plugin.getBoxRegistry();
        this.trovianRegistry = plugin.getTrovianRegistry();
    }

    @EventHandler
    public void onBoxOpen(PlayerInteractEvent e) throws IOException {
        final Player player = e.getPlayer();
        final Trovian trovian = this.trovianRegistry.get(player.getUniqueId());
        ItemStack itemInHand = player.getInventory().getItemInMainHand();

        if(itemInHand.getType() == Material.AIR) return;

        if(this.boxRegistry.isBox(itemInHand)){
            final Box box = this.boxRegistry.getBox(itemInHand);
            box.boxOpen(trovian, itemInHand);
        }


    }

}
