package JRMS.Controlador;

import JRMS.Modelo.Coffee;
import JRMS.Modelo.TablaCafe;
import JRMS.Persistencias.Singleton;
import JRMS.Vista.VCafe;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

public class Controller extends MouseAdapter {
    private VCafe view;
    private TablaCafe tblCafe;

    public Controller(VCafe view) {
        this.view = view;
        tblCafe = new TablaCafe();
        this.view.getTblCafe().setModel(tblCafe);
        this.view.getBtnAgregar().addMouseListener(this);
        this.view.getBtnCargar().addMouseListener(this);
        this.view.getTblCafe().addMouseListener(this);
        this.view.getBtnUpdate().addMouseListener(this);
        this.view.getBtnEliminar().addMouseListener(this);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource() == this.view.getBtnCargar()) {
            tblCafe.cargarDatos();
            this.view.getTblCafe().setModel(tblCafe);
            this.view.getTblCafe().updateUI();
        }
        if (e.getSource() == this.view.getBtnAgregar()) {
            Coffee cafe = new Coffee();
            cafe.setEstilo(this.view.getTxtEstilo().getText());
            cafe.setPais(this.view.getTxtPaisOrigen().getText());
            cafe.setPopularidad(this.view.getTxtPopularidad().getText());
            cafe.setSabor(this.view.getTxtSabor().getText());
            cafe.setUrl(this.view.getTxtUrl().getText());
            if (tblCafe.agregarCafe(cafe)) {
                JOptionPane.showMessageDialog(view, "Se agrego el cafe", "Confirmacion", JOptionPane.INFORMATION_MESSAGE);
                this.view.getTblCafe().updateUI();
            } else {
                JOptionPane.showMessageDialog(view, "Ha ocurrido un error", "Error", JOptionPane.ERROR_MESSAGE);
            }
            this.view.limpieza();
        }
        if (e.getSource() == view.getTblCafe()) {
            int index = this.view.getTblCafe().getSelectedRow();
            Coffee tmp = tblCafe.getCoffeeIndex(index);
            try {
                this.view.getLblIcon().setIcon(tmp.getImagen());
            } catch (MalformedURLException urle) {
                System.out.println(urle.getMessage());
            }
        }
        if (e.getSource() == this.view.getBtnUpdate()) {
            int index = this.view.getTblCafe().getSelectedRow();
            Coffee tmp = tblCafe.getCoffeeIndex(index);
            tmp.setEstilo(this.view.getTxtEstilo1().getText());
            tmp.setPais(this.view.getTxtPaisOrigen1().getText());
            tmp.setPopularidad(this.view.getTxtPopularidad1().getText());
            tmp.setSabor(this.view.getTxtSabor1().getText());
            tmp.setUrl(this.view.getTxtUrl1().getText());
            if (tblCafe.actualizarCafe(tmp)){
                JOptionPane.showMessageDialog(view,"Datos actualizados","Actualizacion",JOptionPane.INFORMATION_MESSAGE);
                this.view.getTblCafe().updateUI();
            }
            this.view.limpieza();
        }
        if (e.getSource() == this.view.getBtnEliminar()) {
            int index = this.view.getTblCafe().getSelectedRow();
            Coffee tmp = tblCafe.getCoffeeIndex(index);
            String id = String.valueOf(tmp.getId());
            int resultado = JOptionPane.showConfirmDialog(view,"Seguro que quieres eliminar?");
            if (resultado == JOptionPane.YES_NO_OPTION){
                if (tblCafe.eliminarCafe(id)){
                    JOptionPane.showMessageDialog(view,"Se ha eliminado el elemento seleccionado");
                }
            }else {
                JOptionPane.showMessageDialog(view, "No se ha eliminado");
            }
                this.view.getTblCafe().updateUI();
        }
    }
}
