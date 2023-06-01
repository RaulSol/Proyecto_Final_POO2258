package JRMS;


import JRMS.Controlador.Controller;
import JRMS.Modelo.Coffee;
import JRMS.Persistencias.CoffeeDAO;
import JRMS.Vista.VCafe;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {
        VCafe view = new VCafe("Cafe BD");
        Controller con = new Controller(view);
    }
}