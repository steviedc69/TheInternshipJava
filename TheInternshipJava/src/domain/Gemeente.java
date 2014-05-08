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
@Table(name="Gemeente")
@NamedQueries({
    @NamedQuery(name = "Gemeente.findAll", query = "SELECT g FROM Gemeente g")
})
public class Gemeente implements Serializable {
    @Id
    private int id;
    private String postcode;
    private String naam;
    private String up;
    private String Structuur;
    
    public Gemeente(){}

    public Gemeente(String postcode, String naam, String up, String Structuur) {
        this.postcode = postcode;
        this.naam = naam;
        this.up = up;
        this.Structuur = Structuur;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    public String getNaam() {
        return naam;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }

    public String getUp() {
        return up;
    }

    public void setUp(String up) {
        this.up = up;
    }

    public String getStructuur() {
        return Structuur;
    }

    public void setStructuur(String Structuur) {
        this.Structuur = Structuur;
    }
    
    
}
