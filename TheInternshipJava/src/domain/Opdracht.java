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
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
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
    //@Temporal(TemporalType.TIMESTAMP)
    private String startDate;
    //@Temporal(TemporalType.TIMESTAMP)
    private String eindDate;
    private int aantalStudenten;
    @OneToOne
    @JoinColumn(name="adresId")
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
    
    
    
    //Studenten worden ingeladen voor wie de opdracht tussen favorieten staat.
    @ManyToMany
    @JoinTable(name="favorites", joinColumns = {@JoinColumn(name="OpdrachtId", referencedColumnName = "Id")}, inverseJoinColumns = {@JoinColumn(name="StudentId", referencedColumnName = "Id")})
    private List<Student> studenten;
    @OneToOne
    @JoinColumn(name="Status_Id")
    private Status status;
    @OneToOne
    @JoinColumn(name="begeleider_id")
    private StageBegeleider stagebegeleider;
    
    @ManyToMany
    @JoinTable(name="begeleiderpreferences", joinColumns = {@JoinColumn(name="OpdrachtId")}, inverseJoinColumns = {@JoinColumn(name="StagebegeleiderId")})
    private List<StageBegeleider> stagebegeleiders;

    public Opdracht(String title, String omschrijving, String vaardigheden, Boolean isSemester1, Boolean isSemester2, String schooljaar, String admincomment, String activatiedatum, String startdate, String einddate, int aantalStudenten, Adres adres, Contactpersoon ondertekenaar, Specialisatie specialisatie, Contactpersoon stagementor, Bedrijf bedrijf, List<Student> studenten, Status status, StageBegeleider stagebegeleider, List<StageBegeleider> stagebegeleiders) {
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
        this.studenten = studenten;
        this.status = status;
        this.stagebegeleider = stagebegeleider;
        this.stagebegeleiders = stagebegeleiders;
        
        try {
            activatieDatum = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(activatiedatum);
            //startDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(startdate);
            //eindDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(einddate);
            
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

    public Boolean getIsSemester1() {
        return isSemester1;
    }

    public void setIsSemester1(Boolean isSemester1) {
        this.isSemester1 = isSemester1;
    }

    public Boolean getIsSemester2() {
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

    public String getStartDate() {
        return startDate;
    }

    public String getEindDate() {
        return eindDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public void setEindDate(String eindDate) {
        this.eindDate = eindDate;
    }


    
    

    public List<Student> getStudenten() {
        return studenten;
    }

    public void setStudenten(List<Student> studenten) {
        this.studenten = studenten;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public StageBegeleider getStagebegeleider() {
        return stagebegeleider;
    }

    public void setStagebegeleider(StageBegeleider stagebegeleider) {
        this.stagebegeleider = stagebegeleider;
    }

    public List<StageBegeleider> getStagebegeleiders() {
        return stagebegeleiders;
    }

    public void setStagebegeleiders(List<StageBegeleider> stagebegeleiders) {
        this.stagebegeleiders = stagebegeleiders;
    }        
    
    
    @Override
    public String toString() {
        return "Opdracht{" + "title=" + title + ", omschrijving=" + omschrijving + ", vaardigheden=" + vaardigheden + ", isSemester1=" + isSemester1 + ", isSemester2=" + isSemester2 + ", schooljaar=" + schooljaar + ", admincomment=" + admincomment + ", activatieDatum=" + activatieDatum + ", aantalStudenten=" + aantalStudenten + ", adres=" + adres + ", ondertekenaar=" + ondertekenaar + ", specialisatie=" + specialisatie + ", stagementor=" + stagementor + ", bedrijf=" + bedrijf + '}';
    }
    
    
}
