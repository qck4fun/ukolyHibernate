/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Other.LocalDataStorage;
import Persistent.Task;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author adam
 */
public class TasksPaneModel extends AbstractTableModel {
    
    public static final String[] columnName =  {"ID úkolu", "Název úkolu", "Popis", "Student", "Předmět"};

    @Override
    public int getRowCount() {
        return LocalDataStorage.tasksList.size();
    }

    @Override
    public int getColumnCount() {
        return 5;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Task task = LocalDataStorage.tasksList.get(rowIndex);
        Object[] values = {task.getId(), task.getName(), task.getDescription(), task.getStudent(), task.getSubject()};
        return values[columnIndex];
    }
    
    public String getColumnName(int column) {
        return columnName[column];
    }
}
