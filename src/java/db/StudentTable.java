/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this tstudlate file, choose Tools | Tstudlates
 * and open the tstudlate in the editor.
 */
package db;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author nemishappy
 */
public class StudentTable {

    public static void insertStudent(Student stud) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Ex9_threadSafePU");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        try {
            em.persist(stud);
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
    }
    public static void updateStudent(Student stud) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Ex9_threadSafePU");
        EntityManager em = emf.createEntityManager();
        Student fromDb = em.find(Student.class, stud.getId());
        fromDb.setName(stud.getName());
        fromDb.setGpa(stud.getGpa());
        em.getTransaction().begin();
        try {
            em.persist(fromDb);
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
    }
    public static Student findStudentById(int id) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Ex9_threadSafePU");
        EntityManager em = emf.createEntityManager();
        Student stud = em.find(Student.class, id);
        em.close();
        return stud;
    }
    public static List<Student> findAllStudent() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Ex9_threadSafePU");
        EntityManager em = emf.createEntityManager();
        List<Student> studList = (List<Student>) em.createNamedQuery("Student.findAll").getResultList();
        em.close();
        return studList;
    }
    public static List<Student> findStudentByName(String name) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Ex9_threadSafePU");
        EntityManager em = emf.createEntityManager();
        Query query = em.createNamedQuery("Student.findByName");
        query.setParameter("name", name);
        List<Student> studList = (List<Student>) query.getResultList();
        em.close();
        return studList;
    }
    public static void removeStudent(Student stud) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Ex9_threadSafePU");
        EntityManager em = emf.createEntityManager();
        Student fromDb = em.find(Student.class, stud.getId());
        em.getTransaction().begin();
        try {
            em.remove(fromDb);
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
                
    }
    
}
