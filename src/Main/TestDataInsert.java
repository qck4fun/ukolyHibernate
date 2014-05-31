/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import Other.HibernateUtil;
import Persistent.Student;
import Persistent.Subject;
import Persistent.Task;
import java.util.Arrays;
import java.util.List;
import org.hibernate.Session;

/**
 *
 * @author adam
 */
public class TestDataInsert {

    private List<Student> students;
    private List<Subject> subjects;
    private List<Task> tasks;

    public TestDataInsert() {
        createDummyData();
        addStudentsDetails();
        insertToDb();
    }

    private void createDummyData() {
        Subject[] sub = {
            new Subject("Programování", 6),
            new Subject("Tělocvik", 10),
            new Subject("Sexclass", 100),};
        subjects = Arrays.asList(sub);
        
        Task[] task = {
            new Task("Úkol 1", "Dolování z DB", subjects.get(0), null),
            new Task("Biceps", "Skotova lavice", subjects.get(1), null),
            new Task("Mrdačka", "Poloha pejsek", subjects.get(2), null),};
        tasks = Arrays.asList(task);
    }
    
    private void addStudentsDetails() {
        Student[] stud = {
            new Student("Jarmila", "Pavlíčková"),
            new Student("Pepa", "Novák"),
            new Student("Luboš", "Pavlíček"),};
        students = Arrays.asList(stud);
        
        students.get(0).addSubject(subjects.get(0));
        students.get(0).addTask(tasks.get(2));
        students.get(1).addSubject(subjects.get(1));
        students.get(1).addTask(tasks.get(1));
        students.get(2).addSubject(subjects.get(2));
        students.get(2).addTask(tasks.get(0));
        
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        for(Student student : students) {
            session.saveOrUpdate(student);
        }
        session.getTransaction().commit();
        session.close();
    }
    
    private void insertToDb() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        for(Subject subject : subjects) {
            session.saveOrUpdate(subject);
        }
        session.getTransaction().commit();
        session.beginTransaction();
        session.close();
    }
}
