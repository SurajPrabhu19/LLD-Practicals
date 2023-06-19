package com.scaler.bookmyshow.exceptions;

public class TheatreNotFoundException extends Exception {
    public TheatreNotFoundException() {
        super("THE THEATRE IS NOT PRESENT IN THE DATABASE");
    }
}
