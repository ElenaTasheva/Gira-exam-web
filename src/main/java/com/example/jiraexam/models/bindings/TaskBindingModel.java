package com.example.jiraexam.models.bindings;

import com.example.jiraexam.models.entities.Classification;
import com.example.jiraexam.models.entities.enums.OptionEnum;
import com.example.jiraexam.models.entities.enums.ProgressEnum;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.jmx.export.annotation.ManagedNotifications;

import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;

public class TaskBindingModel {

    private String name;
    private String description;
    private LocalDate date;
    private OptionEnum classification;

    public TaskBindingModel() {
    }

    @Size(min = 3, max = 20, message = "Name must be between 3 and 20")
    public String getName() {
        return name;
    }

    public TaskBindingModel setName(String name) {
        this.name = name;
        return this;
    }

    @Size(min = 5, message = "Description must be more than 5")
    public String getDescription() {
        return description;
    }

    public TaskBindingModel setDescription(String description) {
        this.description = description;
        return this;
    }

    @FutureOrPresent(message = "Date must be in the present or future")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    public LocalDate getDate() {
        return date;
    }

    public TaskBindingModel setDate(LocalDate date) {
        this.date = date;
        return this;
    }

    @NotNull(message = "Cannot be empty")
    public OptionEnum getClassification() {
        return classification;
    }

    public TaskBindingModel setClassification(OptionEnum classification) {
        this.classification = classification;
        return this;
    }
}
