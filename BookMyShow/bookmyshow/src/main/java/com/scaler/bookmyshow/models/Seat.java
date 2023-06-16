package com.scaler.bookmyshow.models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Seat {
    private int row;
    private int col;
    private String seatName;

    @ManyToOne
    private SeatStatus status;

    @ManyToOne
    private SeatType type;
}
