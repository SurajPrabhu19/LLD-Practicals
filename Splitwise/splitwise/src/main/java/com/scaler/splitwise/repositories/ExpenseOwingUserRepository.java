package com.scaler.splitwise.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.scaler.splitwise.models.Expense;
import com.scaler.splitwise.models.ExpenseOwingUser;

@Repository
public interface ExpenseOwingUserRepository extends JpaRepository<ExpenseOwingUser, Long> {
    List<ExpenseOwingUser> findAllByExpense(Expense expense);
}
