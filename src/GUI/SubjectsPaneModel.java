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
    
    public static final String[] columnName =  {"ID předmět", "Název předmětu", "Počet kreditů", "Student"};

    @Override
    public int getRowCount() {
        return LocalDataStorage.subjectsList.size();
    }

    @Override
    public int getColumnCount() {
        return 4;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Subject subject = LocalDataStorage.subjectsList.get(rowIndex);
        Object[] values = new Object[]{subject.getId(), subject.getName(), subject.getCredit(), subject.getStudent()};
        return values[columnIndex];
    }

    public String getColumnName(int column) {
        return columnName[column];
    }
}
