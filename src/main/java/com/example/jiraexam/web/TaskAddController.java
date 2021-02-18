package com.example.jiraexam.web;


import com.example.jiraexam.models.bindings.TaskBindingModel;
import com.example.jiraexam.models.services.TaskServiceModel;
import com.example.jiraexam.security.CurrentUser;
import com.example.jiraexam.services.ClassificationService;
import com.example.jiraexam.services.TaskService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
public class TaskAddController {


    private final ModelMapper modelMapper;
    private final CurrentUser currentUser;
    private final ClassificationService classificationService;
    private final TaskService taskService;

    public TaskAddController(ModelMapper modelMapper, CurrentUser currentUser, ClassificationService classificationService, TaskService taskService) {
        this.modelMapper = modelMapper;
        this.currentUser = currentUser;
        this.classificationService = classificationService;
        this.taskService = taskService;
    }

    @GetMapping("/task/add")
    public String addTask(Model model){
        if(!currentUser.isAnonymous()) {
            if (!model.containsAttribute("taskBindingModel")) {
                model.addAttribute("taskBindingModel", new TaskBindingModel());

            }
            model.addAttribute("classifications", this.classificationService.getAllClassifications());
            return "add-task";
        }
        return "redirect:/users/login";

    }

    @PostMapping("/task/add")
    public String registerConfirm(@Valid TaskBindingModel taskBindingModel,
                                  BindingResult bindingResult,
                                  RedirectAttributes redirectAttributes){

        if(bindingResult.hasErrors()){
            redirectAttributes.addFlashAttribute("taskBindingModel", taskBindingModel);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.taskBindingModel", bindingResult);
            return "redirect:/task/add";
        }
        this.taskService.save(this.modelMapper.map(taskBindingModel, TaskServiceModel.class));
        return "redirect:/home";


    }


}
