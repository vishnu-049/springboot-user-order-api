package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    // Get all users
    @GetMapping
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    // Add a new user
    @PostMapping
    public User createUser(@RequestBody User user) {
        return userRepository.save(user);
    }
    
    //Update User
    @PutMapping("/{id}")
    public User updateUser(@PathVariable int id, @RequestBody User updatedUser){
        return userRepository.findById(id)
        .map(user ->{
            user.setName(updatedUser.getName());
            user.setEmail(updatedUser.getEmail());
            return userRepository.save(user);
        })
        .orElseThrow(()-> new RuntimeException("User not found with id"+id));

    }
    
    //Delete User
    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable int id){
        if(userRepository.existsById(id)){
            userRepository.deleteById(id);
            return " Deleted User with Id "+id;
        }
        else{
            return "USer not found with ID "+id;
        }
    }
    @GetMapping("/{id}")
public User getUserById(@PathVariable int id) {
    return userRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("User not found with id " + id));
}




}

