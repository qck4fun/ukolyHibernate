/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Other;

import Persistent.Student;
import Persistent.Subject;
import Persistent.Task;
import java.util.ArrayList;
import java.util.Arrays;
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
        //for (Subject savedSubject : subjectsList) { //TODO odstranit
        if (subjectsList.contains(subject)) {
            return false;
        }
        //}
        subjectsList.add(subject);
        return true;
    }

    public static void changeSubject(Subject subject) {
        if (subjectsList.contains(subject)) {
            Subject savedSubject = subjectsList.get(subjectsList.indexOf(subject));
            savedSubject.setName(subject.getName());
            savedSubject.setCredits(subject.getCredits());
        }
    }

    public static Subject getSubjectName(String subjectName) {
        for (Subject s : subjectsList) {
            if (s.getName().equals(subjectName)) {
                return s;
            }
        }
        return null;
    }

    public static boolean addStudent(Student student) {
        //for (Student savedStudent : studentsList) { //TODO odstranit
        if (studentsList.contains(student)) {
            return false;
        }
        //}
        studentsList.add(student);
        return true;
    }

    public static void changeStudent(Student student) {
        if (studentsList.contains(student)) {
            Student savedStudent = studentsList.get(studentsList.indexOf(student));
            savedStudent.setFirstName(student.getFirstName());
            savedStudent.setLastName(student.getLastName());
        }
    }

    public static Student getStudentXname(String studentXname) {
        for (Student s : studentsList) {
            if (s.getXname().equals(studentXname)) {
                return s;
            }
        }
        return null;
    }

    public static boolean addTask(Task task) {
        if (tasksList.contains(task)) {
            return false;
        }
        tasksList.add(task);
        return true;
    }

    public static void changeTask(Task task) {
        if (tasksList.contains(task)) {
            Task savedTask = tasksList.get(tasksList.indexOf(task));
            savedTask.setName(task.getName());
            savedTask.setDescription(task.getDescription());
            savedTask.setSubject(task.getSubject());
            savedTask.setStudent(task.getStudent());
        }
    }

    public static Task getTaskName(String taskName) {
        for (Task t : tasksList) {
            if (t.getName().equals(taskName)) {
                return t;
            }
        }
        return null;
    }

    public static Task getTaskUsingXname(String xname) {
        for (Task t : tasksList) {
            if (t.getStudent().getXname().equals(xname)) {
                return t;
            }
        }
        return null;
    }

    public static Task getTaskUsingSubject(String subject) {
        for (Task t : tasksList) {
            if (t.getSubject().getName().equals(subject)) {
                return t;
            }
        }
        return null;
    }

    public static boolean removeTask(Task task) {
        for (Task t : tasksList) {
            if (t.equals(task)) {
                task.getStudent().getTasks().remove(task);
                task.getSubject().getTasks().remove(task);
                tasksList.remove(task);
                return true;
            }
        }
        return false;
    }

    public static boolean removeSubject(Subject subject) {
        if (subject.getTasks().isEmpty()) {
            for (Student s : studentsList) {
                if(s.removeSubject(subject)) {
                    s.removeSubject(subject);
                    subjectsList.remove(subject);
                    return true;
                }
                break;
            }
        } else {
            return false;
        }
        return false;
    }

    public static boolean removeStudent(Student student) {
        if (student.getTasks().isEmpty() && student.getSubjects().isEmpty()) {
            studentsList.remove(student);
            return true;
        } else {
            return false;
        }
    }
}