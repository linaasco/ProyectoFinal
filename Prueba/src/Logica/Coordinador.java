package Logica;

import java.util.HashMap;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.List;

public class Coordinador extends Usuario {
    private SistemaRegistro sistema;

    public Coordinador(String codigo, String nombre, String rol, String tipoDoc, String numCedula,String horario, SistemaRegistro sistema) {
        super(codigo, nombre, rol, tipoDoc, numCedula, horario, sistema);
        this.sistema = sistema;
    }
    @Override
    public void menuOpciones() {
        Scanner lector = new Scanner(System.in);
        while (true) {
            System.out.println("\nOpciones para Coordinadores:");
            System.out.println("1. Ver mis datos");
            System.out.println("2. Ver Horario de Empleado");
            System.out.println("3. Registrar Horario");
            System.out.println("4. Modificar Horario");
            System.out.println("5. Eliminar  Horario");
            System.out.println("6. Revisar mensajes");
            System.out.println("7. Enviar mensaje");
            System.out.println("8. Cerrar Sesion");
            System.out.print("Ingrese el numero de la opcion deseada: ");
            int opcion = lector.nextInt();
            lector.nextLine();

            switch (opcion) {
                case 1:
                    verDatos();
                    break;
                case 2:
                    System.out.print("Ingrese el codigo del empleado: ");
                    String codigoUsuario = lector.next();
                    if(sistema.existeUsuario(codigoUsuario)) {
                        String nombreUsuario = sistema.getNombresLaboral().get(codigoUsuario);
                        String rolUsuario = sistema.getRoles().get(codigoUsuario);
                        if ("Administrador".equals(rolUsuario)) {
                            System.out.println("El usuario " + nombreUsuario + " (" + codigoUsuario + ") es un Administrador y no tiene horarios disponibles.");
                        }
                        else {
                            HashMap<String, List<String>> horariosUsuario = getHorarios();

                            if (horariosUsuario.containsKey(codigoUsuario)) {
                                List<String> horarios = horariosUsuario.get(codigoUsuario);

                                if (horarios.isEmpty()) {
                                    System.out.println("El usuario " + nombreUsuario + " (" + codigoUsuario + ") no tiene horarios disponibles.");
                                } else {
                                    System.out.println("Horarios disponibles para el usuario " + nombreUsuario + " (" + codigoUsuario + "):");
                                    for (String horario : horarios) {
                                        System.out.println("- " + horario);
                                    }
                                }
                            } else {
                                System.out.println("El usuario " + nombreUsuario + " (" + codigoUsuario + ") no tiene horarios disponibles.");
                            }
                        }
                    } else {
                        System.out.println("NO existe ningun usuario con el código " + codigoUsuario);
                    }
                    break;
                case 3:
                    System.out.print("Ingrese el codigo del empleado: ");
                    codigoUsuario = lector.next();
                    if (sistema.existeUsuario(codigoUsuario)) {
                        String nombreUsuario = sistema.getNombresLaboral().get(codigoUsuario);
                        String rolUsuario = sistema.getRoles().get(codigoUsuario);
                        if ("Empleado".equals(rolUsuario)) {
                            System.out.print("Ingrese el horario a asignar: ");
                            String horarioAsignar = lector.next();
                            lector.nextLine();
                            HashMap<String, List<String>> horariosUsuario = getHorarios();
                            if (horariosUsuario.containsKey(codigoUsuario)) {
                                List<String> horarios = horariosUsuario.get(codigoUsuario);
                                horarios.add(horarioAsignar);
                                System.out.println("Horario asignado correctamente.");
                                lector.nextLine();
                            } else {
                                List<String> nuevosHorarios = new ArrayList<>();
                                nuevosHorarios.add(horarioAsignar);
                                horariosUsuario.put(codigoUsuario, nuevosHorarios);
                                System.out.println("Horario asignado correctamente.");
                                lector.nextLine();
                            }
                        } else {
                            System.out.println("El usuario no tiene el rol de Empleado y no se le puede asignar un horario.");
                        }
                    } else {
                        System.out.println("NO existe ningún usuario con el código " + codigoUsuario);
                    }
                    break;
                case 4:
                    System.out.print("Ingrese el código del empleado: ");
                    codigoUsuario = lector.next();
                    if (sistema.existeUsuario(codigoUsuario)) {
                        String nombreUsuario = sistema.getNombresLaboral().get(codigoUsuario);
                        String rolUsuario = sistema.getRoles().get(codigoUsuario);
                        if ("Empleado".equals(rolUsuario)) {
                            HashMap<String, List<String>> horariosUsuario = getHorarios();
                            if (horariosUsuario != null && horariosUsuario.containsKey(codigoUsuario)) {
                                List<String> horarios = horariosUsuario.get(codigoUsuario);

                                System.out.println("Los horarios asignados del empleado " + nombreUsuario + " son: ");
                                for (int i = 0; i < horarios.size(); i++) {
                                    System.out.println((i + 1) + ". " + horarios.get(i));
                                }
                                System.out.print("Ingrese el número del horario que desea modificar: ");
                                int numeroHorario = lector.nextInt();
                                lector.nextLine();

                                if (numeroHorario >= 1 && numeroHorario <= horariosUsuario.size()) {
                                    System.out.print("Ingrese el nuevo horario: ");
                                    String nuevoHorario = lector.nextLine();
                                    horarios.set(numeroHorario - 1, nuevoHorario);
                                    System.out.println("Horario modificado correctamente.");
                                    lector.nextLine();
                                } else {
                                    System.out.println("Número de horario no válido.");
                                }
                            } else {
                                System.out.println("El usuario " + nombreUsuario + " (" + codigoUsuario + ") no tiene horarios guardados.");
                            }
                        } else {
                            System.out.println("El usuario no tiene el rol de Empleado y no se le puede asignar un horario.");
                        }
                    } else {
                        System.out.println("NO existe ningún usuario con el código " + codigoUsuario);
                    }
                    break;
                case 5:
                    System.out.print("Ingrese el código del empleado: ");
                     codigoUsuario = lector.next();
                    if (sistema.existeUsuario(codigoUsuario)) {
                        String nombreUsuario = sistema.getNombresLaboral().get(codigoUsuario);
                        String rolUsuario = sistema.getRoles().get(codigoUsuario);
                        if ("Empleado".equals(rolUsuario)) {
                            HashMap<String, List<String>> horariosUsuario = getHorarios();

                            if (horariosUsuario != null) {
                                List<String> horarios = horariosUsuario.get(codigoUsuario);
                                if (horarios != null && !horarios.isEmpty()) {
                                    System.out.println("Horarios actuales para el usuario " + nombreUsuario + " (" + codigoUsuario + "):");
                                    for (int i = 0; i < horarios.size(); i++) {
                                        System.out.println((i + 1) + ". " + horarios.get(i));
                                    }

                                    System.out.print("Ingrese el número del horario que desea eliminar: ");
                                    int numeroHorario = lector.nextInt();
                                    lector.nextLine(); // Limpiar el salto de línea

                                    if (numeroHorario >= 1 && numeroHorario <= horarios.size()) {
                                        horarios.remove(numeroHorario - 1);
                                        System.out.println("Horario eliminado correctamente.");
                                    } else {
                                        System.out.println("Número de horario no válido.");
                                    }
                                } else {
                                    System.out.println("El usuario " + nombreUsuario + " (" + codigoUsuario + ") no tiene horarios guardados.");
                                }
                            } else {
                                System.out.println("El usuario " + nombreUsuario + " (" + codigoUsuario + ") no tiene horarios guardados.");
                            }
                        } else {
                            System.out.println("El usuario no tiene el rol de Empleado y no se le pueden asignar horarios.");
                        }
                    } else {
                        System.out.println("NO existe ningún usuario con el código " + codigoUsuario);
                    }
                    break;
                case 6:
                    revisarMensajes();
                    break;
                case 7:
                    enviarMensajes();
                    break;
                case 8:
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