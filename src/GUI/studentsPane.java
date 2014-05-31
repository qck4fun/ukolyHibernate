/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Other.LocalDataStorage;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author adam
 */
public class studentsPane extends AbstractTableModel {
    
    public final static String[] columnName = {"Jméno", "Příjmení"};

    @Override
    public int getRowCount() {
        return LocalDataStorage.studentsList.size();
    }

    @Override
    public int getColumnCount() {
        return 2;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) 
{        return LocalDataStorage.studentsList.get(rowIndex);
    }
    
    public String getColumnName(int column) {
        return columnName[column];
    }
}
