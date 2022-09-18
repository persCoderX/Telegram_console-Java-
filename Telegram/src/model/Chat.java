package model;

import java.util.ArrayList;
import java.util.List;

public class Chat {
    private int chatId;

    private int user1;
    private int user2;

    private List<String> chatlist = new ArrayList<>();


    public int getChatId() {
        return chatId;
    }

    public void setChatId(int chatId) {
        this.chatId = chatId;
    }

    public List<String> getChatlist() {
        return chatlist;
    }

    public void setChatlist(List<String> chatlist) {
        this.chatlist = chatlist;
    }

}
