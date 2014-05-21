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
    @NamedQuery(name = "Student.findAll", query = "SELECT s FROM Student s"),
    @NamedQuery(name = "Student.findRegistered", query = "SELECT s FROM Student s WHERE s.opdracht = :opdrachtStage"),
    @NamedQuery(name = "Student.findUnRegistered", query = "SELECT s FROM Student s WHERE NOT s.opdracht = :opdrachtStage")
        
})

public class Student implements Serializable{
    @Id
    private String id;
    @JoinColumn(name="StageId")
    private Opdracht opdracht;
    private String naam;
    private String voornaam;
    private String gsmnummer;
    private String gebdatum;
    private boolean notFirstTime;
    @ManyToMany
    @JoinTable(name="favorites")
    private List<Opdracht> opdrachtenStudent;
    private String imageUrl;
    @OneToOne
    @JoinColumn(name="adresId")
    private Adres adres;

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imagesUrl) {
        this.imageUrl = imagesUrl;
    }

    public Student(Opdracht opdracht, String naam, String voornaam, String gsmnummer, String gebdatum, boolean notFirstTime, List<Opdracht> opdrachtenStudent, String imageUrl, Adres adres) {
        this.opdracht = opdracht;
        this.naam = naam;
        this.voornaam = voornaam;
        
        this.gsmnummer = gsmnummer;
        this.gebdatum = gebdatum;
        this.notFirstTime = notFirstTime;
        this.opdrachtenStudent = opdrachtenStudent;
        this.imageUrl = imageUrl;
        this.adres = adres;
    }

  
    
    
    public Student(){}

    public String getId() {
        return id;
    }

    public void setId(String id) {
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

    public Opdracht getOpdracht() {
        return opdracht;
    }

    public void setOpdracht(Opdracht opdracht) {
        this.opdracht = opdracht;
    }

    public List<Opdracht> getOpdrachtenStudent() {
        return opdrachtenStudent;
    }

    public void setOpdrachtenStudent(List<Opdracht> opdrachtenStudent) {
        this.opdrachtenStudent = opdrachtenStudent;
    }

    public Adres getAdres() {
        return adres;
    }

    public void setAdres(Adres adres) {
        this.adres = adres;
    }
    
    
    
    
    
}
