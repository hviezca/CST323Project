package com.gcu.cst323contactapp.service;

import com.gcu.cst323contactapp.entity.ContactEntity;
import com.gcu.cst323contactapp.repository.ContactRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ContactDataService implements DataAccessInterface<ContactEntity> {
    @Autowired
    private ContactRepository repository;

    Logger logger = LoggerFactory.getLogger(this.getClass());

    /**
     * Parametrized constructor
     * @param - ContactRepository repository
     */
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
        // Log method entry
        logger.info("Entering ContactDataService.findAll()");

        try{
            List<ContactEntity> entities = (List<ContactEntity>) repository.findAll();
            logger.info("All contacts found!");
            return entities;
        }
        catch (Exception e) {
            logger.error("No contacts found ..... Error: " + e.getMessage());
            throw new RuntimeException(e);
        }
    }

    /**
     * Return Object from database by id number
     *
     * @param id id number of Object
     * @return Object instance
     */
    @Override
    public ContactEntity findById(int id) {
        // Log method entry
        logger.info("Entering ContactDataService.findById(). ID = " + id);

       Optional<ContactEntity> entity = repository.findById((long) id);
       logger.info("Found Contact! Contact First Name = " + entity.get().getFirstName() + " Contact Last Name = " + entity.get().getLastName());
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
        // Log method entry
        logger.info("Entering ContactDataService.create()");

        try{
            //Save new Entity to database
            repository.save(entity);
            logger.info("Contact Saved! Contact First Name = " + entity.getFirstName() + " Contact Last Name = " + entity.getLastName());
        }catch(Exception e){
            logger.error("Contact not saved ... Error: " + e.getMessage());
            e.printStackTrace();
            return false;
        }
        return true;
    }

    /**
     * Update Object in database
     *
     * @param entity Object to be updated in database
     * @return boolean indicating success of operation
     */
    @Override
    public boolean update(ContactEntity entity) {
        // Log method entry
        logger.info("Entering ContactDataService.update()");

        try{
            //Save new Entity to database
            repository.save(entity);
            logger.info("Contact Updated! Contact First Name = " + entity.getFirstName() + " Contact Last Name = " + entity.getLastName());
        }catch(Exception e){
            logger.error("Contact not updated ... Error: " + e.getMessage());
            e.printStackTrace();
            return false;
        }
        return true;
    }

    /**
     * Delete Object in database
     *
     * @param entity Object to be deleted from database
     * @return boolean indicating success of operation
     */
    @Override
    public boolean delete(ContactEntity entity) {
        // Log method entry
        logger.info("Entering ContactDataService.delete()");

        try{
            repository.delete(entity);
            logger.info("Contact deleted! ID = " + entity.getId());
            return true;
        }
        catch (Exception e)
        {
            logger.error("Contact not deleted ... Error: " + e.getMessage());
            e.printStackTrace();
            return false;
        }
    }
}
