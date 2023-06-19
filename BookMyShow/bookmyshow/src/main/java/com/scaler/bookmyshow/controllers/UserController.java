package com.scaler.bookmyshow.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.scaler.bookmyshow.dtos.CreateUserRequestDto;
import com.scaler.bookmyshow.dtos.CreateUserResponseDto;
import com.scaler.bookmyshow.models.User;
import com.scaler.bookmyshow.services.UserService;

@Controller
public class UserController {
    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        super();
        System.out.println("**** USER SERVICE BEING CALLED ****");
        this.userService = userService;
    }

    public CreateUserResponseDto createUser(CreateUserRequestDto request) {
        User savedUser = userService.createUser(request.getEmail());

        CreateUserResponseDto response = new CreateUserResponseDto();
        response.setUser(savedUser);

        return response;
    }
}
