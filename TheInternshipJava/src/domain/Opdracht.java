/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package domain;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.eclipse.persistence.jpa.jpql.parser.DateTime;

/**
 *
 * @author thomas
 */

@Entity
@Table(name = "opdracht")
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
    @Temporal(TemporalType.TIMESTAMP)
    private Date activatieDatum;
    private int aantalStudenten;
    private int adres_id;
    private int ondertekenaar;
    private int specId;
    private int stagementor;
    private String bedrijfId;
    
    
    public Opdracht(String title, String omschrijving, String vaardigheden, Boolean isSemester1, Boolean isSemester2, String schooljaar, String admincomment, Date activatiedatum, 
            int aantalStudenten, int adres_Id, int ondertekenaar, int specId, int stagementor, String bedrijfId){
        this.title = title;
        this.omschrijving = omschrijving;
        this.vaardigheden = vaardigheden;
        this.isSemester1 = isSemester1;
        this.isSemester2 = isSemester2;
        this.schooljaar = schooljaar;
        this.admincomment = admincomment;
        this.activatieDatum = activatiedatum;
        this.aantalStudenten = aantalStudenten;
        this.adres_id = adres_Id;
        this.ondertekenaar = ondertekenaar;
        this.specId = specId;
        this.stagementor = stagementor;
        this.bedrijfId = bedrijfId;
    }
        
    public Opdracht(){}
    
}
