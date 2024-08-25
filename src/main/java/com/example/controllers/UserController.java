package com.example.controllers;

import com.example.entities.Users;
import com.example.exception.UserException;
import com.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class UserController {
    @Autowired
    private UserService userService;
    @PostMapping("/register")
    public ResponseEntity<Users> userRegister(@RequestBody Users user){

        Users users = userService.createUser(user);
        return new ResponseEntity<>(users, HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public ResponseEntity<Users> userLogin(@RequestBody Users user) throws UserException {

        Users users = userService.loginUser(user);
        return new ResponseEntity<>(users, HttpStatus.CREATED);
    }

}
