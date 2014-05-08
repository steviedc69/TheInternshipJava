/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package domain;

/**
 *
 * @author thomas
 */
public class BedrijfBuilder {
    private Adres adres;
    private String bedrijfsnaam;
    private String url;
    private String telefoon;
    private String bereikbaarheid;
    private String activiteit;

    public BedrijfBuilder() {
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

    public BedrijfBuilder bereikbaarheid(String bereikbaarheid) {
        this.bereikbaarheid = bereikbaarheid;
        return this;
    }

    public BedrijfBuilder activiteit(String activiteit) {
        this.activiteit = activiteit;
        return this;
    }
    
    public Bedrijf buildBedrijf(){
        return new Bedrijf(adres, bedrijfsnaam, url, telefoon, bereikbaarheid, activiteit);
    }
    
}
