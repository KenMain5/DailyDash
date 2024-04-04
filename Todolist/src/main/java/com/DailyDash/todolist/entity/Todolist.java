package com.DailyDash.todolist.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class Todolist {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private String title;

    @OneToMany(mappedBy = "todolist")
    private List<Task> tasks;

    @OneToOne
    private DashUser user;
}
