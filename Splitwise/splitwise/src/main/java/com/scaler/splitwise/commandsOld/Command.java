package com.scaler.splitwise.commandsOld;

public interface Command {
    public boolean parse(String command);

    public void execute(String command);
}
