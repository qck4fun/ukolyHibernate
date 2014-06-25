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
 *
 * @author adam
 */
public class DeleteFromDb implements Runnable {
    
    private Subject subject;
    private Student student;
    private Task task;
    
    public DeleteFromDb(Subject subject) {
        this.subject = subject;
    }
    
    public DeleteFromDb(Student student) {
        this.student = student;
    }
    
    public DeleteFromDb(Task task) {
       this.task = task; 
    }

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
        //session.close(); //TODO protože nejspíš chyba
    }
}
