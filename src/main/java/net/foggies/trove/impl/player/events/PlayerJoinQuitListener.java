package net.foggies.trove.impl.player.events;

import net.foggies.trove.Trove;
import net.foggies.trove.impl.player.DustData;
import net.foggies.trove.impl.player.Trovian;
import net.foggies.trove.impl.player.TrovianStat;
import net.foggies.trove.impl.player.TrovianStats;
import net.foggies.trove.impl.player.gems.Gem;
import net.foggies.trove.impl.player.gems.GemData;
import net.foggies.trove.impl.player.gems.GemRarity;
import net.foggies.trove.impl.player.registry.TrovianRegistry;
import net.foggies.trove.impl.player.skills.Skill;
import net.foggies.trove.impl.player.skills.SkillData;
import net.foggies.trove.impl.player.skills.SkillType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class PlayerJoinQuitListener implements Listener {

    private final Trove plugin;
    private final TrovianRegistry registry;

    public PlayerJoinQuitListener(Trove plugin) {
        this.plugin = plugin;
        this.registry = plugin.getTrovianRegistry();
    }

    @EventHandler
    public void onJoin(PlayerJoinEvent e) throws IOException {
        Player player = e.getPlayer();

        Map<SkillType, Skill> skillTypeSkillMap = new ConcurrentHashMap<>();
        skillTypeSkillMap.put(SkillType.COMBAT, new Skill(SkillType.COMBAT, 10000, 1.0D));
        skillTypeSkillMap.put(SkillType.MINING, new Skill(SkillType.MINING, 10000, 1.0D));
        skillTypeSkillMap.put(SkillType.TREE_CHOPPING, new Skill(SkillType.TREE_CHOPPING, 10000, 1.0D));
        skillTypeSkillMap.put(SkillType.FARMING, new Skill(SkillType.FARMING, 10000, 1.0D));

        List<Gem> gemList = new ArrayList<>();
        Gem gem = plugin.getGemFactory().makeGem(GemRarity.COMMON);
        Gem gem3 = plugin.getGemFactory().makeGem(GemRarity.SHADOW);
        Gem gem2 = plugin.getGemFactory().makeGem(GemRarity.STELLAR);
        gemList.add(gem);
        gemList.add(gem2);
        gemList.add(gem3);

        player.getInventory().addItem(plugin.getGemFactory().getGemBoxFactory().makeBox(GemRarity.COMMON));
        player.getInventory().addItem(plugin.getGemFactory().getGemBoxFactory().makeBox(GemRarity.SHADOW));
        player.getInventory().addItem(plugin.getGemFactory().getGemBoxFactory().makeBox(GemRarity.STELLAR));
        player.getInventory().addItem(plugin.getGemFactory().getGemBoxFactory().makeBox(GemRarity.RADIANT));
        player.getInventory().addItem(plugin.getGemFactory().getGemBoxFactory().makeBox(GemRarity.RARE));
        player.getInventory().addItem(plugin.getGemFactory().getGemBoxFactory().makeBox(GemRarity.RELIC));
        player.getInventory().addItem(plugin.getGemFactory().getGemBoxFactory().makeBox(GemRarity.LEGENDARY));

        this.registry.add(
                new Trovian(
                        player.getUniqueId(),
                        new SkillData(skillTypeSkillMap),
                        new TrovianStats(
                                new TrovianStat(1.0D),
                                new TrovianStat(1.0D),
                                new TrovianStat(1.0D)
                        ),
                        new GemData(gemList),
                        new DustData(1000000, 1000000, 100000, 100000)

                )
        );
    }

    @EventHandler
    public void onQuit(PlayerQuitEvent e) {
        Player player = e.getPlayer();
        this.registry.remove(player.getUniqueId());
    }

}
