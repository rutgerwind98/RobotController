/*
 * Created by Rutger Wind
 * You are not permitted to make any changes to this or any of the related files
 * without the explicit permission from the original author, who is in this case Rutger Wind.
 * You may contact him on his school e-mail: rutger.wind@windesheim.nl
 */
package robotcontrol;



import javafx.geometry.*;
import javafx.scene.control.Label;
import java.io.File;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

/**
 *
 * @author Rutger
 */
public class Scherm extends Application{
    
    private String inpakStat;
    private String laadStat;
    private String xmlbestand = "";
    private Order order;
    private Label artikelen;

    
    StatusRobots inpakBot = new StatusRobots(true);
    StatusRobots laadBot = new StatusRobots(false);
    private static XMLReader xmllezer;
    
    public  String getXmlBestand(){
        return this.xmlbestand;
    }
    
    public void start(Stage schermStage){
        schermStage.setTitle("Robot Controller");
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10); //set de breedte van het gat tussen twee collummen.
        grid.setVgap(10); //set de hoogte van het gat tussen twee rijen.
        grid.setPadding(new Insets(25,25,25,25)); //padding zodat wanneer het 
        //scherm kleiner wordt gemaakt, het er nog redelijk uit ziet
        
        Group root = new Group();
        Canvas canvas = new Canvas(400,400);
        GraphicsContext gc = canvas.getGraphicsContext2D();
        drawShapes(gc);
        root.getChildren().add(canvas);
        schermStage.setScene(new Scene(root));
        
        Scene scene = new Scene(grid, 800, 600); //zet de scene hoogte en breedte.
        schermStage.setScene(scene);
        
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Open Resource File");
        
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
        openButton.setOnAction(
            new EventHandler<ActionEvent>() {
                @Override
                public void handle(final ActionEvent e) {
                    configureFileChooser(fileChooser);
                    File file = fileChooser.showOpenDialog(null);
                    if (file != null) {
                        System.out.println(file);
                        xmlbestand = file.toString();
                        System.out.println("lees xml");
                        order = xmllezer.XMLLezen(xmlbestand);
                        artikelen.setText("Artikelen: \n" + order.getArtikelen());
                        System.out.println("xml lezen klaar -- artikelen weergeven...");
                        
                    }
                }
                
            });
        grid.add(openButton, 0, 1);
        grid.add(artikelen, 1, 1);
        try{
        grid.add(root,2,1);
        }catch(Exception e){
            System.out.println(e);
        }
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
    private void drawShapes(GraphicsContext gc){
        gc.setFill(Color.GREEN);
        gc.setStroke(Color.BROWN);
        gc.setLineWidth(5);
        //randen van magazijn
        gc.strokeLine(5, 5, 5, 395);
        gc.strokeLine(5,5,395,5);
        gc.strokeLine(395, 5, 395, 395);
        gc.strokeLine(5, 395, 395, 395);
        //verticale lijnen magazijn
        gc.strokeLine(83, 6, 83, 394);
        gc.strokeLine(162, 6, 162, 394);
        gc.strokeLine(241, 6, 241, 394);
        gc.strokeLine(320, 6, 320, 394);
        //horizontale lijnen magazijn
        gc.strokeLine(6, 83, 394, 83);
        gc.strokeLine(6, 162, 394, 162);
        gc.strokeLine(6, 241, 394, 241);
        gc.strokeLine(6, 320, 394, 320);
    }
}
