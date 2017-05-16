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
    private  int breedte;// hier hoeft geen getter/setter contructor
    private  int hoogte; //  omdat deze waarde niet zal veranderen
    
    public void Magazijn(int breedte,int hoogte){
        this.breedte = breedte;
        this.hoogte = hoogte;
    }
    
    public int getMagazijn(){
        return breedte * hoogte;
    }
}
