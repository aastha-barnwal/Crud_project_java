//package com.example.crud_project.service;
//
//import com.example.crud_project.entity.User;
//import com.example.crud_project.repository.UserRepo;
//import org.bson.types.ObjectId;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//
//import java.util.List;
//import java.util.Optional;
//
//@Component
//public class UserService {
//    @Autowired
//    private UserRepo userRepository;
//
//    public User findByUserName(String username){
//        return userRepository.findByUserName(username);
//    }
//    public User saveUser(User user){
//        return userRepository.save(user);
//    }
//    public List<User> getAll(){
//        return userRepository.findAll();
//    }
//    public Optional<User> getById(ObjectId id){
//        return userRepository.findById(id);
//    }
//    public void delete(ObjectId id){
//        userRepository.deleteById(id);
//    }
//
//
//}


package com.example.demo.service;

import com.example.demo.entity.User;
import com.example.demo.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    //user repository which extends mongorepository
    @Autowired
    private UserRepo userRepository;

    //find user by username
    public User findByUserName(String username){
        return userRepository.findByUserName(username);
    }

    // create user to db
    public User saveUser(User user){
        return userRepository.save(user);
    }

    //get all users
    public List<User> getAll(){
        return userRepository.findAll();
    }

    //get user by id
    public Optional<User> getById(String id){
        return userRepository.findById(id);
    }

    // delete user by id
    public void delete(String id){
        userRepository.deleteById(id);
    }
}

