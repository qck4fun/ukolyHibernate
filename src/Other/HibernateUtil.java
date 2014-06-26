/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Other;

import javax.swing.JOptionPane;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;
/**
 * Pomocná třída, která slouží k inicializaci Session
 * 
 * @author Adam Žák
 */
public class HibernateUtil {
    private static Session session;
    
    /**
     * Samotná inicializace session
     */ 
    static {
        try {
            // Create the SessionFactory from hibernate.cfg.xml
            SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
            session = sessionFactory.openSession();
        } catch (Throwable ex) {
            JOptionPane.showMessageDialog(null, "Nastal problém s inicializací session", "Chyba", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    /**
     * Metoda vracející odkaz na instanci session
     * 
     * @return session
     */
    public static Session getSession() {
        return session;
    }
}
