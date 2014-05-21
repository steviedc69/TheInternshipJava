package controllers;

import domain.Opdracht;
import domain.StageBegeleider;
import domain.Status;
import domain.Statussen;
import eu.schudt.javafx.controls.calendar.DatePicker;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.util.Callback;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author iDev
 */
public class OpdrachtenOverzichtPanelController implements Initializable {
    //model maken
    
    @FXML
    public ListView<Opdracht> opdrachtenLijst;

    @FXML
    public Label titel, vaardigheden, schooljaar, activatiedatum, aantalStudenten, adres, ondertekenaar, specialisatie, stagementor, bedrijf;
    @FXML
    public TextArea admincomment, omschrijving;
    @FXML
    public ChoiceBox<StageBegeleider> stagebegeleider;
    @FXML
    public ChoiceBox<Status> status;
    @FXML
    public CheckBox semester1, semester2;
    @FXML
    public Button opslaan, drukAf;
    @FXML
    public GridPane opdrachtPane;
    @FXML
    public TextField beginDag, beginMaand, beginJaar, eindDag, eindMaand, eindJaar;
    public ObservableList<Opdracht> listOpdrachten = FXCollections.observableArrayList();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    public void vulLijst(List<Opdracht> list) throws UnsupportedEncodingException {
        setupListView();
        listOpdrachten.addAll(list);

        opdrachtenLijst.setItems(listOpdrachten);
        opdrachtenLijst.setCellFactory(new Callback<ListView<Opdracht>, ListCell<Opdracht>>() {
            @Override
            public ListCell<Opdracht> call(ListView<Opdracht> list) {
                return new OpdrachtCell();
            }
        });
        
        opdrachtenLijst.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Opdracht>() {
            @Override
            public void changed(ObservableValue<? extends Opdracht> ov, Opdracht t, Opdracht t1) {
                tekstVakken(t1);
                adres(t1);
                semesters(t1);
                stagebegeleider(t1);
                status(t1);
                datum(t1);
            }
        });

    }

    //Instellen van de listview. dwz hoogte en breedte
    public void setupListView() {
        opdrachtenLijst.relocate(10, 210);
        opdrachtenLijst.setPrefSize(opdrachtenLijst.getPrefWidth(), opdrachtenLijst.getPrefHeight());
        
    }

    //alle tekstvakken opvullen
    public void tekstVakken(Opdracht opdracht) {
        titel.setText(opdracht.getTitle());
        admincomment.setText(opdracht.getAdmincomment());
        omschrijving.setText(opdracht.getOmschrijving());
        vaardigheden.setText(opdracht.getVaardigheden());
        schooljaar.setText(opdracht.getSchooljaar());
        activatiedatum.setText(opdracht.getActivatieDatum());
        aantalStudenten.setText(String.valueOf(opdracht.getAantalStudenten()));
        ondertekenaar.setText(opdracht.getOndertekenaar().getVoornaam() + " " + opdracht.getOndertekenaar().getNaam());
        stagementor.setText(opdracht.getStagementor().getVoornaam() + " " + opdracht.getStagementor().getNaam());
        specialisatie.setText(opdracht.getSpecialisatie().getTitle());
        bedrijf.setText(opdracht.getBedrijf().getBedrijfsnaam());
    }

    //checkboxen aanvinken als dit nodig is.
    public void semesters(Opdracht opdracht) {
        semester1.setSelected(opdracht.getIsSemester1());
        semester2.setSelected(opdracht.getIsSemester2());
    }

    //label adres opvullen
    public void adres(Opdracht opdracht) {
        String adresString = opdracht.getAdres().getStraatnaam() + " " + opdracht.getAdres().getNummer() + "\n";
        adresString += opdracht.getAdres().getGemeente().getPostcode() + " " + opdracht.getAdres().getGemeente().getUp();
        adres.setText(adresString);
    }
    
    public void datum(Opdracht opdracht){
        beginJaar.setText(opdracht.getStartDate().substring(0, 4));
        beginMaand.setText(opdracht.getStartDate().substring(5, 7));
        beginDag.setText(opdracht.getStartDate().substring(8,10));
        eindJaar.setText(opdracht.getEindDate().substring(0, 4));
        eindMaand.setText(opdracht.getEindDate().substring(5, 7));
        eindDag.setText(opdracht.getEindDate().substring(8,10));
        
    }
    
    public void stagebegeleider(Opdracht opdracht) {
        ObservableList<StageBegeleider> stagebegeleiders = FXCollections.observableArrayList(opdracht.getStagebegeleiders());

        //
        stagebegeleider.setItems(stagebegeleiders);
        if (opdracht.getStagebegeleider() != null){
        Iterator<StageBegeleider> it = stagebegeleiders.iterator();
        //overlopen van de lijst van mogelijke stagebegeleiders om te bepalen welke stagebegeleider geselecteerd is.
        
        while (it.hasNext()) {
            StageBegeleider begeleider = it.next();
            if (opdracht.getStagebegeleider().getNaam().equals(begeleider.getNaam()) && begeleider.getVoornaam().equals(opdracht.getStagebegeleider().getVoornaam())) {
                stagebegeleider.getSelectionModel().select(begeleider);
            }
        }
        }

    }

    public void status(Opdracht opdracht) {
        ObservableList<Status> statussen = FXCollections.observableArrayList(Statussen.getStatussen());

        status.setItems(statussen);
        Iterator<Status> it2 = statussen.iterator();
        while (it2.hasNext()) {
            Status statusItem = it2.next();
            if (opdracht.getStatus().getNaam().equals(statusItem.getNaam())) {
                status.getSelectionModel().select(statusItem);
            }
        }

    }
    
    /*public List<Student> geefCheckedStudentenTerug(){
        


        //Hier moeten de studenten opgehaald worden uit de listview die nog aangevinkt zijn
        
        
        
    }*/

    public void initialiseer() {
        
       
        opslaan.setOnAction(new EventHandler<ActionEvent>() {
        
            @Override
            public void handle(ActionEvent t) {
                Opdracht opdracht = opdrachtenLijst.getSelectionModel().getSelectedItem();
                if (opdracht != null) {
                    //
                    Status statusOpdracht = opdracht.getStatus();
                    Opdracht opdrachtNieuw = opdracht;
                    opdrachtNieuw.setAdmincomment(admincomment.getText());
                    opdrachtNieuw.setIsSemester1(semester1.isSelected());
                    opdrachtNieuw.setIsSemester2(semester2.isSelected());
                    opdrachtNieuw.setStatus(status.getSelectionModel().getSelectedItem());
                    opdrachtNieuw.setStagebegeleider(stagebegeleider.getSelectionModel().getSelectedItem());
                    
                    try{
                        Date bDate = new SimpleDateFormat("dd-MM-yyyy").parse(beginDag.getText() + "-" + beginMaand.getText() + "-" + beginJaar.getText());
                        Date eDate = new SimpleDateFormat("dd-MM-yyyy").parse(eindDag.getText() + "-" + eindMaand.getText() + "-" + eindJaar.getText());
                        if (bDate.after(eDate)){
                            throw new Exception();
                        }
                       
                    }
                    catch (Exception ex){
                        JOptionPane.showMessageDialog(null, "De datums zijn niet juist ingevoerd.");
                    }
                    opdrachtNieuw.setStartDate(beginJaar.getText() + "-" + beginMaand.getText() + "-" + beginDag.getText() + " 00:00:00" );
                    opdrachtNieuw.setEindDate(eindJaar.getText() + "-" + eindMaand.getText() + "-" + eindDag.getText() + " 00:00:00" );

                    DBClass.persistOpdracht(opdracht, opdrachtNieuw);
                    
                    try {
                        MyMail.stuurMail(statusOpdracht, opdrachtNieuw);
                    } catch (UnsupportedEncodingException ex) {
                        Logger.getLogger(OpdrachtenOverzichtPanelController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        });
        
        
        
        
        drukAf.setOnAction(new DrukContractenAf(opdrachtenLijst));
    }
}
