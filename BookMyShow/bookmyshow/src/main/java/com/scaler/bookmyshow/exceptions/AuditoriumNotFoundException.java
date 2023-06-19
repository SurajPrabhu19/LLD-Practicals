package com.scaler.bookmyshow.exceptions;

public class AuditoriumNotFoundException extends Exception {
    public AuditoriumNotFoundException() {
        super("THEATRE NOT FOUND IN DATABASE");
    }
}
