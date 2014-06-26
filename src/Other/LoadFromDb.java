/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Other;

import javax.swing.JOptionPane;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 * Třída LoadFromDb se stará o načtení dat z databáze při spuštění programu
 * 
 * @author Adam Žák
 */
public class LoadFromDb implements Runnable {

    /**
     * Metoda, která stáhne data z db a uloží je do lokálního úložiště
     */
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
        } catch (HibernateException he) {
            JOptionPane.showMessageDialog(null, "Chyba při načítání z databáze");
        }
    }
}
