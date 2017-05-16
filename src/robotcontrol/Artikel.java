/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package robotcontrol;

/**
 *
 * @author Rutger
 */
public class Artikel {
    private int artikelnr;
    private int hoogte;   
    
    public void Artikel(int artikelnr){
        this.artikelnr = artikelnr;
    }
    
    public void Artikel(int artikelnr, int hoogte){
        this.artikelnr = artikelnr;
        this.hoogte = hoogte;
    }
    public int getHoogte(){
        return hoogte;
    }
}
