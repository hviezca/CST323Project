package com.gcu.cst323contactapp.controller;

import com.gcu.cst323contactapp.business.ContactBusinessService;
import org.springframework.stereotype.Controller;
import com.gcu.cst323contactapp.data.entity.ContactEntity;
import com.gcu.cst323contactapp.model.ContactModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;

/**
 * Controller that handles logic between View and Model
 */
@Controller
public class ContactController {

    @Autowired
    ContactBusinessService service;

    /**
     *
     * @return home.html
     */
   @GetMapping("/")
    public String home(){
        return "home";
    }

    /**
     *
     * @return login.html
     */
    @GetMapping("/login")
    public String onLogin(){ return "login"; }

    /**
     *
     * @return register.html
     */
    @GetMapping("/register")
    public String onRegister(){ return "register"; }

    @GetMapping("/view")
    public String viewContacts(Model model){
        List<ContactModel> contacts = new ArrayList<>();
        contacts.add(new ContactModel(1, "Contact 1 Name", "Contact 1 Last Name"));
        contacts.add(new ContactModel(2, "Contact 2 Name", "Contact 2 Last Name"));
        contacts.add(new ContactModel(3, "Contact 3 Name", "Contact 3 Last Name"));

        model.addAttribute("title", "View Contacts");
        model.addAttribute("contacts", contacts);

        return "view-contacts";
    }


    @GetMapping("/delete/{id}")
    public String deletePet(@PathVariable("id") int id, Model model)
    {
        if(service.deleteById(id)) {
            List<ContactModel> contacts = service.getAllContacts();
            model.addAttribute("title", "CST-323 Activity - Search");
            model.addAttribute("contacts", contacts);
        }
        return "view-contacts";
    }
}
