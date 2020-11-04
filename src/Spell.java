public class Spell {
    private String type;
    private String action;
    private int mana;
    private String rute;
    public Spell(int mana, String action, String rute){
        this.type = type;
        this.action = action;
        this.mana = mana;
        this.rute = rute;
    }

    public int getMana() {
        return mana;
    }
    public String getAction() {
        return action;
    }

    public void setType(String type) {
        this.type = type;
    }
    public String getType() {
        return type;
    }
    public String getRute() {
        return rute;
    }
    public void setAction(String action) {
        this.action = action;
    }
    public void setMana(int mana) {
        this.mana = mana;
    }
    public void setRute(String rute) {
        this.rute = rute;
    }
}
