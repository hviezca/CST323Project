package com.gcu.cst323contactapp.service;

import com.gcu.cst323contactapp.entity.ContactEntity;
import com.gcu.cst323contactapp.repository.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ContactDataService implements DataAccessInterface<ContactEntity> {
    @Autowired
    private ContactRepository repository;

    public ContactDataService(ContactRepository repository){
        this.repository = repository;
    }
    /**
     * Return a List of all Objects from database
     *
     * @return List of Objects
     */
    @Override
    public List<ContactEntity> findAll() {
        return (List<ContactEntity>) repository.findAll();
    }

    /**
     * Return Object from database by id number
     *
     * @param id id number of Object
     * @return Object instance
     */
    @Override
    public ContactEntity findById(int id) {
       Optional<ContactEntity> entity = repository.findById((long) id);
        return entity.get();
    }

    /**
     * Create new Object in database
     *
     * @param entity Object to be added to database
     * @return boolean indicating success of operation
     */
    @Override
    public boolean create(ContactEntity entity) {
        return false;
    }

    /**
     * Update Object in database
     *
     * @param entity Object to be updated in database
     * @return boolean indicating success of operation
     */
    @Override
    public boolean update(ContactEntity entity) {
        return false;
    }

    /**
     * Delete Object in database
     *
     * @param entity Object to be deleted from database
     * @return boolean indicating success of operation
     */
    @Override
    public boolean delete(ContactEntity entity) {

        try{
            repository.delete(entity);
            return true;
        }
        catch (Exception e)
        {
         e.printStackTrace();
         return false;
        }
    }
}
