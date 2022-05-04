package br.com.meta3group.userservice.controllers;

import br.com.meta3group.userservice.models.User;
import br.com.meta3group.userservice.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity<User> create(@RequestBody User user){
        System.out.println("USUÁRIO:" + user.getEmail());
        User createdProduct = userService.createUser(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdProduct);
    }

    @PostMapping("/login")
    public ResponseEntity<User> login(@RequestBody User user){
        User loggedUser = userService.loginUser(user);
        if(loggedUser == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(loggedUser);
    }

    @PutMapping
    public ResponseEntity<User> update(@RequestBody  User user){
        User updatedUser = userService.updateUser(user);

        if(user == null){
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(updatedUser);
    }

}

