package com.example.jiraexam.models.views;

import com.example.jiraexam.models.entities.Classification;
import com.example.jiraexam.models.entities.User;
import com.example.jiraexam.models.entities.enums.OptionEnum;
import com.example.jiraexam.models.entities.enums.ProgressEnum;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

public class TaskViewModel {

    private Long id;
    private String name;
    private String assigned_to;
    private ProgressEnum progress;
    private LocalDate due_date;
    private OptionEnum classification;

    public TaskViewModel() {
    }

    public Long getId() {
        return id;
    }

    public TaskViewModel setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public TaskViewModel setName(String name) {
        this.name = name;
        return this;
    }

    public String getAssigned_to() {
        return assigned_to;
    }

    public TaskViewModel setAssigned_to(String assigned_to) {
        this.assigned_to = assigned_to;
        return this;
    }

    public ProgressEnum getProgress() {
        return progress;
    }

    public TaskViewModel setProgress(ProgressEnum progress) {
        this.progress = progress;
        return this;
    }

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    public LocalDate getDue_date() {
        return due_date;
    }

    public TaskViewModel setDue_date(LocalDate due_date) {
        this.due_date = due_date;
        return this;
    }

    public OptionEnum getClassification() {
        return classification;
    }

    public TaskViewModel setClassification(OptionEnum classification) {
        this.classification = classification;
        return this;
    }
}
