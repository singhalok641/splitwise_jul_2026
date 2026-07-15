package com.example.splitwise_jul_2026.repositories;

import com.example.splitwise_jul_2026.models.UserExpense;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserExpenseRepository extends JpaRepository<UserExpense, Long> {
}
