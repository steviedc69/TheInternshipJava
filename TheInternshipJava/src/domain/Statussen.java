/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package domain;

import java.util.List;
import javafx.collections.ObservableList;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

/**
 *
 * @author thomas
 */
public class Statussen {
    private static List<Status> status;
    
    public Statussen(){}
    public static List<Status> getStatussen(){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("TheInternshipPU");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        TypedQuery<Status> queryFindAll = em.createNamedQuery("Status.findAll", Status.class);
        status = queryFindAll.getResultList();
        em.getTransaction().commit();
        em.close();
        emf.close();
        
        return status;
    }
}
