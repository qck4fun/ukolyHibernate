/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Other.LocalDataStorage;
import Persistent.Subject;
import javax.swing.table.AbstractTableModel;

/**
 * Třída představující model pro tab předmětů
 *
 * @author Adam Žák
 */
public class SubjectsPaneModel extends AbstractTableModel {
    
    public static final String[] columnName =  {"Název předmětu", "Počet kreditů"};

    /**
     * Metoda vracející počet řádků
     * 
     * @return počet řádků
     */
    @Override
    public int getRowCount() {
        return LocalDataStorage.subjectsList.size();
    }

    /**
     * Metoda vracející počet sloupců
     * 
     * @return počet sloupců
     */
    @Override
    public int getColumnCount() {
        return 2;
    }

    /**
     * Metoda pro získání určité hodnoty tabulky
     * 
     * @param rowIndex 
     * @param columnIndex 
     * @return hodnota
     */
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) throws ArrayIndexOutOfBoundsException {
        Subject subject = LocalDataStorage.subjectsList.get(rowIndex);
        Object[] values = new Object[]{subject.getName(), subject.getCredits()};
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
