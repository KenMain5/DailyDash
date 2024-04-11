package com.DailyDash.Todolist.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private String task;

    @Enumerated(EnumType.STRING)
    private TaskPrioritizationLevel taskPrioritizationLevel;

    @ManyToOne()
    private Todolist todolist;

}
