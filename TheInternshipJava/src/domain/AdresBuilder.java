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


public class AdresBuilder {
    
    private String straatnaam;
    private int nummer;
    private Gemeente gemeente;
    
    public AdresBuilder(){
        
    }
    
    public AdresBuilder straatnaam(String straatnaam){
        this.straatnaam = straatnaam;
        return this;
    }
    
    public AdresBuilder nummer(int nummer){
        this.nummer = nummer;
        return this;
    }
    
    public AdresBuilder gemeente(Gemeente gemeente){
        this.gemeente = gemeente;
        return this;
    }
    
    public Adres buildAdres(){
        return new Adres(straatnaam, nummer, gemeente);
    }
    
}
