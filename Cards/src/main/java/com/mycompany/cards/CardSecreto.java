/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.cards;

/**
 *
 *  @author Montse
 */
public class CardSecreto extends Card {
    private String surprise;

    public CardSecreto(String surprise) {
        super();
        this.surprise = surprise;
    }

    public String getSurprise() {
        return surprise;
    }

    public void setSurprise(String surprise) {
        this.surprise = surprise;
    }
    
    @Override
    public void action() {
        System.out.println("SORPRESA"); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
