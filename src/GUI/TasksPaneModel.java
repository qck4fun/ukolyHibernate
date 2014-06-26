/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Other.LocalDataStorage;
import Persistent.Task;
import javax.swing.table.AbstractTableModel;

/**
 * Třída představující model pro tab úkolů
 *
 * @author Adam Žák
 */
public class TasksPaneModel extends AbstractTableModel {
    
    public static final String[] columnName =  {"Název úkolu", "Popis", "Student", "Předmět"};

    /**
     * Metoda vracející počet řádků
     * 
     * @return počet řádků
     */
    @Override
    public int getRowCount() {
        return LocalDataStorage.tasksList.size();
    }

    /**
     * Metoda vracející počet sloupců
     * 
     * @return počet sloupců
     */
    @Override
    public int getColumnCount() {
        return 4;
    }

    /**
     * Metoda pro získání určité hodnoty tabulky
     * 
     * @param rowIndex 
     * @param columnIndex 
     * @return hodnota
     */
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Task task = LocalDataStorage.tasksList.get(rowIndex);
        Object[] values = {task.getName(), task.getDescription(), task.getStudent(), task.getSubject()};
        return values[columnIndex];
    }
    
    /**
     * Metoda vracející název sloupce
     * 
     * @param column 
     * @return název sloupce
     */
    public String getColumnName(int column) {
        return columnName[column];
    }
}