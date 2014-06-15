/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Other.LocalDataStorage;
import Persistent.Student;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author adam
 */
public class StudentsPaneModel extends AbstractTableModel {
    
    public final static String[] columnName = {"ID student", "xname", "Jméno", "Příjmení"};

    @Override
    public int getRowCount() {
        return LocalDataStorage.studentsList.size();
    }

    @Override
    public int getColumnCount() {
        return 4;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) 
{       Student student = LocalDataStorage.studentsList.get(rowIndex);
        Object[] values = new Object[] {student.getId(), student.getXname(), student.getFirstName(), student.getLastName()};
        return values[columnIndex];
    }
    
    public String getColumnName(int column) {
        return columnName[column];
    }
}
