/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package longbv.motorcycle;

import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.table.AbstractTableModel;
import longbv.brand.BrandDAO;
import longbv.motorcycle.MotorcycleDTO;

/**
 *
 * @author ASUS
 */
public class ListMotors<R> extends AbstractTableModel {

    String[] header;
    int[] indexes;
    ArrayList<MotorcycleDTO> data;

    public ListMotors(String[] header, int[] indexes) {
        int i = 0;
        this.header = new String[header.length];
        for (i = 0; i < header.length; i++) {
            this.header[i] = header[i];
        }
        this.indexes = new int[indexes.length];
        for (i = 0; i < header.length; i++) {
            this.indexes[i] = indexes[i];
        }
        this.data = new ArrayList<MotorcycleDTO>();
    }

    public ArrayList<MotorcycleDTO> getData() {
        return data;
    }

    public String[] getHeader() {
        return header;
    }

    public void setHeader(String[] header) {
        this.header = header;
    }

    public int[] getIndexes() {
        return indexes;
    }

    public void setIndexes(int[] indexes) {
        this.indexes = indexes;
    }

    public void setData(ArrayList<MotorcycleDTO> motors) {
        this.data = motors;
    }

    public int getRowCount() {
        return data.size();
    }

    public int getColumnCount() {
        return header.length;
    }

    public String getColumnName(int column) {
        return (column >= 0 && column < header.length) ? header[column] : "";
    }

    public Object getValueAt(int row, int column) {
        if (row < 0 || row >= data.size() || column < 0 || column >= header.length) {
            return null;
        }
        MotorcycleDTO re = data.get(row);
        String brandName = new BrandDAO().getBrandNameByID(re.getBrandID());
        DateFormat format = new SimpleDateFormat("MM-dd-yyyy");
        
        switch (indexes[column]) {
            case 0:
                return re.getMotorID();
            case 1:
                return re.getModel();
            case 2:
                return format.format(re.getYear());
            case 3:
                return re.getCondition();
            case 4:
                return re.getPrice();
            case 5:
                return re.getQuantity();
            case 6:
                return re.getWarranty();
            case 7:
                return brandName;
        }
        return null;
    }
}
