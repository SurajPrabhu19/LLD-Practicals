package com.scaler.splitwise.commands.Registry;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.scaler.splitwise.commands.Command;
import com.scaler.splitwise.commands.RegisterUserCommand;
import com.scaler.splitwise.commands.UpdateProfileCommand;

@Component
public class CommandRegistryImpl implements CommandRegistry {
    private List<Command> commands = new ArrayList<Command>();

    @Autowired
    public CommandRegistryImpl(RegisterUserCommand registerUserCommand, UpdateProfileCommand updateProfileCommand) {
        super();
        commands.add(registerUserCommand);
        commands.add(updateProfileCommand);
    }

    @Override
    public boolean registerCommand(Command command) {
        if (commands.contains(command)) {
            return false;
        }

        commands.add(command);
        return true;
    }

    @Override
    public boolean unregisterCommand(Command command) {
        if (commands.contains(command)) {
            commands.remove(command);
        }
        return false;
    }

    @Override
    public void execute(String input) {
        for (Command command : commands) {
            if (command.canExecute(input)) {
                command.execute(input);
                return;
            }
        }
    }

}
