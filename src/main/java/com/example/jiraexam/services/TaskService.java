package com.example.jiraexam.services;

import com.example.jiraexam.models.services.TaskServiceModel;
import com.example.jiraexam.models.views.TaskViewModel;

import java.util.List;

public interface TaskService {
    void save(TaskServiceModel taskServiceModel);

    List<TaskViewModel> tasks();

    void changeTask(Long id);
}
