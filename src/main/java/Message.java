import javax.websocket.Session;

public class Message {
   private String sender;
   private String text;
    private int onlineUser;
    public  Message(String username, String text,int onlineUser){
        this.text=text;
        this.sender=username;
        this.onlineUser=onlineUser;
    }
    public Message(String username, String text) {
        this.text=text;
        this.sender=username;
    }
    public Message(){}

    public void setSender(String sender) {
        this.sender=sender;
    }

    public void setText(String text) {
        this.text=text;
    }
    public String getSender() {
        return sender;
    }

    public String getText() {
        return text;
    }
    public int getOnlineUser() {
        return onlineUser;
    }

    public void setOnlineUser(int onlineUser) {
        this.onlineUser = onlineUser;
    }


}
