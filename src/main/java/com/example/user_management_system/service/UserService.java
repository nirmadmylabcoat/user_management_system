package com.example.user_management_system.service;

import com.example.user_management_system.model.User;
import com.example.user_management_system.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    //creates an object of the user-repository
    private final UserRepository repo;

    //constructor
    public UserService(UserRepository repo) {
        this.repo = repo;
    }

    //basic querying functions using user-repo interface
    public List<User> getAllUsers() {
        return repo.findAll();
    }

    public User getUserById(int id) {
        return repo.findById(id).orElse(null);
    }

    public User addUser(User user) {
        // If client doesn’t send id, Mongo will generate one and to the database
        return repo.save(user);
    }

    public User updateUser(int id, User updated) { //get the name, email, age from the "updated" user and set the original/existing one's fields
        return repo.findById(id).map(existing -> { //if value exits, map applies the (lambda) given function to it
            existing.setName(updated.getName());
            existing.setEmail(updated.getEmail());
            existing.setAge(updated.getAge());
            return repo.save(existing);
        }).orElse(null);
    }

    public boolean deleteUser(int id) {
        if (!repo.existsById(id)) return false;
        repo.deleteById(id);
        return true;
    }
}
