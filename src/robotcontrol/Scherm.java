/*
 * Created by Rutger Wind
 * You are not permitted to make any changes to this or any of the related files
 * without the explicit permission from the original author, who is in this case Rutger Wind.
 * You may contact him on his school e-mail: rutger.wind@windesheim.nl
 */
package robotcontrol;

import javafx.geometry.*;
import javafx.scene.control.*;
import java.io.File;
import java.util.ArrayList;
import javafx.application.Application;
import javafx.event.*;
import javafx.geometry.Insets;
import javafx.scene.*;
import javafx.scene.canvas.*;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.stage.*;

/**
 *
 * @author Rutger
 */
public class Scherm extends Application{
    private Doos doos = new Doos();
    private Order order = new Order();
    private static XMLReader xmllezer;
    private XMLReader xmlObj = new XMLReader();
    private Artikel artikel = new Artikel();
    private FirstFitDecreasing FFDalgoritme = new FirstFitDecreasing();
    
    private String inpakStat;
    private String laadStat;
    private String xmlbestand = "";
    private Label artikelen;
    private ArrayList<Artikel> artikelLijst = xmlObj.getLijst();
    
    StatusRobots inpakBot = new StatusRobots(true);
    StatusRobots laadBot = new StatusRobots(false);
    
    public  String getXmlBestand(){
        return this.xmlbestand;
    }
    //hier begint het scherm
    //http://docs.oracle.com/javafx/2/get_started/form.htm handige site

    /**
     *
     * @param schermStage
     */
    @Override
    public void start(Stage schermStage){
        schermStage.setTitle("Robot Controller");
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10); //set de breedte van het gat tussen twee collummen.
        grid.setVgap(10); //set de hoogte van het gat tussen twee rijen.
        grid.setPadding(new Insets(0)); //padding zodat wanneer het 
        //scherm kleiner wordt gemaakt, het er nog redelijk uit ziet  
        grid.setGridLinesVisible(true); //VOOR DEBUGGING
        
        Group doosGroep = new Group();
        Canvas dooscanvas = new Canvas(420,325);//#blazeit
        GraphicsContext gfxc = dooscanvas.getGraphicsContext2D();
        doosGroep.getChildren().add(dooscanvas);
        schermStage.setScene(new Scene(doosGroep));
        
        Group magazijnGroep = new Group();
        Canvas canvas = new Canvas(420,325);
        GraphicsContext gc = canvas.getGraphicsContext2D();
        magazijnGroep.getChildren().add(canvas);
        schermStage.setScene(new Scene(magazijnGroep));
        
        Scene scene = new Scene(grid, 700, 800); //zet de scene hoogte en breedte.
        schermStage.setScene(scene);
        
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Open Resource File");
        
        tekenMagazijn(gc);
        tekenDozen(gfxc);
        

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
        grid.add(laadtekst, 1,0);
        System.out.println("status labels klaar -- xml lezen...");
        
        artikelen = new Label();
        final Button openButton = new Button("Importeer Order");
        openButton.setOnAction((final ActionEvent e) -> {
            configureFileChooser(fileChooser);
            File file = fileChooser.showOpenDialog(null);
            if (file != null) {
                System.out.println(file);
                xmlbestand = file.toString();
                System.out.println("lees xml");
                xmllezer.XMLLezen(xmlbestand);
                order = FFDalgoritme.run(artikelLijst);
                
                System.out.println("xml lezen klaar -- artikelen weergeven...");
                artikelen.setText("Artikelnr.:  Grootte: \n" + stringLijst());
                
                System.out.println("nummers weergegeven \n" + stringLijst());
                    schuifKaas(gc);
                System.out.println("magazijn weergegeven");
                    tekenDoosArt(gfxc);
                System.out.println("artikelen bij dozen weergegeven");
                
                
            }
        });
        
        grid.add(openButton, 0, 1);
        grid.add(artikelen, 1, 1);
        grid.add(magazijnGroep,2,0);
        grid.add(doosGroep,2,1);
        
        
        
