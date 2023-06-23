package com.scaler.splitwise.commands.Registry;

import com.scaler.splitwise.commands.Command;

public interface CommandRegistry {
    boolean registerCommand(Command command);

    boolean unregisterCommand(Command command);

    void execute(String input);
}
