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
public class Locatie {
    private double xcoordinaat;         //locatie grijper
    private double ycoordinaat;         //locatie grijper
    private double artikelXCoordinaat;  //locatie arikel
    private double artikelYCoordinaat;  //locatie artikel
    
    public String getLocatie(){
        return "X: " + xcoordinaat + " Y: " + ycoordinaat;
    }
    public void setLocatie(double X, double Y){
        this.xcoordinaat = X;
        this.ycoordinaat = Y;
    }
    public String getLocatieArtikel(){
        return "artikel X: " + artikelXCoordinaat + " Y: " + artikelYCoordinaat;
    }
    
    public void codeNaarLocatie(int arikelcode){
        //haalt de locatie van het artikel uit ?waar? en set ze in xcoordinaat en ycoordinaat
    }
}
