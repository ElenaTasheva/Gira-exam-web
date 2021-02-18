package com.example.jiraexam.models.services;

import com.example.jiraexam.models.entities.Classification;
import com.example.jiraexam.models.entities.User;
import com.example.jiraexam.models.entities.enums.OptionEnum;
import com.example.jiraexam.models.entities.enums.ProgressEnum;

import java.time.LocalDate;

public class TaskServiceModel {

    private String name;
    private String description;
    private ProgressEnum progress;
    private LocalDate date;
    private OptionEnum classification;
    private User user;


    public TaskServiceModel() {
    }

    public String getName() {
        return name;
    }

    public TaskServiceModel setName(String name) {
        this.name = name;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public TaskServiceModel setDescription(String description) {
        this.description = description;
        return this;
    }

    public ProgressEnum getProgress() {
        return progress;
    }

    public TaskServiceModel setProgress(ProgressEnum progress) {
        this.progress = progress;
        return this;
    }

    public LocalDate getDate() {
        return date;
    }

    public TaskServiceModel setDate(LocalDate date) {
        this.date = date;
        return this;
    }



    public User getUser() {
        return user;
    }

    public TaskServiceModel setUser(User user) {
        this.user = user;
        return this;
    }

    public OptionEnum getClassification() {
        return classification;
    }

    public TaskServiceModel setClassification(OptionEnum classification) {
        this.classification = classification;
        return this;
    }
}
