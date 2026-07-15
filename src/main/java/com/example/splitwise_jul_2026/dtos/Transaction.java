package com.example.splitwise_jul_2026.dtos;

import com.example.splitwise_jul_2026.models.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Transaction {
    private User from;   // who pays
    private User to;     // who receives
    private double amount;

    @Override
    public String toString() {
        return from.getName() + " → " + to.getName() + ": ₹" + amount;
    }

    /*
    Alok -> Suraj: Rs. 100
    Shilpa -> Rahul: Rs. 200
    ..
    ..

     */
}
