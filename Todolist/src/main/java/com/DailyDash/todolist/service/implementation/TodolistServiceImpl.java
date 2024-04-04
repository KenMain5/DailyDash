package com.DailyDash.todolist.service.implementation;

import com.DailyDash.todolist.dto.EditedListDTO;
import com.DailyDash.todolist.entity.Todolist;
import com.DailyDash.todolist.repository.TodolistRepository;
import com.DailyDash.todolist.service.TodolistService;
import com.netflix.discovery.converters.Auto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TodolistServiceImpl implements TodolistService {

    private final TodolistRepository todolistRepository;

    @Autowired
    public TodolistServiceImpl(TodolistRepository todolistRepository) {
        this.todolistRepository = todolistRepository;
    }

    @Override
    public Todolist getList(String username) {
        todolistRepository.findTodolistByDashUser(username);
        //search username from repository.
        //if found, return user
        //if empty, return empty..
        return null;
    }

    @Override
    public void editList(EditedListDTO editedListDTO) {

    }


}
