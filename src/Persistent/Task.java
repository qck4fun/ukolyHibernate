/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Persistent;

import java.util.Objects;

/**
 *
 * @author adam
 */
public class Task {
    
    private Long id;
    
    private String name;
    private String description;
    
    private Subject subject;
    private Student student;
    
    public Task() {
        super();
    }
    
    public Task(String name, String topic, Subject subject, Student student) {
        this.name = name;
        this.description = topic;
        this.subject = subject;
        this.student = student;
    }
    
    @Override
    public String toString() {
        return "|"  + getName() + "| : " + getDescription();
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 89 * hash + Objects.hashCode(this.name);
        return hash;
    }

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
        return true;
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