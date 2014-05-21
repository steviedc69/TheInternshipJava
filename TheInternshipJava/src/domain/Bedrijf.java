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
import javax.persistence.*;

/**
 *
 * @author thomas
 */
@Entity
@Table(name = "bedrijf")
@NamedQueries({
    @NamedQuery(name = "Bedrijf.findAll", query = "SELECT b FROM Bedrijf b")
})
public class Bedrijf implements Serializable {

    @Id
    private String id;
    @OneToOne
    @JoinColumn(name = "Adres")
    private Adres adres;
    private String bedrijfsnaam;
    private String url;
    private String telefoon;
    private String activiteit;
    private String imageUrl;
    private Boolean openbaarVervoer;
    private Boolean perAuto;
    @Temporal(TemporalType.TIMESTAMP)
    private Date beginDate;
    @Temporal(TemporalType.TIMESTAMP)
    private Date eindDate;

    @OneToOne
    @PrimaryKeyJoinColumn
    private AspNetUsers user;

    public Bedrijf() {
    }

    public Bedrijf(Adres adres, String bedrijfsnaam, String url, String telefoon, String activiteit, String imageUrl, Boolean openbaarVervoer, Boolean perAuto, String startDate, String eindDate, AspNetUsers user) {
        this.adres = adres;
        this.bedrijfsnaam = bedrijfsnaam;
        this.url = url;
        this.telefoon = telefoon;
        this.activiteit = activiteit;
        this.imageUrl = imageUrl;
        this.openbaarVervoer = openbaarVervoer;
        this.perAuto = perAuto;
        this.user = user;
        
        try {
            
            this.beginDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(startDate);
            this.eindDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(eindDate);
            
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Adres getAdres() {
        return adres;
    }

    public void setAdres(Adres adres) {
        this.adres = adres;
    }

    public String getBedrijfsnaam() {
        return bedrijfsnaam;
    }

    public void setBedrijfsnaam(String bedrijfsnaam) {
        this.bedrijfsnaam = bedrijfsnaam;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getTelefoon() {
        return telefoon;
    }

    public void setTelefoon(String telefoon) {
        this.telefoon = telefoon;
    }

    public String getActiviteit() {
        return activiteit;
    }

    public void setActiviteit(String activiteit) {
        this.activiteit = activiteit;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public AspNetUsers getUser() {
        return user;
    }

    public void setUser(AspNetUsers user) {
        this.user = user;
    }

    public Boolean isOpenbaarVervoer() {
        return openbaarVervoer;
    }

    public void setOpenbaarVervoer(Boolean openbaarVervoer) {
        this.openbaarVervoer = openbaarVervoer;
    }

    public Boolean isPerAuto() {
        return perAuto;
    }

    public void setPerAuto(Boolean perAuto) {
        this.perAuto = perAuto;
    }

    public Date getStartDate() {
        return beginDate;
    }

    public void setStartDate(Date startDate) {
        this.beginDate = startDate;
    }

    public Date getEindDate() {
        return eindDate;
    }

    public void setEindDate(Date eindDate) {
        this.eindDate = eindDate;
    }
    
    
    
}
