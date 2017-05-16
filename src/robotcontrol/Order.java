/*
 * Created by Rutger Wind
 * You are not permitted to make any changes to this or any of the related files
 * without the explicit permission from the original author, who is in this case Rutger Wind.
 * You may contact him on his school e-mail: rutger.wind@windesheim.nl
 */
package robotcontrol;

import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;

/**
 *
 * @author Rutger
 */
public class Order {

    private int ordernummer;
    private String artikelnummer;
    private ArrayList<Doos> doosLijst = new ArrayList<Doos>();
    ArrayList<String> artikelLijst = new ArrayList<>();

    public Order(String str){
        this.artikelnummer = str;
    }
    public void voegArtikelToe(String str){
        artikelLijst.add(str);
    }
    public void voegDoosToe(Doos ds) {
        doosLijst.add(ds);
    }
    public void getArtikelen(){
        for(int i=0; i < artikelLijst.size(); i++){
            artikelLijst.get(i);            
        }
    }
}
    
       

}
