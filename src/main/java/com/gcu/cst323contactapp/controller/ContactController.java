package com.gcu.cst323contactapp.controller;

import com.gcu.cst323contactapp.business.ContactBusinessService;
import com.gcu.cst323contactapp.business.UserBusinessService;
import com.gcu.cst323contactapp.model.UserModel;
import org.springframework.stereotype.Controller;
import com.gcu.cst323contactapp.entity.ContactEntity;
import com.gcu.cst323contactapp.model.ContactModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

/**
 * Controller that handles logic between View and Model
 */
@Controller
public class ContactController {

    @Autowired
    ContactBusinessService service;

    @Autowired
    UserBusinessService userService;

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
    public String onRegister(Model model){
        model.addAttribute("userModel", new UserModel());
        return "register"; }

    /**
     * Registers user in database
     */
    @PostMapping("/doRegister")
    public String doRegister(@ModelAttribute UserModel userModel) {

        //get userService and add new user
        userService.addUser(userModel);
        return "login";
    }

    @GetMapping("/view")
    public String viewContacts(Model model){
        List<ContactModel> contacts = service.getAllContacts();
        model.addAttribute("title", "View Contacts");
        model.addAttribute("contacts", contacts);
        return "view-contacts";
    }

    @GetMapping("/delete/{id}")
    public String deleteContact(@PathVariable("id") int id, Model model)
    {
        if(service.deleteById(id)) {
            List<ContactModel> contacts = service.getAllContacts();
            model.addAttribute("title", "CST-323 Activity - Search");
            model.addAttribute("contacts", contacts);
        }
        return "view-contacts";
    }

    @GetMapping("/addContact")
    public String addContact(@ModelAttribute("contact")ContactModel contact, Model model){
        List<ContactModel> contacts = service.getAllContacts();
        model.addAttribute("title", "Add New Contact");
        model.addAttribute("contacts", contacts);
        return "addContact";
    }

    @PostMapping("/addContactSubmit")
    public String addContactSubmit(@ModelAttribute("contact")ContactModel contact, Model model){
        service.addContact(contact);
        List<ContactModel> contacts = service.getAllContacts();
        model.addAttribute("title", "View Contacts");
        model.addAttribute("contacts", contacts);
        return "view-contacts";
    }

    @GetMapping("/update/{id}")
    public String updateContact(@PathVariable("id") int id, Model model){
        ContactModel contact = service.findById(id);
        model.addAttribute("title", "View Contacts");
        model.addAttribute("contact", contact);
        return "update";
    }

    @PostMapping("/updateContactSubmit")
    public String updateContactSubmit(@ModelAttribute("contact")ContactModel contact, Model model){
        service.updateContact(contact);
        List<ContactModel> contacts = service.getAllContacts();
        model.addAttribute("title", "View Contacts");
        model.addAttribute("contacts", contacts);
        return "view-contacts";
    }

}
