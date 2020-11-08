public class Henchmen {
    private int attack;
    private int mana;
    private String rute;
    public Henchmen(int attack, int mana, String rute){
        this.attack = attack;
        this.mana = mana;
        this.rute = rute;
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
}
