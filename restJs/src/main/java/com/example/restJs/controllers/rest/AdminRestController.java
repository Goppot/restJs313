package com.example.restJs.controllers.rest;

import com.example.restJs.model.User;
import com.example.restJs.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class AdminRestController {

    private final UserService userService;

    public AdminRestController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users")
    public ResponseEntity<Iterable<User>> getAllUsers(){
        Iterable<User> users = userService.getAll();
        return users != null
                ? new ResponseEntity<>(users, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    @GetMapping("/users/{id}")
    public User getUser(@PathVariable("id") int id){
        return userService.getByUSerId(id);
    }

    @GetMapping("/users/authorized")
    public User getAuthorized(){
        return userService.getAuthorized();
    }

    @PostMapping("/users")
    public ResponseEntity<User> addUser(@RequestBody User user){
        userService.addUser(user);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("/users")
    public ResponseEntity<User> updateUser(@RequestBody User user){
        userService.addUser(user);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/users")
    public ResponseEntity<User> deleteUser(@RequestBody User user){
        userService.deleteUser(user);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
