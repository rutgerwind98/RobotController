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
    private int grootte = 10;
    private int volheid;
    private ArrayList<Artikel> artikelLijst = new ArrayList<Artikel>();
    
    public void Doos(){
    }
    
    public void voegToe(Artikel art) {
        if (volheid + art.getGrootte() <= this.grootte) {
            artikelLijst.add(art);
            setVolheid(berekenVolheid());
        } else {
            System.out.println("Oei, dit product past niet in de doos");
        }
    }
    public String getArtikelen(){
        String returnstring = "";
        for (int i = 0; i < artikelLijst.size(); i++) {
            returnstring += artikelLijst.get(i) + "\n";
        }
        return returnstring;
    }
    
    public int getGrootte(){
        return grootte;
    }
    
    public int getVolheid(){
        return volheid;
    }
    public ArrayList<Artikel> getArtikelLijst(){
        return artikelLijst;
    }
    
    public int berekenVolheid() {
        int i = 0;
        for (Artikel art : artikelLijst) {
            i += art.getGrootte();
        }
        return i;
    }
    public void setVolheid(int volheid) {
        this.volheid = volheid;
    }
    
    public void reset() {
        this.volheid = 0;
        this.artikelLijst.clear();
    }

    
}
