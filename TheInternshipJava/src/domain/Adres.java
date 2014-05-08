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
@Table(name="adres")
@NamedQueries({
    @NamedQuery(name = "Adres.findAll", query = "SELECT a FROM Adres a")
})
public class Adres implements Serializable{
    @Id
    private int Id;
    private String straatnaam;
    private int nummer;
    @OneToOne
    @JoinColumn(name = "gemeente")
    private Gemeente gemeente;
    
    public Adres(){}
    
    public Adres(String straatnaam, int nummer, Gemeente gemeente){
        this.straatnaam = straatnaam;
        this.nummer = nummer;
        this.gemeente = gemeente;
    }

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public String getStraatnaam() {
        return straatnaam;
    }

    public void setStraatnaam(String straatnaam) {
        this.straatnaam = straatnaam;
    }

    public int getNummer() {
        return nummer;
    }

    public void setNummer(int nummer) {
        this.nummer = nummer;
    }

    public Gemeente getGemeente() {
        return gemeente;
    }

    public void setGemeente(Gemeente gemeente) {
        this.gemeente = gemeente;
    }
    
}
