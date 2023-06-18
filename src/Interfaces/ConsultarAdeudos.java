package Interfaces;

import Pojo.Adeudo;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class ConsultarAdeudos extends JFrame {
    private JList<Adeudo> jList ;
    private JLabel encabezado,nombreA, apellidoMA, apellidoPA, tipoA, conceptoA, montoA, fechaA, descripcionA, pagoA;
    private JTextField text1, text2, text3, text4, text5, text6, text7, text8;
    private DefaultListModel<Adeudo> elementosModel;
    private JPanel panelList, panelButton, panelContainer, paneLiz1, panelText1, panelCont1, paneLiz2, panelText2, paneLiz3, panelText3;
    private JButton regresar;

    public ConsultarAdeudos(){
        initializeComponents();
        configFrame();
        llenarAdeudo();
        setupPanelContainer();
        add(panelContainer);

        addActionListeners();

    }

    private void initializeComponents() {

        regresar= new JButton();
        jList= new JList<>();

        panelList = new JPanel();
        paneLiz1 = new JPanel();
        panelText1 = new JPanel();
        panelButton= new JPanel();
        panelContainer= new JPanel();
        paneLiz2 = new JPanel();
        panelText2 = new JPanel();
        paneLiz3 = new JPanel();
        panelText3 = new JPanel();
        panelCont1 = new JPanel();

        nombreA = new JLabel("Nombre del cliente:");
        apellidoPA = new JLabel("Apellido Paterno:");
        apellidoMA = new JLabel("Apellido Materno:");
        tipoA = new JLabel("Tipo de adeudo:");
        conceptoA = new JLabel("Concepto de adeudo:");
        montoA = new JLabel("Monto de adeudo:");
        fechaA = new JLabel("Fecha de adeudo:");
        descripcionA = new JLabel("Descripcion");
        pagoA = new JLabel("¿Registrar como pagado?");
        encabezado = new JLabel("Detalle del adeudo");

        text1 = new JTextField();
        text2 = new JTextField();
        text3 = new JTextField();
        text4 = new JTextField();
        text5 = new JTextField();
        text6 = new JTextField();
        text7 = new JTextField();
        text8 = new JTextField();

        regresar.setText("Regresar");


    }

    private void configFrame(){
        setTitle("Cnsulta de adeudos");
        setLayout(new FlowLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //pack();
        setVisible(true);
        setResizable(false);
        setSize(600, 600);
    }

    private void setupPanelContainer() {

        panelList.setLayout(new GridLayout(1, 0));
        panelList.add(jList);
        panelList.setPreferredSize(new Dimension(300,100));

        paneLiz1.setLayout(new GridLayout(4,0));
        paneLiz1.setPreferredSize(new Dimension(130, 100));
        paneLiz1.add(nombreA);
        paneLiz1.add(apellidoPA);
        paneLiz1.add(apellidoMA);
        paneLiz1.add(tipoA);

        panelText1.setLayout(new GridLayout(4,0));
        panelText1.add(text1);
        panelText1.add(text2);
        panelText1.add(text3);
        panelText1.add(text4);

        paneLiz2.setLayout(new GridLayout(4,0));
        paneLiz2.add(conceptoA);
        paneLiz2.add(montoA);
        paneLiz2.add(fechaA);
        paneLiz2.add(descripcionA);

        panelText2.setLayout(new GridLayout(4,0));
        panelText2.setPreferredSize(new Dimension(50, 10));
        panelText2.add(text5);
        panelText2.add(text6);
        panelText2.add(text7);
        panelText2.add(text8);

        paneLiz3.setLayout(new GridLayout(4,0));
        paneLiz3.add(pagoA);

        panelText2.setLayout(new GridLayout(4,0));
        panelText2.setPreferredSize(new Dimension(50, 10));
        panelText2.add(text5);

        panelCont1.setLayout(new GridLayout(1,0));
        panelCont1.add(paneLiz1);
        panelCont1.add(panelText1);

        panelCont1.setLayout(new GridLayout(1,0));
        panelCont1.add(paneLiz2);
        panelCont1.add(panelText2);

        panelButton.setLayout(new FlowLayout());
        panelButton.setPreferredSize(new Dimension(380, 50));
        panelButton.add(regresar);


        panelContainer.setLayout(new GridLayout(4, 0));
        panelContainer.add(panelList);
        panelContainer.add(encabezado);
        panelContainer.add(panelCont1);
        panelContainer.add(panelButton);

    }
    private void addActionListeners() {
        regresar.addActionListener(e -> {
            this.setVisible(false);
            new Principal().setVisible(true);
        });

        jList.addListSelectionListener(e -> {
            datos();
        });
    }

    public void llenarAdeudo(){
        elementosModel = new DefaultListModel<>();
        ArrayList<Adeudo> lista = RegistroAdeudo.getAdeudo();
        for (Adeudo elemento: lista) {
            elementosModel.addElement(elemento);
        }
        jList.setModel(elementosModel);
    }

    public void datos() {
        int indice = jList.getSelectedIndex();
        text1.setText(RegistroAdeudo.getAdeudo().get(indice).getNombreCliente());
        text2.setText(RegistroAdeudo.getAdeudo().get(indice).getApellidoP());
        text3.setText(RegistroAdeudo.getAdeudo().get(indice).getApellidoM());
        text4.setText(RegistroAdeudo.getAdeudo().get(indice).getTipoAdeudo());
        text5.setText(RegistroAdeudo.getAdeudo().get(indice).getConcepto());
        text6.setText(RegistroAdeudo.getAdeudo().get(indice).getMonto());
        text7.setText(RegistroAdeudo.getAdeudo().get(indice).getFecha());
        text8.setText(RegistroAdeudo.getAdeudo().get(indice).getDescripcion());

    }

}


