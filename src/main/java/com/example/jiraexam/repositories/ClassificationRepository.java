package com.example.jiraexam.repositories;

import com.example.jiraexam.models.entities.Classification;
import com.example.jiraexam.models.entities.enums.OptionEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ClassificationRepository extends JpaRepository<Classification,Long> {

    @Query("SELECT c.classificationName FROM Classification c")
    List<OptionEnum> getAll();


    Classification findClassificationByClassificationName(OptionEnum optionEnum);
}
