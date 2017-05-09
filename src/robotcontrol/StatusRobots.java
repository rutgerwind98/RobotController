/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package robotcontrol;

import java.util.ArrayList;

/**
 *
 * @author Rutger
 */
public class StatusRobots {
    private boolean statusrobot;
    private int aantalDozen;
    
    private ArrayList<String> artikelenLijst = new ArrayList<String>();
    private ArrayList<String> volgordeArtikelenLijst = new ArrayList<String>();
    private ArrayList<String> ingepaktArtikelenLijst = new ArrayList<String>();

    public void toonRoute(){
        //toont de route die uiteindelij door het TSP is bepaald.
    }
    
    public boolean getStatus() {
        return statusrobot;
    }

    public int getAantalDozen() {
        return aantalDozen;
    }

    public ArrayList<String> getArtikelenLijst() {
        return artikelenLijst;
    }

    public ArrayList<String> getVolgordeArtikelenLijst() {
        return volgordeArtikelenLijst;
    }

    public ArrayList<String> getIngepaktArtikelenLijst() {
        return ingepaktArtikelenLijst;
    }
    
    
    
}
