package com.gcu.cst323contactapp.model;

/**
 * Model for User
 * @author Matthias
 *
 */

public class UserModel {
    private int id;
    private String userName;
    private String password;

    public UserModel(int id, String userName, String password) {
        this.id = id;
        this.userName = userName;
        this.password = password;
    }

    public UserModel() {
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
