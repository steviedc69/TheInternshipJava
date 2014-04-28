package controllers;

import app.TheInternship;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;

/**
 * FXML Controller class
 *
 * @author iDev
 */
public class OpdrachtenOverzichtPanelController implements Initializable, ControlledView 
{
    ViewController controller;
    
    @FXML
    public ListView<String> opdrachtenLijst;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @Override
    public void setViewParent(ViewController viewcontroller)
    {
        controller = viewcontroller;
    }
    
    @FXML
    public void vulLijst()
    {
        ObservableList<String> items = FXCollections.observableArrayList(
                "Green IT: Domotica op KMO niveau ",
                "Ontwerpen van een live Dashbord ",
                "Kinect Game",
                "Nieuwe login mogelijkheden voor de KMO ",
                "Windows 8 Metro applicaties",
                "Ontwikkeling van een mobile applicatie voor het tekenen van leveringsbonnen",
                "White hacking",
                "Ontwerpen van een live Dashbord ",
                "Kinect Game",
                "Nieuwe login mogelijkheden voor de KMO ",
                "Windows 8 Metro applicaties",
                "Ontwikkeling van een mobile applicatie voor het tekenen van leveringsbonnen",
                "White hacking");
        opdrachtenLijst.setItems(items);
    }
    
    @FXML
    private void onBack(ActionEvent event)
    {
        controller.setView(TheInternship.idLoginPanel);
    }
}
