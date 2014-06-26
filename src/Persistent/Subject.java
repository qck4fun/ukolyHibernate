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
 * Třída reprezentující předmět - jedna z hlavních entit databáze
 *
 * @author Adam Žák
 */
public class Subject {
    
    private Long id;
    
    private String name;
    private int credits;
    
    private Set<Task> tasks;
    
    /**
     * Bezparametrický konstruktor třídy Subject
     */
    public Subject() {
        super();
    }
    
    /**
     * Kontruktor třídy Subject
     * 
     * @param name
     * @param credit
     */
    public Subject(String name, int credit) {
        this.name = name;
        this.credits = credit;
        
        tasks = new HashSet<Task>();
    }
    
    /**
     * Metoda přidávající odkaz na úkol do seznamu instance předmět
     * 
     * @param task 
     * @return true pokud se podaří přidat
     */
    public boolean addTask(Task task) {
        return tasks.add(task);
    }
    
    /**
     * Metoda odstraňující odkaz na úkol ze seznamu instance předmět
     * 
     * @param task 
     * @return true pokud se podaří odstranit
     */
    public boolean removeTask(Task task) {
        return getTasks().remove(task);
    }
    
    /**
     * Přepsaná metoda toString
     * 
     * @return textový výpis
     */
    @Override
    public String toString() {
        return this.name;
    }

    /**
     * Přepsaná metoda hashCode
     * 
     * @return hash
     */
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 97 * hash + Objects.hashCode(this.name);
        return hash;
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
