package com.DailyDash.todolist.entity;

import jakarta.persistence.*;

@Entity
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Enumerated(EnumType.STRING)
    private TaskPrioritizationLevel taskPrioritizationLevel;

    @ManyToOne()
    private Todolist todolist;

}
