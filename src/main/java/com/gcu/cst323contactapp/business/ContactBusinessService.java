package com.gcu.cst323contactapp.business;

import com.gcu.cst323contactapp.data.entity.ContactEntity;
import com.gcu.cst323contactapp.data.service.ContactDataService;
import com.gcu.cst323contactapp.model.ContactModel;
import com.gcu.cst323contactapp.model.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;

@Service
public class ContactBusinessService {

    @Autowired
    private ContactDataService service;

    /**
     * Method for adding new user to database
     * @author Matthias 5/18/22
     */
    public boolean addUser(ContactModel newUser){
        //Create entity (user) from model (user)
        ContactEntity entity = new ContactEntity(newUser.getId(),
                                                newUser.getFirstName(),
                                                newUser.getLastName());

        //Create user in database
        return service.create(entity);
    }

    public List<ContactModel> getAllContacts() {

        List<ContactEntity> contacts = service.findAll();
        List<ContactModel>contactModels = new ArrayList<>();
        for (ContactEntity contact :
                contacts) {
            ContactModel model = new ContactModel(contact.getId(), contact.getFirstName(), contact.getLastName());
            contactModels.add(model);
        }
        return contactModels;
    }
    public ContactModel findById(int id) {
        ContactModel contact = new ContactModel();
        ContactEntity entity = service.findById(id);

        contact.setId(entity.getId());
        contact.setFirstName(entity.getFirstName());
        contact.setLastName(entity.getLastName());

        return contact;
    }

    public boolean deleteById(int id) {
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
}
