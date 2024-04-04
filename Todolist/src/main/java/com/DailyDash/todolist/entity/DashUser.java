package com.DailyDash.todolist.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class DashUser {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private String username;

    @OneToOne(mappedBy = "dashuser")
    private Todolist todolist;
}
