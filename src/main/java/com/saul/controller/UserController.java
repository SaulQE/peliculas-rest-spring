package com.saul.controller;

import com.saul.entity.User;
import com.saul.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

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
    @PreAuthorize("hasAnyAuthority('SCOPE_DBA', 'SCOPE_ADMIN') || hasAuthority('SCOPE_ADMIN')")
    public ResponseEntity<?> listUsers()
    {
        var users = userService.findAll();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @PostMapping("/user/register")
    @PreAuthorize("hasAnyAuthority('SCOPE_DBA', 'SCOPE_ADMIN') || hasAuthority('SCOPE_ADMIN')")
    public ResponseEntity<?> register(@RequestBody User user) {
        userService.insert(user);
        return ResponseEntity.ok("User creado correctamente");
    }

    @PutMapping("/user/update/{userId}")
    @PreAuthorize("hasAnyAuthority('SCOPE_DBA', 'SCOPE_ADMIN') || hasAuthority('SCOPE_ADMIN')")
    public ResponseEntity<?> update(@PathVariable("userId") Integer userId,
                                    @RequestBody User user)
    {
        User userDb = userService.findById(userId);
        if (userDb != null) {
            userService.update(user);
            return new ResponseEntity<>("User actualizado correctamente", HttpStatus.OK);
        }
        return new ResponseEntity<>("User no encontrado", HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/user/delete/{userId}")
    @PreAuthorize("hasAnyAuthority('SCOPE_DBA', 'SCOPE_ADMIN') || hasAuthority('SCOPE_ADMIN')")
    public ResponseEntity<?> delete(@PathVariable("userId") Integer userId)
    {
        User user = userService.findById(userId);
        if (user != null) {
            userService.delete(userId);
            return new ResponseEntity<>("User eliminado correctamente", HttpStatus.OK);
        }
        return new ResponseEntity<>("User no encontrado", HttpStatus.NOT_FOUND);
    }

    @GetMapping("/user/buscar/{userId}")
    @PreAuthorize("hasAnyAuthority('SCOPE_DBA', 'SCOPE_ADMIN') || hasAuthority('SCOPE_BASIC') || hasAuthority('SCOPE_ADMIN')")
    public ResponseEntity<?> findById(@PathVariable("userId") Integer userId)
    {
        User user = userService.findById(userId);
        if (user != null) {
            return new ResponseEntity<>(user, HttpStatus.FOUND);
        }
        return new ResponseEntity<>("User no encontrado", HttpStatus.NOT_FOUND);
    }

}
