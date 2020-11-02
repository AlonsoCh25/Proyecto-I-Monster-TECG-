/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.cards;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 *  @author Montse
 */
public class JSONParse {
    private File file;
    private ObjectMapper mapper;
    private JsonNode nodo;
    
    public JSONParse(){
        file=new File("Recursos/Cards.json");
        mapper=new ObjectMapper();
        try {
            nodo= mapper.readTree(file);
        } catch (IOException ex) {
            Logger.getLogger(JSONParse.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public Controler getAllCards(){//Controler lo use para retornar un arreglo desde el main
        Controler controler= new Controler();
        ArrayNode cards= (ArrayNode) nodo.get("Cartas");
        JsonNode cartas= cards.get(0);
        
        if(cards!=null){
            JsonNode esbirros= cartas.get("Esbirros");
            for(int i=0; i<esbirros.size(); i++){;
                JsonNode esbirro = esbirros.get(i);
                CardEsbirro esbirroN = new CardEsbirro(esbirro.get("daño").asInt(), esbirro.get("costo").asInt());
                controler.add(esbirroN);//Hacer insert normal a la lista
            }
            
            JsonNode hechizos= cartas.get("Hechizos");
            for(int i=0; i<hechizos.size(); i++){;
                JsonNode hechizo = hechizos.get(i);
                CardHechizo hechizoN = new CardHechizo(hechizo.get("poder").asText());
                controler.add(hechizoN);
            }
            
            JsonNode secretos= cartas.get("Secretos");
            for(int i=0; i<secretos.size(); i++){;
                JsonNode secreto = secretos.get(i);
                CardSecreto secretoN = new CardSecreto(secreto.get("sorpresa").asText());
                controler.add(secretoN);
            }
   
       
        }
        
        return controler;
    }
}
