package com.scaler.bookmyshow.exceptions;

public class ShowSeatNotAvailableException extends Exception {
    public ShowSeatNotAvailableException(Long seatId) {
        super("The Seat with Id " + seatId + "is not available for Booking.");
    }
}
