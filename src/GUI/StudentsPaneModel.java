/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Other.LocalDataStorage;
import Persistent.Student;
import javax.swing.table.AbstractTableModel;

/**
 * Třída představující model pro tab studentů
 * 
 * @author Adam Žák
 */
public class StudentsPaneModel extends AbstractTableModel {
    
    public final static String[] columnName = {"xname", "Jméno", "Příjmení"};

    /**
     * Metoda vracející počet řádků
     * 
     * @return počet řádků
     */
    @Override
    public int getRowCount() {
        return LocalDataStorage.studentsList.size();
    }
    
    /**
     * Metoda vracející počet sloupců
     * 
     * @return počet sloupců
     */
    @Override
    public int getColumnCount() {
        return 3;
    }

    /**
     * Metoda pro získání určité hodnoty tabulky
     * 
     * @param rowIndex 
     * @param columnIndex 
     * @return hodnota
     */
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) 
{       Student student = LocalDataStorage.studentsList.get(rowIndex);
        Object[] values = new Object[] {student.getXname(), student.getFirstName(), student.getLastName()};
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
