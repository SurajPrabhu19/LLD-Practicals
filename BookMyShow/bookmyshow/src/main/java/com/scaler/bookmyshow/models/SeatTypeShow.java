package com.scaler.bookmyshow.models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class SeatTypeShow extends BaseModel {

    @ManyToOne
    private Show show;

    @ManyToOne
    private SeatType seatType;

    private double price;
}
