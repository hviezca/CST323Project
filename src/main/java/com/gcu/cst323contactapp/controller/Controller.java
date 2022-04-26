package com.gcu.cst323contactapp.controller;

import org.springframework.web.bind.annotation.GetMapping;

/**
 * Controller that handles logic between View and Model
 */
@org.springframework.stereotype.Controller
public class Controller {

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
}
