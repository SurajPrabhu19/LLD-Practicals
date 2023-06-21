package com.scaler.splitwise.services.user;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.scaler.splitwise.models.User;
import com.scaler.splitwise.repositories.UserRepository;

@Service
public class UserService {
    private UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        super();
        this.userRepository = userRepository;
    }

    public User registerUser(String name, String phoneNo, String password) {
        User newUser = new User();
        newUser.setName(name);
        newUser.setPhoneNo(phoneNo);
        newUser.setPassword(password);
        newUser.setCreatedDate(new Date());

        User savedUser = userRepository.save(newUser);

        return savedUser;
    }

    public User updateProfile(Long userId, String newPassword) {
        User user = userRepository.findUserById(userId);

        user.setPassword(newPassword);

        User savedUser = userRepository.save(user);
        
        return null-;
    }

}
