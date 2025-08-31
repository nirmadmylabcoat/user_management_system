package com.example.user_management_system.repository;

import com.example.user_management_system.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

//create a repo for User and extend MongoRepo so that we don't have to write the queries by ourselves, we can just import all the built in methods
public interface UserRepository extends MongoRepository<User, Integer>
//T -> entity class (User) and ID -> primary key in that entity
{
    //used for single objects, not collections so it returns a user if found or else Optional.empty()
    Optional<User> findByEmail(String email); //safer way to handle nulls

    //for collections cause multiple can exist
    List<User> findByNameContainingIgnoreCase(String name); //containing searches based on the partial parameter
}
