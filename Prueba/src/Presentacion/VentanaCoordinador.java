package Presentacion;

import Logica.SistemaRegistro;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaCoordinador extends JFrame {
    private JButton btnVerHorario;
    private JButton btnRegistrarHorario;
    private JButton btnModificarHorario;
    private JButton btnElminarHorario;
    private JButton btnRevisarMensajes;
    private JButton btnEnviarMensajeAdmin;
    private JButton btnEnviarMensajeEmpleado;
    private JButton btnCerrarSesion;
    private JLabel lblTexto;
    private JButton btnVerDatosPropios;
    private SistemaRegistro sistema;

    public VentanaCoordinador(SistemaRegistro sistema) {
        super("Administrador - Panel de Control");
        this.sistema = sistema;

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(600, 400);
        setLocationRelativeTo(null);


        btnVerDatosPropios.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        btnVerHorario.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        btnRegistrarHorario.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        btnModificarHorario.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        btnElminarHorario.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        btnRevisarMensajes.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        btnEnviarMensajeAdmin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        btnEnviarMensajeEmpleado.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        btnCerrarSesion.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }
}
