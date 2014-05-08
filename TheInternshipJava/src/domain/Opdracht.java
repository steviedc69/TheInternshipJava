/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package domain;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author thomas
 */

@Entity
@Table(name = "opdracht")
@NamedQueries({
    @NamedQuery(name = "Opdracht.findAll", query = "SELECT o FROM Opdracht o")
})
public class Opdracht implements Serializable{
    @Id
    private int id;
    private String title;
    private String omschrijving;
    private String vaardigheden;
    private Boolean isSemester1;
    private Boolean isSemester2;
    private String schooljaar;
    private String admincomment;
    
    //formate = yyyyMMddHHmmss
    @Temporal(TemporalType.TIMESTAMP)
    private Date activatieDatum;
    private int aantalStudenten;
    @OneToOne
    @JoinColumn(name="adres_Id")
    private Adres adres;
    @OneToOne
    @JoinColumn(name="ondertekenaar")
    private Contactpersoon ondertekenaar;
    @OneToOne
    @JoinColumn(name="specId")
    private Specialisatie specialisatie;
    @OneToOne
    @JoinColumn(name="stagementor")
    private Contactpersoon stagementor;
    @OneToOne
    @JoinColumn(name="bedrijfId")
    private Bedrijf bedrijf;
    
    
    public Opdracht(String title, String omschrijving, String vaardigheden, Boolean isSemester1, Boolean isSemester2, String schooljaar, String admincomment, String activatiedatum, 
            int aantalStudenten, Adres adres, Contactpersoon ondertekenaar, Specialisatie specialisatie, Contactpersoon stagementor, Bedrijf bedrijf){
        this.title = title;
        this.omschrijving = omschrijving;
        this.vaardigheden = vaardigheden;
        this.isSemester1 = isSemester1;
        this.isSemester2 = isSemester2;
        this.schooljaar = schooljaar;
        this.admincomment = admincomment;
        this.aantalStudenten = aantalStudenten;
        this.adres = adres;
        this.ondertekenaar = ondertekenaar;
        this.specialisatie = specialisatie;
        this.stagementor = stagementor;
        this.bedrijf = bedrijf;
        try {
            activatieDatum = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(activatiedatum);
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
        
    public Opdracht(){}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getOmschrijving() {
        return omschrijving;
    }

    public void setOmschrijving(String omschrijving) {
        this.omschrijving = omschrijving;
    }

    public String getVaardigheden() {
        return vaardigheden;
    }

    public void setVaardigheden(String vaardigheden) {
        this.vaardigheden = vaardigheden;
    }

    public Boolean isIsSemester1() {
        return isSemester1;
    }

    public void setIsSemester1(Boolean isSemester1) {
        this.isSemester1 = isSemester1;
    }

    public Boolean isIsSemester2() {
        return isSemester2;
    }

    public void setIsSemester2(Boolean isSemester2) {
        this.isSemester2 = isSemester2;
    }

    public String getSchooljaar() {
        return schooljaar;
    }

    public void setSchooljaar(String schooljaar) {
        this.schooljaar = schooljaar;
    }

    public String getAdmincomment() {
        return admincomment;
    }

    public void setAdmincomment(String admincomment) {
        this.admincomment = admincomment;
    }

    public String getActivatieDatum() {
        return activatieDatum.toString();
    }

    public void setActivatieDatum(String activatieDatum) {
        try {
            this.activatieDatum = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(activatieDatum);
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public int getAantalStudenten() {
        return aantalStudenten;
    }

    public void setAantalStudenten(int aantalStudenten) {
        this.aantalStudenten = aantalStudenten;
    }

    public Adres getAdres() {
        return adres;
    }

    public void setAdres(Adres adres) {
        this.adres = adres;
    }

    public Contactpersoon getOndertekenaar() {
        return ondertekenaar;
    }

    public void setOndertekenaar(Contactpersoon ondertekenaar) {
        this.ondertekenaar = ondertekenaar;
    }

    public Specialisatie getSpecialisatie() {
        return specialisatie;
    }

    public void setSpecialisatie(Specialisatie specialisatie) {
        this.specialisatie = specialisatie;
    }

    public Contactpersoon getStagementor() {
        return stagementor;
    }

    public void setStagementor(Contactpersoon stagementor) {
        this.stagementor = stagementor;
    }

    public Bedrijf getBedrijf() {
        return bedrijf;
    }

    public void setBedrijfId(Bedrijf bedrijf) {
        this.bedrijf = bedrijf;
    }
    
}
