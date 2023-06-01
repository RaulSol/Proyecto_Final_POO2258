package JRMS.Guia;

import JRMS.Persistencias.Singleton;
import JRMS.Modelo.Coffee;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class coffeeDB {
    public coffeeDB() {
    }

    public void insertarStatement(){
        try{
            Statement stm = Singleton.getInstance("cafe.db").getConnection().createStatement();
            String sqlInsert = "INSERT INTO cafe(estilo,paisOrigen,popularidad,sabor,url) VALUES('Capuccino','Francia','Alta','Dulce','a')";
            int rowCount = stm.executeUpdate(sqlInsert);
            System.out.println("Se insertaron " + rowCount + " campos");
        }catch (SQLException sqle){
            System.out.println("Error");
        }
    }
    public void insertarPreparedStatement(){
        String estilo = "Americano";
        String pais = "USA";
        String popularidad = "Alta";
        String sabor = "Amargo";
        String url = "abcdefg";
        String sqlInsert = "INSERT INTO cafe(estilo,paisOrigen,popularidad,sabor,url) VALUES(?,?,?,?,?)";
        try {
            PreparedStatement pstm = Singleton.getInstance("cafe.db").getConnection().prepareStatement(sqlInsert);
            pstm.setString(1,estilo);
            pstm.setString(2,pais);
            pstm.setString(3,popularidad);
            pstm.setString(4,sabor);
            pstm.setString(5,url);
            int rowCount = pstm.executeUpdate();
            System.out.println("Se añadieron " + rowCount + " elementos");
        }catch (SQLException sqle){
            System.out.println("Error " + sqle.getMessage());
        }
    }
    public boolean insertarCafe(Coffee cafe) throws SQLException {
        int rowCount = 0;
        String sqlInsert = "INSERT INTO cafe(estilo,paisOrigen,popularidad,sabor,url) VALUES(?,?,?,?,?)";
        PreparedStatement pstm = Singleton.getInstance("cafe.db").getConnection().prepareStatement(sqlInsert);
        pstm.setString(1, cafe.getEstilo());
        pstm.setString(2, cafe.getPais());
        pstm.setString(3, cafe.getPopularidad());
        pstm.setString(4, cafe.getSabor());
        pstm.setString(5, cafe.getUrl());
        rowCount = pstm.executeUpdate();
        System.out.println("Se añadieron " + rowCount + " elementos");
        return rowCount > 0;
        }
    public Coffee buscarPorId(int id){
        String sql = "SELECT * FROM cafe WHERE id = ?;";
        Coffee cafe = null;
        try {
            PreparedStatement pstm = Singleton.getInstance("cafe.db").getConnection().prepareStatement(sql);
            pstm.setInt(1,id);
            ResultSet rst = pstm.executeQuery();
            if (rst.next()){
                cafe = new Coffee(rst.getInt(1),rst.getString(2),rst.getString(3),
                        rst.getString(4),rst.getString(5),rst.getString(6));

            }
        }catch (SQLException sqle){
            System.out.println("Error " + sqle.getMessage());
        }
        return cafe;
    }
    public ArrayList<Coffee> obtenerTodo(){
        ArrayList<Coffee> res = new ArrayList<>();
        String sql = "SELECT * FROM cafe";
        try{
            Statement stm = Singleton.getInstance("cafe.db").getConnection().createStatement();
            ResultSet rst = stm.executeQuery(sql);
            while (rst.next()){
                res.add(new Coffee(rst.getInt(1),rst.getString(2),rst.getString(3),
                        rst.getString(4),rst.getString(5),rst.getString(6)));

            }
        }catch (SQLException sqle){
            System.out.println("Error " + sqle.getMessage());
        }
        return res;
        }
    }
