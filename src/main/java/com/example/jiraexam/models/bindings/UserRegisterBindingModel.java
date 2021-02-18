package com.example.jiraexam.models.bindings;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class UserRegisterBindingModel {

    private String username;
    private String password;
    private String confirmedPassword;
    private String email;

    public UserRegisterBindingModel() {
    }

    @NotBlank
    @Size(min = 3, max = 20, message = "Username must be between 3 and 20 characters")
    public String getUsername() {
        return username;
    }

    public UserRegisterBindingModel setUsername(String username) {
        this.username = username;
        return this;
    }

    @NotBlank
    @Size(min = 3, max = 20, message = "Password must be between 3 and 20 characters")
    public String getPassword() {
        return password;
    }

    public UserRegisterBindingModel setPassword(String password) {
        this.password = password;
        return this;
    }
    @NotBlank
    @Size(min = 3, max = 20)
    public String getConfirmedPassword() {
        return confirmedPassword;
    }

    public UserRegisterBindingModel setConfirmedPassword(String confirmedPassword) {
        this.confirmedPassword = confirmedPassword;
        return this;
    }

    @Email
    @NotNull
    public String getEmail() {
        return email;
    }

    public UserRegisterBindingModel setEmail(String email) {
        this.email = email;
        return this;
    }
}
