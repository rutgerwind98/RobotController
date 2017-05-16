/*
 * Created by Rutger Wind
 * You are not permitted to make any changes to this or any of the related files
 * without the explicit permission from the original author, who is in this case Rutger Wind.
 * You may contact him on his school e-mail: rutger.wind@windesheim.nl
 */
package robotcontrol;

import javafx.application.Application;
import javafx.geometry.*;
import javafx.scene.*;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;


/**
 *
 * @author Rutger
 */
public class Scherm extends Application{
    
    private String inpakStat;
    private String laadStat;
    private Order order;
    private XMLReader xmlLezer;
    
    
    StatusRobots inpakBot = new StatusRobots(true);
    StatusRobots laadBot = new StatusRobots(false);
    
    
    
    public void start(Stage primaireRobotStatus){
        primaireRobotStatus.setTitle("Robot Status");
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10); //set de breedte van het gat tussen twee collummen.
        grid.setVgap(10); //set de hoogte van het gat tussen twee rijen.
        grid.setPadding(new Insets(25,25,25,25)); //padding zodat wanneer het 
        //scherm kleiner wordt gemaakt, het er nog redelijk uit ziet
        
        Scene scene = new Scene(grid, 300, 275); //zet de scene hoogte en breedte.
        primaireRobotStatus.setScene(scene);
        
        if(inpakBot.getStatus()){
            inpakStat = "aan";
        }
        else{
            inpakStat = "uit";
        }
        Label inpaktekst = new Label("status inpakrobot: " + inpakStat);
        grid.add(inpaktekst, 0 ,0);
        if(laadBot.getStatus()){
            laadStat = "aan";
        }
        else{
            laadStat = "uit";
        }
        Label laadtekst = new Label("status laadrobot: " + laadStat);
        grid.add(laadtekst, 1, 0);
        System.out.println("status labels klaar -- xml lezen...");
        
        
        System.out.println("xml lezen klaar -- artikelen weergeven...");
        Label artikelen = new Label("Artikelen: \n" + order.getArtikelen());
        grid.add(artikelen, 0, 2);
        primaireRobotStatus.show();
        System.out.println("klaar!");
    }
}
