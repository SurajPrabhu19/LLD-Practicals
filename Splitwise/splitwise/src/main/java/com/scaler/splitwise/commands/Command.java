package com.scaler.splitwise.commands;

public interface Command {
    boolean canExecute(String input);

    void execute(String input);
}
