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
@Table(name="Status")
@NamedQueries({
    @NamedQuery(name = "Status.findAll", query = "SELECT s FROM Status s"),
    @NamedQuery(name = "Status.findByName", query = "SELECT s FROM Status s WHERE s.naam = :statusNaam")
})
public class Status implements Serializable{
    @Id
    private int id;
    private String naam;
    private String panelClass;
    private String alertClass;

    public Status() {
    }

    public Status(String naam, String panelClass, String alertClass) {
        this.naam = naam;
        this.panelClass = panelClass;
        this.alertClass = alertClass;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNaam() {
        return naam;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }

    public String getPanelClass() {
        return panelClass;
    }

    public void setPanelClass(String panelClass) {
        this.panelClass = panelClass;
    }

    public String getAlertClass() {
        return alertClass;
    }

    public void setAlertClass(String alertClass) {
        this.alertClass = alertClass;
    }

    @Override
    public String toString() {
        return naam;
    }
    
    
    
}
