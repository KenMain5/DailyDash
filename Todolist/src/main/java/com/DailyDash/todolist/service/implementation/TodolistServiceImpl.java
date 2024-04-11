package com.DailyDash.Todolist.service.implementation;

import com.DailyDash.Todolist.dto.EditedListDTO;
import com.DailyDash.Todolist.entity.Todolist;
import com.DailyDash.Todolist.repository.TodolistRepository;
import com.DailyDash.Todolist.service.TodolistService;
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
        Todolist userTodolist = todolistRepository.findTodolistByUsername(username);
        if (userTodolist.getTitle() == null) {
            userTodolist.setTitle("To Do List");
        }
        return userTodolist;
    }

    @Override
    public void editList(EditedListDTO editedListDTO) {
        Todolist newTodolist = new Todolist();

        newTodolist.setTitle(editedListDTO.getTitle());
        newTodolist.setUsername(editedListDTO.getUsername());
        newTodolist.setTasks(editedListDTO.getTasks());

        todolistRepository.save(newTodolist);
    }

}
