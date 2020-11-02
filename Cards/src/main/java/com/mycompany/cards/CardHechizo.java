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
public class CardHechizo extends Card{
    
    private String power;

    public CardHechizo(String power) {
        super();
        this.power = power;
        
    }

    public String getPower() {
        return power;
    }

    public void setPower(String power) {
        this.power = power;
    }
    
    @Override
    public void action() {
        System.out.println("PODER"); //To change body of generated methods, choose Tools | Templates.
        //switch (this.power):
            //case congela turno del contrincante:
            //llama a funcion congelar un turno
    }
    //funcion congelar un turno
    
}
