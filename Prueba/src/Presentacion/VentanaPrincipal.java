package Presentacion;

import Logica.SistemaRegistro;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VentanaPrincipal extends JFrame {
    private JButton btnIniciarSesion;
    private JPanel pnlPrincipal;
    private JButton btnRegistrarUsuario;
    private JButton btnSalir;
    private SistemaRegistro sistemaPrincipal;
    private SistemaRegistro sistema;


    public VentanaPrincipal(SistemaRegistro sistema) {
            super("Ventana Principal");
        this.sistema = sistema;

            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setSize(400, 70);
            setLocationRelativeTo(null);
        btnIniciarSesion.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                VentanaIniciarSesion ventanaIniciarSesion = new VentanaIniciarSesion(sistema);
                ventanaIniciarSesion.setVisible(true);
            }
        });
        btnRegistrarUsuario.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                VentanaRegistrarUsuario ventanaRegistrarUsuario = new VentanaRegistrarUsuario(sistema);
                ventanaRegistrarUsuario.setVisible(true);
            }
        });

        btnSalir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        pnlPrincipal= new JPanel();
        pnlPrincipal.add(btnIniciarSesion);
        pnlPrincipal.add(btnRegistrarUsuario);
        pnlPrincipal.add(btnSalir);
        add(pnlPrincipal);
    }


    }

