package com.gcu.cst323contactapp.service;

import com.gcu.cst323contactapp.entity.UserEntity;
import com.gcu.cst323contactapp.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserDataService implements DataAccessInterface<UserEntity> {

    @Autowired
    private UserRepository userRepo;

    Logger logger = LoggerFactory.getLogger(this.getClass());

    /**
     * Paramerized constructor
     * @param - UserRepository userRepo
     */
    public UserDataService(UserRepository userRepo){
        this.userRepo = userRepo;
    }

    @Override
    public List<UserEntity> findAll() {
        return null;
    }

    /**
     * Creates a user in the database
     * @param - UserEntity newUser Object to be added to database
     * @return - boolean
     */
    @Override
    public boolean create(UserEntity newUser) {
        // Log method entry
        logger.info("Entering UserDataService.create()");
        try{
            //Save new Entity to database
            userRepo.save(newUser);
            logger.info("User created! Username = " + newUser.getUserName());
        }catch(Exception e){
            logger.error("User not creaged ... Error: " + e.getMessage());
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public UserEntity findById(int id) {
        logger.info("Entering UserDataService.findById()");

        return null;
    }

    @Override
    public boolean update(UserEntity userEntity) {
        return false;
    }

    @Override
    public boolean delete(UserEntity userEntity) {
        return false;
    }

    /**
     * Finds a user by username
     * @param - String userName
     * @return - The UserEntity found
     */
    public UserEntity findByUserName(String userName){
        // Log method entry
        logger.info("Entering ContactDataService.findbyUsername()");

        try{
            UserEntity entity = userRepo.findByUsername(userName);
            logger.info("User found! Username = " + userName);
            return entity;
        }
        catch (Exception e){
            logger.error("User not found ... Error: " + e.getMessage());
            throw new RuntimeException(e);
        }
    }
}
