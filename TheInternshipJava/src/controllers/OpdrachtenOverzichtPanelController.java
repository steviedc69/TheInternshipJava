package controllers;

import app.TheInternship;
import domain.Opdracht;
import domain.OpdrachtBuilder;
import java.net.URL;
import java.util.Iterator;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.text.Text;
import javafx.util.Callback;

/**
 * FXML Controller class
 *
 * @author iDev
 */
public class OpdrachtenOverzichtPanelController implements Initializable {

    @FXML
    public ListView<Opdracht> opdrachtenLijst ;
    
    public ObservableList<Opdracht> listOpdrachten = FXCollections.observableArrayList();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
    
    @FXML
    public void vulLijst(List<Opdracht> list) {
        setupListView();
        listOpdrachten.addAll(list);

        opdrachtenLijst.setItems(listOpdrachten);
        opdrachtenLijst.setCellFactory(new Callback<ListView<Opdracht>, 
            ListCell<Opdracht>>() {
                @Override 
                public ListCell<Opdracht> call(ListView<Opdracht> list) {
                    return new MyCell();
                }
            }
        );

    }
    
    //Instellen van de listview. dwz hoogte en breedte
    public void setupListView(){
        opdrachtenLijst.relocate(10, 210);
        opdrachtenLijst.setPrefSize(opdrachtenLijst.getPrefWidth(), opdrachtenLijst.getPrefHeight());
    }
    
    

}
