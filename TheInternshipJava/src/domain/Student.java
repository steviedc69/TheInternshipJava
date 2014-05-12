/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package domain;

import java.io.Serializable;
import java.util.List;
import javax.persistence.*;

/**
 *
 * @author thomas
 */
@Entity
@Table(name="student")
@NamedQueries({
    @NamedQuery(name = "Student.findAll", query = "SELECT s FROM Student s")
})
public class Student implements Serializable{
    @Id
    private int id;
    private String naam;
    private String voornaam;
    private String straat;
    private int straatnummer;
    private String woonplaats;
    private int postcode;
    private String gsmnummer;
    private String gebdatum;
    private boolean notFirstTime;
    @ManyToMany
    @JoinTable(name="favorites")
    List<Opdracht> opdrachten;

    public Student(String naam, String voornaam, String straat, int straatnummer, String woonplaats, int postcode, String gsmnummer, String gebdatum, boolean notFirstTime) {
        this.naam = naam;
        this.voornaam = voornaam;
        this.straat = straat;
        this.straatnummer = straatnummer;
        this.woonplaats = woonplaats;
        this.postcode = postcode;
        this.gsmnummer = gsmnummer;
        this.gebdatum = gebdatum;
        this.notFirstTime = notFirstTime;
    }
    
    public Student(){}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNaam() {
        return naam;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }

    public String getVoornaam() {
        return voornaam;
    }

    public void setVoornaam(String voornaam) {
        this.voornaam = voornaam;
    }

    public String getStraat() {
        return straat;
    }

    public void setStraat(String straat) {
        this.straat = straat;
    }

    public int getStraatnummer() {
        return straatnummer;
    }

    public void setStraatnummer(int straatnummer) {
        this.straatnummer = straatnummer;
    }

    public String getWoonplaats() {
        return woonplaats;
    }

    public void setWoonplaats(String woonplaats) {
        this.woonplaats = woonplaats;
    }

    public int getPostcode() {
        return postcode;
    }

    public void setPostcode(int postcode) {
        this.postcode = postcode;
    }

    public String getGsmnummer() {
        return gsmnummer;
    }

    public void setGsmnummer(String gsmnummer) {
        this.gsmnummer = gsmnummer;
    }

    public String getGebdatum() {
        return gebdatum;
    }

    public void setGebdatum(String gebdatum) {
        this.gebdatum = gebdatum;
    }

    public boolean isNotFirstTime() {
        return notFirstTime;
    }

    public void setNotFirstTime(boolean notFirstTime) {
        this.notFirstTime = notFirstTime;
    }
    
    
    
}
