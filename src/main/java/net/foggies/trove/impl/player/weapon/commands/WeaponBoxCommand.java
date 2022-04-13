package net.foggies.trove.impl.player.weapon.commands;

import me.lucko.helper.utils.Players;
import net.foggies.trove.Trove;
import net.foggies.trove.api.UberType;
import net.foggies.trove.api.command.CommandArgument;
import net.foggies.trove.api.command.ICommand;
import net.foggies.trove.api.command.ISubCommand;
import net.foggies.trove.impl.player.boxes.WeaponBox;
import net.foggies.trove.utils.PlayerUtils;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class WeaponBoxCommand extends ICommand {


    public WeaponBoxCommand(Trove plugin) {
        super(
                plugin,
                "weaponbox",
                "&c/weaponbox give <player> <uber> <amount>"
        );
    }


    private static class WeaponBoxGiveCommand extends ISubCommand {

        public WeaponBoxGiveCommand(Trove plugin) {
            super(
                    plugin,
                    "give",
                    Arrays.asList(
                            new CommandArgument(1, PlayerUtils.getPlayerNames()),
                            new CommandArgument(2, new ArrayList<>(UberType.getNames())),
                            new CommandArgument(3, Arrays.asList("1", "10", "64"))
                    )
            );
        }

        @Override
        public void execute(CommandSender sender, String[] args) throws IOException {
            final Player player = Players.getNullable(args[1]);
            final ItemStack gemBox = ((WeaponBox) getPlugin().getBoxRegistry().getBox("weapon_box"))
                    .makeBox(UberType.valueOf(args[2].toUpperCase()));
            final int amount = Integer.parseInt(args[3]);

            gemBox.setAmount(amount);

            player.getInventory().addItem(gemBox);
        }


    }

    @Override
    public List<ISubCommand> getSubCommands() {
        return Arrays.asList(
                new WeaponBoxGiveCommand(getPlugin())
        );
    }
}