        schermStage.show();
        System.out.println("eerste scherm klaar -- ETA on next screen aprox. less then 1 sec!");
        //Application.launch(Magazijn.class, args);  //start de gui voor de classe status robot
    }
    
    
    private static void configureFileChooser(final FileChooser fileChooser){                           
        fileChooser.setTitle("kies xml-bestand");
        fileChooser.setInitialDirectory(new File(System.getProperty("user.home")));
        fileChooser.getExtensionFilters().addAll(
        new FileChooser.ExtensionFilter("XML", "*.xml"),
        new FileChooser.ExtensionFilter("All Files", "*.*")
                
        );
    }
    //drawShapes maakt de layout van het magazijn
    private void tekenMagazijn(GraphicsContext gc){
        gc.setStroke(Color.CHOCOLATE);
        gc.setLineWidth(5);
        //randen van magazijn
        gc.strokeLine(5, 5, 5, 320);
        gc.strokeLine(5,5,395,5);
        gc.strokeLine(395, 5, 395, 320);
        //verticale lijnen magazijn
        gc.strokeLine(83, 6, 83, 318);
        gc.strokeLine(162, 6, 162, 318);
        gc.strokeLine(241, 6, 241, 318);
        gc.strokeLine(320, 6, 320, 318);
        //horizontale lijnen magazijn
        gc.strokeLine(6, 83, 394, 83);
        gc.strokeLine(6, 162, 394, 162);
        gc.strokeLine(6, 241, 394, 241);
        gc.strokeLine(6, 320, 394, 320);
    }
    
    //tekenArtikel tekent blauwe rondjes op op de meegegeven x en y coordinaten
    private void tekenArtikel(GraphicsContext gc,int x,int y){
        gc.setFill(Color.BLUE);
        gc.fillOval(x, y, 50, 50);
    }
    //schuifKaas kijkt welke artikelen in de arraylist zitten en geeft vervolgens de juiste
    //coordinaten mee naar tekenArtikel
    private void schuifKaas(GraphicsContext gc){
        for (int i = 0; i < artikelLijst.size(); i++) {
            int item = artikelLijst.get(i).getArtikelnr();
            switch(item){
                // over het algmeen kan er een marge van 80 pixels worden aangehouden tussen de hokjes.
                // dit moet overigens nog wel een beetje gecorrigeerd worden 
                //omdat de lijnen een oneven dikte hebben van 5 px.
                //bovenste rij
                case 1: tekenArtikel(gc,19,19); break;
                case 2: tekenArtikel(gc,98,19); break;
                case 3: tekenArtikel(gc,176,19); break;
                case 4: tekenArtikel(gc,255,19); break;
                case 5: tekenArtikel(gc,333,19); break;
                //tweede rij
                case 6: tekenArtikel(gc,19,98); break;
                case 7: tekenArtikel(gc,98,98); break;
                case 8: tekenArtikel(gc,176,98); break;
                case 9: tekenArtikel(gc,255,98); break;
                case 10: tekenArtikel(gc,333,98); break;
                //derde rij
                case 11: tekenArtikel(gc,19,174); break;
                case 12: tekenArtikel(gc,98,174); break;
                case 13: tekenArtikel(gc,176,174); break;
                case 14: tekenArtikel(gc,255,174); break;
                case 15: tekenArtikel(gc,333,174); break;
                //vierde rij
                case 16: tekenArtikel(gc,19,255); break;
                case 17: tekenArtikel(gc,98,255); break;
                case 18: tekenArtikel(gc,176,255); break;
                case 19: tekenArtikel(gc,255,255); break;
                case 20: tekenArtikel(gc,333,255); break;
            }
        }
    }

    private void tekenDozen(GraphicsContext gfxc) {
        gfxc.setStroke(Color.BLACK);
        gfxc.setLineWidth(2);
        gfxc.strokeRect(5, 5, 95, 225);
        gfxc.strokeRect(105, 5, 95, 225);
        gfxc.strokeRect(205, 5, 95, 225);
        gfxc.strokeRect(305, 5, 95, 225);
        
        
    }
    
    private void tekenDoosArt(GraphicsContext gfxc){
        int modifier = 23;
        gfxc.setFill(Color.ORANGE);
/*        for (int i = 0; i < artikelLijst.size(); i++) {
            int x = (i * 46) + 5;
            int h = artikelLijst.get(i).getGrootte() * 7;
            gfxc.fillRect(x,240,45,h);
        }*/

        System.out.println(order);
        int nummerVanDoos = 0;
        for(Doos ds : order.getLijst()){
            int volheid = 0;
            for(Artikel art: ds.getArtikelLijst()){
                int grootte = art.getGrootte();
                gfxc.setFill(getColor(1.0 - (double)art.getGrootte() / (double)10));
                gfxc.fillRect(5 + 100 * nummerVanDoos, 230 - volheid * modifier - grootte * modifier, 95, grootte * modifier);
                gfxc.strokeLine(5 + 100 * nummerVanDoos, 230 - volheid * modifier - grootte * modifier, 5 + 100 * nummerVanDoos+ 95, 230 - volheid * modifier - grootte * modifier);
                volheid += grootte;
            }
            nummerVanDoos++;
        }
    }
    private String stringLijst(){
        String returnString = "";
        for(int i = 0; i<artikelLijst.size();i++){
            returnString += artikelLijst.get(i).getArtikelnr() + " ----------- " + artikelLijst.get(i).getGrootte() + "\n";
        }
        return returnString;
    }

    private Color getColor(double d) {
        double H = d*150;
        double S = 0.9;
        double B = 0.9;
        
        return Color.hsb((float) H, (float) S, (float) B);
    }
    
    
}
