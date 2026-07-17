package com.example.splitwise_jul_2026.models;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "user_expenses")
public class UserExpense extends BaseModel {
    @ManyToOne
    private User user;

    @ManyToOne
    private Expense expense;

    private double amount;

    @Enumerated(EnumType.ORDINAL)
    private UserExpenseType userExpenseType;

}
/*
 1       1
UE ----- E
 M       1

u ------- e

U1E1
U1E2
U2E1
U2E4


U1E1 -> paid by Alok: 1000

U2E1 -> paid by Chirag: 2000

U1E1 -> had to pay by Alok: 500
 */