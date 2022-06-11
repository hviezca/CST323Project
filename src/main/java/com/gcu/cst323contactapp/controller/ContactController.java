package com.gcu.cst323contactapp.controller;

import com.gcu.cst323contactapp.business.ContactBusinessService;
import com.gcu.cst323contactapp.business.UserBusinessService;
import com.gcu.cst323contactapp.model.UserModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

    Logger logger = LoggerFactory.getLogger(this.getClass());

    /**
     *Returns website main page
     * @return home.html
     */
   @GetMapping("/")
    public String home(){
       // Log method entry
       logger.info("Entering ContactController.home()");
        return "home";
    }

    /**
     *Returns the website Login page
     * @return login.html
     */
    @GetMapping("/login")
    public String onLogin(Model model){
        // Log method entry
        logger.info("Entering ContactController.onLogin()");

        model.addAttribute("userModel", new UserModel());
        return "login"; }

    /**
     * Performs a user login action
     * @param - UserModel userModel
     * @param - Model model
     * @return - String for the View to return
     */
    @PostMapping("/doLogin")
    public String doLogin(@ModelAttribute UserModel userModel, Model model){

        if(userService.getAuthorizedUser(userModel)){
            //if returns true
            model.addAttribute("contacts", service.getAllContacts());
            return "view-contacts";
        } else {
            //if returns false
            return "home";
        }

    }

    /**
     *Returns the website Register page
     * @return register.html
     */
    @GetMapping("/register")
    public String onRegister(Model model){
        // Log method entry
        logger.info("Entering ContactController.onRegister()");

        model.addAttribute("userModel", new UserModel());
        return "register"; }

    /**
     * Registers user in database
     */
    @PostMapping("/doRegister")
    public String doRegister(@ModelAttribute UserModel userModel) {
        // Log method entry
        logger.info("Entering ContactController.doRegister()");

        //get userService and add new user
        userService.addUser(userModel);
        return "login";
    }

    /**
     * Returns the website view contacts page
     * @param - Model model
     * @return - view-contacts.html
     */
    @GetMapping("/view")
    public String viewContacts(Model model){
        // Log method entry
        logger.info("Entering ContactController.viewContacts()");

        List<ContactModel> contacts = service.getAllContacts();
        model.addAttribute("title", "View Contacts");
        model.addAttribute("contacts", contacts);
        return "view-contacts";
    }

    /**
     * Method to delete a contact
     * @param - int id
     * @param - Model model
     * @return - view-contacts.html
     */
    @GetMapping("/delete/{id}")
    public String deleteContact(@PathVariable("id") int id, Model model)
    {
        // Log method entry
        logger.info("Entering ContactController.deleteContact()");

        if(service.deleteById(id)) {
            List<ContactModel> contacts = service.getAllContacts();
            model.addAttribute("title", "CST-323 Activity - Search");
            model.addAttribute("contacts", contacts);
        }
        return "view-contacts";
    }

    /**
     * Method to display the addContact View
     * @param - ContactModel contact
     * @param - Model model
     * @return - addContact.html
     */
    @GetMapping("/addContact")
    public String addContact(@ModelAttribute("contact")ContactModel contact, Model model){
        // Log method entry
        logger.info("Entering ContactController.addContact()");

        List<ContactModel> contacts = service.getAllContacts();
        model.addAttribute("title", "Add New Contact");
        model.addAttribute("contacts", contacts);
        return "addContact";
    }

    /**
     * Method to perfrom the add contact action
     * @param - ContactModel contact
     * @param - Model model
     * @return - view-contacts.html
     */
    @PostMapping("/addContactSubmit")
    public String addContactSubmit(@ModelAttribute("contact")ContactModel contact, Model model){
        // Log method entry
        logger.info("Entering ContactController.addContactSubmit()");

        service.addContact(contact);
        List<ContactModel> contacts = service.getAllContacts();
        model.addAttribute("title", "View Contacts");
        model.addAttribute("contacts", contacts);
        return "view-contacts";
    }

    /**
     * Method to display the update form
     * @param - int id
     * @param - Model model
     * @return - update.html
     */
    @GetMapping("/update/{id}")
    public String updateContact(@PathVariable("id") int id, Model model){
        // Log method entry
        logger.info("Entering ContactController.updateContact()");

        ContactModel contact = service.findById(id);
        model.addAttribute("title", "View Contacts");
        model.addAttribute("contact", contact);
        return "update";
    }

    /**
     * Method to perform the update contact action
     * @param - ContactModel contact
     * @param - Model model
     * @return - view-contacts.html
     */
    @PostMapping("/updateContactSubmit")
    public String updateContactSubmit(@ModelAttribute("contact")ContactModel contact, Model model){
        // Log method entry
        logger.info("Entering ContactController.updateContactSubmit()");

        service.updateContact(contact);
        List<ContactModel> contacts = service.getAllContacts();
        model.addAttribute("title", "View Contacts");
        model.addAttribute("contacts", contacts);
        return "view-contacts";
    }
}
