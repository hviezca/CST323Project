package com.gcu.cst323contactapp.data.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Table("contact")
public class ContactEntity {

    @Id
    //@Column("id")
    private long id;

    @Column("first_name")
    private String firstName;

    @Column("last_name")
    private String lastName;

    public ContactEntity() {}

    public ContactEntity(long id, String first_name, String last_name) {
        super();
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

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String last_name) {
        this.lastName = last_name;
    }
}
