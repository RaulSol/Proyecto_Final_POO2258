package JRMS.Persistencias;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Singleton {
    private String baseDatos;
    public static JRMS.Persistencias.Singleton _instance;
    private Connection connection;

    private Singleton(String database) {
        this.baseDatos = database;
        try {
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection("jdbc:sqlite:"+this.baseDatos);
        } catch (SQLException e){
            e.printStackTrace();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static JRMS.Persistencias.Singleton getInstance(String baseDatos) {
        if(_instance == null){
            _instance = new JRMS.Persistencias.Singleton(baseDatos);
        }else{
            System.out.println("Ya fué creada.");
        }
        return _instance;
    }


    public Connection getConnection() {
        return connection;
    }


}