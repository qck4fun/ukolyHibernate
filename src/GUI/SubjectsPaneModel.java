/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Other.LocalDataStorage;
import Persistent.Subject;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author adam
 */
public class SubjectsPaneModel extends AbstractTableModel {
    
    public static final String[] columnName =  {"Název předmětu", "Počet kreditů"};

    @Override
    public int getRowCount() {
        return LocalDataStorage.subjectsList.size();
    }

    @Override
    public int getColumnCount() {
        return 2;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) throws ArrayIndexOutOfBoundsException {
        Subject subject = LocalDataStorage.subjectsList.get(rowIndex);
        Object[] values = new Object[]{subject.getName(), subject.getCredits()};
        return values[columnIndex];
    }

    public String getColumnName(int column) {
        return columnName[column];
    }
}
