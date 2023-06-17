package com.scaler.bookmyshow.models;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Seat extends BaseModel {
    private int seatRow;
    private int seatCols;
    private String seatName;

    // @ManyToOne
    @Enumerated(EnumType.ORDINAL)
    private SeatStatus status;

    // @ManyToOne
    @Enumerated(EnumType.ORDINAL)
    private SeatType type;
}
