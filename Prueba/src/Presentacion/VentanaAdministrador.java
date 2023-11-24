package Presentacion;

import Logica.SistemaRegistro;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaAdministrador extends JFrame {
    private JLabel lblTexto;
    private JButton btnVerDatos;
    private JButton btnConsultarEmpleado;
    private JButton btnConsultarTodos;
    private JButton btnModificarEmpleado;
    private JButton btnEliminarEmpleado;
    private JButton btnRevisarMensajes;
    private JButton btnEnviarMensaje;
    private JButton btnCerrarSesion;
    private JButton btnVerDatosPropios;
    private SistemaRegistro sistema;

    public VentanaAdministrador(SistemaRegistro sistema) {
        super("Administrador - Panel de Control");
        this.sistema = sistema;

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(600, 400);
        setLocationRelativeTo(null);

        btnVerDatos.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        btnConsultarEmpleado.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        btnConsultarTodos.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        btnModificarEmpleado.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        btnEliminarEmpleado.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        btnRevisarMensajes.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        btnEnviarMensaje.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        btnCerrarSesion.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        btnVerDatosPropios.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }

}

