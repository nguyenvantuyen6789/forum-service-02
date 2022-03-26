package com.tuyennguyen.userservice.controller;

import com.tuyennguyen.userservice.entity.UserEntity;
import com.tuyennguyen.userservice.model.UserDTO;
import com.tuyennguyen.userservice.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping
    public UserDTO add(@RequestBody UserDTO userDTO) {
        UserEntity userEntity = modelMapper.map(userDTO, UserEntity.class);
        userRepo.save(userEntity);

        return userDTO;
    }

    @DeleteMapping("{userId}")
    public UserDTO delete(@PathVariable Long userId) {
        UserEntity userEntity = userRepo.getById(userId);
        if (userEntity != null) {
            userRepo.delete(userEntity);
        }

        return null;
    }

}
