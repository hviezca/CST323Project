package com.gcu.cst323contactapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/*
Main. This calls Spring Application method "run" on Cst323ContactAppApplication
 */
@SpringBootApplication
@ComponentScan(basePackages = {"com.gcu.cst323contactapp"})
public class Cst323ContactAppApplication {

    public static void main(String[] args) {
        SpringApplication.run(Cst323ContactAppApplication.class, args);
    }

}
