package com.rightguy.controller;


import com.rightguy.dtos.UserRequestDto;
import com.rightguy.enums.Specialization;
import com.rightguy.model.User;
import com.rightguy.services.UserService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody @Valid UserRequestDto userRequestDto) {
        User user = User.builder().name(userRequestDto.getName())
                .email(userRequestDto.getEmail())
                .mobileNumber(userRequestDto.getMobileNumber())
                .address(userRequestDto.getAddress())
                .specialization(Specialization.valueOf(userRequestDto.getSpecialization().toUpperCase()))
                .password(userRequestDto.getPassword())
                .build();

        User createdUser = userService.createUser(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdUser);
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUser(@PathVariable long id) {
        return userService.getUserById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<List<User>> getAllUsers(){
        List<User> user = userService.getAllUsers();
        return ResponseEntity.ok(user);
    }

}
