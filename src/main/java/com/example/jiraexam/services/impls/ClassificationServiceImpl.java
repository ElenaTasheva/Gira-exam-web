package com.example.jiraexam.services.impls;


import com.example.jiraexam.models.entities.Classification;
import com.example.jiraexam.models.entities.enums.OptionEnum;
import com.example.jiraexam.repositories.ClassificationRepository;
import com.example.jiraexam.services.ClassificationService;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class ClassificationServiceImpl  implements ClassificationService {

    private final ClassificationRepository classificationRepository;

    public ClassificationServiceImpl(ClassificationRepository classificationRepository) {
        this.classificationRepository = classificationRepository;
    }

    @Override
    public void initClassifications() {

        if(classificationRepository.count() == 0){
            Arrays.stream(OptionEnum.values()).forEach(option -> {
                Classification classification = new Classification(option);
                classificationRepository.save(classification);
            });
        }

    }

    @Override
    public List<OptionEnum> getAllClassifications() {
        return this.classificationRepository.getAll();
    }

    @Override
    public Classification findByName(OptionEnum classification) {
        return this.classificationRepository.findClassificationByClassificationName(classification);
    }


}
