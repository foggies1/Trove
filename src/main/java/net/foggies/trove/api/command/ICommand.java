package net.foggies.trove.api.command;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import me.lucko.helper.utils.Players;
import net.foggies.trove.Trove;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Getter
public abstract class ICommand implements TabCompleter, CommandExecutor {

    private final Trove plugin;
    private final String command;
    private final String helpMessage;

    public abstract List<ISubCommand> getSubCommands();


    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {

        if (command.getName().equalsIgnoreCase(this.command)) {

            if (args.length == 0) {
                Players.msg(sender, getHelpMessage());
                return false;
            }

            if (args.length > 1) {
                ISubCommand subCommand = getSubCommand(args[0]);

                if (subCommand == null) {
                    Players.msg(sender, getHelpMessage());
                    return false;
                }

                if (args.length == (subCommand.getArgumentList().size() + 1)) {
                    try {
                        subCommand.execute(sender, args);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                } else {
                    Players.msg(sender, getHelpMessage());
                }

                return true;
            }

        }

        return false;
    }

    @Override
    public @Nullable List<String> onTabComplete(@NotNull CommandSender sender, @NotNull Command command, @NotNull String alias, @NotNull String[] args) {

        if (args.length == 0) new ArrayList<>();
        if (args.length == 1)
            return getSubCommands().stream().map(ISubCommand::getDisplay).collect(Collectors.toList());

        String sub = args[0];

        for (ISubCommand subCommand : getSubCommands()) {
            if (subCommand.getDisplay().equalsIgnoreCase(sub))
                return subCommand.getArg(args.length - 1).getOptions();
        }

        return null;
    }

    public ISubCommand getSubCommand(String arg) {
        return getSubCommands().stream().filter(subCommand -> subCommand.getDisplay().equalsIgnoreCase(arg)).findFirst().orElse(null);
    }

    public IArgument getArgument(String arg) {
        for (ISubCommand subCommand : getSubCommands()) {
            for (IArgument argument : subCommand.getArgumentList()) {
                for (String option : argument.getOptions()) {
                    if (option.equalsIgnoreCase(arg)) {
                        return argument;
                    }
                }
            }
        }
        return null;
    }

}
