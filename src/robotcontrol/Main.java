/*
 * Created by Rutger Wind
 * You are not permitted to make any changes to this or any of the related files
 * without the explicit permission from the original author, who is in this case Rutger Wind.
 * You may contact him on his school e-mail: rutger.wind@windesheim.nl
 */
package robotcontrol;

import javafx.application.Application;

/**
 *
 * @author Rutger
 */



public class Main {

    /**
     * @param args the command line arguments
     */ 
    
    public static void main(String[] args) {
        
        System.out.println("pre launch");
        Application.launch(Scherm.class, args);  //start de gui voor de classe status robot
        System.out.println("post launch");
        
    }
    
}
