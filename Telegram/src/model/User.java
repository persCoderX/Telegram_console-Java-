package model;

import java.util.ArrayList;
import java.util.List;

public class User {
    protected String phoneNumber;
    protected String firstname;
    protected String lastName;
    protected int userID;
    protected String userName="";
    public List<Contact> contactList = new ArrayList<>();

    public String getUserName() {
        return userName;
    }
    public User(){
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;

    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }
}
