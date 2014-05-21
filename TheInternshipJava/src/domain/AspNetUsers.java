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
@Table(name="aspnetusers")
@NamedQueries({
    @NamedQuery(name = "AspNetUsers.findAll", query = "SELECT a FROM AspNetUsers a")
})
public class AspNetUsers implements Serializable{
    @Id
    private String id;
    private String username;
    private String passwordHash;
    private String securityStamp;

    public AspNetUsers() {
    }

    public AspNetUsers(String username, String passwordHash, String securityStamp) {
        this.username = username;
        this.passwordHash = passwordHash;
        this.securityStamp = securityStamp;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPasswordHash() {
        return passwordHash;
    }

    public void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
    }

    public String getSecurityStamp() {
        return securityStamp;
    }

    public void setSecurityStamp(String securityStamp) {
        this.securityStamp = securityStamp;
    }
    
    
}
