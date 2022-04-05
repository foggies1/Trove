package net.foggies.trove.impl.player;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import net.foggies.trove.impl.player.gems.GemData;
import net.foggies.trove.impl.player.skills.SkillData;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.util.UUID;

@AllArgsConstructor
@Getter
@Setter
@ToString
public class Trovian {

    private UUID uuid;
    private SkillData skillData;
    private TrovianStats trovianStats;
    private GemData gemData;
    private DustData dustData;

    public Player toBukkit(){
        return Bukkit.getPlayer(uuid);
    }

}
