package com.gcu.cst323contactapp.service;

import com.gcu.cst323contactapp.entity.UserEntity;
import com.gcu.cst323contactapp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserDataService implements DataAccessInterface<UserEntity> {

    @Autowired
    private UserRepository userRepo;

    public UserDataService(UserRepository userRepo){
        this.userRepo = userRepo;
    }

    @Override
    public List<UserEntity> findAll() {
        return null;
    }

    @Override
    public boolean create(UserEntity newUser) {

        try{
            //Save new Entity to database
            userRepo.save(newUser);
        }catch(Exception e){
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public UserEntity findById(int id) {
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

    public UserEntity findByUserName(String userName){
        //Attempt to find user by username
        return userRepo.findByUsername(userName);
    }
}
