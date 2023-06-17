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
// @Table(name = "show_seat_mapping") // give your desired table name with
// @Table(name="")
public class ShowSeat extends BaseModel {
    @ManyToOne
    private MainShow mainShow;

    @ManyToOne
    private Seat seat;

    // @ManyToOne
    @Enumerated(EnumType.ORDINAL)
    private ShowSeatStatus status;
}
