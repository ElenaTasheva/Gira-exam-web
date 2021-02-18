package com.example.jiraexam.models.entities;


import com.example.jiraexam.models.entities.enums.OptionEnum;

import javax.persistence.*;

@Entity
@Table(name = "classifications")
public class Classification extends BaseEntity{

    private OptionEnum classificationName;
    private String description;


    public Classification(OptionEnum option) {
        this.classificationName = option;
    }

    public Classification() {
    }

    @Enumerated(EnumType.STRING)
    public OptionEnum getClassificationName() {
        return classificationName;
    }

    public Classification setClassificationName(OptionEnum classificationName) {
        this.classificationName = classificationName;
        return this;
    }

    @Column(columnDefinition = "TEXT")
    public String getDescription() {
        return description;
    }

    public Classification setDescription(String description) {
        this.description = description;
        return this;
    }


}
