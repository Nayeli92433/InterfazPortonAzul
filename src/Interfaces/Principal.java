package Interfaces;

import javax.swing.*;
import java.awt.*;

public class Principal extends JFrame {
    private JPanel panelCanvas;
    private JPanel panelContainer, panelButton, panelImagen;
    private JButton boton1, boton2, boton3;

    public Principal() {
        initializeComponents();
        setupFrame();
        setupPanelContainer();

        add(panelContainer);
        addActionListeners();
    }

    private void initializeComponents() {

        panelCanvas = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                ImageIcon imagen = new ImageIcon("C:\\Users\\Nayeli Velasco\\IdeaProjects\\InterfazPortonAzul\\src\\Imagen\\restaurante.png"); // Reemplaza "ruta_de_la_imagen.jpg" por la ruta correcta de la imagen
                Image img = imagen.getImage();
                g.drawImage(img, 35, 23, null);
            }
        };

        panelContainer = new JPanel();
        panelButton = new JPanel();
        panelImagen = new JPanel();

        boton1 = new JButton("Registrar nuevo cliente");
        boton2 = new JButton("Registrar nuevo adeudo");
        boton3 = new JButton("Consultar adeudos");
    }

    private void setupFrame() {
        setTitle("EL PORTON AZUL");
        setLayout(new FlowLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setResizable(true);
        setSize(500, 500);
    }

    private void setupPanelContainer() {

        panelImagen.setLayout(new BorderLayout());
        panelImagen.setPreferredSize(new Dimension(200, 200));
        panelImagen.add(panelCanvas, BorderLayout.CENTER);

        panelButton.setLayout(new FlowLayout());
        panelButton.setPreferredSize(new Dimension(200, 200));
        panelButton.add(boton1);
        panelButton.add(boton2);
        panelButton.add(boton3);

        panelContainer.setLayout(new GridLayout(2, 0));
        panelContainer.add(panelImagen);
        panelContainer.add(panelButton);

        add(panelContainer);
    }

    private void addActionListeners() {
        boton1.addActionListener(e ->{
            RegistroCliente registroCliente = new RegistroCliente();
            registroCliente.setVisible(true);
            this.setVisible(false);
        });
        boton2.addActionListener(e -> {
            RegistroAdeudo registroAdeudo = new RegistroAdeudo();
            registroAdeudo.setVisible(true);
            this.setVisible(false);
        });
        boton3.addActionListener(e->{
            ConsultarAdeudos tablaClientes = new ConsultarAdeudos();
            tablaClientes.setVisible(true);
            this.setVisible(false);
        });
    }
}
