package com.scaler.splitwise.services.settleup;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.scaler.splitwise.models.Expense;
import com.scaler.splitwise.models.ExpenseOwingUser;
import com.scaler.splitwise.models.ExpensePayingUser;
import com.scaler.splitwise.models.Group;
import com.scaler.splitwise.repositories.ExpenseOwingUserRepository;
import com.scaler.splitwise.repositories.ExpensePayingUserRepository;
import com.scaler.splitwise.repositories.GroupRepository;
import com.scaler.splitwise.services.settleup.strategies.SettleUpTransactionsCalculatorStrategy;

@Service
public class SettleUpService {

    @Autowired
    @Qualifier("giveToNextSettleUpStrategy")
    private SettleUpTransactionsCalculatorStrategy settleUpTransactionsCalculatorStrategy;

    @Autowired
    private SettleUpTransactionsCalculatorStrategy minMaxSettleUpStrategy;
    private GroupRepository groupRepository;
    private ExpenseOwingUserRepository expenseOwingUserRepository;
    private ExpensePayingUserRepository expensePayingUserRepository;

    @Autowired
    public SettleUpService(GroupRepository groupRepository, ExpenseOwingUserRepository expenseOwingUserRepository,
            ExpensePayingUserRepository expensePayingUserRepository,
            SettleUpTransactionsCalculatorStrategy settleUpTransactionsCalculatorStrategy) {
        super();
        this.groupRepository = groupRepository;
        this.expenseOwingUserRepository = expenseOwingUserRepository;
        this.expensePayingUserRepository = expensePayingUserRepository;
        this.settleUpTransactionsCalculatorStrategy = settleUpTransactionsCalculatorStrategy;
    }

    public List<Transaction> settleUpUser(Long userId) {
        return new ArrayList<Transaction>();
    }

    public List<Transaction> settleUpGroup(Long groupId, String method) {
        // Optional<Transaction>
        Optional<Group> optionalGroup = groupRepository.findById(groupId);

        if (optionalGroup.isEmpty()) {
            System.out.println("Group Not found");
            return new ArrayList<Transaction>();
        }

        Group group = optionalGroup.get();
        List<Expense> expenses = group.getExpenses();

        List<ExpenseOwingUser> expenseOwingUsers = new ArrayList<>();
        List<ExpensePayingUser> expensePayingUsers = new ArrayList<>();

        for (Expense expense : expenses) {
            expenseOwingUsers.addAll(expenseOwingUserRepository.findAllByExpense(expense));
            expensePayingUsers.addAll(expensePayingUserRepository.findAllByExpense(expense));
        }

        if (method == "minMax") {
            return minMaxSettleUpStrategy.getTransaction(expenseOwingUsers, expensePayingUsers);
        }

        return settleUpTransactionsCalculatorStrategy.getTransaction(expenseOwingUsers, expensePayingUsers);

    }
}
