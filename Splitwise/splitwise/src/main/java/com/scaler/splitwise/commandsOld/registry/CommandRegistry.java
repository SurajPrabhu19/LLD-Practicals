package com.scaler.splitwise.commandsOld.registry;

import com.scaler.splitwise.commandsOld.Command;

public interface CommandRegistry {
    public Command getCommand();

    public void addCommand();

    public void removeCommand();

    public boolean executeCommand();
}
