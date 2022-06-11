package com.gcu.cst323contactapp.business;

import com.gcu.cst323contactapp.entity.ContactEntity;
import com.gcu.cst323contactapp.model.UserModel;
import com.gcu.cst323contactapp.service.ContactDataService;
import com.gcu.cst323contactapp.model.ContactModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ContactBusinessService {

    @Autowired
    private ContactDataService service;

    Logger logger = LoggerFactory.getLogger(this.getClass());

    /**
     * Method for adding new user to database
     * @author Matthias 5/18/22
     */
    public boolean addUser(UserModel newUser){
        // Log method entry
        logger.info("Entering ContactBusinessService.addUser()");

        //Create entity (user) from model (user)
        ContactEntity entity = new ContactEntity(newUser.getId(),
                                                newUser.getUsername(),
                                                newUser.getPassword());

        //Create user in database
        return service.create(entity);
    }

    /**
     * Method for adding contacts
     * @param - ContactModel newContact
     * @return - boolean
     */
    public boolean addContact(ContactModel newContact){
        // Log method entry
        logger.info("Entering ContactBusinessService.addContact()");

        //Create entity (user) from model (user)
        ContactEntity entity = new ContactEntity(newContact.getId(),
                newContact.getFirstName(),
                newContact.getLastName());

        //Create user in database
        return service.create(entity);
    }

    /**
     * Method for retrieving all contacts
     * @return - List of ContactEntity objects
     */
    public List<ContactModel> getAllContacts() {
        // Log method entry
        logger.info("Entering ContactBusinessService.getAllContacts()");

        List<ContactEntity> contacts = service.findAll();
        List<ContactModel>contactModels = new ArrayList<>();
        for (ContactEntity contact :
                contacts) {
            ContactModel model = new ContactModel(contact.getId(), contact.getFirstName(), contact.getLastName());
            contactModels.add(model);
        }
        return contactModels;
    }

    /**
     * Method for finding a contact by id
     * @param - int id
     * @return - A ContactModel object
     */
    public ContactModel findById(int id) {
        // Log method entry
        logger.info("Entering ContactBusinessService.findById()");

        ContactModel contact = new ContactModel();
        ContactEntity entity = service.findById(id);

        contact.setId(entity.getId());
        contact.setFirstName(entity.getFirstName());
        contact.setLastName(entity.getLastName());

        return contact;
    }

    /**
     * Method for deleting a contact by id
     * @param - int id
     * @return - boolean
     */
    public boolean deleteById(int id) {
        // Log method entry
        logger.info("Entering ContactBusinessService.deleteById()");

        ContactEntity contact = service.findById(id);

        try{
            service.delete(contact);
            return true;
        }
        catch (Exception e)
        {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * Method for updating a contact
     * @param - ContactModel contact
     * @return - boolean
     */
    public boolean updateContact(ContactModel contact) {
        // Log method entry
        logger.info("Entering ContactBusinessService.updateContact()");

        ContactEntity entity = contact.toContactEntity();
        return service.update(entity);
    }
}
