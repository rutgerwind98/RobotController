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
public class Artikel {
    private int artikelnr;
    private int grootte;   
    ArrayList<Integer> nummerlijst = new ArrayList<>();
    ArrayList<Artikel> artikelLijst = new ArrayList<>();
    
    public Artikel(){
    }
    
    public Artikel(int artikelnr){
        this.artikelnr = artikelnr;
        nummerlijst.add(artikelnr);
    }
   
    public void voegNummerToe(int num){
        nummerlijst.add(num);
        System.out.println(num + "is toegevoegd");
    }
    
    public Artikel(int artikelnr, int grootte){
        this.artikelnr = artikelnr;
        this.grootte = grootte;
        nummerlijst.add(artikelnr);
    }
    public int getGrootte(){
        return grootte;
    }
    public int getArtikelnr(){
        return artikelnr;
    }
    public String getFancyNummers(){
        String returnstring = "";
        for (int i = 0; i < nummerlijst.size(); i++) {
            returnstring += nummerlijst.get(i) + "\n";
        }
        return returnstring;
    }
    public int getGrootteFromList(int xyz){
        Artikel art = artikelLijst.get(xyz);
        return art.getGrootte();
    }
}
