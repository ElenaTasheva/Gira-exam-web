package com.example.jiraexam.web;


import com.example.jiraexam.models.bindings.UserLoginBindingModel;
import com.example.jiraexam.models.bindings.UserRegisterBindingModel;
import com.example.jiraexam.models.services.UserServiceModel;
import com.example.jiraexam.security.CurrentUser;
import com.example.jiraexam.services.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@RequestMapping("/users")
public class UserController {

    private final CurrentUser currentUser;
    private final ModelMapper modelMapper;
    private final UserService userService;

    public UserController(CurrentUser currentUser, ModelMapper modelMapper, UserService userService) {
        this.currentUser = currentUser;
        this.modelMapper = modelMapper;
        this.userService = userService;
    }

    @GetMapping("/register")
    public String register(Model model) {
        if (!model.containsAttribute("userRegisterBindingModel")) {
            model.addAttribute("userRegisterBindingModel", new UserRegisterBindingModel());
        }
        return "register";

    }

    @PostMapping("/register")
    public String registerConfirm(@Valid UserRegisterBindingModel userRegisterBindingModel,
                                  BindingResult bindingResult,
                                  RedirectAttributes redirectAttributes) {

        if (bindingResult.hasErrors() || !userRegisterBindingModel.getPassword().equals(userRegisterBindingModel.getConfirmedPassword())) {
            redirectAttributes.addFlashAttribute("userRegisterBindingModel", userRegisterBindingModel);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.userRegisterBindingModel", bindingResult);
            return "redirect:register";
        }

        this.userService.saveUser(this.modelMapper.map(userRegisterBindingModel, UserServiceModel.class));
        return "redirect:login";


    }


    @GetMapping("/login")
    public String login(Model model) {
        if (!model.containsAttribute("userLoginBindingModel")) {
            model.addAttribute("userLoginBindingModel", new UserLoginBindingModel());
            model.addAttribute("notFound", false);
        }
        return "login";

    }

    @PostMapping("/login")
    public String registerConfirm(@Valid UserLoginBindingModel userLoginBindingModel,
                                  BindingResult bindingResult,
                                  RedirectAttributes redirectAttributes) {

        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("userLoginBindingModel", userLoginBindingModel);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.userLoginBindingModel", bindingResult);
            return "redirect:login";
        }

        if (!this.userService.findByuserNameAndEmial(userLoginBindingModel.getEmail(), userLoginBindingModel.getPassword())) {
            redirectAttributes.addFlashAttribute("userLoginBindingModel", userLoginBindingModel);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.userRegisterBindingModel", bindingResult);
            redirectAttributes.addFlashAttribute("notFound", true);
            return "redirect:login";
        }

        currentUser.setName(userLoginBindingModel.getEmail());
        return "redirect:/home";


    }

    @GetMapping("/logout")
    public String logout() {
        if (!currentUser.isAnonymous()) {
            this.currentUser.setName("anonymous");
            return "redirect:/home";

        }
        return "redirect:login";
    }
}
