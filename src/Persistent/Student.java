/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Persistent;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * Třída reprezentující studenta - jednu z hlavních entit databáze
 *
 * @author Adam Žák
 */
public class Student {
    
    private Long id;
    
    private String xname;
    private String firstName;
    private String lastName;
    
    private Set<Task> tasks;
    private Set<Subject> subjects;
    
    /**
     * Bezparametrický konstruktor třídy Student
     */
    public Student() {
        super();
    }
    
    /**
     * Konstruktor třídy Student
     * 
     * @param xname
     * @param name
     * @param lastName 
     */
    public Student(String xname, String name, String lastName) {
        this.xname = xname;
        this.firstName = name;
        this.lastName = lastName;
        
        tasks = new HashSet<Task>();
        subjects = new HashSet<Subject>();
    }
    
    /**
     * Metoda přidávají úkol k instanci studenta
     * 
     * @param  task
     * @return true pokud se podaří přidat
     */
    public boolean addTask(Task task) {
        return tasks.add(task);
    }
    
    /**
     * Metoda odstraňující odkaz na úkol ze seznamu instance studenta
     * 
     * @param task
     * @return true pokud se podaří smazat
     */
    public boolean removeTask(Task task) {
        return getTasks().remove(task);
    }
    
    /**
     * Metoda přídávající předmět k instanci studenta
     * 
     * @param subject 
     * @return true pokud se podaří přidat
     */
    public boolean addSubject(Subject subject) {
        return subjects.add(subject);
    }
    
    /**
     * Metoda odstraňující odkaz na předmět ze seznamu instance studenta
     * 
     * @param subject 
     * @return true pokud se podaří smazat
     */
    public boolean removeSubject(Subject subject) {
        return getSubjects().remove(subject);
    }
    
    /**
     * Přepsaná metoda toString
     * 
     * @return textový výpis
     */
    @Override
    public String toString() {
        return getFirstName() + " " + getLastName() + " (" + getXname() + ")";
    }

    /**
     * Přepsaná metoda hashCode
     * 
     * @return hash
     */
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 97 * hash + Objects.hashCode(this.xname);
        return hash;
    }

    /**
     * Přepsaná metoda equals
     * 
     * @param obj 
     * @return true pokud jde o ten samý objekt
     */
    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Student other = (Student) obj;
        if (!Objects.equals(this.xname, other.xname)) {
            return false;
        }
        return true;
    }

    //GETTERS and SETTERS
    
    public Long getId() {
        return id;
    }

    private void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String name) {
        this.firstName = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getXname() {
        return xname;
    }

    public void setXname(String xname) {
        this.xname = xname;
    }

    public Set<Task> getTasks() {
        return tasks;
    }

    public void setTasks(Set<Task> tasks) {
        this.tasks = tasks;
    }

    public Set<Subject> getSubjects() {
        return subjects;
    }

    public void setSubjects(Set<Subject> subjects) {
        this.subjects = subjects;
    }
}
