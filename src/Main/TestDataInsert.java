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
        insertToDb();
        addStudentsDetails();
        addSubjectsDetails();
    }

    private void createDummyData() {
        Student[] stud = {
            new Student("xpavj64", "Jarmila", "Pavlíčková"),
            new Student("xnovp79", "Pepa", "Novák"),
            new Student("xpavl62", "Luboš", "Pavlíček"),};
        students = Arrays.asList(stud);
        
        Subject[] sub = {
            new Subject("Programování", 6),
            new Subject("Tělocvik", 10),
            new Subject("Sexclass", 100)};
        subjects = Arrays.asList(sub);
        
        Task[] task = {
            new Task("Úkol 1", "Dolování z DB", subjects.get(0), students.get(0)),
            new Task("Biceps", "Skotova lavice", subjects.get(1), students.get(1)),
            new Task("Mrdačka", "Poloha pejsek", subjects.get(2), students.get(2)),};
        tasks = Arrays.asList(task);
    }
    
    private void addStudentsDetails() {
        subjects.get(0).addTask(tasks.get(0));
        subjects.get(1).addTask(tasks.get(1));
        subjects.get(2).addTask(tasks.get(2));
        
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        for(Subject subject : subjects) {
            session.saveOrUpdate(subject);
        }
        session.flush();
        session.getTransaction().commit();
    }
    
    private void addSubjectsDetails() {
        students.get(0).addSubject(subjects.get(0));
        students.get(0).addTask(tasks.get(0));
        students.get(1).addSubject(subjects.get(1));
        students.get(1).addTask(tasks.get(1));
        students.get(2).addSubject(subjects.get(2));
        students.get(2).addTask(tasks.get(2));
        
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        for(Student student : students) {
            session.saveOrUpdate(student);
        }
        session.flush();
        session.getTransaction().commit();
    }
    
    private void insertToDb() {
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        
        for(Student student : students) {
            session.saveOrUpdate(student);
        }
        session.flush();
        session.getTransaction().commit();
        session.beginTransaction();
        for(Subject subject : subjects) {
            session.saveOrUpdate(subject);
        }
        session.flush();
        session.getTransaction().commit();
        session.beginTransaction();
        for(Task task : tasks) {
            session.saveOrUpdate(task);
        }
        session.flush();
        session.getTransaction().commit();
    }
}