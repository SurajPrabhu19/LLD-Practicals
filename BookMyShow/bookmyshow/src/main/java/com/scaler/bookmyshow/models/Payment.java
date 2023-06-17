package com.scaler.bookmyshow.models;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
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

    // @ManyToOne
    @Enumerated(EnumType.ORDINAL)
    private PaymentMode modeOfPayment;

    // @ManyToOne
    @Enumerated(EnumType.ORDINAL)
    private PaymentStatus status;

    @ManyToOne
    private Ticket ticket;
}
