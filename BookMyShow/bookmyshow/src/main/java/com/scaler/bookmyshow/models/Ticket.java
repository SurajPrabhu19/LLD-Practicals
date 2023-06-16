package com.scaler.bookmyshow.models;

import java.util.Date;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Ticket extends BaseModel {
    private double price;
    private Date dateOfBooking;

    @ManyToOne
    private User user;

    @ManyToOne
    private Show show;

    @ManyToMany
    // this is a unique case where the cardinality is many to many
    // since cancellation is made possible and that can lead to many tickets for a
    // single show seat
    private List<ShowSeat> showSeats;

    @OneToMany(mappedBy = "ticket") // this help ORM to avoid duplicate tables for same relation
    private List<Payment> paymentModes;

    private TicketStatus status;
}
