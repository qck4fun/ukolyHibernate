/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Persistent;

import java.util.Objects;

/**
 * Třída reprezentující úkol - jedna z hlavních entit databáze
 *
 * @author Adam Žák
 */
public class Task {
    
    private Long id;
    
    private String name;
    private String description;
    
    private Subject subject;
    private Student student;
    
    /**
     * Bezparametrický konstruktor třídy Task
     */
    public Task() {
        super();
    }
    
    /**
     * Konstruktor třídy Task
     * 
     * @param name 
     * @param topic 
     * @param subject 
     * @param student 
     */
    public Task(String name, String topic, Subject subject, Student student) {
        this.name = name;
        this.description = topic;
        this.subject = subject;
        this.student = student;
    }
    
    /**
     * Přepsaná metoda toString
     * 
     * @return textový výpis
     */
    @Override
    public String toString() {
        return getName();
    }

    /**
     * Přepsaná metoda equals
     * 
     * @param obj 
     * @return true pokud se jedná o ten samý objekt
     */
    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Task other = (Task) obj;
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        if (!Objects.equals(this.description, other.description)) {
            return false;
        }
        if (!Objects.equals(this.subject, other.subject)) {
            return false;
        }
        if (!Objects.equals(this.student, other.student)) {
            return false;
        }
        return true;
    }

    /**
     * Přepsaná metoda hashCode
     * 
     * @return hash
     */
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 97 * hash + Objects.hashCode(this.name);
        hash = 97 * hash + Objects.hashCode(this.description);
        hash = 97 * hash + Objects.hashCode(this.subject);
        hash = 97 * hash + Objects.hashCode(this.student);
        return hash;
    }
    
    //GETTERS and SETTERS

    public Long getId() {
        return id;
    }

    private void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }
}