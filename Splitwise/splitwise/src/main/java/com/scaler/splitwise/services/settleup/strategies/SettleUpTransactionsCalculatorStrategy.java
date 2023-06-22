package com.scaler.splitwise.services.settleup.strategies;

import java.util.List;

import com.scaler.splitwise.models.ExpenseOwingUser;
import com.scaler.splitwise.models.ExpensePayingUser;
import com.scaler.splitwise.services.settleup.Transaction;

public interface SettleUpTransactionsCalculatorStrategy {
    List<Transaction> getTransaction(List<ExpenseOwingUser> owingUsers, List<ExpensePayingUser> payingUsers);
}
