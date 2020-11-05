public class Initial_cards {
    private DoubleLinkedList All_Cards;
    private DoubleCircularList Mass;
    private Stack Deck;
    private String rute;
    private int Henchmen;
    private int Secrets;
    private int Spells;
    public Initial_cards(){
        this.All_Cards = new DoubleLinkedList();
        this.Mass = new DoubleCircularList();
        this.Deck = new Stack(17);
        this.rute = "/images/cards/";
        this.Henchmen = 17;
        this.Secrets = 8;
        this.Spells = 12;
    }
    public void crete_All_cards(){
        for(int i = 1; i<=40; i++){
                switch (i){
                    case 1:
                        Henchmen henchman = new Henchmen(75, 50, this.rute + "Henchmen/henchman_1");
                        All_Cards.insertFirst(henchman);
                        break;
                    case 2:
                        henchman = new Henchmen(100, 75, this.rute + "Henchmen/henchman_2");
                        All_Cards.insertFirst(henchman);
                        break;
                    case 3:
                        henchman = new Henchmen(125, 100, this.rute + "Henchmen/henchman_3");
                        All_Cards.insertFirst(henchman);
                        break;
                    case 4:
                        henchman = new Henchmen(150, 125, this.rute + "Henchmen/henchman_4");
                        All_Cards.insertFirst(henchman);
                        break;
                    case 5:
                        henchman = new Henchmen(175, 150, this.rute + "Henchmen/henchman_5");
                        All_Cards.insertFirst(henchman);
                        break;
                    case 6:
                        henchman = new Henchmen(200, 175, this.rute + "Henchmen/henchman_6");
                        All_Cards.insertFirst(henchman);
                        break;
                    case 7:
                        henchman = new Henchmen(225, 200, this.rute + "Henchmen/henchman_7");
                        All_Cards.insertFirst(henchman);
                        break;
                    case 8:
                        henchman = new Henchmen(250, 225, this.rute + "Henchmen/henchman_8");
                        All_Cards.insertFirst(henchman);
                        break;
                    case 9:
                        henchman = new Henchmen(270, 250, this.rute + "Henchmen/henchman_9");
                        All_Cards.insertFirst(henchman);
                        break;
                    case 10:
                        henchman = new Henchmen(300, 275, this.rute + "Henchmen/henchman_10");
                        All_Cards.insertFirst(henchman);
                        break;
                    case 11:
                        henchman = new Henchmen(325, 300, this.rute + "Henchmen/henchman_11");
                        All_Cards.insertFirst(henchman);
                        break;
                    case 12:
                        henchman = new Henchmen(350, 325, this.rute + "Henchmen/henchman_12");
                        All_Cards.insertFirst(henchman);
                        break;
                    case 13:
                        henchman = new Henchmen(375, 350, this.rute + "Henchmen/henchman_13");
                        All_Cards.insertFirst(henchman);
                        break;
                    case 14:
                        henchman = new Henchmen(400, 375, this.rute + "Henchmen/henchman_14");
                        All_Cards.insertFirst(henchman);
                        break;
                    case 15:
                        henchman = new Henchmen(425, 400, this.rute + "Henchmen/henchman_15");
                        All_Cards.insertFirst(henchman);
                        break;
                    case 16:
                        henchman = new Henchmen(450, 425, this.rute + "Henchmen/henchman_16");
                        All_Cards.insertFirst(henchman);
                        break;
                    case 17:
                        henchman = new Henchmen(50, 25, this.rute + "Henchmen/henchman_17");
                        All_Cards.insertFirst(henchman);
                        break;
                    case 18:
                        Spell spell = new Spell(200, "r_damage", this.rute + "Spells/Spell_1");
                        All_Cards.insertFirst(spell);
                        break;
                    case 19:
                        spell = new Spell(200, "v_+50%", this.rute + "Spells/Spell_2");
                        All_Cards.insertFirst(spell);
                        break;
                    case 20:
                        spell = new Spell(200, "p_4cards", this.rute + "Spells/Spell_3");
                        All_Cards.insertFirst(spell);
                        break;
                    case 21:
                        spell = new Spell(200, "r_card", this.rute + "Spells/Spell_4");
                        All_Cards.insertFirst(spell);
                        break;
                    case 22:
                        spell = new Spell(200, "s_card", this.rute + "Spells/Spell_5");
                        All_Cards.insertFirst(spell);
                        break;
                    case 23:
                        spell = new Spell(200,"shield", this.rute + "Spells/Spell_6");
                        All_Cards.insertFirst(spell);
                        break;
                    case 24:
                        spell = new Spell(200, "freeze_x1", this.rute + "Spells/Spell_7");
                        All_Cards.insertFirst(spell);
                        break;
                    case 25:
                        spell = new Spell(200, "-damage", this.rute + "Spells/Spell_8");
                        All_Cards.insertFirst(spell);
                        break;
                    case 26:
                        spell = new Spell(200, "freeze_x2", this.rute + "Spells/Spell_9");
                        All_Cards.insertFirst(spell);
                        break;
                    case 27:
                        spell = new Spell(200, "n_shield", this.rute + "Spells/Spell_10");
                        All_Cards.insertFirst(spell);
                        break;
                    case 28:
                        spell = new Spell(200, "v_+25%", this.rute + "Spells/Spell_11");
                        All_Cards.insertFirst(spell);
                        break;
                    case 29:
                        spell = new Spell(200, "+100m", this.rute + "Spells/Spell_12");
                        All_Cards.insertFirst(spell);
                        break;
                    case 30:
                        Secret secret = new Secret(300, "-10%", this.rute + "Secrets/Secret1");
                        All_Cards.insertFirst(secret);
                        break;
                    case 31:
                        secret = new Secret(300, "-10%m", this.rute + "Secrets/Secret2");
                        All_Cards.insertFirst(secret);
                        break;
                    case 32:
                        secret = new Secret(300, "-30%", this.rute + "Secrets/Secret3");
                        All_Cards.insertFirst(secret);
                        break;
                    case 33:
                        secret = new Secret(300, "d_card", this.rute + "Secrets/Secret4");
                        All_Cards.insertFirst(secret);
                        break;
                    case 34:
                        secret = new Secret(300, "+lastM", this.rute + "Secrets/Secret5");
                        All_Cards.insertFirst(secret);
                        break;
                    case 35:
                        secret = new Secret(300, "E_250", this.rute + "Secrets/Secret6");
                        All_Cards.insertFirst(secret);
                        break;
                    case 36:
                        secret = new Secret(300, "doubleM", this.rute + "Secrets/Secret7");
                        All_Cards.insertFirst(secret);
                        break;
                    case 37:
                        secret = new Secret(300, "big_damage", this.rute + "Secrets/Secret8");
                        All_Cards.insertFirst(secret);
                        break;
                    case 38:
                        spell = new Spell(200, "p_3cards", this.rute + "Spells/Spell_13");
                        All_Cards.insertFirst(spell);
                        break;
                    case 39:
                        secret = new Secret(300, "c_mass", this.rute + "Secrets/Secret9");
                        All_Cards.insertFirst(secret);
                        break;
                    case 40:
                        secret = new Secret(300, "n_damage", this.rute + "Secrets/Secret10");
                        All_Cards.insertFirst(secret);
                        break;
                }
        }
    }
    public void create_Deck() throws Exception {
        for(int i = 0; i<16; i++){
            Deck.push(All_Cards.Data_find((int) (Math.random() * 40) + 1));
        }
    }
    public void create_Mass(){
        for(int i = 0; i<4; i++){ ;
            Mass.insertFirst(All_Cards.Data_find((int) (Math.random() * 40) + 1));
        }
    }
    public DoubleCircularList getMass() {
        return Mass;
    }
    public DoubleLinkedList getAll_Cards() {
        return All_Cards;
    }
    public Stack getDeck() {
        return Deck;
    }
}
