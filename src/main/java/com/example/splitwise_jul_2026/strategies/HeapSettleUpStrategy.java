package com.example.splitwise_jul_2026.strategies;

import com.example.splitwise_jul_2026.dtos.Transaction;
import com.example.splitwise_jul_2026.models.User;

import java.util.List;
import java.util.Map;

public class HeapSettleUpStrategy implements SettleUpStrategy{
    @Override
    public List<Transaction> settleUp(Map<User, Double> balances) {
        return null;
    }
}
