package com.example.splitwise_jul_2026.strategies;

import com.example.splitwise_jul_2026.dtos.Transaction;
import com.example.splitwise_jul_2026.models.User;

import java.util.List;
import java.util.Map;

public interface SettleUpStrategy {
    /*
    Given a map of user -> net balance
    positive balance = owed money(creditor)
    negative balance = owes money(debtor)
     */
    List<Transaction> settleUp(Map<User, Double> balances);
}
