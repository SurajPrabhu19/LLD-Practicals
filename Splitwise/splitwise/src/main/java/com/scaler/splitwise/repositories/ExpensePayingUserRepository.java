package com.scaler.splitwise.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.scaler.splitwise.models.Expense;
import com.scaler.splitwise.models.ExpensePayingUser;

@Repository
public interface ExpensePayingUserRepository extends JpaRepository<ExpensePayingUser, Long> {
    List<ExpensePayingUser> findAllByExpense(Expense expense);
}
