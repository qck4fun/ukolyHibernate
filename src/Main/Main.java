/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Main;

import GUI.MainWindow;
import Other.LoadFromDb;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.SwingUtilities;

/**
 *
 * @author adam
 */
public class Main {
    
    public static void main(String[] args) {
        Thread t1 = new Thread(new LoadFromDb());
        t1.start();
        try {
            t1.join();
        } catch (InterruptedException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            //TODO odchytit
        }
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
               new MainWindow();
            }
        });
    }
}