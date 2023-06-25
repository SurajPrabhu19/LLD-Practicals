package com.scaler.splitwise.commands;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.scaler.splitwise.controllers.UserController;
import com.scaler.splitwise.dtos.RegisterUserRequestDto;
import com.scaler.splitwise.dtos.RegisterUserResponseDto;

@Component
public class RegisterUserCommand implements Command {

    @Autowired
    private UserController userController;

    @Autowired
    public RegisterUserCommand(UserController userController) {
        super();
        this.userController = userController;
    }

    @Override
    public boolean canExecute(String input) {
        List<String> commandTokens = Arrays.stream(input.split(" ")).toList();

        if (commandTokens.size() != 4) {
            return false;
        }
        
        // we use .equals since both are strings:
        if (!commandTokens.get(0).equals(CommandKeywords.REGISTER_USER_COMMAND)) {
            return false;
        }

        return true;
    }

    @Override
    public void execute(String input) {
        List<String> commandTokens = Arrays.stream(input.split(" ")).toList();

        RegisterUserRequestDto request = new RegisterUserRequestDto();
        request.setName(commandTokens.get(1));
        request.setPhoneNo(commandTokens.get(2));
        request.setPassword(commandTokens.get(3));

        RegisterUserResponseDto response = userController.registerUser(request);

        System.out.println(response.getUser().getName() + " registered");

    }

}
