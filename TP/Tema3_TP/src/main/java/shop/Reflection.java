package shop;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.lang.reflect.Field;
import java.util.List;

/**
 *  Aceasta clasa se ocupa de generarea capului de tabel si de umplerea acestuia cu date
 * @author Helha Balog balog.helga@yahoo.com
 * @since 26.04.2021
 */

public class Reflection {

    /**
     * Aceasta metoda primeste o lista de obiecte si pe baza acestor obiecte scoate coloanele tabelului si randurile acestuia
     * @param list este lista de Obiecte. Obiectele pot fi clienti, produse sau comenzi
     * @return metoda returneaza tabelul generat
     */

    public JTable retrieveProperties(List<Object> list) {
        if (!(list.isEmpty())) {
            DefaultTableModel model;
            JTable table;
            String[] columnNames= new String[4];
            int index=0;
            Object[][] data= new Object[list.size()][4];
            for (Field field : list.get(0).getClass().getDeclaredFields()) {
                columnNames[index]= field.getName();
                field.setAccessible(true);
                int j=0;
                for (Object object : list) {
                    Object value;
                    try {
                        value = field.get(object);
                        data[j][index]=value;
                        j++;
                    } catch (IllegalArgumentException e) {
                        e.printStackTrace();
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }
                }
                index++;

            }
            model= new DefaultTableModel(data, columnNames);
            table= new JTable( model);
            return table;
        }
        return null;
    }
}