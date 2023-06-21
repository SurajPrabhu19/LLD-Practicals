package com.scaler.splitwise.models;

import java.util.Date;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Expense extends BaseModel {
    private double amount;
    private String description;

    // 1U -> mE
    // 1E -> 1U
    // Many to One: E -> U
    @ManyToOne
    private User createdBy;
    private Date createdAt;

    // 1E -> 1U
    // 1U -> mE
    @ManyToOne
    private List<User> user;

    // 1E -> 1C
    // mE <- 1E
    @ManyToOne
    private Currency baseCurrency;

    // private List<UserExpense> paidBy;
    // private List<UserExpense> owedBy;
}
