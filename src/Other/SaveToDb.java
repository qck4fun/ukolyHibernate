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
 * Třída, která se stará o ukládání změn do databáze
 *
 * @author Adam Žák
 */
public class SaveToDb implements Runnable {
    
    private Subject subject;
    private Student student;
    private Task task;
    
    /**
     * Konstruktor třídy SaveToDb
     * 
     * @param subject 
     */
    public SaveToDb(Subject subject) {
        this.subject = subject;
    }
    
    /**
     * Konstruktor třídy SaveToDb
     * 
     * @param student  
     */
    public SaveToDb(Student student) {
        this.student = student;
    }
    
    /**
     * Konstruktor třídy SaveToDb
     * 
     * @param task  
     */
    public SaveToDb(Task task) {
       this.task = task; 
    }
    
    /**
     * Metoda, která obsluhuje komunikaci s db a stará se o zápis změn v datech
     */
    @Override
    public void run() {
        
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        
        if(subject != null) {
            session.saveOrUpdate(subject);
            session.flush();
            session.getTransaction().commit();
        }
        else if(student != null) {
            session.saveOrUpdate(student);
            session.flush();
            session.getTransaction().commit();
        }
        else if(task != null) {
            session.saveOrUpdate(task);
            session.flush();
            session.getTransaction().commit();
        }
    }
}
