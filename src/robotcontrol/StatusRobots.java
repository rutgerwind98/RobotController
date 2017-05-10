/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package robotcontrol;


import java.util.ArrayList;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.geometry.*;
import javafx.scene.*;
import javafx.scene.control.Label;
import javafx.scene.layout.*;


/**
 *
 * @author Rutger
 */
public class StatusRobots extends Application{
    private boolean statusrobot;
    private int aantalDozen;
    
    
    private ArrayList<String> artikelenLijst = new ArrayList<String>();
    private ArrayList<String> volgordeArtikelenLijst = new ArrayList<String>();
    private ArrayList<String> ingepaktArtikelenLijst = new ArrayList<String>();

    //hier begint het scherm
    public void start(Stage primaireRobotStatus){
        primaireRobotStatus.setTitle("Robot Status");
        //http://docs.oracle.com/javafx/2/get_started/form.htm handige site
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10); //set de breedte van het gat tussen twee collummen.
        grid.setVgap(10); //set de hoogte van het gat tussen twee rijen.
        grid.setPadding(new Insets(25,25,25,25)); //padding zodat wanneer het 
        //scherm kleiner wordt gemaakt, het er nog redelijk uit ziet
        
        Scene scene = new Scene(grid, 300, 275); //zet de scene hoogte en breedte.
        primaireRobotStatus.setScene(scene);
        
        Label labeltje = new Label("status inpakrobot: ");
        grid.add(labeltje, 0 ,1);
        
        Label
        
        primaireRobotStatus.show();
    }
    
    
    public void toonRoute(){
        //toont de route die uiteindelij door het TSP is bepaald.
    }
    
    public boolean getStatus() {
        return statusrobot;
    }

    public int getAantalDozen() {
        return aantalDozen;
    }

    public ArrayList<String> getArtikelenLijst() {
        return artikelenLijst;
    }

    public ArrayList<String> getVolgordeArtikelenLijst() {
        return volgordeArtikelenLijst;
    }

    public ArrayList<String> getIngepaktArtikelenLijst() {
        return ingepaktArtikelenLijst;
    }
    
    public static void main(String args[]){
        launch();
    }
    
    
    
}
