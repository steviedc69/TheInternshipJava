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
public class StudentBuilder {
    private String naam;
    private String voornaam;
    private String straat;
    private int straatnummer;
    private String woonplaats;
    private int postcode;
    private String gsmnummer;
    private String gebdatum;
    private boolean notFirstTime;
    
    public StudentBuilder(){}
    
    public StudentBuilder naam(String naam){
        this.naam = naam;
        return this;
    }
    
    public StudentBuilder voornaam(String voornaam){
        this.voornaam = voornaam;
        return this;
    }
    
    public StudentBuilder straat(String straat){
        this.straat = straat;
        return this;
    }
    
    public StudentBuilder straatnummer(int straatnummer){
        this.straatnummer = straatnummer;
        return this;
    }
    
    public StudentBuilder woonplaats(String woonplaats){
        this.woonplaats = woonplaats;
        return this;
    }
    
    public StudentBuilder postcode(int postcode){
        this.postcode = postcode;
        return this;
    }
    
    public StudentBuilder gsmnummer(String gsmnummer){
        this.gsmnummer = gsmnummer;
        return this;
    }
    
    public StudentBuilder gebDatum(String gebDatum){
        this.gebdatum = gebDatum;
        return this;
    }
    
    public StudentBuilder notFirstTime(Boolean notFirstTime){
        this.notFirstTime = notFirstTime;
        return this;
    }
    
    public Student buildStudent(){
        return new Student(naam, voornaam, straat, straatnummer, woonplaats, postcode, gsmnummer, gebdatum, notFirstTime);
    }
    
}
