package Interfaces;

import Interfaces.Principal;
import Pojo.Cliente;
import Util.UtilCombo;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;

public class RegistroCliente extends JFrame implements ChangeListener, ItemListener {
    static ArrayList<Cliente> clientes= new ArrayList<Cliente>();
    private JPanel panelCanvas;
    private JPanel   panelContainer2, panelImagen,panelButton, panelTitulo, panelRadio, panelRadio2,panelContainer, panelText1, panelText2, panelText3, paneLiz1, panelLiz2, paneLiz3, paneLiz4,panelText4, panelCont1, panelCont2;
    private JLabel datosPersonales, nombre, apellidoP, apellidoM, datosContacto, sTelefono, sCorreo, telefono, correo, datosUbicacion, estado, ciudad, colonia, codigoP;
    private JTextField text1, text2, text3, text4, text5, text6, text7, text8,text9;
    private JRadioButton radio1,radio2, radio3, radio4;
    private ButtonGroup buttonGroup, buttonGroup2;
    private JComboBox<String> estados;
    private JComboBox<String> ciudades;
    private JButton regresar, guardar;


    private static final ArrayList<String> listaEstados = UtilCombo.listaEstados();
    private static final ArrayList<String> listaCiudades = UtilCombo.listaCiudades();

    public RegistroCliente(){
        initializeComponents();
        setupFrame();
        setupPanelContainer();
        llenarCombo();
        add(panelContainer);

        addActionListeners();
        radio1.addChangeListener(this);
        radio2.addChangeListener(this);
        radio3.addChangeListener(this);
        radio4.addChangeListener(this);
        estados.addItemListener(this);
        ciudades.addItemListener(this);

    }

