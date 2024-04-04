package com.DailyDash.todolist.service;


import com.DailyDash.todolist.dto.EditedListDTO;
import com.DailyDash.todolist.entity.Todolist;

public interface TodolistService {
    public Todolist getList(String username);
    public void editList(EditedListDTO editedListDTO);
}
