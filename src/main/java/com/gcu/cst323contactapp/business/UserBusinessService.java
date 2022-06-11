package com.gcu.cst323contactapp.business;

import com.gcu.cst323contactapp.entity.UserEntity;
import com.gcu.cst323contactapp.model.UserModel;
import com.gcu.cst323contactapp.repository.UserRepository;
import com.gcu.cst323contactapp.service.UserDataService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserBusinessService {

    @Autowired
    UserDataService service;

    Logger logger = LoggerFactory.getLogger(this.getClass());

    /**
     * Method for adding user entity to database
     */
    public boolean addUser(UserModel newUser){
        // Log method entry
        logger.info("Entering UserBusinessService.addUser()");

        //Create entity from model
        UserEntity entity = new UserEntity(newUser.getId(),
                                            newUser.getUsername(),
                                            newUser.getPassword());
        //Insert entity into database
        return service.create(entity);
    }

    /**
     *Take userModel object and turn into Entity
     *Search database for that username using method findByUsername in UserDataService.findByUsername()
     *if username exists, compare username/password, boolean results
     * @param - UserModel userModel
     * @return - boolean
     */
    public boolean getAuthorizedUser(UserModel userModel) {
        // Log method entry
        logger.info("Entering UserBusinessService.getAuthorizedUser()");

        //Create modelToEntity from model to be compared if entity created = entity in db
        UserEntity modelToEntity = service.findByUserName(userModel.getUsername());

        //search db for modelToEntity object by username
        if(modelToEntity == null){
            //if user not found (null) return false
            return false;
        }else{
             if(userModel.getUsername().equals(modelToEntity.getUserName()) && userModel.getPassword().equals(modelToEntity.getPassword())){
                //If name/password match, return true
                return true;
            }else {
                //If name/password !match, return false
                return false;
            }
        }
    }
}
