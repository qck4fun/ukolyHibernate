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
public class SaveToDb implements Runnable {
    
    private Subject subject;
    private Student student;
    private Task task;
    
    public SaveToDb(Subject subject) {
        this.subject = subject;
    }
    
    public SaveToDb(Student student) {
        this.student = student;
    }
    
    public SaveToDb(Task task) {
       this.task = task; 
    }

    @Override
    public void run() {
        
        Session session = HibernateUtil.getSessionFactory().openSession();
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
        }
        session.close();
    }
}
