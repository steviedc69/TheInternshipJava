/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package domain;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author thomas
 */

@Entity
@Table(name = "specialisatie")
@NamedQueries({
    @NamedQuery(name = "Specialisatie.findAll", query = "SELECT s FROM Specialisatie s")
})
public class Specialisatie implements Serializable{
   @Id
   private int id = 0;
   
   private String title;

    public Specialisatie() {
    }
   
   public Specialisatie(String sp){
       this.title = sp;
   }
}
