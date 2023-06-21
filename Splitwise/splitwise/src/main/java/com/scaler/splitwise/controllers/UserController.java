package com.scaler.splitwise.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.scaler.splitwise.dtos.RegisterUserRequestDto;
import com.scaler.splitwise.dtos.RegisterUserResponseDto;
import com.scaler.splitwise.dtos.UpdateProfileRequestDto;
import com.scaler.splitwise.dtos.UpdateProfileResponseDto;
import com.scaler.splitwise.models.BaseModel;
import com.scaler.splitwise.models.User;
import com.scaler.splitwise.services.user.UserService;

@Controller
public class UserController extends BaseModel {
    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        super();
        this.userService = userService;
    }

    public RegisterUserResponseDto registerUser(RegisterUserRequestDto request) {
        User user = userService.registerUser(request.getName(), request.getPhoneNo(), request.getPassword());

        RegisterUserResponseDto response = new RegisterUserResponseDto();
        response.setUser(user);
        return response;
    }

    public UpdateProfileResponseDto updateProfile(UpdateProfileRequestDto request) {
        User user = userService.updateProfile(request.getUserId(), request.getNewPassword());

        UpdateProfileResponseDto response = new UpdateProfileResponseDto();
        response.setUser(user);
        return response;
    }

}
