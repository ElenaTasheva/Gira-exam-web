package com.example.jiraexam;


import com.example.jiraexam.services.ClassificationService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class AppInitilizer implements CommandLineRunner {

    private final ClassificationService classificationService;

    public AppInitilizer(ClassificationService classificationService) {
        this.classificationService = classificationService;
    }

    @Override
    public void run(String... args) throws Exception {

        classificationService.initClassifications();
    }
}
