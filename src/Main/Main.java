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
 *
 * @author adam
 */
public class Main {
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
               //new MainWindow();
            }
        });
        new TestDataInsert(); 
        Thread t1 = new Thread(new LoadFromDb());
        t1.start();
    }
}