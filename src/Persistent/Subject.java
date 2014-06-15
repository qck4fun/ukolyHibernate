/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Persistent;

import Persistent.Task;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 *
 * @author adam
 */
public class Subject {
    
    private Long id;
    
    private String name;
    private int credits;
    
    private Set<Task> tasks;
    
    public Subject() {
        super();
    }
    
    public Subject(String name, int credit) {
        this.name = name;
        this.credits = credit;
        
        tasks = new HashSet<Task>();
    }
    
    public boolean addTask(Task task) {
        return tasks.add(task);
    }
    
    public boolean removeTask(Task task) {
        return getTasks().remove(task);
    }

    @Override
    public String toString() {
        return this.name;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 97 * hash + Objects.hashCode(this.name);
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
        final Subject other = (Subject) obj;
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

    public int getCredits() {
        return credits;
    }

    public void setCredits(int credits) {
        this.credits = credits;
    }

    public Set<Task> getTasks() {
        return tasks;
    }

    public void setTasks(Set<Task> tasks) {
        this.tasks = tasks;
    }
}
