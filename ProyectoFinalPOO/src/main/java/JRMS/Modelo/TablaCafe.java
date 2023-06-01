package JRMS.Modelo;

import JRMS.Persistencias.CoffeeDAO;

import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;
import java.sql.SQLException;
import java.util.ArrayList;

public class TablaCafe implements TableModel {
    public static final int COLUMNS = 6;
    private ArrayList<Coffee> datos;
    private CoffeeDAO coffeeDAO;

    public TablaCafe() {
        coffeeDAO = new CoffeeDAO();
        datos = new ArrayList<>();
    }

    public TablaCafe(ArrayList<Coffee> datos) {
        this.datos = datos;
        coffeeDAO = new CoffeeDAO();
    }

    @Override
    public int getRowCount() {
        return datos.size();
    }

    @Override
    public int getColumnCount() {
        return COLUMNS;
    }

    @Override
    public String getColumnName(int columnIndex) {
        switch (columnIndex) {
            case 0:
                return "Id";
            case 1:
                return "Estilo";
            case 2:
                return "Pais Origen";
            case 3:
                return "Popularidad";
            case 4:
                return "Sabor";
            case 5:
                return "URL";
        }
        return null;
    }

    @Override
    public Class<?> getColumnClass(int rowIndex) {
        switch (rowIndex) {
            case 0:
                return Integer.class;
            case 1, 2, 3, 4, 5:
                return String.class;
        }
        return null;
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return true;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Coffee tmp = datos.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return tmp.getId();
            case 1:
                return tmp.getEstilo();
            case 2:
                return tmp.getPais();
            case 3:
                return tmp.getPopularidad();
            case 4:
                return tmp.getSabor();
            case 5:
                return tmp.getUrl();
        }
        return null;
    }

    @Override
    public void setValueAt(Object a, int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0:
                //datos.get(rowIndex).setId((String) a);
                break;
            case 1:
                datos.get(rowIndex).setEstilo((String) a);
                break;
            case 2:
                datos.get(rowIndex).setPais((String) a);
                break;
            case 3:
                datos.get(rowIndex).setPopularidad((String) a);
                break;
            case 4:
                datos.get(rowIndex).setSabor((String) a);
                break;
            case 5:
                datos.get(rowIndex).setUrl((String) a);
                break;
            default:
                System.out.println("No se modifica nada");
        }

    }

    @Override
    public void addTableModelListener(TableModelListener l) {

    }

    @Override
    public void removeTableModelListener(TableModelListener l) {
    }

    public void cargarDatos() {
        try {
            datos = coffeeDAO.btenerTodo();
        } catch (SQLException sqle) {
            System.out.println("Error " + sqle.getMessage());
        }

    }

    public boolean agregarCafe(Coffee cafe) {
        boolean res = false;
        try {
            if (coffeeDAO.insertar(cafe)) {
                datos.add(cafe);
                res = true;
            } else {
                res = false;

            }
        } catch (SQLException sqle) {
            System.out.println("Error " + sqle.getMessage());
        }
        return res;
    }

    public boolean actualizarCafe(Coffee cafe) {
        boolean res = false;
        try {
            if (coffeeDAO.update(cafe)) {
                datos.add(cafe);
                res = true;
            } else {
                res = false;

            }
        } catch (SQLException sqle) {
            System.out.println("Error " + sqle.getMessage());
        }
        return res;
    }

    public Coffee getCoffeeIndex(int index) {
        return datos.get(index);
    }

    public boolean eliminarCafe(String id){
        boolean res = false;
        try {
            if (coffeeDAO.delete(id)) {
                res = true;
            } else {
                res = false;
            }
        } catch (SQLException sqle) {
            System.out.println("Error " + sqle.getMessage());
        }
        return res;
    }
}
