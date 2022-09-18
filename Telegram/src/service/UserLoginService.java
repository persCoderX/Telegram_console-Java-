package service;

public class UserLoginService{
    int number=0;

    public void sendSms(String telNumber){
        number = (int)(Math.random()*(9999-999-1)+999);
        System.out.println("SmS sent to +998(**)***"+telNumber.substring(5)+" number! "+number); // ekranga chiqarilgan number ozgaruvchisi sms code
    }
    public boolean recieveTheCode(int code){
        if(code==number){
            return true;
        }else {
            return false;
        }
    }
}




