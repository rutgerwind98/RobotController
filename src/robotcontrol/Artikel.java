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
    private int grootte;   
    
    public void Artikel(int artikelnr){
        this.artikelnr = artikelnr;
    }
    
    public void Artikel(int artikelnr, int grootte){
        this.artikelnr = artikelnr;
        this.grootte = grootte;
    }
    public int getGrootte(){
        return grootte;
    }
}
