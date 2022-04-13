package net.foggies.trove.api;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import net.foggies.trove.Trove;
import net.foggies.trove.impl.uber.boss.data.BossHealth;
import net.foggies.trove.impl.uber.boss.data.BossInfo;
import net.foggies.trove.utils.StringUtils;
import org.bukkit.Location;
import org.bukkit.NamespacedKey;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Zombie;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.persistence.PersistentDataType;

import java.util.UUID;

@Getter
@Setter
@ToString
public abstract class TroveBoss {

    private UUID uuid;
    private String name;
    private BossHealth bossHealth;
    private BossInfo bossInfo;
    private EntityType entityType;
    private Entity entity;

    public TroveBoss(Location location, String name, double maxHealth, double currentHealth, double baseDamage, double baseCoins, double baseExperience, EntityType entityType) {
        this.uuid = UUID.randomUUID();
        this.name = name;
        this.bossHealth = new BossHealth(this, currentHealth, maxHealth);
        this.bossInfo = new BossInfo(this, baseCoins, baseDamage, baseExperience);
        this.entityType = entityType;
        this.entity = loadEntity(location);
    }

    public abstract void onDamage(EntityDamageByEntityEvent e);

    public Location getBossesCurrentLocation(){
        return this.entity.getLocation();
    }

    public void updateName(Entity entity) {
        entity.setCustomName(StringUtils.color(this.name + " (" + this.bossHealth.prettified() + ")"));
    }

    public Entity loadEntity(Location location) {

        Entity entity = location.getWorld().spawnEntity(location, this.entityType);

        if(entity instanceof Zombie zombie) zombie.setAdult();

        entity.setCustomNameVisible(true);
        entity.getPersistentDataContainer().set(
                new NamespacedKey(Trove.getPlugin(), "boss"),
                PersistentDataType.STRING,
                this.uuid.toString()
        );

        updateName(entity);
        return entity;
    }


}
