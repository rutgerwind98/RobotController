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
public class StatusRobots{
    private boolean statusrobot;
    private int aantalDozen;
    
    
    private ArrayList<String> artikelenLijst = new ArrayList<String>();
    private ArrayList<String> volgordeArtikelenLijst = new ArrayList<String>();
    private ArrayList<String> ingepaktArtikelenLijst = new ArrayList<String>();

    StatusRobots(boolean b) {
        statusrobot = b;
    }

    
    
    public boolean getStatus() {
        return statusrobot;
    }
    
    
    
}
