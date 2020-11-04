public class Henchmen {
    private String type;
    private int attack;
    private int mana;
    private String rute;
    public Henchmen(int attack, int mana, String rute){
        this.type = type;
        this.attack = attack;
        this.mana = mana;
        this.rute = rute;
    }

    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }
    public int getMana() {
        return mana;
    }
    public int getAttack() {
        return attack;
    }
    public String getRute() {
        return rute;
    }
    public void setAttack(int attack) {
        this.attack = attack;
    }
    public void setMana(int mana) {
        this.mana = mana;
    }
    public void setRute(String rute) {
        this.rute = rute;
    }
}
