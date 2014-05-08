/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package domain;

/**
 *
 * @author thomas
 */
public class ContactPersoonBuilder {
    private String naam;
    private String voornaam;
    private String functie;
    private String contactEmail;
    private String contactTelNr;
    private String gsmNummer;
    private Bedrijf bedrijf;
    
    public ContactPersoonBuilder(){}
    
    public ContactPersoonBuilder naam(String naam){
        this.naam = naam;
        return this;
    }
    
    public ContactPersoonBuilder voornaam(String voornaam){
        this.voornaam = voornaam;
        return this;
    }
    
    public ContactPersoonBuilder functie(String functie){
        this.functie = functie;
        return this;
    }
    
    public ContactPersoonBuilder contactEmail(String contactEmail){
        this.contactEmail = contactEmail;
        return this;
    }
    
    public ContactPersoonBuilder contactTelNr(String contactTelNr){
        this.contactTelNr = contactTelNr;
        return this;
    }
    
    public ContactPersoonBuilder gsmNummer(String gsmNummer){
        this.gsmNummer = gsmNummer;
        return this;
    }
    
    public ContactPersoonBuilder bedrijf(Bedrijf bedrijf){
        this.bedrijf = bedrijf;
        return this;
    }
    
    public Contactpersoon buildContactPersoon(){
        return new Contactpersoon(naam, voornaam, functie, contactEmail, contactTelNr, gsmNummer, bedrijf);
    }
}
