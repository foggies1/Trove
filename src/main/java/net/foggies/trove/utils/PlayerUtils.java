package net.foggies.trove.utils;

import me.lucko.helper.utils.Players;

import java.util.ArrayList;
import java.util.List;

public class PlayerUtils {

    public static List<String> getPlayerNames(){
        List<String> names = new ArrayList<>();
        Players.forEach(player -> names.add(player.getName()));
        return names;
    }

}
