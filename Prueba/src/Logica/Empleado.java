package Logica;

import java.util.HashMap;
import java.util.Scanner;
import java.util.List;

public class Empleado extends Usuario {
    private SistemaRegistro sistema;
    public Empleado(String codigo, String nombre, String rol, String tipoDoc, String numCedula, String horario, SistemaRegistro sistema) {
        super(codigo, nombre, rol, tipoDoc, numCedula, horario, sistema);
        this.sistema = sistema;
    }
    @Override
    public void menuOpciones() {
        Scanner lector = new Scanner(System.in);
        while (true) {
            System.out.println("\nOpciones para Empleados:");
            System.out.println("1. Ver mis datos");
            System.out.println("2. Ver horario");
            System.out.println("3. Revisar mensajes");
            System.out.println("4. Enviar mensaje");
            System.out.println("5. Cerrar Sesion");
            System.out.print("Ingrese el numero de la opcion deseada: ");
            int opcion = lector.nextInt();
            lector.nextLine();

            switch (opcion) {
                case 1:
                    verDatos();
                    break;
                case 2:
                    String codigoUsuario = lector.next();
                    HashMap<String, List<String>> horariosUsuario = getHorarios();
                    if (horariosUsuario != null) {
                        List<String> horariosEmpleado = horariosUsuario.get(codigoUsuario);
                        if (horariosEmpleado != null && !horariosEmpleado.isEmpty()) {
                            System.out.println("Horario asignado:");
                            for (String horario : horariosEmpleado) {
                                System.out.println("- " + horario);
                            }
                        } else {
                            System.out.println("No tienes horarios asignados.");
                        }
                    } else {
                        System.out.println("Error interno: No se encontró el registro de horarios para el usuario.");
                    }
                    break;
                case 3:
                    revisarMensajes ();
                    break;
                case 4:
                    enviarMensajes();
                    break;
                case 5:
                    return;
                default:
                    System.out.println("Opcion invalida. Por favor, seleccione una opción valida.");
                    break;
            }
        }
    }
    @Override
    public void revisarMensajes() {
        super.revisarMensajes();
    }
    @Override
    public void enviarMensajes() {
        super.enviarMensajes();
    }
}