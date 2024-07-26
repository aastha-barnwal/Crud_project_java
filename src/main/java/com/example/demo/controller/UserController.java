//package com.example.crud_project.controller;
//
//
//import com.example.crud_project.entity.User;
//import com.example.crud_project.service.UserService;
//import org.bson.types.ObjectId;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//
//@RestController
//@RequestMapping("user")
//public class UserController {
//    @Autowired
//    private UserService userService;
//
//    @GetMapping
//    public ResponseEntity<?> getAll(){
//        return new ResponseEntity<>(userService.getAll(), HttpStatus.OK);
//    }
//
//    @PostMapping
//    public ResponseEntity<?> create(@RequestBody User user){
//        if(user.getUserName()==null || user.getPassword()==null){
//            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
//        }
//        userService.saveUser(user);
//        return new ResponseEntity<>(user, HttpStatus.OK);
//    }
//
//    @PutMapping("/{username}")
//    public ResponseEntity<?> Update(@RequestBody User user,@PathVariable String username){
//        User old = userService.findByUserName(username);
//        if(old==null){
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }
//        else{
//            old.setUserName(user.getUserName());
//            old.setPassword(user.getPassword());
//            userService.saveUser(old);
//            return new ResponseEntity<>(old,HttpStatus.ACCEPTED);
//        }
//    }
//
//    @DeleteMapping("Id/{id}")
//    public ResponseEntity<?> delete(@PathVariable ObjectId id){
//        userService.delete(id);
//        return new ResponseEntity<>(HttpStatus.OK);
//    }
//
//
//}

package com.example.demo.controller;

import com.example.demo.entity.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/")
public class UserController {
    @Autowired
    private UserService userService;

    // get all users
    @GetMapping
    public ResponseEntity<?> getAll(){
        return new ResponseEntity<>(userService.getAll(),HttpStatus.OK);
    }

    //get user by id
    @GetMapping("Id/{id}")
    public ResponseEntity<?> getById(@PathVariable String id){
//        System.out.println(userService.getById(id));
        if(userService.getById(id).isEmpty()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(userService.getById(id),HttpStatus.FOUND);
    }

    // Save user or create user
    @PostMapping
    public ResponseEntity<?> create(@RequestBody User user){
        if(user.getUserName()==null || user.getPassword()==null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        userService.saveUser(user);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    //Update username and password of the user
    @PutMapping("/{username}")
    public ResponseEntity<?> Update(@RequestBody User user,@PathVariable String username){
        User old = userService.findByUserName(username);
        if(old==null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        else{
            old.setUserName(user.getUserName());
            old.setPassword(user.getPassword());
            userService.saveUser(old);
            return new ResponseEntity<>(old,HttpStatus.ACCEPTED);
        }
    }

    // Delete user by id
    @DeleteMapping("Id/{id}")
    public ResponseEntity<?> delete(@PathVariable String id){
        userService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}

