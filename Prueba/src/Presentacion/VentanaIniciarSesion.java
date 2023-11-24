package Presentacion;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Logica.SistemaRegistro;
public class VentanaIniciarSesion extends JFrame {

    private JButton btnIniciarSesion;
    private JLabel lblCodigo;
    private JTextField txtCodigo;
    private JPanel jpnIniciarSesion;
    private SistemaRegistro sistema;
    private String nombre;


    public VentanaIniciarSesion(SistemaRegistro sistema) {
        super("Iniciar Sesión");
        this.sistema = sistema;

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(500, 500);
        setLocationRelativeTo(null);

        txtCodigo = new JTextField(10);
        btnIniciarSesion = new JButton("Iniciar Sesión");

        btnIniciarSesion.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String codigo = txtCodigo.getText();

                if (sistema.existeUsuario(codigo)) {
                    nombre = sistema.getNombresLaboral().get(codigo);
                    String rol = sistema.getRoles().get(codigo);

                    JOptionPane.showMessageDialog(null,
                            "Bienvenido al Sistema\nNombre: " + nombre + "\nRol: " + rol);

                    sistema.gestionRoles(rol);

                } else {
                    JOptionPane.showMessageDialog(null, "No existe ningún usuario con el código " + codigo);
                }
            }

        });
    }

    private void abrirVentanaSegunRol(String rol) {
        switch (rol) {
            case "Administrador":
                VentanaAdministrador ventanaAdministrador = new VentanaAdministrador(sistema);
                ventanaAdministrador.setVisible(true);
                break;
            case "Coordinador":
                VentanaCoordinador ventanaCoordinador = new VentanaCoordinador(sistema);
                ventanaCoordinador.setVisible(true);
                break;
            case "Empleado":
                VentanaEmpleado ventanaEmpleado = new VentanaEmpleado(sistema);
                ventanaEmpleado.setVisible(true);
                break;
            default:
                System.out.println("Rol no reconocido");
                break;
        }
        dispose();
    }
}
