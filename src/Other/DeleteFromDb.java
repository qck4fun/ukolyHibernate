/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Other;

import Persistent.Student;
import Persistent.Subject;
import Persistent.Task;
import org.hibernate.Session;

/**
 * Třídá, která se stará o výmat dat z databáze
 * 
 * @author Adam Žák
 */
public class DeleteFromDb implements Runnable {
    
    private Subject subject;
    private Student student;
    private Task task;
    
    /**
     * Konstruktor třídy DeleteFromDb
     * 
     * @param subject 
     */
    public DeleteFromDb(Subject subject) {
        this.subject = subject;
    }
    
    /**
     * Konstruktor třídy DeleteFromDb
     * 
     * @param student  
     */
    public DeleteFromDb(Student student) {
        this.student = student;
    }
    
    /**
     * Konstruktor třídy DeleteFromDb
     * 
     * @param task  
     */
    public DeleteFromDb(Task task) {
       this.task = task; 
    }

    /**
     * Metoda obsluhující mazání dat z databáze
     */
    @Override
    public void run() {
        
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        
        if(subject != null) {
            session.delete(subject);
            session.flush();
            session.getTransaction().commit();
        }
        else if(student != null) {
            session.delete(student);
            session.flush();
            session.getTransaction().commit();
        }
        else if(task != null) {
            session.delete(task);
            session.flush();
            session.getTransaction().commit();
        }
    }
}
