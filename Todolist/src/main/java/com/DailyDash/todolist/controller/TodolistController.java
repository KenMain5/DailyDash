package com.DailyDash.Todolist.controller;

import com.DailyDash.Todolist.dto.EditedListDTO;
import com.DailyDash.Todolist.entity.Todolist;
import com.DailyDash.Todolist.service.implementation.TodolistServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/todolist")
public class TodolistController {

    private final TodolistServiceImpl todolistService;

    @Autowired
    public TodolistController(TodolistServiceImpl todolistService) {
        this.todolistService = todolistService;
    }

    @GetMapping(value = "/get/{username}")
    public ResponseEntity<Todolist> getTodolist(@PathVariable("username") String username){
        Todolist list = todolistService.getList(username);
        return new ResponseEntity<>(list, HttpStatus.ACCEPTED);
    }

    @PatchMapping(value = "/edit/", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> editTodolist(@RequestBody EditedListDTO editedListDTO){
        todolistService.editList(editedListDTO);
        return new ResponseEntity<>("The Todolist has been saved successfully", HttpStatus.CREATED);
    }
}
