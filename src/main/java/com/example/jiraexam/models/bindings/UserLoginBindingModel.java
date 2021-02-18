package com.example.jiraexam.models.bindings;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class UserLoginBindingModel {

    private String password;
    private String email;


    @NotBlank(message = "Email can not be empty")
    public String getEmail() {
        return email;
    }

    public UserLoginBindingModel setEmail(String email) {
        this.email = email;
        return this;
    }

    public UserLoginBindingModel() {
    }

    @Size(min = 3,max = 20, message = "Password must be between 3 and 20")
    @NotBlank(message = "Password can not be empty")
    public String getPassword() {
        return password;
    }

    public UserLoginBindingModel setPassword(String password) {
        this.password = password;
        return this;
    }
}
