/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Other.DeleteFromDb;
import Other.LocalDataStorage;
import Persistent.Student;
import Persistent.Subject;
import Persistent.Task;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

/**
 * Třída MainWindow je třídou starající se o kompletní grafiku aplikace
 * 
 * @author Adam Žák
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
    private JButton changeStudent;
    private JButton removeStudent;
    private JButton changeSubject;
    private JButton removeSubject;
    private JButton changeTask;
    private JButton removeTask;

    /**
     * Konstruktor třídy MainWindow, která se stará o grafiku
     */
    public MainWindow() {
        init();
    }

    /**
     * Privátní metoda sloužící k inicializaci hlavních komponent
     */
    private void init() {
        setTitle("Hibernate task application");
        setSize(1000, 400);
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

    /**
     * Privátní třída sloužící k inicializaci tabu se studenty
     */
    private void initStudentsPane() {
        studentsPanel = new JPanel();
        studentsPanel.setLayout(new BoxLayout(studentsPanel, BoxLayout.PAGE_AXIS));
        studentsPaneModel = new StudentsPaneModel();
        studentsTable = new JTable(studentsPaneModel);
        studentsPanel.add(new JScrollPane(studentsTable));
        studentsTable.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.LINE_AXIS));
        JButton addStudent = new JButton("Přidat studenta");
        addStudent.addActionListener(new ActionListener() {

            /**
             * Po kliknutí se spustí okno na přidání nového studenta
             * 
             * @param e
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                new StudentFrame(studentsPaneModel).setVisible(true);
            }
        });

        changeStudent = new JButton("Upravit studenta");
        changeStudent.addActionListener(new ActionListener() {

            /**
             * Po kliknutí se spustí okno pro úpravu studenta
             * 
             * @param e
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String studentXname = studentsTable.getModel().getValueAt(studentsTable.getSelectedRow(), 0).toString();
                    Student student = LocalDataStorage.getStudentXname(studentXname);
                    new StudentFrame(studentsPaneModel, student).setVisible(true);
                } catch (ArrayIndexOutOfBoundsException er) {
                    JOptionPane.showMessageDialog(null, "Je třeba vybrat záznam, kterých chcete změnit", "Chyba", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        removeStudent = new JButton("Smazat studenta");
        removeStudent.addActionListener(new ActionListener() {

            /**
             * Po kliknutí dojde ke smazání studenta
             * 
             * @param e
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String studentXname = studentsTable.getModel().getValueAt(studentsTable.getSelectedRow(), 0).toString();
                    Student student = LocalDataStorage.getStudentXname(studentXname);
                    if(LocalDataStorage.removeStudent(student)) {
                        LocalDataStorage.removeStudent(student);
                        Thread t1 = new Thread(new DeleteFromDb(student));
                        t1.start();
                        try {
                            t1.join();
                        } catch (InterruptedException ex) {
                            Logger.getLogger(MainWindow.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        studentsPaneModel.fireTableStructureChanged();
                    }
                    else {
                        JOptionPane.showMessageDialog(null, "Student nejde smazat, protože by byla narušena integrita databáze.", "Chyba", JOptionPane.ERROR_MESSAGE);
                    }
                } catch (ArrayIndexOutOfBoundsException er) {
                    JOptionPane.showMessageDialog(null, "Je třeba vybrat záznam, kterých chcete změnit", "Chyba", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        buttonPanel.add(addStudent);
        buttonPanel.add(Box.createGlue());
        buttonPanel.add(changeStudent);
        buttonPanel.add(Box.createGlue());
        buttonPanel.add(removeStudent);
        studentsPanel.add(buttonPanel);
    }

    /**
     * Privátní metoda sloužící k inicializaci tabu s předměty
     */
    private void initSubjectsPane() {
        subjectsPanel = new JPanel();
        subjectsPanel.setLayout(new BoxLayout(subjectsPanel, BoxLayout.PAGE_AXIS));
        subjectsPaneModel = new SubjectsPaneModel();
        subjectsTable = new JTable(subjectsPaneModel);
        subjectsPanel.add(new JScrollPane(subjectsTable));
        subjectsTable.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.LINE_AXIS));
        JButton addSubject = new JButton("Přidat předmět");
        addSubject.addActionListener(new ActionListener() {

            /**
             * Po kliknutí se spustí okno pro přidání nového předmětu
             * 
             * @param e
             */
            @Override
            public void actionPerformed(ActionEvent e) {
            }
        });

        changeSubject = new JButton("Upravit předmět");
        changeSubject.addActionListener(new ActionListener() {

            /**
             * Po kliknutí se spustí okno pro úpravu předmětu
             * 
             * @param e
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String subjectName = subjectsTable.getModel().getValueAt(subjectsTable.getSelectedRow(), 0).toString();
                    Subject subject = LocalDataStorage.getSubjectName(subjectName);
                    new SubjectFrame(subjectsPaneModel, subject).setVisible(true);
                } catch (ArrayIndexOutOfBoundsException er) {
                    JOptionPane.showMessageDialog(null, "Je třeba vybrat záznam, kterých chcete změnit", "Chyba", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        removeSubject = new JButton("Smazat předmět");
        removeSubject.addActionListener(new ActionListener() {

            /**
             * Po kliknutí dojde ke smazání předmětu
             * 
             * @param e
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String subjectName = subjectsTable.getModel().getValueAt(subjectsTable.getSelectedRow(), 0).toString();
                    Subject subject = LocalDataStorage.getSubjectName(subjectName);
                    if(LocalDataStorage.removeSubject(subject)) {
                        LocalDataStorage.removeSubject(subject);
                        Thread t1 = new Thread(new DeleteFromDb(subject));
                        t1.start();
                        try {
                            t1.join();
                        } catch (InterruptedException ex) {
                            Logger.getLogger(MainWindow.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        subjectsPaneModel.fireTableStructureChanged();
                    }
                    else {
                        JOptionPane.showMessageDialog(null, "Předmět nejde smazat, protože by byla narušena integrita databáze.", "Chyba", JOptionPane.ERROR_MESSAGE);
                    }
                } catch (ArrayIndexOutOfBoundsException er) {
                    JOptionPane.showMessageDialog(null, "Je třeba vybrat záznam, kterých chcete smazat", "Chyba", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        buttonPanel.add(addSubject);
        buttonPanel.add(Box.createGlue());
        buttonPanel.add(changeSubject);
        buttonPanel.add(Box.createGlue());
        buttonPanel.add(removeSubject);
        subjectsPanel.add(buttonPanel);
    }

    /**
     * Privátní metoda sloužící k inicializaci tabu s úkoly
     */
    private void initTasksPane() {
        tasksPanel = new JPanel();
        tasksPanel.setLayout(new BoxLayout(tasksPanel, BoxLayout.PAGE_AXIS));
        tasksPaneModel = new TasksPaneModel();
        tasksTable = new JTable(tasksPaneModel);
        tasksPanel.add(new JScrollPane(tasksTable));
        tasksTable.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.LINE_AXIS));
        JButton addTask = new JButton("Přidat úkol");
        addTask.addActionListener(new ActionListener() {

            /**
             * Po kliknutí se spustí ono pro přidání úkolu
             * 
             * @param e
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                new TaskFrame(tasksPaneModel).setVisible(true);
            }
        });

        changeTask = new JButton("Změnit úkol");
        changeTask.addActionListener(new ActionListener() {

            /**
             * Po kliknutí se spustí okno pro změnu předmětu
             * 
             * @param e
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String taskName = tasksTable.getModel().getValueAt(tasksTable.getSelectedRow(), 0).toString();
                    Task task = LocalDataStorage.getTaskName(taskName);
                    new TaskFrame(tasksPaneModel, task).setVisible(true);
                } catch (ArrayIndexOutOfBoundsException er) {
                    JOptionPane.showMessageDialog(null, "Je třeba vybrat záznam, kterých chcete změnit", "Chyba", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        removeTask = new JButton("Smazat úkol");
        removeTask.addActionListener(new ActionListener() {

            /**
             * Po kliknutí dojde ke smazání úkolu
             * 
             * @param e
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String taskName = tasksTable.getModel().getValueAt(tasksTable.getSelectedRow(), 0).toString();
                    Task task = LocalDataStorage.getTaskName(taskName);                               
                    if(LocalDataStorage.removeTask(task)) {
                        //LocalDataStorage.removeTask(task);
                        Thread t1 = new Thread(new DeleteFromDb(task));
                        t1.start();
                        try {
                            t1.join();
                        } catch (InterruptedException ex) {
                            Logger.getLogger(MainWindow.class.getName()).log(Level.SEVERE, null, ex);
                            //TODO odchytit
                        }
                        tasksPaneModel.fireTableStructureChanged();
                    }
                    else { // TODO to tu být nemá!
                        JOptionPane.showMessageDialog(null, "Úkol nejde smazat, protože by byla narušena integrita databáze.", "Chyba", JOptionPane.ERROR_MESSAGE);
                    }
                } catch (ArrayIndexOutOfBoundsException er) {
                    JOptionPane.showMessageDialog(null, "Je třeba vybrat záznam, kterých chcete smazat", "Chyba", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        buttonPanel.add(addTask);
        buttonPanel.add(Box.createGlue());
        buttonPanel.add(changeTask);
        buttonPanel.add(Box.createGlue());
        buttonPanel.add(removeTask);
        tasksPanel.add(buttonPanel);
    }
}