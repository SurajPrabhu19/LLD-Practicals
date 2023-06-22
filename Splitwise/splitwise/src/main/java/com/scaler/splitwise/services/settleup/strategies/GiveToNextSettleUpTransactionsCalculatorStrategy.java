package com.scaler.splitwise.services.settleup.strategies;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.scaler.splitwise.models.ExpenseOwingUser;
import com.scaler.splitwise.models.ExpensePayingUser;
import com.scaler.splitwise.models.User;
import com.scaler.splitwise.services.settleup.Transaction;

@Service
public class GiveToNextSettleUpTransactionsCalculatorStrategy implements SettleUpTransactionsCalculatorStrategy {

    @Override
    public List<Transaction> getTransaction(List<ExpenseOwingUser> owingUsers, List<ExpensePayingUser> payingUsers) {

        Map<User, Double> extraAmounts = new HashMap<>();

        for (ExpensePayingUser payingUser : payingUsers) {
            User user = payingUser.getUser();
            double userAmount = payingUser.getAmount();

            if (!extraAmounts.containsKey(user)) {
                extraAmounts.put(user, 0.0);
            }
            extraAmounts.put(user, extraAmounts.get(user) + userAmount);
        }

        for (ExpenseOwingUser owingUser : owingUsers) {
            User user = owingUser.getUser();
            double userAmount = owingUser.getAmount();

            if (!extraAmounts.containsKey(user)) {
                extraAmounts.put(user, 0.0);
            }
            extraAmounts.put(user, extraAmounts.get(user) - userAmount);
        }

        List<Map.Entry<User, Double>> entries = new ArrayList<>(extraAmounts.entrySet());

        List<Transaction> transactionsToSettleUp = new ArrayList<>();

        for (int i = 0; i < entries.size() - 2; i++) {
            Transaction transaction = new Transaction();
            User user1 = entries.get(i).getKey();
            User user2 = entries.get(i + 1).getKey();

            double amount1 = entries.get(i).getValue();
            double amount2 = entries.get(i + 1).getValue();

            if (amount1 < 0) {
                transaction.setFrom(user2);
                transaction.setTo(user1);
                transaction.setAmount(Math.abs(amount1));

                entries.get(i + 1).setValue(amount2 - Math.abs(amount1));
            } else {
                transaction.setFrom(user1);
                transaction.setTo(user2);
                transaction.setAmount(Math.abs(amount1));

                entries.get(i + 1).setValue(amount2 + Math.abs(amount1));
            }

            // last 2 lines in if else can be written as given below outside the condition:
            // transaction.setAmount(Math.abs(amount1));
            // entries.get(i + 1).setValue(amount1 + amount2);
            // amount1 can be (+/-) depending on whether the user owes(-) or needsToPay(+)

        }

        return transactionsToSettleUp;
    }

}