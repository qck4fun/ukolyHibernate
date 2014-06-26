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
 * Třída představující lokální úložiště pro data z databáze
 *
 * @author Adam Žák
 */
public class LocalDataStorage {

    public static List<Student> studentsList = new ArrayList<Student>();
    public static List<Subject> subjectsList = new ArrayList<Subject>();
    public static List<Task> tasksList = new ArrayList<Task>();

    /**
     * Privátní konstrutkor
     */
    private LocalDataStorage() {
    }

    /**
     * Metoda, která přidává předmět do seznamu předmětů
     * 
     * @param subject 
     * @return true pokud se předmět podaří přidat
     */
    public static boolean addSubject(Subject subject) {
        if (subjectsList.contains(subject)) {
            return false;
        }
        subjectsList.add(subject);
        return true;
    }

    /**
     * Metoda měnící datové atributy instance třídy Subject
     * 
     * @param subject 
     */
    public static void changeSubject(Subject subject) {
        if (subjectsList.contains(subject)) {
            Subject savedSubject = subjectsList.get(subjectsList.indexOf(subject));
            savedSubject.setName(subject.getName());
            savedSubject.setCredits(subject.getCredits());
        }
    }
    
    /**
     * Metoda vracející odkaz na třídu Subject
     * 
     * @param subjectName 
     * @return odkaz na třídu Subject
     */
    public static Subject getSubjectName(String subjectName) {
        for (Subject s : subjectsList) {
            if (s.getName().equals(subjectName)) {
                return s;
            }
        }
        return null;
    }

    /**
     * Metoda přidávající instanci studenta do seznamu studentů
     * 
     * @param student 
     * @return true pokud se podaří přidat
     */
    public static boolean addStudent(Student student) {
        if (studentsList.contains(student)) {
            return false;
        }
        studentsList.add(student);
        return true;
    }
    
    /**
     * Metoda měnící datové atributy třídy student
     * 
     * @param student 
     */
    public static void changeStudent(Student student) {
        if (studentsList.contains(student)) {
            Student savedStudent = studentsList.get(studentsList.indexOf(student));
            savedStudent.setFirstName(student.getFirstName());
            savedStudent.setLastName(student.getLastName());
        }
    }

    /**
     * Metoda vracející odkaz na třídu Studnet
     * 
     * @param studentXname 
     * @return odkaz na třídu student
     */
    public static Student getStudentXname(String studentXname) {
        for (Student s : studentsList) {
            if (s.getXname().equals(studentXname)) {
                return s;
            }
        }
        return null;
    }

    /**
     * Metoda přídávající úkol do seznamu úkolů
     * 
     * @param task 
     * @return true pokud se podaří přidat
     */
    public static boolean addTask(Task task) {
        if (tasksList.contains(task)) {
            return false;
        }
        tasksList.add(task);
        return true;
    }

    /**
     * Metoda měnící datové atributy instance třídy Task
     * 
     * @param task 
     */
    public static void changeTask(Task task) {
        if (tasksList.contains(task)) {
            Task savedTask = tasksList.get(tasksList.indexOf(task));
            savedTask.setName(task.getName());
            savedTask.setDescription(task.getDescription());
            savedTask.setSubject(task.getSubject());
            savedTask.setStudent(task.getStudent());
        }
    }

    /**
     * Metoda vracející instanci třídy Task
     * 
     * @param taskName 
     * @return instance třídy Task
     */
    public static Task getTaskName(String taskName) {
        for (Task t : tasksList) {
            if (t.getName().equals(taskName)) {
                return t;
            }
        }
        return null;
    }

    /**
     * Metoda vracející odkaz na třídu Student
     * 
     * @param xname 
     * @return odkaz na třídu Student
     */
    public static Student getStudentUsingXname(String xname) {
        for (Student s : studentsList) {
            if (s.getXname().equals(xname)) {
                return s;
            }
        }
        return null;
    }
    
    /**
     * Metoda vracející odkaz na instanci třídy Subject
     * 
     * @param subjectName 
     * @return odkaz na instanci třídy Subject
     */
    public static Subject getSubjectUsingSubjectName(String subjectName) {
        for (Subject s : subjectsList) {
            if (s.getName().equals(subjectName)) {
                return s;
            }
        }
        return null;
    }

    /**
     * Metoda vracející odkaz na instanci třídy Task
     * 
     * @param subject 
     * @return odkaz na instanci třídy Task
     */
    public static Task getTaskUsingSubject(String subject) {
        for (Task t : tasksList) {
            if (t.getSubject().getName().equals(subject)) {
                return t;
            }
        }
        return null;
    }

    /**
     * Metoda odstraňující úkol ze seznamů úkolů + řeší i zachování integrity
     * 
     * @param task 
     * @return true pokud se podaří smazat
     */
    public static boolean removeTask(Task task) {
        System.out.println(task.getStudent().getSubjects().size());
        for (Task t : tasksList) {
            if (t.equals(task)) {
                task.getStudent().getTasks().remove(task);
                task.getSubject().getTasks().remove(task);
                task.getStudent().removeSubject(task.getSubject());
                // TODO když má dva úkoly ze stejného předmětu, tak se to smaže taky a to je špatně!
                tasksList.remove(task);
                return true;
            }
        }
        return false;
    }

    /**
     * Metoda odstraňující předmět ze seznamu předmětů + řeší i integritu
     * ¨
     * @param subject 
     * @return true pokud se podaří odstranit
     */
    public static boolean removeSubject(Subject subject) {
        if (subject.getTasks().isEmpty()) {
            for (Student s : studentsList) {
                subjectsList.remove(subject);
                return true;
            }
        } else {
            return false;
        }
        return false;
    }

    /**
     * Metoda odstraňující studenta ze seznamu studentů + řeší í integritu
     * 
     * @param student 
     * @return true pokud se podaří smazat
     */
    public static boolean removeStudent(Student student) {
        if (student.getTasks().isEmpty() && student.getSubjects().isEmpty()) {
            studentsList.remove(student);
            return true;
        } else {
            return false;
        }
    }
}