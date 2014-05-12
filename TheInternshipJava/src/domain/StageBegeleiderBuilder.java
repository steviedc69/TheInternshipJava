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
public class StageBegeleiderBuilder {
    private String naam;
    private String voornaam;
    private String gsmNummer;
    
    public StageBegeleiderBuilder(){}
    
    public StageBegeleiderBuilder naam(String naam){
        this.naam = naam;
        return this;
    }
    
    public StageBegeleiderBuilder voornaam(String voornaam){
        this.voornaam = voornaam;
        return this;
    }
    
    public StageBegeleiderBuilder gsmNummer(String gsmNummer){
        this.gsmNummer = gsmNummer;
        return this;
    }
    
    public StageBegeleider BuildStageBegeleider(){
        return new StageBegeleider(naam, voornaam, gsmNummer);
    }
    
}
