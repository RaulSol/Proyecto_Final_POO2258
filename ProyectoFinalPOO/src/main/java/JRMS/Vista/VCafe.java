package JRMS.Vista;

import javax.swing.*;
import java.awt.*;

public class VCafe extends JFrame {

    //Labels
    private JLabel lblId;
    private JLabel lblEstilo;
    private JLabel lblPaisOrigen;
    private JLabel lblPopularidad;
    private JLabel lblSabor;
    private JLabel lblUrl;
    private JLabel lblIcon;


    //Text Fields
    private JTextField txtId;
    private JTextField txtEstilo;
    private JTextField txtPaisOrigen;
    private JTextField txtPopularidad;
    private JTextField txtSabor;
    private JTextField txtUrl;


    //Tables
    private JTable tblCafe;
    private JScrollPane scrollPane;


    //Panels & Layout
    private GridLayout layout;
    private JPanel panel1;
    private JPanel panel2;
    private JPanel panel3;
    private JPanel panel4;


    //Elementos panel4
    private JLabel lblId1;
    private JLabel lblEstilo1;
    private JLabel lblPaisOrigen1;
    private JLabel lblPopularidad1;
    private JLabel lblSabor1;
    private JLabel lblUrl1;
    private JTextField txtId1;
    private JTextField txtEstilo1;
    private JTextField txtPaisOrigen1;
    private JTextField txtPopularidad1;
    private JTextField txtSabor1;
    private JTextField txtUrl1;


    //Buttons
    private JButton btnAgregar;
    private JButton btnCargar;
    private JButton btnEliminar;
    private JButton btnUpdate;

