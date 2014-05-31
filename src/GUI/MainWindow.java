/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package GUI;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;

/**
 *
 * @author adam
 */
public class MainWindow extends JFrame{
    
    public MainWindow() {
        init();
        createMenuBar();
    }
    
    private void init() {
        setTitle("Hibernate task application");
        setSize(400, 400);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    private void createMenuBar() {
        JMenuBar menuBar = new JMenuBar();
        JMenu students = new JMenu("Studenti");
        JMenu subjects = new JMenu("Předměty");
        JMenu tasks = new JMenu("Úkoly");
        menuBar.add(students);
        menuBar.add(subjects);
        menuBar.add(tasks);
        setJMenuBar(menuBar);
    }
}
