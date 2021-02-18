package com.example.jiraexam.services.impls;

import com.example.jiraexam.models.entities.User;
import com.example.jiraexam.models.services.UserServiceModel;
import com.example.jiraexam.repositories.UserRepository;
import com.example.jiraexam.services.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;


@Service
public class UserServiceImpl implements UserService {

    private final ModelMapper modelMapper;
    private final UserRepository userRepository;

    public UserServiceImpl(ModelMapper modelMapper, UserRepository userRepository) {
        this.modelMapper = modelMapper;
        this.userRepository = userRepository;
    }

    @Override
    public void saveUser(UserServiceModel userServiceModel) {
        this.userRepository.save(this.modelMapper.map(userServiceModel, User.class));
    }

    @Override
    public boolean findByuserNameAndEmial(String email, String passsword) {
        if(this.userRepository.findByEmailAndPassword(email, passsword).isPresent()){
            return true;
        }
        return false;
    }

    @Override
    public User getByEmail(String email) {
        return this.userRepository.getByEmail(email);
    }
}
