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
public class Magazijn {
    private final int breedte = 5;// hier hoeft geen getter/setter contructor
    private final int hoogte = 5; //  omdat deze waarde niet zal veranderen
    
    public long getGrootte(){
        //returned de oppervlakte van het magazijn
        return breedte * hoogte; 
    }
}
