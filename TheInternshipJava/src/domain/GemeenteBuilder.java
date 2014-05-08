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
public class GemeenteBuilder {
    private String postcode;
    private String naam;
    private String up;
    private String Structuur;
    
    public GemeenteBuilder(){}

    public void postcode(String postcode) {
        this.postcode = postcode;
    }

    public void naam(String naam) {
        this.naam = naam;
    }

    public void up(String up) {
        this.up = up;
    }

    public void structuur(String Structuur) {
        this.Structuur = Structuur;
    }
    
    
}
