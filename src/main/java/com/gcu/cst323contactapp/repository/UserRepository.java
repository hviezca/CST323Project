package com.gcu.cst323contactapp.repository;

import com.gcu.cst323contactapp.entity.UserEntity;
import org.apache.catalina.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<UserEntity, Long> {

    //Method for finding a user by their username
    //Used for login verification
    UserEntity findByUsername(String userName);
}
