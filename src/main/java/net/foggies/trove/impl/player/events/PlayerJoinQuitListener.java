package net.foggies.trove.impl.player.events;

import net.foggies.trove.Trove;
import net.foggies.trove.api.UberType;
import net.foggies.trove.impl.player.trovian.TrovianHealth;
import net.foggies.trove.impl.player.boxes.GemBox;
import net.foggies.trove.impl.player.boxes.WeaponBox;
import net.foggies.trove.impl.player.gems.constant.GemRarity;
import net.foggies.trove.impl.player.gems.obj.Gem;
import net.foggies.trove.impl.player.gems.obj.GemData;
import net.foggies.trove.impl.player.registry.TrovianRegistry;
import net.foggies.trove.impl.player.skills.Skill;
import net.foggies.trove.impl.player.skills.SkillData;
import net.foggies.trove.impl.player.skills.SkillType;
import net.foggies.trove.impl.player.trovian.DustData;
import net.foggies.trove.impl.player.trovian.Trovian;
import net.foggies.trove.impl.player.trovian.TrovianStat;
import net.foggies.trove.impl.player.trovian.TrovianStats;
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
        skillTypeSkillMap.put(SkillType.COMBAT, new Skill(SkillType.COMBAT, 1, 1.0D));
        skillTypeSkillMap.put(SkillType.MINING, new Skill(SkillType.MINING, 1, 1.0D));
        skillTypeSkillMap.put(SkillType.TREE_CHOPPING, new Skill(SkillType.TREE_CHOPPING, 1, 1.0D));
        skillTypeSkillMap.put(SkillType.FARMING, new Skill(SkillType.FARMING, 1, 1.0D));

        List<Gem> gemList = new ArrayList<>();
        Gem gem = plugin.getGemFactory().makeGem(GemRarity.COMMON);
        Gem gem3 = plugin.getGemFactory().makeGem(GemRarity.SHADOW);
        Gem gem2 = plugin.getGemFactory().makeGem(GemRarity.STELLAR);
        gemList.add(gem);
        gemList.add(gem2);
        gemList.add(gem3);

        player.getInventory().addItem(((GemBox) plugin.getBoxRegistry().getBox("gem_box")).makeBox(GemRarity.COMMON));
        player.getInventory().addItem(((GemBox) plugin.getBoxRegistry().getBox("gem_box")).makeBox(GemRarity.RADIANT));
        player.getInventory().addItem(((GemBox) plugin.getBoxRegistry().getBox("gem_box")).makeBox(GemRarity.RARE));
        player.getInventory().addItem(((GemBox) plugin.getBoxRegistry().getBox("gem_box")).makeBox(GemRarity.RELIC));
        player.getInventory().addItem(((WeaponBox) plugin.getBoxRegistry().getBox("weapon_box")).makeBox(UberType.UBER_ONE));

        this.registry.add(
                new Trovian(
                        player.getUniqueId(),
                        new SkillData(skillTypeSkillMap),
                        new TrovianStats(
                                new TrovianStat(1.0D),
                                new TrovianStat(1.0D),
                                new TrovianStat(1.0D)
                        ),
                        new TrovianHealth(10000.0D, 10000.0D),
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
