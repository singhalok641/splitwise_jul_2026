package com.example.splitwise_jul_2026.models;

import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity(name = "expenses")
public class Expense extends BaseModel {
    private String description;
    private double amount;

    @ManyToOne
    private User createdBy;
    @Enumerated(EnumType.ORDINAL)
    private ExpenseType expenseType;

    @ManyToOne
    @Nullable
    private Group group; // nullable - expense may not belong to a group

    @OneToMany(mappedBy = "expense", cascade = CascadeType.ALL)
    private List<UserExpense> userExpenses;
}
