package net.foggies.trove.impl.boss.data;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.bukkit.entity.Entity;

import java.util.UUID;

@RequiredArgsConstructor
@Getter
public class BossData {

    private final UUID id;
    private final Entity entity;

}
