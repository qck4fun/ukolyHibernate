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

    public static boolean addSubject(Subject subject) {
        for (Subject savedSubject : subjectsList) {
            if (subjectsList.contains(subject)) {
                return false;
            }
        }
        subjectsList.add(subject);
        return true;
    }

    public static void changeSubject(Subject subject) {
        if (subjectsList.contains(subject)) {
            Subject savedSubject = subjectsList.get(subjectsList.indexOf(subject));
            savedSubject.setName(subject.getName());
            savedSubject.setCredit(subject.getCredit());
        }
    }

    public static Subject getSubjectName(String subjectName) {
        for (Subject s : subjectsList) {
            if (s.getName().equals(subjectName.toString())) {
                return s;
            }
        }
        return null;
    }
}