package com.DailyDash.Todolist.dto;

import com.DailyDash.Todolist.entity.Task;
import lombok.Data;

import java.util.List;

@Data
public class EditedListDTO {
    private String title;
    private List<Task> tasks;
    private String username;
}
