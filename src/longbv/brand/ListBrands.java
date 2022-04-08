/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package longbv.brand;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author longh
 */
public class ListBrands <R> extends AbstractTableModel{
    String[] header;
    int[] indexes;
    ArrayList<BrandDTO> data;

    public ListBrands(String[] header, int[] indexes) {
        int i = 0;
        this.header = new String[header.length];
        for (i = 0; i < header.length; i++) {
            this.header[i] = header[i];
        }
        this.indexes = new int[indexes.length];
        for (i = 0; i < header.length; i++) {
            this.indexes[i] = indexes[i];
        }
        this.data = new ArrayList<BrandDTO>();
    }

    public ArrayList<BrandDTO> getData() {
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

    public void setData(ArrayList<BrandDTO> brands) {
        this.data = brands;
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
        BrandDTO re = data.get(row);
        switch (indexes[column]) {
            case 0:
                return re.getBrandID();
            case 1:
                return re.getBrandName();
            case 2:
                return re.getCountry();
            case 3:
                return re.getDescription();     
        }
        return null;
    }
}
