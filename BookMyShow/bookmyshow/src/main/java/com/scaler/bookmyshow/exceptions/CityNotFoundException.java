package com.scaler.bookmyshow.exceptions;

public class CityNotFoundException extends Exception {
    public CityNotFoundException() {
        super("CITY NOT FOUND IN THE DATABASE");
    }
}
