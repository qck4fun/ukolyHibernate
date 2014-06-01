/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package GUI;

import javax.swing.*;

/**
 *
 * @author adam
 */
public class MainWindow extends JFrame {
    
    private JTabbedPane tabbedPane;
    
    private JPanel studentsPanel;
    private JPanel subjectsPanel;
    private JPanel tasksPanel;
    
    private JTable studentsTable;
    private JTable subjectsTable;
    private JTable tasksTable;
    
    private StudentsPaneModel studentsPaneModel;
    private SubjectsPaneModel subjectsPaneModel;
    private TasksPaneModel tasksPaneModel;
    
    public MainWindow() {
        init();
    }
    
    private void init() {
        setTitle("Hibernate task application");
        setSize(600, 400);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        tabbedPane = new JTabbedPane();
        
        initStudentsPane();
        initSubjectsPane();
        initTasksPane();
        
        tabbedPane.addTab("Studenti", studentsPanel);
        tabbedPane.addTab("Předměty", subjectsPanel);
        tabbedPane.addTab("Úkoly", tasksPanel);
        
        setContentPane(tabbedPane);
    }
    
    private void initStudentsPane() {
        studentsPanel = new JPanel();
        studentsPanel.setLayout(new BoxLayout(studentsPanel, BoxLayout.PAGE_AXIS));
        studentsPaneModel = new StudentsPaneModel();
        studentsTable = new JTable(studentsPaneModel);
        studentsPanel.add(new JScrollPane(studentsTable));
        studentsTable.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
    }
    
    private void initSubjectsPane() {
        subjectsPanel = new JPanel();
        subjectsPanel.setLayout(new BoxLayout(subjectsPanel, BoxLayout.PAGE_AXIS));
        subjectsPaneModel = new SubjectsPaneModel();
        subjectsTable = new JTable(subjectsPaneModel);
        subjectsPanel.add(new JScrollPane(subjectsTable));
        subjectsTable.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
    }
    
    private void initTasksPane() {
        tasksPanel = new JPanel();
        tasksPanel.setLayout(new BoxLayout(tasksPanel, BoxLayout.PAGE_AXIS));
        tasksPaneModel = new TasksPaneModel();
        tasksTable = new JTable(tasksPaneModel);
        tasksPanel.add(new JScrollPane(tasksTable));
        tasksTable.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
    }
}
