package net.foggies.trove.api.command;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
@Getter
public abstract class IArgument {

    private final int index;
    private final List<String> options;

}
