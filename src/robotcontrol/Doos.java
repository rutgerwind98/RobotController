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
public class Doos {
    private int hoogte;
    private int volheid;
    
    private ArrayList<Artikel> artikelLijst = new ArrayList<Artikel>();
    
    public void Doos(int hoogte){
        this.hoogte = hoogte;
    }
    
    public int getHoogte(){
        return hoogte;
    }
    
    public int getVolheid(){
        return volheid;
    }
    public ArrayList<Artikel> getLijst(){
        return artikelLijst;
    }
    
    public void berekenVolheid(){
        volheid = hoogte; //hier moet nog wel wat bij
    }
    
    
    
}
