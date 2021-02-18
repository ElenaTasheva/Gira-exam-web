package com.example.jiraexam.web;

import com.example.jiraexam.security.CurrentUser;
import com.example.jiraexam.services.TaskService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@Controller
public class HomeController {


    private final CurrentUser currentUser;
    private final TaskService taskService;

    public HomeController(CurrentUser currentUser, TaskService taskService) {
        this.currentUser = currentUser;
        this.taskService = taskService;
    }

    @GetMapping("/home")
    public String showHome(Model model){
        if(currentUser.isAnonymous()){
            return "index";
        }
        if(!model.containsAttribute("tasks")){
            model.addAttribute("tasks", this.taskService.tasks());
        }

        return "home";
    }


    @GetMapping("/home/{id}")
    public String buyById(@PathVariable Long id){

        this.taskService.changeTask(id);
        return "redirect:/home";
    }


}

