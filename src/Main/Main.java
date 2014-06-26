/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import GUI.MainWindow;
import Other.LoadFromDb;
import javax.swing.SwingUtilities;

/**
 * Třída sloužící ke spustění databázové aplikace
 *
 * @author Adam Žák
 */
public class Main {

    /**
     * Spustí vlákno s instancí třídy LoadFromDb a vytvoří hlavní okno aplikace.
     *     
     * @param args ignored
     */
    public static void main(String[] args) {
        Thread t1 = new Thread(new LoadFromDb());
        t1.start();
        try {
            t1.join();
        } catch (InterruptedException ex) {
            //není třeba odchytávat - nepracuji s přerušením
        }
        SwingUtilities.invokeLater(new Runnable() {

            public void run() {
                new MainWindow();
            }
        });
    }
}