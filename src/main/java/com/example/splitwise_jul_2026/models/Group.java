package com.example.splitwise_jul_2026.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity(name = "spgroups")  // "groups" is a reserved keyword in SQL
public class Group extends BaseModel {
    private String name;
    @ManyToOne
    private User admin;
    @ManyToMany
    private List<User> members;
    @OneToMany
    @JoinColumn(name = "group_id")
    private List<Expense> expenses;
}
// 1               1
// G -- admin--- User -> M:1
// M              1