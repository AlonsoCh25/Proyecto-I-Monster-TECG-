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
public class CardEsbirro extends Card{
    
    private int damage;
    private int cost;

    public CardEsbirro(int damage, int cost) {
        super();
        this.damage = damage;
        this.cost = cost;
    }

    

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    @Override
    public String toString() {
        return "CardEsbirro{" + "damage=" + damage + ", cost=" + cost + '}';
    }

    @Override
    public void action() {
        System.out.println("ATACO"); //To change body of generated methods, choose Tools | Templates.
        //
        //aqui puedo hacer una validacion del tipo de carta para que haga algo
        //
    }
    
    
}
