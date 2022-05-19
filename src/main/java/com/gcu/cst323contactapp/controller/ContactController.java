package com.gcu.cst323contactapp.controller;

import com.gcu.cst323contactapp.business.ContactBusinessService;
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

    /**
     * Registers user in database
     */
    @PostMapping("/doRegister")
    public String doRegister(@ModelAttribute UserModel userModel) {

        //get userService and add new user
        service.addUser(userModel);
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
}
