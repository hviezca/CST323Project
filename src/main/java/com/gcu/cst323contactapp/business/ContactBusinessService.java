package com.gcu.cst323contactapp.business;

import com.gcu.cst323contactapp.data.service.ContactDataService;
import com.gcu.cst323contactapp.model.ContactModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContactBusinessService {

    @Autowired
    private ContactDataService service;

    public List<ContactModel> getAllContacts() {

        List<ContactModel> contacts = service.findAll();

        return contacts;
    }
}
