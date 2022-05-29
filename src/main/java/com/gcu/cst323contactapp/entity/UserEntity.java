package com.gcu.cst323contactapp.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

/**
 * UserEntity to match database table attributes named 'user' in MySql
 */

@Table("user")
public class UserEntity {
    @Id
    private int id;

    @Column("username")
    private String userName;

    @Column("password")
    private String password;

    public UserEntity() {
    }

    public UserEntity(int id, String userName, String password) {
        this.id = id;
        this.userName = userName;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
