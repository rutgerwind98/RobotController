/*
 * Created by Rutger Wind
 * You are not permitted to make any changes to this or any of the related files
 * without the explicit permission from the original author, who is in this case Rutger Wind.
 * You may contact him on his school e-mail: rutger.wind@windesheim.nl
 */
package robotcontrol;

import java.util.ArrayList;
import java.util.Random;


/**
 *
 * @author Rutger
 */
public class Order {

    private Artikel artikel;
    private int artikelGrootte;
    private ArrayList<Doos> doosLijst = new ArrayList<Doos>();
    ArrayList<String> artikelLijst = new ArrayList<>();
    ArrayList<Artikel>database = new ArrayList<>();
    Random rand = new Random();

    public Order() {

    }

    public void voegArtikelToe(String str) {
        artikelLijst.add(str);
    }

    public void voegDoosToe(Doos ds) {
        doosLijst.add(ds);
    }

    public String getArtikelen() {
        String returnstring = "";
        for (int i = 0; i < artikelLijst.size(); i++) {
            returnstring += artikelLijst.get(i) + "\n";
        }
        return returnstring;
    }
    public ArrayList<String> getArtLijst(){
        return artikelLijst;
    }
    
    public void maakArtikelen(){
        for(int i =0; i<artikelLijst.size(); i++){
            artikelGrootte = rand.nextInt(11); //zet de grootte van het artikel van 1 t/m 10
            
        }
    }
}
