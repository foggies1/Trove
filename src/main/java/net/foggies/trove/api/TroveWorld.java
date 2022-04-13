package net.foggies.trove.api;

import lombok.Getter;
import lombok.Setter;
import me.lucko.helper.Schedulers;
import net.foggies.trove.utils.Cuboid;
import net.foggies.trove.utils.EntityUtils;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Entity;

import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

@Getter
@Setter
public abstract class TroveWorld {

    private String worldIdentifier;
    private World bukkitWorld;
    private Cuboid region;
    private UberType bossType;
    private Map<UUID, TroveBoss> bossMap;

    public TroveWorld(String worldIdentifier, World bukkitWorld, Cuboid region, UberType bossType) {
        this.worldIdentifier = worldIdentifier;
        this.bukkitWorld = bukkitWorld;
        this.region = region;
        this.bossType = bossType;
        this.bossMap = new ConcurrentHashMap<>();
        refresh();
    }

    public abstract void onBossSpawn();

    public void refresh() {
        Schedulers.sync().runRepeating(() -> {
            clearBosses();
            spawnBosses(100);
        }, 20L, 20L * 20L);
    }

    private void addBoss(TroveBoss boss) {
        this.bossMap.put(boss.getUuid(), boss);
    }

    public void clearBosses() {
        this.bossMap.values().forEach(this::removeBoss);
    }

    public void removeBoss(TroveBoss troveBoss) {
        removeBoss(troveBoss.getEntity());
    }

    public TroveBoss getBoss(Entity entity){
        return this.bossMap.get(EntityUtils.getUUID(entity, "boss"));
    }

    private void removeBoss(Entity entity) {
        this.bossMap.remove(EntityUtils.getUUID(entity, "boss"));
        entity.remove();
    }

    public void spawnBosses(int amount) {

        for (int i = 0; i < amount; i++) {
            final Location location = this.region.getRandomLocation();
            TroveBoss boss = bossType.toTroveBoss(location);
            System.out.println(boss.toString());
            addBoss(boss);
            onBossSpawn();
        }

    }

}
