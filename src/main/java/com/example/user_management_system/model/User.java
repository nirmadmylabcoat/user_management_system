package com.example.user_management_system.model;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor //constructor
@Getter //getters (to get the values since it's private, so that no one can change it in an unauthorized way)
@Setter //setters (to change the values in an authorized way)
public class User {
    //private variables
    private int id;
    private String name;
    private String email;
    private int age;
}
