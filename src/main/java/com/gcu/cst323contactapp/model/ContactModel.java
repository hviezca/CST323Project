package com.gcu.cst323contactapp.model;

import org.springframework.data.annotation.Id;
import javax.validation.constraints.NotEmpty;

public class ContactModel {

    @Id
    private long id;

    @NotEmpty(message = "Please enter a First Name")
    private String first_name;

    @NotEmpty(message = "Please enter a Last Name")
    private String last_name;

    public ContactModel() {}

    public ContactModel(long id, String first_name, String last_name) {
        this.id = id;
        this.first_name = first_name;
        this.last_name = last_name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }
}
