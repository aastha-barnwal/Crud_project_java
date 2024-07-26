//package com.example.crud_project.repository;
//
//import com.example.crud_project.entity.User;
//import org.bson.types.ObjectId;
//import org.springframework.data.mongodb.repository.MongoRepository;
//
//public interface UserRepo extends MongoRepository<User, ObjectId> {
//    User findByUserName(String username);
//}


package com.example.demo.repository;

import com.example.demo.entity.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends MongoRepository<User, String> {

    // function to find users by username
    User findByUserName(String username);

}


