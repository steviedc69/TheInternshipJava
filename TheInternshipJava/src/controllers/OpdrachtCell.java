/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import domain.Opdracht;
import domain.StageBegeleider;
import domain.Status;
import domain.Statussen;
import java.util.Iterator;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ListCell;
import javafx.scene.control.TextArea;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;

/**
 *
 * @author thomas
 */
public class OpdrachtCell extends ListCell<Opdracht> {

    private Opdracht opdracht;

    @Override
    public void updateItem(Opdracht opdracht, boolean empty) {
        super.updateItem(opdracht, empty);
        if (empty) {
            setText(null);
            setGraphic(null);
        } else {
            setText(null);

            this.opdracht = opdracht;

            setGraphic(cell());
        }
    }

    public GridPane cell() {
        GridPane grid = new GridPane();
        grid.add(titel(), 0, 0);
        //grid.add(omschrijving(), 1, 0);
        //grid.add(vaardigheden(), 2, 0);
        //grid.add(schooljaar(), 3, 0);
        //grid.add(isSemester1(), 4, 0);
        //grid.add(isSemester2(), 5, 0);
        //grid.add(adminComment(), 6, 0);
        //grid.add(activatieDatum(), 7, 0);
        //grid.add(aantalStudenten(), 8, 0);
        //grid.add(adres(), 9, 0);
        //grid.add(stagebegeleider(), 10, 0);
        //grid.add(ondertekenaar(), 11, 0);
        //grid.add(specialisatie(), 12, 0);
        //grid.add(stagementor(), 13, 0);
        //grid.add(status(), 14, 0);
        grid.add(bedrijf(), 0, 1);
        return grid;
    }

    private Text titel() {
        Text titel = new Text(opdracht.getTitle());
        titel.setWrappingWidth(150);
        return titel;
    }

    private Text omschrijving() {
        Text omschrijving = new Text(opdracht.getOmschrijving());
        omschrijving.setWrappingWidth(150);
        return omschrijving;
    }

    private Text vaardigheden() {
        Text vaardigheden = new Text(opdracht.getVaardigheden());
        vaardigheden.setWrappingWidth(150);
        return vaardigheden;
    }

    private Text schooljaar() {
        Text schooljaar = new Text(opdracht.getSchooljaar());
        schooljaar.setWrappingWidth(150);
        return schooljaar;
    }

    private CheckBox isSemester1() {
        CheckBox isSemester1 = new CheckBox("Semester 1: ");
        isSemester1.setSelected(opdracht.getIsSemester1());
        return isSemester1;
    }

    private CheckBox isSemester2() {
        CheckBox isSemester2 = new CheckBox("Semester 2: ");
        isSemester2.setSelected(opdracht.getIsSemester2());
        return isSemester2;
    }

    private TextArea adminComment() {
        TextArea adminComment = new TextArea(opdracht.getAdmincomment());
        return adminComment;
    }

    private Text activatieDatum() {
        Text activatieDatum = new Text(opdracht.getActivatieDatum());
        activatieDatum.setWrappingWidth(150);
        return activatieDatum;
    }

    private Text aantalStudenten() {
        Text aantalStudenten = new Text(String.valueOf(opdracht.getAantalStudenten()));
        aantalStudenten.setWrappingWidth(150);
        return aantalStudenten;
    }

    private Text adres() {
        String adresString = opdracht.getAdres().getStraatnaam() + " " + opdracht.getAdres().getNummer() + "\n";
        adresString += opdracht.getAdres().getGemeente().getPostcode().toString() + " " + opdracht.getAdres().getGemeente().getNaam();
        Text adres = new Text(adresString);
        adres.setWrappingWidth(150);
        return adres;
    }

    private ChoiceBox stagebegeleider() {
        ObservableList<StageBegeleider> stagebegeleiders = FXCollections.observableArrayList(opdracht.getStagebegeleiders());
        ChoiceBox<StageBegeleider> itemsStageBegeleider = new ChoiceBox();
        itemsStageBegeleider.setItems(stagebegeleiders);
        Iterator<StageBegeleider> it = stagebegeleiders.iterator();
        while (it.hasNext()) {
            StageBegeleider stagebegeleider = it.next();
            if (opdracht.getStagebegeleider().getNaam().equals(stagebegeleider.getNaam()) && stagebegeleider.getVoornaam().equals(opdracht.getStagebegeleider().getVoornaam())) {
                itemsStageBegeleider.getSelectionModel().select(stagebegeleider);
            }
        }
        return itemsStageBegeleider;
    }

    private Text ondertekenaar() {
        Text ondertekenaar = new Text(opdracht.getOndertekenaar().getVoornaam() + " " + opdracht.getOndertekenaar().getNaam());
        ondertekenaar.setWrappingWidth(150);
        return ondertekenaar;
    }

    private Text specialisatie() {
        Text specialisatie = new Text(opdracht.getSpecialisatie().getTitle());
        specialisatie.setWrappingWidth(150);
        return specialisatie;
    }

    private Text stagementor() {
        Text stagementor = new Text(opdracht.getStagementor().getVoornaam() + " " + opdracht.getStagementor().getNaam());
        stagementor.setWrappingWidth(150);
        return stagementor;
    }

    private ChoiceBox status() {
        ObservableList<Status> statussen = FXCollections.observableArrayList(Statussen.getStatussen());
        ChoiceBox<Status> items = new ChoiceBox();
        items.setItems(statussen);
        Iterator<Status> it2 = statussen.iterator();
        while (it2.hasNext()) {
            Status status = it2.next();
            if (opdracht.getStatus().getNaam().equals(status.getNaam())) {
                items.getSelectionModel().select(status);
            }
        }
        return items;
    }

    private Text bedrijf() {
        Text bedrijf = new Text(opdracht.getBedrijf().getBedrijfsnaam());
        bedrijf.setWrappingWidth(150);
        return bedrijf;
    }
}
