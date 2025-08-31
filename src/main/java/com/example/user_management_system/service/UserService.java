package com.example.user_management_system.service;

import com.example.user_management_system.model.User;
import org.springframework.stereotype.Service;
import java.util.*;

@Service //spring automatically considers it as a service component
public class UserService {
    private List<User> users = new ArrayList<>(Arrays.asList
            (new User(1, "Sanjana", "sanjanaxrx@gmail.com", 21),
             new User(2, "Shivam", "shivamsultaniy123@gmail.com", 20)));

    public List<User> getAllUsers()
    {
        return users;
    }

    public User getUserById(int id)
    {
        //find the first match else return null
        return users.stream().filter(u -> u.getId() == id).findFirst().orElse(null);
    }

    public void addUser(User user)
    {
        users.add(user);
    }
}
