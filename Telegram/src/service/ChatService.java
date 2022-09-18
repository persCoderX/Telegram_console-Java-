package service;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class ChatService {


    public String getMessageTime() {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("hh:mm");
        LocalTime localTime = LocalTime.now();
        return dateTimeFormatter.format(localTime);
    }
}
