/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;

import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

public class TableSetupUtil {
    public static TableRowSorter<TableModel> setTableFilter(JTable table, JTextField filterText){
         TableRowSorter<TableModel> rowSorter = new TableRowSorter<>(table.getModel());
         table.setRowSorter(rowSorter);
         
         filterText.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                String searchText = filterText.getText();
                if(searchText.trim().length() > 0) {
                    rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + searchText));
                } else {
                    rowSorter.setRowFilter(null);
                }
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                String searchText = filterText.getText();
                if(searchText.trim().length() > 0) {
                    rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + searchText));
                } else {
                    rowSorter.setRowFilter(null);
                }
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
               
            }
        });
        
         return rowSorter;
    }
}
