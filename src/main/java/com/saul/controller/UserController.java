package com.saul.controller;

import com.saul.entity.User;
import com.saul.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController
{
    public UserController() {
    }

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public ResponseEntity<?> newUser(@RequestBody User user)
    {
        userService.insertUserDefault(user);
        return new ResponseEntity<>("User creado correctamente", HttpStatus.CREATED);
    }

    @GetMapping("/users")
    @PreAuthorize("hasAnyAuthority('SCOPE_DBA', 'SCOPE_ADMIN')")
    public ResponseEntity<?> listUsers()
    {
        var users = userService.findAll();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @PostMapping("/user/register")
    public ResponseEntity<?> register(@RequestBody User user) {
        return null;
    }

}
