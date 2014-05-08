/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package domain;

import java.io.Serializable;
import javax.persistence.*;

/**
 *
 * @author thomas
 */
@Entity
@Table(name="bedrijf")
@NamedQueries({
    @NamedQuery(name = "Bedrijf.findAll", query = "SELECT b FROM Bedrijf b")
})
public class Bedrijf implements Serializable{
    @Id
    private String id;
    @OneToOne
    @JoinColumn(name="Adres")
    private Adres adres;
    private String bedrijfsnaam;
    private String url;
    private String telefoon;
    private String bereikbaarheid;
    private String activiteit;
    
    public Bedrijf(){}

    public Bedrijf(Adres adres, String bedrijfsnaam, String url, String telefoon, String bereikbaarheid, String activiteit) {
        this.adres = adres;
        this.bedrijfsnaam = bedrijfsnaam;
        this.url = url;
        this.telefoon = telefoon;
        this.bereikbaarheid = bereikbaarheid;
        this.activiteit = activiteit;
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

    public String getBereikbaarheid() {
        return bereikbaarheid;
    }

    public void setBereikbaarheid(String bereikbaarheid) {
        this.bereikbaarheid = bereikbaarheid;
    }

    public String getActiviteit() {
        return activiteit;
    }

    public void setActiviteit(String activiteit) {
        this.activiteit = activiteit;
    }
    
    
    
}
