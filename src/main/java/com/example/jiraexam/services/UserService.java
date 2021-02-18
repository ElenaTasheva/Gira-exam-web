package com.example.jiraexam.services;

import com.example.jiraexam.models.entities.User;
import com.example.jiraexam.models.services.UserServiceModel;

public interface UserService {

    void saveUser(UserServiceModel userServiceModel);

    boolean findByuserNameAndEmial(String email, String username);

    User getByEmail(String email);
}
