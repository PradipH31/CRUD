/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.leapfrog.crud.entity;

import java.util.Date;

/**
 *
 * @author HP B&O
 */
public class Course {

    private int id, fees;
    private String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getFees() {
        return fees;
    }

    public void setFees(int fees) {
        this.fees = fees;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getAddedDate() {
        return addedDate;
    }

    public void setAddedDate(Date addedDate) {
        this.addedDate = addedDate;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
    private Date addedDate;
    private boolean status;

    public Course() {
    }

    public Course(int id, int fees, String name, boolean status) {
        this.id = id;
        this.fees = fees;
        this.name = name;
        this.status = status;
    }

}
