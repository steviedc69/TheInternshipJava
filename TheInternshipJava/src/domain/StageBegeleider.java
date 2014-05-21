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
@Table(name="stagebegeleider")
@NamedQueries({
    @NamedQuery(name = "StageBegeleider.findAll", query = "SELECT s FROM StageBegeleider s")
})
public class StageBegeleider implements Serializable{
    @Id
    private String id;
    private String naam;
    private String voornaam;
    private String gsmNummer;
    @ManyToMany
    @JoinTable(name="begeleiderpreferences")
    List<Opdracht> opdrachten;
    private Boolean isFirstTime;

    public StageBegeleider() {
    }

    public StageBegeleider(String naam, String voornaam, String gsmNummer) {
        this.naam = naam;
        this.voornaam = voornaam;
        this.gsmNummer = gsmNummer;
    }

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

    public String getGsmNummer() {
        return gsmNummer;
    }

    public void setGsmNummer(String gsmNummer) {
        this.gsmNummer = gsmNummer;
    }
    
    public void addStage(){
        
    }

    public List<Opdracht> getOpdrachten() {
        return opdrachten;
    }

    public void setOpdrachten(List<Opdracht> opdrachten) {
        this.opdrachten = opdrachten;
    }

    public Boolean isIsFirstTime() {
        return isFirstTime;
    }

    public void setIsFirstTime(Boolean isFirstTime) {
        this.isFirstTime = isFirstTime;
    }

    
    
    @Override
    public String toString() {
        return voornaam + " " + naam;
    }
    
    
}
