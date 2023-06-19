package com.scaler.bookmyshow.exceptions;

public class UserNotRegisteredException extends Exception {

    public UserNotRegisteredException() {
        super("The following user is not Regiested to the Application, please register and Book Again");
    }
}
