package Interfaces;

import Interfaces.Principal;
import Interfaces.RegistroCliente;
import Pojo.Adeudo;
import Pojo.Cliente;
import Util.UtilCombo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;

public class RegistroAdeudo extends JFrame implements ItemListener {
    static ArrayList<Adeudo> adeudos= new ArrayList<Adeudo>();
    private JList<Cliente> jList ;
    private JPanel panelButton, panelList,panelContainer, panelText1, panelText2, panelText3, paneLiz1, panelLiz2, paneLiz3, paneLiz4,panelText4, panelCont1, panelCont2;
    private JLabel nombre, apellidoP, apellidoM, tipoAdeudo, conceptoAdeudo, montoAdeudo, fechaAdeudo, descripcion, titulo;
    private JTextField text1, text2, text3, text4, text5, text6, text7, text8;
    private JComboBox<String> tiposAdeudo;
    private DefaultListModel<Cliente> elementosModel;
    private JButton cancelar, guardar;

    private static final ArrayList<String> listaTipos= UtilCombo.tiposAdeudo();

    public RegistroAdeudo(){
        initializeComponents();
        setupFrame();
        llenarCliente();
        llenarCombo();
        setupPanelContainer();
        add(panelContainer);

        addActionListeners();
        tiposAdeudo.addItemListener(this);

    }
    private void initializeComponents() {
        EventClick eventClick = new EventClick();
        jList= new JList<>();

        panelContainer = new JPanel();
        paneLiz1 = new JPanel();
        panelLiz2 = new JPanel();
        paneLiz3 = new JPanel();
        panelText1 = new JPanel();
        panelText2 = new JPanel();
        panelText3 = new JPanel();
        panelCont1 = new JPanel();
        panelCont2 = new JPanel();
        paneLiz4 = new JPanel();
        panelText4 = new JPanel();
        panelButton = new JPanel();
        panelList = new JPanel();

        titulo = new JLabel("Registro de nuevo adeudo");
        nombre = new JLabel("Nombre del Cliente: ");
        apellidoP = new JLabel("Apellido Paterno:");
        apellidoM = new JLabel("Apellido Materno:");
        tipoAdeudo = new JLabel("Tipo adeudo:");
        conceptoAdeudo = new JLabel("Concepto de adeudo:");
        montoAdeudo = new JLabel("Monto de adeudo:");
        fechaAdeudo = new JLabel("Fecha del adeudo:");
        descripcion = new JLabel("Descripcion:");


        text1 = new JTextField();
        text2 = new JTextField();
        text3 = new JTextField();
        text4 = new JTextField();
        text5 = new JTextField();
        text6 = new JTextField();
        text7 = new JTextField();
        text8 = new JTextField();

        tiposAdeudo = new JComboBox<>();

        cancelar = new JButton("Cancelar");
        guardar = new JButton("Guardar");
    }

    private void setupFrame() {
        setTitle("Registrar Adeudo");
        setLayout(new FlowLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setResizable(true);
        setSize(600, 500);
    }

    private void setupPanelContainer() {
        panelList.setLayout(new GridLayout(1, 0));
        panelList.add(jList);
        panelList.setPreferredSize(new Dimension(300,100));

        paneLiz1.setLayout(new GridLayout(4,0));
        paneLiz1.setPreferredSize(new Dimension(130, 100));
        paneLiz1.add(nombre);
        paneLiz1.add(apellidoP);
        paneLiz1.add(apellidoM);
        paneLiz1.add(tipoAdeudo);

        panelText1.setLayout(new GridLayout(4,0));
        panelText1.add(text1);
        panelText1.add(text2);
        panelText1.add(text3);
        panelText1.add(tiposAdeudo);

        panelLiz2.setLayout(new GridLayout(4,0));
        panelLiz2.add(conceptoAdeudo);
        panelLiz2.add(montoAdeudo);
        panelLiz2.add(fechaAdeudo);
        panelLiz2.add(descripcion);

        panelText2.setLayout(new GridLayout(4,0));
        panelText2.setPreferredSize(new Dimension(50, 10));
        panelText2.add(text5);
        panelText2.add(text6);
        panelText2.add(text7);
        panelText2.add(text8);

        panelCont1.setLayout(new GridLayout(1,0));
        panelCont1.add(paneLiz1);
        panelCont1.add(panelText1);

        panelCont1.setLayout(new GridLayout(1,0));
        panelCont1.add(panelLiz2);
        panelCont1.add(panelText2);

        panelButton.setLayout(new FlowLayout());
        panelButton.setPreferredSize(new Dimension(200, 50));
        cancelar.setBackground(new Color(0x65000C));
        cancelar.setForeground(new Color(0xFFFFFF));
        guardar.setBackground(new Color(0x18910D));
        guardar.setForeground(new Color(0xFFFFFF));
        panelButton.add(cancelar);
        panelButton.add(guardar);

        panelContainer.setLayout(new GridLayout(4, 0));
        titulo.setHorizontalAlignment(SwingConstants.CENTER);
        panelContainer.add(panelList);
        panelContainer.add(titulo);
        panelContainer.add(panelCont1);
        panelContainer.add(panelButton);

        add(panelContainer);
    }

    private void addActionListeners() {
        guardar.addActionListener(new EventClick1());
        cancelar.addActionListener(e -> {
            this.setVisible(false);
            new Principal().setVisible(true);
        });
        jList.addListSelectionListener(e -> {
            datos();
        });
    }

    public void llenarCliente(){
        elementosModel = new DefaultListModel<>();
        ArrayList<Cliente> lista = RegistroCliente.getCliente();
        for (Cliente elemento: lista) {
            elementosModel.addElement(elemento);
        }
        jList.setModel(elementosModel);
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        if (e.getSource() == tiposAdeudo){
            String item2 = (String) tiposAdeudo.getSelectedItem();
            text4.setText(item2);
        }
    }

    public class EventClick implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == tiposAdeudo){
                String item2 = (String) tiposAdeudo.getSelectedItem();
                text4.setText(item2);

            }
        }
    }
    public void datos(){
        int indice = jList.getSelectedIndex();
        text1.setText(RegistroCliente.getCliente().get(indice).getNombre());
        text2.setText(RegistroCliente.getCliente().get(indice).getApellidoP());
        text3.setText(RegistroCliente.getCliente().get(indice).getApellidoM());
    }

    public class EventClick1 implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String nombreCliente = text1.getText();
            String apellidoP = text2.getText();
            String apellidoM = text3.getText();
            String tipo= text4.getText();
            String concepto = text5.getText();
            String monto = text6.getText();
            String fecha = text7.getText();
            String descripcion = text8.getText();

            adeudos.add(new Adeudo(nombreCliente,apellidoP,apellidoM,tipo,concepto,monto,fecha,descripcion));
            clearTextFields();
        }
    }
    private void llenarCombo(){
        for (String s: listaTipos) {
            tiposAdeudo.addItem(s);
        }
    }
    public static ArrayList<Adeudo> getAdeudo(){
        return adeudos;
    }
    private void clearTextFields() {
        text1.setText("");
        text2.setText("");
        text3.setText("");
        text4.setText("");
        text5.setText("");
        text6.setText("");
        text7.setText("");
        text8.setText("");
    }
}
