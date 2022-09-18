package service;

import model.Contact;
import model.User;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class ContactService {

    public void searchContact(List<User> userslist,List<Contact> contactList, String phoneNumber){
        Scanner scanner=new Scanner(System.in);
        int counter= 0;
        for (User user : userslist) {
            if (user != null) {
                if (user.getPhoneNumber().equals(phoneNumber)) {
                    counter++;
                    System.out.println("User has been found\n" + user.getFirstname() + " " + user.getLastName() + "\nPhone Numeber: +998" + user.getPhoneNumber());
                    System.out.print("\nAdd to your contact (yes/no): >>");
                    if (scanner.nextLine().equals("yes")) {
                        addContact(user, contactList);
                        System.out.println("User has been added to your contact successfully.");
                        return;
                    }

                }
            }
        }
        if(counter==0){
            System.out.println("Sorry we could not find the User !");
        }
    }

    public void addContact(User user,List<Contact> list){
        Contact contact = new Contact();
        contact.setFirstname(user.getFirstname());
        contact.setLastName(user.getLastName());
        contact.setPhoneNumber(user.getPhoneNumber());
        contact.setUserName(user.getUserName());
        contact.setUserID(user.getUserID());
        list.add(contact);
    }

    public void deleteContact(List<Contact> contactList,String phoneNumber){
        Scanner scanner=new Scanner(System.in);
        int counter =0;
        if(!contactList.isEmpty()) {
            for (Contact user : contactList) {
                if (user != null) {
                    if (user.getPhoneNumber().equals(phoneNumber)) {
                        counter++;
                        System.out.println("User has been found\n" + user.getFirstname() + " " + user.getLastName() + "\nPhone Numeber: +998" + user.getPhoneNumber());
                        System.out.print("\nAre you sure you want to delete this contact (yes/no): >>");
                        if (scanner.nextLine().equals("yes")) {
                            contactList.remove(user);
                            System.out.println("User has been deleted from your contact successfully.");
                            return;
                        }

                    }
                }
            }
            if(counter==0){
                System.out.println("Sorry we could not find the User !");
            }
        }else {
            System.out.println("Sorry your contact list is empty ! ");
        }
    }
    public void editContact(List<Contact> contactList,String phoneNumber) {
        int counter=0;
        String changeName,changeSurname;
        if (!contactList.isEmpty()) {
            for (Contact user : contactList) {
                if (user != null) {
                    if (user.getPhoneNumber().equals(phoneNumber)) {
                        counter++;
                        System.out.println("User has been found\n" + user.getFirstname() + " " + user.getLastName() + "\nPhone Numeber: +998" + user.getPhoneNumber());
                        Scanner scanner = new Scanner(System.in);
                        System.out.print("\nEdit name : >>");
                        changeName = scanner.nextLine();
                        user.setFirstname(changeName);
                        scanner = new Scanner(System.in);
                        System.out.print("Edit surname : >>");
                        changeSurname = scanner.nextLine();
                        user.setLastName(changeSurname);
                        System.out.println("User's name has been changed successfully.");
                    }
                }
            }
            if(counter==0) {
                System.out.println("Sorry we could not find the User !");
            }
        }else {
            System.out.println("Sorry your contact list is empty ! ");
        }
    }
    public void getContacList(List<Contact> contactList){
        if(!contactList.isEmpty()) {
            for (Contact user : contactList) {
                System.out.println(user.getFirstname() + " " + user.getLastName());
            }
        }else {
            System.out.println("Your contact list is empty ! ");
        }
    }
}