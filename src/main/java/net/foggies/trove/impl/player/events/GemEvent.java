package net.foggies.trove.impl.player.events;

import me.lucko.helper.utils.Players;
import net.foggies.trove.Trove;
import net.foggies.trove.impl.player.gems.factory.GemFactory;
import net.foggies.trove.impl.player.gems.obj.Gem;
import net.foggies.trove.impl.player.registry.TrovianRegistry;
import net.foggies.trove.impl.player.trovian.Trovian;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

import java.io.IOException;

public class GemEvent implements Listener {

    private final Trove plugin;
    private final GemFactory gemFactory;
    private final TrovianRegistry trovianRegistry;

    public GemEvent(Trove plugin) {
        this.plugin = plugin;
        this.gemFactory = plugin.getGemFactory();
        this.trovianRegistry = plugin.getTrovianRegistry();
    }

    @EventHandler
    public void onGemClick(PlayerInteractEvent e) throws IOException, ClassNotFoundException {
        final Player player = e.getPlayer();
        final Trovian trovian = this.trovianRegistry.get(player.getUniqueId());
        ItemStack itemInHand = player.getInventory().getItemInMainHand();

        if(itemInHand.getType() == Material.AIR) return;

        if(this.gemFactory.isGem(itemInHand)) {

            final Gem gem = this.gemFactory.toGem(itemInHand);
            boolean equipped = trovian.getGemData().addGem(gem);

            if(equipped){
                Players.msg(player, "&aYou've equipped a Gem.");
                itemInHand.setAmount(itemInHand.getAmount() - 1);
            } else {
                Players.msg(player, "&cYou've reached the Maximum amount of Gems you can have.");
                Players.msg(player, "&cRemove a gem and try gain.");
            }

        }


    }

}
