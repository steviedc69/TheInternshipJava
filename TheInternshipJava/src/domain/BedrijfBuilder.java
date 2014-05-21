/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package domain;

import java.util.Date;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author thomas
 */
public class BedrijfBuilder {
    private Adres adres;
    private String bedrijfsnaam;
    private String url;
    private String telefoon;
    private String activiteit;
    private String imageUrl;
    private Boolean openbaarVervoer;
    private Boolean perAuto;
    private String beginDate;
    private String eindDate;
    private AspNetUsers user;
    
    public BedrijfBuilder() {
    }
    
    public BedrijfBuilder user(AspNetUsers user){
        this.user = user;
        return this;
    }
    
    public BedrijfBuilder eindDate(String eindDate){
        this.eindDate = eindDate;
        return this;
    }
    
    public BedrijfBuilder beginDate(String beginDate){
        this.beginDate = beginDate;
        return this;
    }
    
    public BedrijfBuilder perAuto(Boolean perAuto){
        this.perAuto = perAuto;
        return this;
    }
    
    public BedrijfBuilder openbaarVervoer(Boolean openbaarVervoer){
        this.openbaarVervoer = openbaarVervoer;
        return this;
    }

    public BedrijfBuilder adres(Adres adres) {
        this.adres = adres;
        return this;
    }

    public BedrijfBuilder bedrijfsnaam(String bedrijfsnaam) {
        this.bedrijfsnaam = bedrijfsnaam;
        return this;
    }

    public BedrijfBuilder url(String url) {
        this.url = url;
        return this;
    }

    public BedrijfBuilder telefoon(String telefoon) {
        this.telefoon = telefoon;
        return this;
    }


    public BedrijfBuilder activiteit(String activiteit) {
        this.activiteit = activiteit;
        return this;
    }
    
    public BedrijfBuilder imageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
        return this;
    }

    
    public Bedrijf buildBedrijf(){
        
        return new Bedrijf(adres, bedrijfsnaam, url, telefoon, activiteit, imageUrl, openbaarVervoer, perAuto, beginDate, eindDate, user);

        
    }
    
}
