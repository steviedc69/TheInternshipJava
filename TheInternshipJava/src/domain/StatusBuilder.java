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
public class StatusBuilder {
    private String naam;
    private String panelClass;
    private String alertClass;
    
    public StatusBuilder(){}
    
    public StatusBuilder naam(String naam){
        this.naam = naam;
        return this;
    }
    
    public StatusBuilder panelClass(String panelClass){
        this.panelClass = panelClass;
        return this;
    }
    
    public StatusBuilder alertClass(String alertClass){
        this.alertClass = alertClass;
        return this;
    }
    
    public Status buildStatus(){
        return new Status(naam, panelClass, alertClass);
    }
}
