package com.scaler.splitwise.models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class ExpensePayingUser extends BaseModel {
    private double amount;

    // 1EOU -> 1E
    // 1E -> m-EOU
    @ManyToOne
    private Expense expense;

    // Same as above
    @ManyToOne
    private User user;
}
