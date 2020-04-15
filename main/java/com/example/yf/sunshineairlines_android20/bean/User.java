package com.example.yf.sunshineairlines_android20.bean;

/**
 * Created by yf on 2020/4/4.
 */

import java.io.Serializable;

/**
 * 用户类
 */
public class User implements Serializable {
    private String ID;
    private String Email;
    private String FirstName;
    private String LastName;
    private String Gender;
    private String Password;

    public User() {
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String firstName) {
        FirstName = firstName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }

    public String getGender() {
        return Gender;
    }

    public void setGender(String gender) {
        Gender = gender;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public User(String ID, String email, String firstName, String lastName, String gender, String password) {

        this.ID = ID;
        Email = email;
        FirstName = firstName;
        LastName = lastName;
        Gender = gender;
        Password = password;
    }
}