    public VCafe(String title) throws HeadlessException {
        super(title);

        //Inicio
        this.setSize(1200,1000);
        layout = new GridLayout(2,2);
        this.getContentPane().setLayout(layout);


        //Panel 1
        panel1 = new JPanel(new FlowLayout());
        panel1.setBackground(new Color(142, 239, 135));
        lblId = new JLabel("id: ");
        lblEstilo = new JLabel("Estilo de cafe: ");
        lblPaisOrigen = new JLabel("Pais de origen: ");
        lblPopularidad = new JLabel("Popularidad: ");
        lblSabor = new JLabel("Sabor: ");
        lblUrl = new JLabel("URL:");
        txtId = new JTextField(2);
        txtId.setText("0");
        txtId.setEnabled(false);
        txtEstilo = new JTextField(12);
        txtPaisOrigen = new JTextField(15);
        txtPopularidad = new JTextField(15);
        txtSabor = new JTextField(15);
        txtUrl = new JTextField(15);
        btnAgregar = new JButton("Agregar");
        panel1.add(lblId);
        panel1.add(txtId);
        panel1.add(lblEstilo);
        panel1.add(txtEstilo);
        panel1.add(lblPaisOrigen);
        panel1.add(txtPaisOrigen);
        panel1.add(lblPopularidad);
        panel1.add(txtPopularidad);
        panel1.add(lblSabor);
        panel1.add(txtSabor);
        panel1.add(lblUrl);
        panel1.add(txtUrl);
        panel1.add(btnAgregar);



        //Panel2
        panel2 = new JPanel(new FlowLayout());
        panel2.setBackground(new Color(252, 238, 117));
        tblCafe = new JTable();
        scrollPane = new JScrollPane(tblCafe);
        btnCargar = new JButton("Cargar Datos");
        panel2.add(btnCargar);
        panel2.add(scrollPane);


        //Panel3
        panel3 = new JPanel(new FlowLayout());
        panel3.setBackground(new Color(255, 134, 72));
        lblIcon = new JLabel("...");
        panel3.add(lblIcon);


        //panel4
        panel4 = new JPanel(new FlowLayout());
        panel4.setBackground(new Color(255, 41, 65));
        lblId1 = new JLabel("id: ");
        lblEstilo1 = new JLabel("Estilo de cafe: ");
        lblPaisOrigen1 = new JLabel("Pais de origen: ");
        lblPopularidad1 = new JLabel("Popularidad: ");
        lblSabor1 = new JLabel("Sabor: ");
        lblUrl1 = new JLabel("URL:");
        txtId1 = new JTextField(2);
        txtEstilo1 = new JTextField(12);
        txtPaisOrigen1 = new JTextField(15);
        txtPopularidad1 = new JTextField(15);
        txtSabor1 = new JTextField(15);
        txtUrl1 = new JTextField(15);
        btnUpdate = new JButton("Actualizar");
        btnEliminar = new JButton("Borrar");
        panel4.add(lblId1);
        panel4.add(txtId1);
        panel4.add(lblEstilo1);
        panel4.add(txtEstilo1);
        panel4.add(lblPaisOrigen1);
        panel4.add(txtPaisOrigen1);
        panel4.add(lblPopularidad1);
        panel4.add(txtPopularidad1);
        panel4.add(lblSabor1);
        panel4.add(txtSabor1);
        panel4.add(lblUrl1);
        panel4.add(txtUrl1);
        panel4.add(btnUpdate);
        panel4.add(btnEliminar);



        //Vista
        this.getContentPane().add(panel1,0);
        this.getContentPane().add(panel2,1);
        this.getContentPane().add(panel3,2);
        this.getContentPane().add(panel4,3);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    public JLabel getLblId() {
        return lblId;
    }

    public void setLblId(JLabel lblId) {
        this.lblId = lblId;
    }

    public JLabel getLblEstilo() {
        return lblEstilo;
    }

    public void setLblEstilo(JLabel lblEstilo) {
        this.lblEstilo = lblEstilo;
    }

    public JLabel getLblPaisOrigen() {
        return lblPaisOrigen;
    }

    public void setLblPaisOrigen(JLabel lblPaisOrigen) {
        this.lblPaisOrigen = lblPaisOrigen;
    }

    public JLabel getLblPopularidad() {
        return lblPopularidad;
    }

    public void setLblPopularidad(JLabel lblPopularidad) {
        this.lblPopularidad = lblPopularidad;
    }

    public JLabel getLblSabor() {
        return lblSabor;
    }

    public void setLblSabor(JLabel lblSabor) {
        this.lblSabor = lblSabor;
    }

    public JLabel getLblUrl() {
        return lblUrl;
    }

    public void setLblUrl(JLabel lblUrl) {
        this.lblUrl = lblUrl;
    }

    public JTextField getTxtId() {
        return txtId;
    }

    public void setTxtId(JTextField txtId) {
        this.txtId = txtId;
    }

    public JTextField getTxtEstilo() {
        return txtEstilo;
    }

    public void setTxtEstilo(JTextField txtEstilo) {
        this.txtEstilo = txtEstilo;
    }

    public JTextField getTxtPaisOrigen() {
        return txtPaisOrigen;
    }

    public void setTxtPaisOrigen(JTextField txtPaisOrigen) {
        this.txtPaisOrigen = txtPaisOrigen;
    }

    public JTextField getTxtPopularidad() {
        return txtPopularidad;
    }

    public void setTxtPopularidad(JTextField txtPopularidad) {
        this.txtPopularidad = txtPopularidad;
    }

    public JTextField getTxtSabor() {
        return txtSabor;
    }

    public void setTxtSabor(JTextField txtSabor) {
        this.txtSabor = txtSabor;
    }

    public JTextField getTxtUrl() {
        return txtUrl;
    }

    public void setTxtUrl(JTextField txtUrl) {
        this.txtUrl = txtUrl;
    }

    public JTable getTblCafe() {
        return tblCafe;
    }

    public void setTblCafe(JTable tblCafe) {
        this.tblCafe = tblCafe;
    }

    public JScrollPane getScrollPane() {
        return scrollPane;
    }

    public void setScrollPane(JScrollPane scrollPane) {
        this.scrollPane = scrollPane;
    }

    @Override
    public GridLayout getLayout() {
        return layout;
    }

    public void setLayout(GridLayout layout) {
        this.layout = layout;
    }

    public JPanel getPanel1() {
        return panel1;
    }

    public void setPanel1(JPanel panel1) {
        this.panel1 = panel1;
    }

    public JPanel getPanel2() {
        return panel2;
    }

    public void setPanel2(JPanel panel2) {
        this.panel2 = panel2;
    }

    public JPanel getPanel3() {
        return panel3;
    }

    public void setPanel3(JPanel panel3) {
        this.panel3 = panel3;
    }

    public JPanel getPanel4() {
        return panel4;
    }

    public void setPanel4(JPanel panel4) {
        this.panel4 = panel4;
    }

    public JButton getBtnAgregar() {
        return btnAgregar;
    }

    public void setBtnAgregar(JButton btnAgregar) {
        this.btnAgregar = btnAgregar;
    }

    public JButton getBtnCargar() {
        return btnCargar;
    }

    public void setBtnCargar(JButton btnCargar) {
        this.btnCargar = btnCargar;
    }

    public JButton getBtnEliminar() {
        return btnEliminar;
    }

    public void setBtnEliminar(JButton btnEliminar) {
        this.btnEliminar = btnEliminar;
    }

    public JLabel getLblIcon() {
        return lblIcon;
    }

    public void setLblIcon(JLabel lblIcon) {
        this.lblIcon = lblIcon;
    }

    public JButton getBtnUpdate() {
        return btnUpdate;
    }

    public void setBtnUpdate(JButton btnUpdate) {
        this.btnUpdate = btnUpdate;
    }

    public JLabel getLblId1() {
        return lblId1;
    }

    public void setLblId1(JLabel lblId1) {
        this.lblId1 = lblId1;
    }

    public JLabel getLblEstilo1() {
        return lblEstilo1;
    }

    public void setLblEstilo1(JLabel lblEstilo1) {
        this.lblEstilo1 = lblEstilo1;
    }

    public JLabel getLblPaisOrigen1() {
        return lblPaisOrigen1;
    }

    public void setLblPaisOrigen1(JLabel lblPaisOrigen1) {
        this.lblPaisOrigen1 = lblPaisOrigen1;
    }

    public JLabel getLblPopularidad1() {
        return lblPopularidad1;
    }

    public void setLblPopularidad1(JLabel lblPopularidad1) {
        this.lblPopularidad1 = lblPopularidad1;
    }

    public JLabel getLblSabor1() {
        return lblSabor1;
    }

    public void setLblSabor1(JLabel lblSabor1) {
        this.lblSabor1 = lblSabor1;
    }

    public JLabel getLblUrl1() {
        return lblUrl1;
    }

    public void setLblUrl1(JLabel lblUrl1) {
        this.lblUrl1 = lblUrl1;
    }

    public JTextField getTxtId1() {
        return txtId1;
    }

    public void setTxtId1(JTextField txtId1) {
        this.txtId1 = txtId1;
    }

    public JTextField getTxtEstilo1() {
        return txtEstilo1;
    }

    public void setTxtEstilo1(JTextField txtEstilo1) {
        this.txtEstilo1 = txtEstilo1;
    }

    public JTextField getTxtPaisOrigen1() {
        return txtPaisOrigen1;
    }

    public void setTxtPaisOrigen1(JTextField txtPaisOrigen1) {
        this.txtPaisOrigen1 = txtPaisOrigen1;
    }

    public JTextField getTxtPopularidad1() {
        return txtPopularidad1;
    }

    public void setTxtPopularidad1(JTextField txtPopularidad1) {
        this.txtPopularidad1 = txtPopularidad1;
    }

    public JTextField getTxtSabor1() {
        return txtSabor1;
    }

    public void setTxtSabor1(JTextField txtSabor1) {
        this.txtSabor1 = txtSabor1;
    }

    public JTextField getTxtUrl1() {
        return txtUrl1;
    }

    public void setTxtUrl1(JTextField txtUrl1) {
        this.txtUrl1 = txtUrl1;
    }

    public void limpieza(){
        txtEstilo.setText("");
        txtPaisOrigen.setText("");
        txtPopularidad.setText("");
        txtSabor.setText("");
        txtUrl.setText("");
    }
}
