/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import model.Department;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author user
 */
public class DepartmentTable {
        
    public static void insertDepartment(Department emp) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("TesttoPU");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        try {
            em.persist(emp);
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
    }
    public static void updateDepartment(Department emp) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("TesttoPU");
        EntityManager em = emf.createEntityManager();
        Department fromDb = em.find(Department.class, emp.getDepartmentid());
        fromDb.setName(emp.getName());
        em.getTransaction().begin();
        try {
            em.merge(fromDb);
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
    }
    public static Department findDepartmentById(Integer id) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("TesttoPU");
        EntityManager em = emf.createEntityManager();
        Department emp = em.find(Department.class, id);
        em.close();
        return emp;
    }
    public static List<Department> findAllDepartment() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("TesttoPU");
        EntityManager em = emf.createEntityManager();
        Query query = em.createNamedQuery("Department.findAll");
        List<Department> empList = (List<Department>) query.getResultList();
        em.close();
        return empList;
    }
    public static List<Department> findDepartmentByName(String name) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("TesttoPU");
        EntityManager em = emf.createEntityManager();
        Query query = em.createNamedQuery("Department.findByName");
        query.setParameter("name", name);
        List<Department> empList = (List<Department>) query.getResultList();
        em.close();
        return empList;
    }
    public static void removeDepartment(Department emp) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("TesttoPU");
        EntityManager em = emf.createEntityManager();
        Department fromDb = em.find(Department.class, emp.getDepartmentid());
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