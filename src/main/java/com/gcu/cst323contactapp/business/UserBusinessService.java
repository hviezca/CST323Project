package com.gcu.cst323contactapp.business;

import com.gcu.cst323contactapp.entity.UserEntity;
import com.gcu.cst323contactapp.model.UserModel;
import com.gcu.cst323contactapp.service.UserDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserBusinessService {

    @Autowired
    UserDataService service;

    /**
     * Method for adding user entity to database
     */
    public boolean addUser(UserModel newUser){
        //Create entity from model
        UserEntity entity = new UserEntity(newUser.getId(),
                                            newUser.getUserName(),
                                            newUser.getPassword());
        //Insert entity into database
        return service.create(entity);
    }
}
