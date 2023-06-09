package com.scaler.bookmyshow.models;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class SeatTypeShow extends BaseModel {

    @ManyToOne
    private MainShow mainShow;

    // @ManyToOne
    @Enumerated(EnumType.ORDINAL)
    private SeatType seatType;

    private double price;
}
