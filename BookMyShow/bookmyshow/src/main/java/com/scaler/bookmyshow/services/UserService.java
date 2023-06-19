package com.scaler.bookmyshow.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.scaler.bookmyshow.models.User;
import com.scaler.bookmyshow.repositories.UserRepository;

@Service
public class UserService {
    private UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        super();
        this.userRepository = userRepository;
    }

    public User createUser(String email) {
        // create a new User + init with necessary values
        User user = new User();
        user.setEmail(email);

        // Save to the Database:
        user = userRepository.save(user);

        return user;
    }

}
