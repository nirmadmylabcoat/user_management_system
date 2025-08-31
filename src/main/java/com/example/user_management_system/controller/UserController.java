package com.example.user_management_system.controller;

import com.example.user_management_system.model.User;
import com.example.user_management_system.service.UserService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService service;
    public UserController(UserService service) { this.service = service; }

    @GetMapping
    public List<User> getAll() {
        return service.getAllUsers();
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getById(@PathVariable int id) {
        User u = service.getUserById(id);
        return (u == null) ? ResponseEntity.notFound().build() : ResponseEntity.ok(u); //404 or 200
    }

    @PostMapping
    public ResponseEntity<User> create(@Valid @RequestBody User user) {
        User saved = service.addUser(user);
        return ResponseEntity.created(URI.create("/users/" + saved.getId())).body(saved);
        //201 created page and create the location. body(saved) adds the user saved to the json body
    }

    @PutMapping("/{id}")
    public ResponseEntity<User> update(@PathVariable int id, @Valid @RequestBody User user) {
        User updated = service.updateUser(id, user);
        return (updated == null) ? ResponseEntity.notFound().build() : ResponseEntity.ok(updated); //404 or 200
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable int id) {
        return service.deleteUser(id) ? ResponseEntity.noContent().build()
                : ResponseEntity.notFound().build(); //204 or 404
    }
}
