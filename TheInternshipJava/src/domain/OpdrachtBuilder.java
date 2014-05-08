/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package domain;

import java.util.Date;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author thomas
 */
public class OpdrachtBuilder {
    private String title;
    private String omschrijving;
    private String vaardigheden;
    private Boolean isSemester1;
    private Boolean isSemester2;
    private String schooljaar;
    private String admincomment;
    private String activatiedatum;
    private int aantalStudenten;
    private Adres adres;
    private Contactpersoon ondertekenaar;
    private Specialisatie specialisatie;
    private Contactpersoon stagementor;
    private Bedrijf bedrijf;
    
    public OpdrachtBuilder(){}
    public OpdrachtBuilder title(String title){
        this.title = title;
        return this;
    }
    public OpdrachtBuilder omschrijving(String omschrijving){
        this.omschrijving = omschrijving;
        return this;
    }
    public OpdrachtBuilder vaardigheden(String vaardigheden){
        this.vaardigheden = vaardigheden;
        return this;
    }
    
    public OpdrachtBuilder isSemester1(Boolean isSemester1){
        this.isSemester1 = isSemester1;
        return this;
    }
    public OpdrachtBuilder isSemester2(Boolean isSemester2){
        this.isSemester2 = isSemester2;
        return this;
    }
    
    public OpdrachtBuilder schooljaar(String schooljaar){
        this.schooljaar = schooljaar;
        return this;
    }
    
    public OpdrachtBuilder admincomment(String admincomment){
        this.admincomment = admincomment;
        return this;
    }
    
    public OpdrachtBuilder activatieDatum(String activatiedatum){
        this.activatiedatum = activatiedatum;
        return this;
    }
    public OpdrachtBuilder aantalStudenten(int aantalStudenten){
        this.aantalStudenten = aantalStudenten;
        return this;
    }
    public OpdrachtBuilder adres(Adres adres){
        this.adres = adres;
        return this;
    }
    public OpdrachtBuilder ondertekenaar(Contactpersoon ondertekenaar){
        this.ondertekenaar = ondertekenaar;
        return this;
    }
    public OpdrachtBuilder specialisatie(Specialisatie specialisatie){
        this.specialisatie = specialisatie;
        return this;
    }
    public OpdrachtBuilder stagementor(Contactpersoon stagementor){
        this.stagementor = stagementor;
        return this;
    }
    public OpdrachtBuilder bedrijfId(Bedrijf bedrijf){
        this.bedrijf = bedrijf;
        return this;
    }
    
    public Opdracht buildOpdracht(){
        return new Opdracht(title, omschrijving, vaardigheden, isSemester1, isSemester2, schooljaar, admincomment, activatiedatum, 
             aantalStudenten,  adres,  ondertekenaar,  specialisatie,  stagementor,  bedrijf);
    }
}

