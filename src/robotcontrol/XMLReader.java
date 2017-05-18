/*
 * Created by Rutger Wind
 * You are not permitted to make any changes to this or any of the related files
 * without the explicit permission from the original author, who is in this case Rutger Wind.
 * You may contact him on his school e-mail: rutger.wind@windesheim.nl
 */
package robotcontrol;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.DOMException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 *
 * @author Rutger
 */
public class XMLReader {
    private static int aantalArtikelen;
    //private static String tempArt = " ";
    
    static Order order;
    
    
    public static Order XMLLezen(String bestand){
     //public static void main(String args[]){ 
        order = new Order();
        try {
            File fXmlFile = new File(bestand);
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(fXmlFile);
            
            doc.getDocumentElement().normalize();
            //normalize zorgt ervoor dat als dingen over meerder regels getypt zijn ze
            //alsnog bij elkaar komen als ze in het zelfde element zitten.
            
            System.out.println("\nRoot element: " + doc.getDocumentElement().getNodeName());
            NodeList nList = doc.getElementsByTagName("bestelling");
            
            System.out.println("-----------");
            
            for (int temp = 0; temp < nList.getLength(); temp++){
                Node nNode = nList.item(temp);
                System.out.println("CurrentElement : " + nNode.getNodeName());
                
                if(nNode.getNodeType() == Node.ELEMENT_NODE){
                    Element eElement = (Element) nNode;
                    
                    NodeList artikelLijst = doc.getElementsByTagName("artikelnr");
                    aantalArtikelen = artikelLijst.getLength();
                    
                    System.out.println("ordernummer: "
                            + eElement.getElementsByTagName("ordernummer").item(0).getTextContent());
                    System.out.println("datum: "
                            + eElement.getElementsByTagName("datum").item(0).getTextContent());
                    
                    for(int i = 0; i < aantalArtikelen; i++){
                        
                        String tempArt = eElement.getElementsByTagName("artikelnr").item(i).getTextContent();
                        
                        System.out.println("artikelnr: " + tempArt);
                        try{                     
                            order.voegArtikelToe(tempArt);
                        }catch(Exception e){
                            System.out.println(e);
                        }
                    }
                    
                }
                
            }
        } catch (IOException | ParserConfigurationException | DOMException | SAXException ex) {
            Logger.getLogger(XMLReader.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return order;
    }
}
