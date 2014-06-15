/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Other.LocalDataStorage; 
import java.awt.event.ActionEvent; 
import javax.swing.JButton; 
import javax.swing.JFrame; 
import javax.swing.JLabel; 
import javax.swing.JTextField;
import Other.SaveToDb;
import Persistent.Subject;
import javax.swing.JOptionPane;

/**
 *
 * @author adam
 */
public class SubjectFrame extends javax.swing.JFrame {

    private final SubjectsPaneModel subjectsPaneModel;
    private Subject subject;
    private String errorMsg;
    private boolean newSubject;

    /**
     * Creates new form SubjectFrame
     */
    public SubjectFrame(SubjectsPaneModel subjectsPaneModel) {
        this.subjectsPaneModel = subjectsPaneModel;
        initComponents();
        setTitle("Nový předmět");
        newSubject = true;
    }

    public SubjectFrame(SubjectsPaneModel subjectsPaneModel, Subject subject) {
        this.subjectsPaneModel = subjectsPaneModel;
        this.subject = subject;
        initComponents();
        setTitle("Upravit předmět");
        headline.setText("Upravit předmět");
        name.setText(subject.getName());
        credits.setText(String.valueOf(subject.getCredits()));
        newSubject = false;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        headline = new javax.swing.JLabel();
        nameLabel = new javax.swing.JLabel();
        name = new javax.swing.JTextField();
        creditsLabel = new javax.swing.JLabel();
        credits = new javax.swing.JTextField();
        saveSubject = new javax.swing.JButton();
        cancelSubject = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        headline.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        headline.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        headline.setText("Nový předmět");

        nameLabel.setText("Název");

        creditsLabel.setText("Počet kreditů");

        saveSubject.setText("Uložit");
        saveSubject.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveSubject(evt);
            }
        });

        cancelSubject.setText("Zrušit");
        cancelSubject.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelClick(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(creditsLabel)
                            .addComponent(nameLabel))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(name)
                            .addComponent(credits)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(saveSubject)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(cancelSubject)
                        .addGap(13, 13, 13)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 81, Short.MAX_VALUE)
                .addComponent(headline)
                .addGap(75, 75, 75))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(headline)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nameLabel)
                    .addComponent(name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(creditsLabel)
                    .addComponent(credits, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(saveSubject)
                    .addComponent(cancelSubject))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cancelClick(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelClick
        this.dispose();
    }//GEN-LAST:event_cancelClick

    private void saveSubject(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveSubject
        if (checkInputData()) {
            if (newSubject) {
                subject = new Subject(name.getText(), Integer.parseInt(credits.getText()));
                if (LocalDataStorage.addSubject(subject)) {
                    subjectsPaneModel.fireTableDataChanged();
                    name.setText("");
                    credits.setText("");
                    new Thread(new SaveToDb(subject)).start();
                    cancelClick(evt);
                } else {
                    errorMsg = "Takový předmět již v databázi existuje";
                    JOptionPane.showMessageDialog(this, errorMsg, "Chyba", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                    subject.setName(name.getText());
                    subject.setCredits(Integer.parseInt(credits.getText()));
                    LocalDataStorage.changeSubject(subject);
                    subjectsPaneModel.fireTableDataChanged();
                    new Thread(new SaveToDb(subject)).start();
                    cancelClick(evt);
            }
        } else {
            JOptionPane.showMessageDialog(this, errorMsg, "Chyba", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_saveSubject

    private boolean checkInputData() {
        try {
            String subjectInput = name.getText();
            String creditsInput = credits.getText();

            if (subjectInput.isEmpty()) {
                errorMsg = "Je třeba vyplnit název předmětu";
                return false;
            } else if (creditsInput.isEmpty()) {
                errorMsg = "Je třeba vyplnit pole s počtem kreditů";
                return false;
            }
            int creditsNumber = Integer.parseInt(credits.getText());

            if (creditsNumber < 1) {
                errorMsg = "Počet kreditů za předmět by měl být větší než 0";
                return false;
            }
        } catch (NumberFormatException e) {
            errorMsg = "Pole počet kreditů může obsahovat pouze čísla";
            return false;
        }
        return true;
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cancelSubject;
    private javax.swing.JTextField credits;
    private javax.swing.JLabel creditsLabel;
    private javax.swing.JLabel headline;
    private javax.swing.JTextField name;
    private javax.swing.JLabel nameLabel;
    private javax.swing.JButton saveSubject;
    // End of variables declaration//GEN-END:variables
}