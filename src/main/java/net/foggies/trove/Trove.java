package net.foggies.trove;

import lombok.Getter;
import me.lucko.helper.plugin.ExtendedJavaPlugin;
import net.foggies.trove.api.TroveWorld;
import net.foggies.trove.impl.boss.BossDamageEvent;
import net.foggies.trove.impl.boss.BossSpawnCommand;
import net.foggies.trove.impl.player.events.GemApplyEvent;
import net.foggies.trove.impl.player.events.PlayerJoinQuitListener;
import net.foggies.trove.impl.player.gems.GemFactory;
import net.foggies.trove.impl.player.gems.GemShopUICommand;
import net.foggies.trove.impl.player.gems.GemUICommand;
import net.foggies.trove.impl.player.registry.TrovianRegistry;
import net.foggies.trove.impl.uber.registry.TroveWorldRegistry;
import net.milkbowl.vault.economy.Economy;
import org.bukkit.event.Listener;
import org.bukkit.plugin.RegisteredServiceProvider;

import java.util.Arrays;

@Getter
public final class Trove extends ExtendedJavaPlugin {

    private static Trove plugin;
    private TrovianRegistry trovianRegistry;
    private TroveWorldRegistry uberRegistry;
    private Economy economy;
    private GemFactory gemFactory;

    @Override
    public void enable() {

        plugin = this;

        if (!setupEconomy()) {
            System.out.println("Disabled plugin due to not Vault plugin.");
            getServer().getPluginManager().disablePlugin(this);
            return;
        }

        this.uberRegistry = new TroveWorldRegistry(this);
        this.trovianRegistry = new TrovianRegistry(this);
        this.gemFactory = new GemFactory(this);

        registerListeners(new BossDamageEvent(this), new PlayerJoinQuitListener(this), new GemApplyEvent(this));
        new BossSpawnCommand(this);
        new GemUICommand(this);
        new GemShopUICommand(this);

    }

    @Override
    public void disable() {

        this.uberRegistry.getUbers().forEach(TroveWorld::clearBosses);

    }

    private boolean setupEconomy() {
        if (getServer().getPluginManager().getPlugin("Vault") == null) {
            return false;
        }
        RegisteredServiceProvider<Economy> rsp = getServer().getServicesManager().getRegistration(Economy.class);
        if (rsp == null) {
            return false;
        }
        economy = rsp.getProvider();
        return economy != null;
    }

    private void registerListeners(Listener... events) {
        Arrays.stream(events).forEach(event -> getServer().getPluginManager().registerEvents(event, this));
    }

    public static Trove getPlugin() {
        return plugin;
    }
}
