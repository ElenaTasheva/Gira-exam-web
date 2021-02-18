package com.example.jiraexam.security;


import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

@SessionScope
@Component
public class CurrentUser {

    private String name = "anonymous";

    public CurrentUser() {
    }

    public String getName() {
        return name;
    }

    public CurrentUser setName(String name) {
        this.name = name;
        return this;
    }

    public boolean isAnonymous(){
        return this.name.equals("anonymous");
    }
}
