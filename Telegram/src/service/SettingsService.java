package service;

import model.User;

public class SettingsService {
    public void EditName(User user,String newFirstName ,String newLastName) {
        user.setFirstname(newFirstName);
        user.setLastName(newLastName);
        System.out.println("Name has been changed successfully");

    }
    public void editUsername(User user,String newUsername) {
        user.setUserName(newUsername);
        System.out.println("User name has been changed successfully");
    }
    public void deleteName(User user){
        user.setFirstname("Unknown");
        user.setLastName("");
        System.out.println("Name has been deleted successfully");
    }
    public void getAccountInfo(User user){
        System.out.println("First name: "+user.getFirstname());
        System.out.println("Last name: "+user.getLastName());
        System.out.println("Username: "+user.getUserName());
        System.out.println("Phone number: "+user.getPhoneNumber());
        System.out.println("ID number: "+user.getUserID());
    }

}
