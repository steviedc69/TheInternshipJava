/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controllers;

import domain.Opdracht;
import domain.Status;
import domain.Student;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

/**
 *
 * @author thomas
 */
public class DBClass {
    public DBClass(){}
    public static void persistOpdracht(Opdracht opdracht, Opdracht opdrachtNieuw){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("TheInternshipPU");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.detach(opdracht);
        opdracht = opdrachtNieuw;
        em.merge(opdracht);
        em.getTransaction().commit();
        em.close();
        emf.close();
    }
    
    public static void veranderStatus(Opdracht opdracht, Status status){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("TheInternshipPU");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.detach(opdracht);
        opdracht.setStatus(status);
        em.merge(opdracht);
        em.getTransaction().commit();
        em.close();
        emf.close();
    }
    
    public static List<Opdracht> getOpdrachten(){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("TheInternshipPU");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        TypedQuery<Opdracht> queryFindAll = em.createNamedQuery("Opdracht.findAll", Opdracht.class);
        List<Opdracht> list = queryFindAll.getResultList();
        em.getTransaction().commit();
        em.close();
        emf.close();
        return list;
    }
    
    public static List<Student> getStudentenIngeschreven(Opdracht opdracht){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("TheInternshipPU");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Query query = em.createNamedQuery("Student.findRegistered", Student.class);
        query.setParameter("opdrachtStage", opdracht);
        List<Student> list = query.getResultList();
        em.getTransaction().commit();
        em.close();
        emf.close();
        return list;
        
    }
    public static List<Student> getStudentenNietIngeschreven(Opdracht opdracht){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("TheInternshipPU");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Query query = em.createNamedQuery("Student.findUnRegistered", Student.class);
        query.setParameter("opdrachtStage", opdracht);
        List<Student> list = query.getResultList();
        em.getTransaction().commit();
        em.close();
        emf.close();
        return list;
    }
    public static Status getStatusByName(String naam){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("TheInternshipPU");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Query query = em.createNamedQuery("Status.findByName", Status.class);
        query.setParameter("statusNaam", naam);
        List<Status> status = query.getResultList();
        em.getTransaction().commit();
        em.close();
        emf.close();
        return status.get(0);
    }
}
