package net.foggies.trove.api.command;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import net.foggies.trove.Trove;
import org.bukkit.command.CommandSender;

import java.io.IOException;
import java.util.List;

@RequiredArgsConstructor
@Getter
public abstract class ISubCommand {

    private final Trove plugin;
    private final String display;
    private final List<IArgument> argumentList;

    public abstract void execute(CommandSender sender, String[] args) throws IOException;

    public IArgument getArg(int index){
        return argumentList.stream().filter(arg -> arg.getIndex() == index).findFirst().orElse(null);
    }

}
