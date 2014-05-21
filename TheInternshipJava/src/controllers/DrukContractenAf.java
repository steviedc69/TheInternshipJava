/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import domain.Opdracht;
import domain.Student;
import java.util.HashMap;
import java.util.List;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;

/**
 *
 * @author thomas
 */
public class DrukContractenAf implements EventHandler {

    @FXML
    private ListView<Opdracht> opdrachtenLijst;

    public DrukContractenAf(ListView opdrachtenLijst) {
        this.opdrachtenLijst = opdrachtenLijst;
            
    }

    @Override
    public void handle(Event t) {
        Opdracht opdracht = opdrachtenLijst.getSelectionModel().getSelectedItem();
        List<Student> studenten = DBClass.getStudentenIngeschreven(opdracht);
        for (Student student : studenten) {
            try {
                HashMap<String, String> replacementText = new HashMap<String, String>();
                replacementText.put("……………………………………………. gevestigd te …………………………………….", opdracht.getBedrijf().getBedrijfsnaam() + " gevestigd te " + opdracht.getBedrijf().getAdres().toString());
                replacementText.put("vertegenwoordigd door.....……………………………………………………………………", "vertegenwoordig door " +  opdracht.getOndertekenaar().getVoornaam() + " " + opdracht.getOndertekenaar().getNaam());
                replacementText.put("………………………………………… wonende te …………………………………………", student.getVoornaam() + " " + student.getNaam() + " wonende te " + student.getAdres().getStraatnaam() + " " + student.getAdres().getNummer() + " " + student.getAdres().getGemeente().getNaam() + " " + student.getAdres().getGemeente().getPostcode());
                replacementText.put("Geboortedatum: …./…./………", "Geboortedatum: " + student.getGebdatum().toString().replace('-', '/'));
                replacementText.put("…………………………………………………………………………………………………………………", opdracht.getAdres().toString());
                replacementText.put("onderwijsinstelling de heer of mevrouw ……………………", "onderwijsinstelling de heer/mevrouw " + opdracht.getStagementor().getVoornaam() + " " + opdracht.getStagementor().getNaam());
                replacementText.put("De stage instelling duidt de heer of mevrouw  ………………………..", "De stage-instelling duidt de heer/mevrouw " + opdracht.getStagebegeleider().getVoornaam() + " " + opdracht.getStagebegeleider().getNaam());
                replacementText.put("De stageperiode loopt van ../../….  tot ../../…. . Het uurrooster en de vrijgestelde dagen zijn bepaald", "De stageperiode loopt van " + opdracht.getStartDateConverted() + " van " + opdracht.getendDateConverted() + ". Het uurrooster en de vrijgestelde dagen zijn bepaald");
                InsertText in = new InsertText("TI_Blanco_stageovereenkomst_2014-2015.doc", replacementText, student.getVoornaam() + "_" + student.getNaam() + ".doc");
                in.processFile();
                System.out.println("Ok");
                DBClass.veranderStatus(opdracht, DBClass.getStatusByName("Toegewezen"));
                
            } catch (Exception eEx) {
                System.out.println("Caught an: " + eEx.getClass().getName());
                System.out.println("Message: " + eEx.getMessage());
                System.out.println("StackTrace follows:");
                eEx.printStackTrace(System.out);
            }
        }
    }

}
