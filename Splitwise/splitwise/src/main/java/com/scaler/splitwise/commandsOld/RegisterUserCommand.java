package com.scaler.splitwise.commandsOld;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.scaler.splitwise.controllers.UserController;
import com.scaler.splitwise.dtos.RegisterUserRequestDto;
import com.scaler.splitwise.dtos.RegisterUserResponseDto;

public class RegisterUserCommand implements Command {

    @Autowired
    private UserController userController;

    @Autowired
    public RegisterUserCommand(UserController userController) {
        super();
        this.userController = userController;
    }

    @Override
    public boolean parse(String command) {
        List<String> commandTokens = Arrays.stream(command.split(" ")).toList();

        if (commandTokens.size() > 4) {
            System.out.println("Incorrect Command");
            return false;
        }

        if (!commandTokens.get(0).equals("Register")) {
            System.out.println("Not a Register User Command");
            return false;
        }

        return true;
    }

    @Override
    public void execute(String command) {
        List<String> commandTokens = Arrays.stream(command.split(" ")).toList();

        RegisterUserRequestDto request = new RegisterUserRequestDto();
        request.setName(commandTokens.get(1));
        request.setPhoneNo(commandTokens.get(2));
        request.setPassword(commandTokens.get(3));

        RegisterUserResponseDto response = userController.registerUser(request);

        System.out.println(response.getUser().getName() + " is Registered");
    }

}
