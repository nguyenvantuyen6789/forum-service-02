package com.tuyennguyen.userservice.controller;

import com.tuyennguyen.userservice.entity.UserEntity;
import com.tuyennguyen.userservice.model.UserDTO;
import com.tuyennguyen.userservice.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    UserRepository userRepo;

    @Autowired
    ModelMapper modelMapper;

    @GetMapping
    public List<UserDTO> get() {
        List<UserEntity> userEntities = userRepo.findAll();
        List<UserDTO> userDTOS = new ArrayList<>();

        userEntities.forEach(userEntity -> {
            userDTOS.add(modelMapper.map(userEntity, UserDTO.class));
        });

        return userDTOS;
    }

}
