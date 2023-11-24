package Presentacion;

import Logica.SistemaRegistro;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaEmpleado extends JFrame {
    private JLabel lblTexto;
    private JButton btnVerHorario;
    private JButton btnRevisarMnesajes;
    private JButton btnEnviarMensaje;
    private JButton btnCerrarSesion;
    private SistemaRegistro sistema;

    public VentanaEmpleado(SistemaRegistro sistema) {
        super("Administrador - Panel de Control");
        this.sistema = sistema;

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(600, 400);
        setLocationRelativeTo(null);


        btnVerHorario.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        btnRevisarMnesajes.addActionListener(new ActionListener() {
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
    }
}
