package com.DailyDash.todolist.dto;

import com.DailyDash.todolist.entity.DashUser;
import com.DailyDash.todolist.entity.Task;
import lombok.Data;

import java.util.List;

@Data
public class EditedListDTO {
    private String title;
    private List<Task> tasks;
    private DashUser user;
}
