/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Other;

import Persistent.Student;
import Persistent.Subject;
import Persistent.Task;
import javax.swing.JOptionPane;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author adam
 */
public class LoadFromDb implements Runnable {

    @Override
    public void run() {
        try {
            Session session = HibernateUtil.getSession();
            session.beginTransaction();

            Query q = session.createQuery("from Student");
            LocalDataStorage.studentsList = q.list();

            q = session.createQuery("from Subject");
            LocalDataStorage.subjectsList = q.list();

            q = session.createQuery("from Task");
            LocalDataStorage.tasksList = q.list();
            
            session.getTransaction().commit();
            //session.close(); //TODO protože jinak lazily error blabla
        } catch (HibernateException he) {
            JOptionPane.showMessageDialog(null, "Chyba při načítání z databáze");
            he.printStackTrace(); //TODO smazat
        }
    }
}
