package com.gcu.cst323contactapp.data.service;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContactDataService implements DataAccessInterface{
    /**
     * Return a List of all Objects from database
     *
     * @return List of Objects
     */
    @Override
    public List findAll() {
        return null;
    }

    /**
     * Return Object from database by id number
     *
     * @param id id number of Object
     * @return Object instance
     */
    @Override
    public Object findById(int id) {
        return null;
    }

    /**
     * Create new Object in database
     *
     * @param o Object to be added to database
     * @return boolean indicating success of operation
     */
    @Override
    public boolean create(Object o) {
        return false;
    }

    /**
     * Update Object in database
     *
     * @param o Object to be updated in database
     * @return boolean indicating success of operation
     */
    @Override
    public boolean update(Object o) {
        return false;
    }

    /**
     * Delete Object in database
     *
     * @param o Object to be deleted from database
     * @return boolean indicating success of operation
     */
    @Override
    public boolean delete(Object o) {
        return false;
    }
}
