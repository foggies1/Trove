package net.foggies.trove;

import lombok.Getter;
import me.lucko.helper.plugin.ExtendedJavaPlugin;
import net.foggies.trove.api.TroveWorld;
import net.foggies.trove.api.command.ICommand;
import net.foggies.trove.impl.player.boxes.BoxRegistry;
import net.foggies.trove.impl.player.events.BoxOpenEvent;
import net.foggies.trove.impl.player.events.GemEvent;
import net.foggies.trove.impl.player.events.PlayerJoinQuitListener;
import net.foggies.trove.impl.player.gems.commands.GemBoxCommand;
import net.foggies.trove.impl.player.gems.commands.GemShopUICommand;
import net.foggies.trove.impl.player.gems.commands.GemUICommand;
import net.foggies.trove.impl.player.gems.factory.GemFactory;
import net.foggies.trove.impl.player.registry.TrovianRegistry;
import net.foggies.trove.impl.player.weapon.WeaponRegistry;
import net.foggies.trove.impl.player.weapon.commands.WeaponBoxCommand;
import net.foggies.trove.impl.uber.boss.BossDamageEvent;
import net.foggies.trove.impl.uber.boss.BossSpawnCommand;
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
    private WeaponRegistry weaponRegistry;
    private BoxRegistry boxRegistry;
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
        this.weaponRegistry = new WeaponRegistry(this);
        this.gemFactory = new GemFactory(this);
        this.boxRegistry = new BoxRegistry(this);

        registerListeners(new BoxOpenEvent(this), new BossDamageEvent(this), new PlayerJoinQuitListener(this), new GemEvent(this));
        new BossSpawnCommand(this);
        new GemUICommand(this);
        new GemShopUICommand(this);

        ICommand gemBoxCommand = new GemBoxCommand(this);
        getCommand(gemBoxCommand.getCommand()).setExecutor(gemBoxCommand);

        ICommand weaponBoxCommand = new WeaponBoxCommand(this);
        getCommand(weaponBoxCommand.getCommand()).setExecutor(weaponBoxCommand);

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
