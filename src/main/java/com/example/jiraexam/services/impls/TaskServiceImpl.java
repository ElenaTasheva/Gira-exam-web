package com.example.jiraexam.services.impls;

import com.example.jiraexam.models.entities.Task;
import com.example.jiraexam.models.entities.enums.ProgressEnum;
import com.example.jiraexam.models.services.TaskServiceModel;
import com.example.jiraexam.models.views.TaskViewModel;
import com.example.jiraexam.repositories.TaskRepository;
import com.example.jiraexam.security.CurrentUser;
import com.example.jiraexam.services.ClassificationService;
import com.example.jiraexam.services.TaskService;
import com.example.jiraexam.services.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class TaskServiceImpl implements TaskService {

    private final ModelMapper modelMapper;
    private final TaskRepository taskRepository;
    private final CurrentUser currentUser;
    private final UserService userService;
    private final ClassificationService classificationService;

    public TaskServiceImpl(ModelMapper modelMapper, TaskRepository taskRepository, CurrentUser currentUser, UserService userService, ClassificationService classificationService) {
        this.modelMapper = modelMapper;
        this.taskRepository = taskRepository;
        this.currentUser = currentUser;
        this.userService = userService;
        this.classificationService = classificationService;
    }

    @Override
    public void save(TaskServiceModel taskServiceModel) {
        taskServiceModel.setProgress(ProgressEnum.OPEN);
        taskServiceModel.setUser(this.userService.getByEmail(this.currentUser.getName()));
        Task task = this.modelMapper.map(taskServiceModel, Task.class);
        task.setClassification(this.classificationService.findByName(taskServiceModel.getClassification()));
        this.taskRepository.save(task);
    }

    @Override
    public List<TaskViewModel> tasks() {

        return this.taskRepository.findAll()
                .stream()
                .map(t -> {
                    TaskViewModel task = this.modelMapper.map(t, TaskViewModel.class);
                    task.setAssigned_to(t.getUser().getUsername());
                    task.setClassification(t.getClassification().getClassificationName());
                    task.setDue_date(t.getDate());
                    return task;
                }).collect(Collectors.toList());

    }

    @Override
    public void changeTask(Long id) {
        Task task = this.taskRepository.findById(id).get();

        if (task.getProgress().equals(ProgressEnum.COMPLETED)) {
            this.taskRepository.delete(task);
        } else {
            changeProgress(task);
            taskRepository.save(task);

        }
    }

    private Task changeProgress(Task task) {
        switch (task.getProgress()) {
            case OPEN:
                task.setProgress(ProgressEnum.IN_PROGRESS);
                break;
            case IN_PROGRESS:
                task.setProgress(ProgressEnum.COMPLETED);
                break;

        }
        return task;
    }
}
