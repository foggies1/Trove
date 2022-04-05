package net.foggies.trove.impl.player.skills;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import net.foggies.trove.utils.Number;
import net.foggies.trove.utils.StringUtils;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.title.TitlePart;
import org.bukkit.entity.Player;

@AllArgsConstructor
@Getter
@Setter
public class Skill {

    private SkillType skillType;
    private long currentLevel;
    private double currentExperience;

    public double getRequiredExperience(){
        return Math.pow(currentLevel, 2.5D);
    }

    public void addLevel(Player player, long amount){
        player.sendTitlePart(TitlePart.TITLE,
                Component.text(
                        StringUtils.color("&6" + this.skillType.getPrefix() + " Level Up (+" + amount + ")")
                )
        );
        setCurrentLevel(getCurrentLevel() + amount);
    }

    public void addExperience(Player player, double amount){

        if(getCurrentExperience() + amount > getRequiredExperience()){
            setCurrentExperience(0.0D);
            addLevel(player,1L);
            return;
        }

        player.sendActionBar(Component.text(
                StringUtils.color(
                        "&e&l" + this.skillType.getPrefix() + " &7» &f+" + Number.pretty(amount) +
                        " &7(&e" + Number.formatted(currentExperience) + "/&6" + Number.formatted(getRequiredExperience()) + "&7)"
                )
        ));

        setCurrentExperience(getCurrentExperience() + amount);

    }

}
