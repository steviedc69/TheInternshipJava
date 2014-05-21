/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package domain;

import java.util.List;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;

/**
 *
 * @author thomas
 */
public class StudentBuilder {
    private Opdracht opdracht;
    private String naam;
    private String voornaam;
    private String gsmnummer;
    private String gebdatum;
    private boolean notFirstTime;
    private List<Opdracht> opdrachtenStudent;
    private Adres adres;
    private String imageUrl;
    
    public StudentBuilder(){}
    
    public StudentBuilder opdracht(Opdracht opdracht){
        this.opdracht = opdracht;
        return this;
    }
    
    public StudentBuilder adres(Adres adres){
        this.adres = adres;
        return this;
    }
    
    public StudentBuilder opdrachtenStudent(List<Opdracht> opdrachtenStudent){
        this.opdrachtenStudent = opdrachtenStudent;
        return this;
    }
    
    public StudentBuilder imageUrl(String imageUrl){
        this.imageUrl = imageUrl;
        return this;
    }
    
    public StudentBuilder naam(String naam){
        this.naam = naam;
        return this;
    }
    
    public StudentBuilder voornaam(String voornaam){
        this.voornaam = voornaam;
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
        return new Student(opdracht, naam, voornaam, gsmnummer, gebdatum, notFirstTime, opdrachtenStudent, imageUrl, adres);
        

    }
    
}
