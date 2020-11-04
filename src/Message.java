public class Message {
    private String type;
    private String action;

    public Message(String type, String action){
        this.action = action;
        this.type = type;
    }
    public void setType(String type){this.type = type;}
    public void setAction(String action){this.action = action;}
    public String getType(){return this.type;}
    public String getAction(){return this.action;}

}
