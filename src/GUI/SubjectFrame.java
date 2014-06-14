/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Persistent.Subject;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 *
 * @author Adam
 */
public class SubjectFrame extends JFrame {
    
    private final SubjectsPaneModel subjectsPaneModel;
    private Subject subject;
    
    public SubjectFrame(SubjectsPaneModel subjectsPaneModel) {
        this.subjectsPaneModel = subjectsPaneModel;
        initCompoments();
        setLocationRelativeTo(null);
        setTitle("Nový pokoj");
    }
    
    private void initCompoments() {
        JLabel nameLabel = new JLabel("Jméno: ");
        JTextField name = new JTextField(20);
        JLabel creditsLabel = new JLabel("Kredity: ");
        JTextField credits = new JTextField(20);
    }
}