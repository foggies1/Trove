package net.foggies.trove.impl.player.registry;

import net.foggies.trove.Trove;
import net.foggies.trove.impl.player.trovian.Trovian;

import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

public class TrovianRegistry {

    private final Trove plugin;
    private final Map<UUID, Trovian> trovianMap;

    public TrovianRegistry(Trove plugin) {
        this.plugin = plugin;
        this.trovianMap = new ConcurrentHashMap<>();
    }

    public void add(Trovian trovian){
        this.trovianMap.put(trovian.getUuid(), trovian);
    }

    public void remove(UUID uuid){
        this.trovianMap.remove(uuid);
    }

    public Trovian get(UUID uuid){
        return this.trovianMap.get(uuid);
    }

}
