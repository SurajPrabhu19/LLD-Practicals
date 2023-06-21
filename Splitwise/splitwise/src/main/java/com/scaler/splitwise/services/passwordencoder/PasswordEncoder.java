package com.scaler.splitwise.services.passwordencoder;

public interface PasswordEncoder {
    String getEncodedPassword(String realPassword);

    boolean matchPassword(String realPassword, String hashedPassword);
}
