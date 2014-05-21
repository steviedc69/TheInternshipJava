/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controllers;

import domain.Opdracht;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author thomas
 */
public class DrukAf {
    public static void drukContractenAf(Opdracht opdracht){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("TheInternshipPU");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        
        
 
        
        em.getTransaction().commit();
        em.close();
        emf.close();
    }
}
