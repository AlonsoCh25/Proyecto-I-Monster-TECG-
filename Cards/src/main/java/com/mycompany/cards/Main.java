/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.cards;

import java.util.ArrayList;

/**
 *
 *  @author Montse
 */
public class Main {

    public static void main(String[] args) {
        JSONParse json = new JSONParse();
        ArrayList<Card> cartas = json.getAllCards();
        for (int i = 0; i < cartas.size(); i++) {
            cartas.get(i).action();


        }
    }
}