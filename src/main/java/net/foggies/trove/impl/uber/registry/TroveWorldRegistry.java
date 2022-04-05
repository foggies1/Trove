package net.foggies.trove.impl.uber.registry;

import net.foggies.trove.Trove;
import net.foggies.trove.api.TroveWorld;
import net.foggies.trove.impl.uber.worlds.UberOneWorld;
import net.foggies.trove.impl.uber.worlds.UberTwoWorld;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class TroveWorldRegistry {

    private final Trove plugin;
    private final Map<String, TroveWorld> worldMap;

    public TroveWorldRegistry(Trove plugin) {
        this.plugin = plugin;
        this.worldMap = new ConcurrentHashMap<>();
        loadMaps();
    }

    public List<TroveWorld> getUbers(){
        return this.worldMap.values().stream().toList();
    }

    public TroveWorld get(String world){
        return this.worldMap.get(world);
    }

    public void loadMaps(){
        this.worldMap.put("UberOne", new UberOneWorld());
        this.worldMap.put("UberTwo", new UberTwoWorld());
    }

}
