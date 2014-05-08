/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package domain;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author thomas
 */
@Entity
@Table(name="contactpersoon")
@NamedQueries({
    @NamedQuery(name = "Contactpersoon.findAll", query = "SELECT c FROM Contactpersoon c")
})
public class Contactpersoon implements Serializable{
    @Id
    private int id;
    private String naam;
    private String voornaam;
    private String functie;
    private String contactEmail;
    private String contactTelNr;
    private String gsmNummer;
    @ManyToOne
    @JoinColumn(name="bedrijfId")
    private Bedrijf bedrijf;
//e
    public Contactpersoon() {
    }

    public Contactpersoon(String naam, String voornaam, String functie, String contactEmail, String contactTelNr, String gsmNummer, Bedrijf bedrijf) {
        this.naam = naam;
        this.voornaam = voornaam;
        this.functie = functie;
        this.contactEmail = contactEmail;
        this.contactTelNr = contactTelNr;
        this.gsmNummer = gsmNummer;
        this.bedrijf = bedrijf;
    }

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

    public String getFunctie() {
        return functie;
    }

    public void setFunctie(String functie) {
        this.functie = functie;
    }

    public String getContactEmail() {
        return contactEmail;
    }

    public void setContactEmail(String contactEmail) {
        this.contactEmail = contactEmail;
    }

    public String getContactTelNr() {
        return contactTelNr;
    }

    public void setContactTelNr(String contactTelNr) {
        this.contactTelNr = contactTelNr;
    }

    public String getGsmNummer() {
        return gsmNummer;
    }

    public void setGsmNummer(String gsmNummer) {
        this.gsmNummer = gsmNummer;
    }

    public Bedrijf getBedrijf() {
        return bedrijf;
    }

    public void setBedrijf(Bedrijf bedrijf) {
        this.bedrijf = bedrijf;
    }
    
    
    
    
}
