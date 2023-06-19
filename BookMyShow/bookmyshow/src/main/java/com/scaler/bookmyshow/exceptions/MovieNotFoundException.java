package com.scaler.bookmyshow.exceptions;

public class MovieNotFoundException extends Exception {
    public MovieNotFoundException() {
        super("MOVIE NOT FOUND IN DATABASE");
    }
}
