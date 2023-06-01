package JRMS.Persistencias;

import JRMS.Modelo.Coffee;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class CoffeeDAO implements DAO {
    public CoffeeDAO() {
    }

    @Override
    public boolean insertar(Object obj) throws SQLException {
        String sqlInsert = "INSERT INTO cafe(estilo,paisOrigen,popularidad,sabor,url) VALUES(?,?,?,?,?)";
        int rowCount = 0;
        PreparedStatement pstm = Singleton.getInstance("cafe.db").getConnection().prepareStatement(sqlInsert);
        pstm.setString(1, ((Coffee)obj).getEstilo());
        pstm.setString(2, ((Coffee)obj).getPais());
        pstm.setString(3, ((Coffee)obj).getPopularidad());
        pstm.setString(4, ((Coffee)obj).getSabor());
        pstm.setString(5, ((Coffee)obj).getUrl());
        rowCount = pstm.executeUpdate();
        return rowCount > 0;
    }

    @Override
    public boolean update(Object obj) throws SQLException {
        String sqlUpdate = "UPDATE cafe SET estilo = ?, paisOrigen = ?, popularidad = ?, sabor = ?, url = ? WHERE id= ? ;";
        int rowCount = 0;
        PreparedStatement pstm = Singleton.getInstance("cafe.db").getConnection().prepareStatement(sqlUpdate);
        pstm.setString(1, ((Coffee)obj).getEstilo());
        pstm.setString(2, ((Coffee)obj).getPais());
        pstm.setString(3, ((Coffee)obj).getPopularidad());
        pstm.setString(4, ((Coffee)obj).getSabor());
        pstm.setString(5, ((Coffee)obj).getUrl());
        pstm.setInt(6,((Coffee)obj).getId());
        rowCount = pstm.executeUpdate();
        return rowCount > 0;
    }

    @Override
    public boolean delete(String id) throws SQLException {
        String sqlDelete = "DELETE FROM cafe WHERE id = ? ;";
        int rowCount = 0;
        PreparedStatement pstm = Singleton.getInstance("cafe.db").getConnection().prepareStatement(sqlDelete);
        pstm.setInt(1,Integer.parseInt(id));
        rowCount = pstm.executeUpdate();
        return rowCount > 0;
    }

    @Override
    public ArrayList btenerTodo() throws SQLException {
        ArrayList<Coffee> res = new ArrayList<>();
        String sql = "SELECT * FROM cafe";

            Statement stm = Singleton.getInstance("cafe.db").getConnection().createStatement();
            ResultSet rst = stm.executeQuery(sql);

            while (rst.next()){
                res.add(new Coffee(rst.getInt(1),rst.getString(2),rst.getString(3),
                        rst.getString(4),rst.getString(5),rst.getString(6)));
            }
        return res;
    }

    @Override
    public Object buscarPorid(String id) throws SQLException {
        String sql = "SELECT * FROM cafe WHERE id = ?;";
        Coffee cafe = null;

        PreparedStatement pstm = Singleton.getInstance("cafe.db").getConnection().prepareStatement(sql);
        pstm.setInt(1,Integer.parseInt(id));
        ResultSet rst = pstm.executeQuery();

        if (rst.next()) {
                cafe = new Coffee(rst.getInt(1), rst.getString(2), rst.getString(3),
                        rst.getString(4), rst.getString(5), rst.getString(6));
                return cafe;
            }
           return null;
    }
}
