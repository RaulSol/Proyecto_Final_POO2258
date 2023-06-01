package JRMS.Modelo;

import javax.swing.*;
import java.net.MalformedURLException;
import java.net.URL;

public class Coffee {
    private int id;
    private String estilo;
    private String pais;
    private String popularidad;
    private String sabor;
    private String url;

    public Coffee() {
    }

    public Coffee(int id, String estilo, String pais, String popularidad, String sabor, String url) {
        this.id = id;
        this.estilo = estilo;
        this.pais = pais;
        this.popularidad = popularidad;
        this.sabor = sabor;
        this.url = url;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEstilo() {
        return estilo;
    }

    public void setEstilo(String estilo) {
        this.estilo = estilo;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getPopularidad() {
        return popularidad;
    }

    public void setPopularidad(String popularidad) {
        this.popularidad = popularidad;
    }

    public String getSabor() {
        return sabor;
    }

    public void setSabor(String sabor) {
        this.sabor = sabor;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "Coffee{" +
                "id=" + id +
                ", estilo='" + estilo + '\'' +
                ", pais='" + pais + '\'' +
                ", popularidad='" + popularidad + '\'' +
                ", sabor='" + sabor + '\'' +
                ", url='" + url + '\'' +
                '}';
    }

    public ImageIcon getImagen() throws MalformedURLException{
            URL urlImagen = new URL(this.url);
        return new ImageIcon(urlImagen);
    }

}