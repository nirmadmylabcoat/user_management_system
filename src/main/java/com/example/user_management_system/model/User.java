package com.example.user_management_system.model;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@NoArgsConstructor
@AllArgsConstructor //constructor
@Getter //getters (to get the values since it's private, so that no one can change it in an unauthorized way)
@Setter //setters (to change the values in an authorized way)
@Document(collection="users")
public class User {
    //private variables
    @Id //primary key
    private int id;

    @NotBlank //stricter than not null, no space also allowed
    private String name;

    @Email //validates email format
    @NotBlank
    @Indexed(unique = true) //indexes emails, makes sure no 2 users have same email
    private String email;

    @Min(0) //minimum age can be 0.
    private int age;
}
