package Presentacion;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Logica.SistemaRegistro;

public class VentanaRegistrarUsuario extends JFrame {
    private JLabel lblNombre;
    private JTextField txtNombre;
    private JLabel lblCodigo;
    private JTextField txtCodigo;
    private JLabel lblRol;
    private JRadioButton rbtAdministrador;
    private JRadioButton rbtCoordinador;
    private JRadioButton rbtEmpleado;
    private JLabel lblTipoDoc;
    private JRadioButton rbtCedulaCiudadana;
    private JRadioButton rbtCedulaExtrangera;
    private JRadioButton rbtPasaporte;
    private JLabel lblNumCedula;
    private JTextField txtNumCedula;
    private JButton btnRegistrar;
    private SistemaRegistro sistema;
    private String mensaje;

    public VentanaRegistrarUsuario(SistemaRegistro sistema) {
        super("Registrar Usuario");
        this.sistema = sistema;

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(500, 500);
        setLocationRelativeTo(null);

        btnRegistrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                registrarUsuario();

                JOptionPane.showMessageDialog(btnRegistrar, mensaje);
                dispose();
            }
        });
    }
    private String getRol() {
        return (rbtAdministrador.isSelected()) ? "Administrador" :
                (rbtCoordinador.isSelected()) ? "Coordinador" :
                        (rbtEmpleado.isSelected()) ? "Empleado":
                                        "No indicado";
    }
    private String getTipoDoc() {
        return (rbtCedulaCiudadana.isSelected()) ? "Cedula de Ciudadania (CC)" :
                (rbtCedulaExtrangera.isSelected()) ? "Cedula de Extrandería (CE)" :
                        (rbtPasaporte.isSelected()) ? "Pasaporte":
                                "No indicado";
    }
    private void registrarUsuario() {

        String codigo = txtCodigo.getText();
        String nombre = txtNombre.getText();
        String tipoDoc = getTipoDoc();
        String numCedula = txtNumCedula.getText();
        String rol = getRol();

        mensaje = "Tus datos son: \n" +
                "Código: " + codigo + "\n" +
                "Nombre: " + nombre + "\n" +
                "Tipo de documento: " + tipoDoc + "\n" +
                "Numero de Cedula:" + numCedula + "\n" +
                "Rol: " + rol;


        if (sistema.existeUsuario(codigo)) {
            JOptionPane.showMessageDialog(this, "El código " + codigo + " ya está en uso. Por favor, ingrese un código único.");
        } else {

            sistema.getNombresLaboral().put(codigo, nombre);
            sistema.getTiposDocs().put(codigo, tipoDoc);
            sistema.getNumCedulas().put(codigo, numCedula);
            sistema.getRoles().put(codigo, rol);


            JOptionPane.showMessageDialog(this, "Usuario creado exitosamente.");


        }
    }

}
