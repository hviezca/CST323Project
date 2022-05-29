package com.gcu.cst323contactapp.model;

import com.gcu.cst323contactapp.entity.ContactEntity;
import org.springframework.data.annotation.Id;
import javax.validation.constraints.NotEmpty;

public class ContactModel {

    @Id
    private long id;

    @NotEmpty(message = "Please enter a First Name")
    private String firstName;

    @NotEmpty(message = "Please enter a Last Name")
    private String lastName;
    public ContactModel() {}

    public ContactModel(long id, String first_name, String last_name) {
        this.id = id;
        this.firstName = first_name;
        this.lastName = last_name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String first_name) {
        this.firstName = first_name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String last_name) {
        this.lastName = last_name;
    }

    public ContactEntity toContactEntity(){
        ContactEntity entity = new ContactEntity(this.id,this.firstName,this.lastName);
        return entity;
    }

    public void printInfo(){
        System.out.println(this.id + ", " + this.firstName + ", " + this.lastName + ".");
    }

}
