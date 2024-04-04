package com.DailyDash.todolist.controller;

import com.DailyDash.todolist.dto.EditedListDTO;
import com.DailyDash.todolist.entity.Todolist;
import com.DailyDash.todolist.service.implementation.TodolistServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/todolist")
public class TodolistController {

    private final TodolistServiceImpl todolistService;

    @Autowired
    public TodolistController(TodolistServiceImpl todolistService) {
        this.todolistService = todolistService;
    }

    @GetMapping("/get/{username}")
    public ResponseEntity<Todolist> getTodolist(@PathVariable("username") String username){
        Todolist list = todolistService.getList(username);
        return new ResponseEntity<>(list, HttpStatus.ACCEPTED);
    }

    @PatchMapping("/edit/")
    public ResponseEntity editTodolist(@RequestBody EditedListDTO editedListDTO){
        todolistService.editList(editedListDTO);
        return null;
    }
}
