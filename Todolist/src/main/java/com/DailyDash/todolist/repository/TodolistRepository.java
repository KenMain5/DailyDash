package com.DailyDash.Todolist.repository;

import com.DailyDash.Todolist.entity.Todolist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TodolistRepository extends JpaRepository<Todolist, Long> {
    Todolist findTodolistByUsername(String username);
}
