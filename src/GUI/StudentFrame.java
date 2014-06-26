/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Other.LocalDataStorage;
import Other.SaveToDb;
import Persistent.Student;
import Persistent.Subject;
import Persistent.Task;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

/**
 * Třída předtavující okno pro tvorbu a editaci studenta
 * 
 * @author Adam Žák
 */
public class StudentFrame extends javax.swing.JFrame {

    private final StudentsPaneModel studentsPaneModel;
    private Student student;
    private String errorMsg;
    private boolean newStudent;
    private DefaultListModel<Subject> defaultSubjectsListModel = new DefaultListModel<Subject>();
    private DefaultListModel<Task> defaultTasksListModel = new DefaultListModel<Task>();

    /**
     * Konstruktor pro tvorbu nového studenta
     * 
     * @param studentsPaneModel 
     */
    public StudentFrame(StudentsPaneModel studentsPaneModel) {
        this.studentsPaneModel = studentsPaneModel;
        initComponents();
        setTitle("Nový student");
        newStudent = true;
    }

    /**
     * Konstruktor pro editaci již existujícího studenta
     * 
     * @param studentsPaneModel 
     * @param student 
     */
    public StudentFrame(StudentsPaneModel studentsPaneModel, Student student) {
        this.studentsPaneModel = studentsPaneModel;
        this.student = student;
        initComponents();
        setTitle("Upravit studenta");
        headline.setText("Upravit studenta");
        xname.setText(student.getXname());
        firstName.setText(student.getFirstName());
        lastName.setText(student.getLastName());
        newStudent = false;
        repaintSubjectsList();
        repaintTasksList();
    }

    /**
     * Privátní metoda sloužící pro vykreslení studentovo předmětů do JListu
     */
    private void repaintSubjectsList() {
        for (Subject subject : student.getSubjects()) {
            defaultSubjectsListModel.addElement(subject);
        }
    }

    /**
     * Privátní metoda sloužící pro vykreslení studentovo úkolů do JListu
     */
    private void repaintTasksList() {
        for (Task task : student.getTasks()) {
            defaultTasksListModel.addElement(task);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    /**
     * Vygenerovaná metoda inicializujíci komponenty tohoto okna
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        headline = new javax.swing.JLabel();
        firstNameLabel = new javax.swing.JLabel();
        lastNameLabel = new javax.swing.JLabel();
        lastName = new javax.swing.JTextField();
        firstName = new javax.swing.JTextField();
        saveStudent = new javax.swing.JButton();
        cancelStudent = new javax.swing.JButton();
        xnameLabel = new javax.swing.JLabel();
        xname = new javax.swing.JTextField();
        subjectsListLabel = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        subjectsList = new javax.swing.JList();
        jScrollPane2 = new javax.swing.JScrollPane();
        tasksList = new javax.swing.JList();
        tasksListLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        headline.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        headline.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        headline.setText("Nový student");

        firstNameLabel.setText("Jméno");

        lastNameLabel.setText("Příjmení");

        saveStudent.setText("Uložit");
        saveStudent.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveStudent(evt);
            }
        });

        cancelStudent.setText("Zrušit");
        cancelStudent.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelStudent(evt);
            }
        });

        xnameLabel.setText("xname");

        subjectsListLabel.setText("Studuje");

        subjectsList.setEnabled(false);
        subjectsList.setModel(defaultSubjectsListModel);
        jScrollPane1.setViewportView(subjectsList);

        tasksList.setEnabled(false);
        tasksList.setModel(defaultTasksListModel);
        jScrollPane2.setViewportView(tasksList);

        tasksListLabel.setText("Úkoly");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(80, 80, 80)
                        .addComponent(headline)
                        .addGap(0, 90, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addComponent(saveStudent)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(cancelStudent))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(subjectsListLabel)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(lastNameLabel)
                                            .addComponent(firstNameLabel)
                                            .addComponent(xnameLabel)))
                                    .addComponent(tasksListLabel))
                                .addGap(7, 7, 7)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(firstName)
                                    .addComponent(lastName)
                                    .addComponent(xname)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))))
                        .addGap(9, 9, 9)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(headline)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(xname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(xnameLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(firstNameLabel)
                    .addComponent(firstName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lastNameLabel)
                    .addComponent(lastName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(subjectsListLabel)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 147, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2)
                    .addComponent(tasksListLabel))
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(saveStudent)
                    .addComponent(cancelStudent))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Metoda ukládající nového/editovaného studenta
     * 
     * @param evt 
     */
    private void saveStudent(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveStudent
        if (checkInputData()) {
            if (newStudent) {
                student = new Student(xname.getText(), firstName.getText(), lastName.getText());
                if (LocalDataStorage.addStudent(student)) {
                    xname.setText("");
                    firstName.setText("");
                    lastName.setText("");
                    Thread t1 = new Thread(new SaveToDb(student));
                    t1.start();
                    try {
                        t1.join();
                    } catch (InterruptedException ex) {
                        Logger.getLogger(StudentFrame.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    studentsPaneModel.fireTableDataChanged();
                    cancelStudent(evt);
                } else {
                    errorMsg = "Takový student již v databázi existuje";
                    JOptionPane.showMessageDialog(this, errorMsg, "Chyba", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                student.setXname(xname.getText());
                student.setFirstName(firstName.getText());
                student.setLastName(lastName.getText());
                LocalDataStorage.changeStudent(student);
                Thread t1 = new Thread(new SaveToDb(student));
                t1.start();
                try {
                    t1.join();
                } catch (InterruptedException ex) {
                    Logger.getLogger(StudentFrame.class.getName()).log(Level.SEVERE, null, ex);
                }
                studentsPaneModel.fireTableDataChanged();
                cancelStudent(evt);
            }
        } else {
            JOptionPane.showMessageDialog(this, errorMsg, "Chyba", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_saveStudent
    
    /**
     * Metoda sloužící k zavření tohoto okna
     * 
     * @param evt 
     */
    private void cancelStudent(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelStudent
        this.dispose();
    }//GEN-LAST:event_cancelStudent

    /**
     * Privátní metoda kontrolující vstup uživatele
     */
    private boolean checkInputData() {
        String xnameInput = xname.getText();
        String firstNameInput = firstName.getText();
        String lastNameInput = lastName.getText();

        if (xnameInput.isEmpty()) {
            errorMsg = "Je třeba zadat xname studenta";
            return false;
            //TODO vyřešit další omezení pro xname - regex??
        } else if (firstNameInput.isEmpty()) {
            errorMsg = "Je třeba zadat jméno studenta";
            return false;
        } else if (lastNameInput.isEmpty()) {
            errorMsg = "Je třeba zadat příjmení studenta";
            return false;
        }
        return true;
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cancelStudent;
    private javax.swing.JTextField firstName;
    private javax.swing.JLabel firstNameLabel;
    private javax.swing.JLabel headline;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField lastName;
    private javax.swing.JLabel lastNameLabel;
    private javax.swing.JButton saveStudent;
    private javax.swing.JList subjectsList;
    private javax.swing.JLabel subjectsListLabel;
    private javax.swing.JList tasksList;
    private javax.swing.JLabel tasksListLabel;
    private javax.swing.JTextField xname;
    private javax.swing.JLabel xnameLabel;
    // End of variables declaration//GEN-END:variables
}
