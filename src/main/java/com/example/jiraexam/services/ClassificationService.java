package com.example.jiraexam.services;

import com.example.jiraexam.models.entities.Classification;
import com.example.jiraexam.models.entities.enums.OptionEnum;

import java.util.List;

public interface ClassificationService {

    void initClassifications();

    List<OptionEnum> getAllClassifications();

    Classification findByName(OptionEnum classification);
}
