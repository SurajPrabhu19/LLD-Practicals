package com.scaler.bookmyshow.models;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Payment extends BaseModel {
    private double amount;
    private Date timeOfPayment;
    private String transactionId;

    @ManyToOne
    private PaymentMode modeOfPayment;

    @ManyToOne
    private PaymentStatus status;

    @ManyToOne
    private Ticket ticket;
}
