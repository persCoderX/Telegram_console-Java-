import model.Chat;
import model.Contact;
import model.User;
import service.ContactService;
import service.SettingsService;
import service.UserLoginService;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    static Scanner scannerInt=new Scanner(System.in);
    static Scanner scannerStr=new Scanner(System.in);
    public static void main(String[] args) {
        List<User> usersList = new ArrayList<>();
        List<Chat> chatList = new ArrayList<>();
        ContactService contactService=new ContactService();
        SettingsService service = new SettingsService();
        UserLoginService loginService = new UserLoginService();

        telegram(contactService, service, loginService, usersList);
    }
    private static void telegram(ContactService contactService, SettingsService service, UserLoginService loginService, List<User> usersList) {
        int userId = 10;
        while (true) {
            System.out.print("1 => Sign up\n2 =>(Have already an account) Log in\n0 => Stop the program\n>>>");
            int var5 = scannerInt.nextInt();
            if(var5==0) return;   //0 kiritlganda dastur toxtaydi
            if(!(var5>=0&&var5<=2)){
                System.out.println("Wrong choice ! Please try again.");
                continue;
            }
            String telNumber;
            while (true) {
                byte counter = 0;
                System.out.print("Insert phoneNumber: +998 ");
                telNumber = scannerStr.nextLine();
                if (telNumber.length() == 9) { // tel raqamani 9 xonaligini tekshirish
                    for (byte i = 0; i < telNumber.length(); i++) { // tel raqamani faqat raqamlardan iboratligini tekshirish
                        if (Character.isDigit(telNumber.charAt(i))) { // agar harf aralashgan bo'lsa sikl boshidan boshlanadi
                            counter++;
                        }
                    }
                } else {
                    System.out.println("Phone number have to be at least 9 digit ! Please try again.");
                    continue;
                }
                if (counter == 9) {
                    break;
                } else {
                    System.out.println("Phone number have to be only digit ! Please try again.");
                }
            }
            switch (var5) {
                case 1 -> {
                    while (true) {
                        loginService.sendSms(telNumber);
                        System.out.print("Insert sms code: ");
                        if (!loginService.recieveTheCode(scannerInt.nextInt())) {
                            System.out.println("Incorrect password please try again");
                        }else {
                            break;
                        }
                    }
                    User user = new User();
                    user.setPhoneNumber(telNumber);
                    System.out.println("<<<Creating new account. Please wait...>>>");
                    System.out.print("Insert your firstname: ");
                    user.setFirstname(scannerStr.nextLine());
                    System.out.print("Insert your lastname: ");
                    user.setLastName(scannerStr.nextLine());
                    user.setUserID(userId++);
                    usersList.add(user);
                    menuPart(contactService,service,user.contactList,usersList,telNumber);
                }
                case 2 ->{
                    int count =0;
                    for (User user : usersList) {
                        if(user!=null){
                            count++;
                        }
                    }
                    if(count==0){
                        System.out.println("There is not any account with this number !!! Please try again.\n\n ");
                        break;
                    }
                    loginService.sendSms(telNumber);
                    System.out.print("Insert sms code: ");
                    if (!loginService.recieveTheCode(scannerInt.nextInt())) {
                        System.out.println("Incorrect password please try again");
                        break;
                    }
                    for (User user : usersList) {
                        if(user.getPhoneNumber().equals(telNumber)){
                            menuPart(contactService,service,user.contactList,usersList,telNumber);
                        }
                    }
                }
                default -> System.out.println("Wrong choice please try again!");
            }
        }
    }
    public static void menuPart(ContactService contactService, SettingsService service,List<Contact> contactList, List<User> usersList,String telNumber){
        for (User user : usersList) {
            if (user != null) {
                if (user.getPhoneNumber().equals(telNumber)) {
                    while (true) {
                        System.out.print("1 => Chats\n2 => Contacts\n3 => Settings\n4 => Log out\n>>>");
                        int var1 = scannerInt.nextInt();
                        if(!(var1>0&&var1<=4)){
                            System.out.println("Wrong choice ! Please try again.");
                            continue;
                        }
                        switch (var1) {
//              case 1 -> {
//
//              }
                            case 2 -> {
                                while (true) {
                                    System.out.print("1 => Add Contact\n2 => Edit Contact\n3 => Delete Contact\n4 => List Contacts\n0 => Back\n>>>");
                                    int var2 = scannerInt.nextInt();
                                    if(!(var2>=0&&var2<=4)){
                                        System.out.println("Wrong choice ! Please try again.");
                                        continue;
                                    }
                                    if(var2==0) break;
                                    switch (var2) {
                                        case 1 -> {
                                            System.out.print("Insert phone number to search contact: +998");
                                            contactService.searchContact(usersList,contactList,scannerStr.nextLine());
                                        }
                                        case 2 -> {
                                            System.out.print("Insert phone number to search contact: +998");
                                            contactService.editContact(contactList, scannerStr.nextLine());
                                        }
                                        case 3 -> {
                                            System.out.print("Insert phone number to search contact: +998");
                                            contactService.deleteContact(contactList, scannerStr.nextLine());
                                        }
                                        case 4 -> contactService.getContacList(contactList);
                                        default -> System.out.println("Wrong choice! Please try again.");
                                    }
                                }
                            }
                            case 3 -> {
                                while (true) {
                                    System.out.println("1 => Edit Name\n2 => Edit Username\n3 => Delete Name\n4 => Get Account info\n0 => Back");
                                    int var3 = scannerInt.nextInt();
                                    if(!(var3>=0&&var3<=4)){
                                        System.out.println("Wrong choice ! Please try again.");
                                        continue;
                                    }
                                    switch (var3) {
                                        case 1 -> {
                                            System.out.print("Insert new first name: ");
                                            String newName = scannerStr.nextLine();
                                            System.out.print("Insert new last name: ");
                                            String newSurname = scannerStr.nextLine();
                                            service.EditName(user, newName, newSurname);
                                            System.out.println("Name: " + user.getFirstname() + " " + user.getLastName());
                                        }
                                        case 2 -> {
                                            System.out.print("Insert new username: ");
                                            String newUsername = scannerStr.nextLine();
                                            service.editUsername(user, newUsername);
                                            System.out.println("Username: "+user.getUserName());
                                        }
                                        case 3 -> {
                                            service.deleteName(user);
                                            System.out.println("Name: "+user.getFirstname() + " " + user.getLastName());
                                        }
                                        case 4 -> service.getAccountInfo(user);
                                        case 0 ->{
                                        }
                                        default -> System.out.println("Wrong choice! Please try again.");
                                    }
                                    if(var3==0) break;
                                }
                            }
                            case 4->{
                                return;
                            }
                            default -> System.out.println("Wrong choice! Please try again.");
                        }
                    }
                }
            }
        }
    }
}