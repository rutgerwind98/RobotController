/*
 * Created by Rutger Wind
 * You are not permitted to make any changes to this or any of the related files
 * without the explicit permission from the original author, who is in this case Rutger Wind.
 * You may contact him on his school e-mail: rutger.wind@windesheim.nl, to ask for such permissions.
 */
package robotcontrol;

import java.util.ArrayList;
import java.util.Random;


/**
 *
 * @author Rutger
 */
public class Order {


    private ArrayList<Doos> doosLijst = new ArrayList<Doos>();

    public Order() {
        
    }
     public void voegToe(Doos ds) {
        doosLijst.add(ds);
    }

    public ArrayList<Doos> getLijst() {
        return doosLijst;
    }

    @Override
    public String toString() {
        return "Order{" + "doosLijst=" + doosLijst + '}';
    }

}
