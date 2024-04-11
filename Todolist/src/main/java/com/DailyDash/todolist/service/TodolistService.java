package com.DailyDash.Todolist.service;

import com.DailyDash.Todolist.dto.EditedListDTO;
import com.DailyDash.Todolist.entity.Todolist;

public interface TodolistService {
    public Todolist getList(String username);
    public void editList(EditedListDTO editedListDTO);
}
