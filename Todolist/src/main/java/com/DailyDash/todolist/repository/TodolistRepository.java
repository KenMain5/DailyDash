package com.DailyDash.todolist.repository;

import com.DailyDash.todolist.entity.Todolist;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TodolistRepository extends JpaRepository<Todolist, Long> {
    Todolist findTodolistByDashUser();
}
