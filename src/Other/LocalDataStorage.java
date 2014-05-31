/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Other;

import Persistent.Student;
import Persistent.Subject;
import Persistent.Task;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author adam
 */
public class LocalDataStorage {
    
    public static List<Student> studentsList = new ArrayList<Student>();
    public static List<Subject> subjectsList = new ArrayList<Subject>();
    public static List<Task> tasksList = new ArrayList<Task>();
    
    private LocalDataStorage() {
    }
}