    private void initializeComponents() {
        EventClick eventClick = new EventClick();

        panelCanvas = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                ImageIcon imagen = new ImageIcon("C:\\Users\\Nayeli Velasco\\IdeaProjects\\InterfazPortonAzul\\src\\Imagen\\cliente.png"); // Reemplaza "ruta_de_la_imagen.jpg" por la ruta correcta de la imagen
                Image img = imagen.getImage();
                g.drawImage(img, 250, 23, null);
            }
        };

        panelContainer = new JPanel();
        paneLiz1 = new JPanel();
        panelLiz2 = new JPanel();
        paneLiz3 = new JPanel();
        panelText1 = new JPanel();
        panelText2 = new JPanel();
        panelText3 = new JPanel();
        panelCont1 = new JPanel();
        panelCont2 = new JPanel();
        panelRadio = new JPanel();
        panelRadio2 = new JPanel();
        panelTitulo = new JPanel();
        paneLiz4 = new JPanel();
        panelText4 = new JPanel();
        panelButton = new JPanel();
        panelImagen = new JPanel();
        panelContainer2 = new JPanel();

        datosPersonales = new JLabel("Datos personales");
        nombre = new JLabel("Nombre del Cliente: ");
        apellidoP = new JLabel("Apellido Paterno:");
        apellidoM = new JLabel("Apellido Materno:");
        datosContacto = new JLabel("Datos de contacto");
        sTelefono = new JLabel("¿Tiene telefono?");
        telefono = new JLabel("Telefono:");
        sCorreo = new JLabel("¿Tiene correo?");
        correo = new JLabel("Correo:");
        datosUbicacion = new JLabel("Datos de ubicacion");
        estado = new JLabel("Estado:");
        ciudad = new JLabel("Ciudad:");
        colonia = new JLabel("Colonia/Barrio/Agencia:");
        codigoP = new JLabel("Codigo postal:");

        text1 = new JTextField();
        text2 = new JTextField();
        text3 = new JTextField();
        text4 = new JTextField();
        text5 = new JTextField();
        text6 = new JTextField();
        text7 = new JTextField();
        text8 = new JTextField();
        text9 = new JTextField();

        radio1= new JRadioButton("Si");
        radio2= new JRadioButton("No");
        radio3= new JRadioButton("Si");
        radio4= new JRadioButton("No");

        buttonGroup = new ButtonGroup();
        buttonGroup2 = new ButtonGroup();

        estados = new JComboBox<>();
        ciudades = new JComboBox<>();

        regresar = new JButton("Regresar");
        guardar = new JButton("Guardar");
    }

    private void setupFrame() {
        setTitle("Registrar Pojo.Cliente");
        setLayout(new FlowLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setResizable(true);
        setSize(800, 800);
    }
    private void setupPanelContainer() {
        panelImagen.setLayout(new BorderLayout());
        panelImagen.setPreferredSize(new Dimension(200, 150));
        panelImagen.add(panelCanvas, BorderLayout.CENTER);

        paneLiz1.setLayout(new GridLayout(4,0));
        paneLiz1.setPreferredSize(new Dimension(130, 0));
        paneLiz1.add(nombre);
        paneLiz1.add(apellidoP);
        paneLiz1.add(apellidoM);

        panelText1.setLayout(new GridLayout(4,0));
        panelText1.setPreferredSize(new Dimension(130, 0));
        panelText1.add(text1);
        panelText1.add(text2);
        panelText1.add(text3);

        panelLiz2.setLayout(new GridLayout(4,0));
        panelLiz2.setPreferredSize(new Dimension(130, 0));
        panelLiz2.add(sTelefono);
        panelLiz2.add(telefono);
        panelLiz2.add(sCorreo);
        panelLiz2.add(correo);

        panelText2.setLayout(new GridLayout(4,0));
        panelText2.setPreferredSize(new Dimension(130, 0));
        panelText2.add(panelRadio);
        panelText2.add(text4);
        panelText2.add(panelRadio2);
        panelText2.add(text5);

        paneLiz3.setLayout(new GridLayout(2,0));
        paneLiz3.setPreferredSize(new Dimension(130, 50));
        paneLiz3.add(estado);
        paneLiz3.add(ciudad);

        panelText3.setLayout(new GridLayout(2,0));
        panelText3.setPreferredSize(new Dimension(130, 0));
        panelText3.add(estados);
        panelText3.add(ciudades);

        paneLiz4.setLayout(new GridLayout(2,0));
        paneLiz4.setPreferredSize(new Dimension(150, 50));
        paneLiz4.add(colonia);
        paneLiz4.add(codigoP);

        panelText4.setLayout(new GridLayout(2,0));
        panelText4.add(text8);
        panelText4.add(text9);

        panelCont1.setLayout(new GridLayout(1,0));
        panelCont1.setPreferredSize(new Dimension(150, 0));
        panelCont1.add(paneLiz1);
        panelCont1.add(panelText1);

        panelCont1.setLayout(new GridLayout(1,0));
        panelCont1.setPreferredSize(new Dimension(150, 0));
        panelCont1.add(panelLiz2);
        panelCont1.add(panelText2);

        panelCont2.setLayout(new GridLayout(1,0));
        panelCont2.setPreferredSize(new Dimension(150, 50));
        panelCont2.add(paneLiz3);
        panelCont2.add(panelText3);

        panelCont2.setLayout(new GridLayout(1,0));
        panelCont2.setPreferredSize(new Dimension(150, 50));
        panelCont2.add(paneLiz4);
        panelCont2.add(panelText4);

        panelTitulo.setLayout(new GridLayout(1,0));
        panelTitulo.setPreferredSize(new Dimension(150, 70));
        panelTitulo.add(datosPersonales);
        panelTitulo.add(datosContacto);

        panelRadio.setLayout(new FlowLayout());
        buttonGroup.add(radio1);
        buttonGroup.add(radio2);
        panelRadio.add(radio1);
        panelRadio.add(radio2);

        panelRadio2.setLayout(new FlowLayout());
        buttonGroup2.add(radio3);
        buttonGroup2.add(radio4);
        panelRadio2.add(radio3);
        panelRadio2.add(radio4);

        panelButton.setLayout(new FlowLayout());
        panelButton.setPreferredSize(new Dimension(200, 50));
        regresar.setBackground(new Color(0x011065));
        regresar.setForeground(new Color(0xFFFFFF));
        guardar.setBackground(new Color(0x18910D));
        guardar.setForeground(new Color(0xFFFFFF));
        panelButton.add(regresar);
        panelButton.add(guardar);

        panelContainer2.setLayout(new GridLayout(2,0));
        panelContainer2.setPreferredSize(new Dimension(550, 30));
        panelContainer2.add(panelCont2);


        panelContainer.setLayout(new GridLayout(6, 0));
        datosUbicacion.setHorizontalAlignment(SwingConstants.CENTER);
        panelContainer.add(panelImagen);
        panelContainer.add(panelTitulo);
        panelContainer.setPreferredSize(new Dimension(550, 800));
        panelContainer.add(panelCont1);
        panelContainer.add(datosUbicacion);
        panelContainer.add(panelContainer2);
        panelContainer.add(panelButton);

        add(panelContainer);
    }
    private void addActionListeners() {
        guardar.addActionListener(new EventClick());
        regresar.addActionListener(e -> {
            this.setVisible(false);
            new Principal().setVisible(true);
        });

    }
    private void llenarCombo(){
        for (String s: listaEstados) {
            estados.addItem(s);
        }
        for (String s: listaCiudades) {
            ciudades.addItem(s);
        }
    }

    public static ArrayList<Cliente> getCliente(){
        return clientes;
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        if (e.getSource() == estados){
            String item2 = (String) estados.getSelectedItem();
            text6.setText(item2);

        }
        if (e.getSource() == ciudades){
            String item2 = (String) ciudades.getSelectedItem();
            text7.setText(item2);

        }
    }

    @Override
    public void stateChanged(ChangeEvent e) {
        if (radio1.isSelected()) {
            text4.setEditable(true);
        }
        if (radio2.isSelected()) {
            text4.setEditable(false);
        }
        if (radio3.isSelected()) {
            text5.setEditable(true);
        }
        if (radio4.isSelected()) {
            text5.setEditable(false);
        }
    }


    public class EventClick implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
                String nombreCliente = text1.getText();
                String apellidoP = text2.getText();
                String apellidoM = text3.getText();
                String telefono= text4.getText();
                String correo = text5.getText();
                String estado = text6.getText();
                String ciudad = text7.getText();
                String colonia = text8.getText();;
                String codigoPostal= text9.getText();


                clientes.add(new Cliente(nombreCliente,apellidoP,apellidoM,telefono,correo,estado,ciudad,colonia,codigoPostal));
                clearTextFields();
            }

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


