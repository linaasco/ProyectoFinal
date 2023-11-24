package Logica;

import java.util.Scanner;

public class Coordinador extends Usuario {
    private SistemaRegistro sistema;

    public Coordinador(String codigo, String nombre, String rol, String tipoDoc, String numCedula, String horario, SistemaRegistro sistema) {
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
                    lector.nextLine();
                    if(sistema.existeUsuario(codigoUsuario)) {
                        String nombreUsuario = sistema.getNombresLaboral().get(codigoUsuario);
                        String rolUsuario = sistema.getRoles().get(codigoUsuario);
                        if ("Empleado".equals(rolUsuario)) {
                            String horariosUsuario = sistema.getHorarios().get(codigoUsuario);
                            if (horariosUsuario != null && !horariosUsuario.isEmpty()) {
                                System.out.println("\nEl empleado " + nombreUsuario + " tiene asignado el horario: "+ horariosUsuario);
                            } else {
                                System.out.println("El empleado " + nombreUsuario + " no tiene horario asignado.");
                            }
                        } else {
                            System.out.println("El usuario no tiene rol Empleado y no se le asigna horario.");
                        }
                    } else {
                        System.out.println("NO existe ningun usuario con el código " + codigoUsuario);
                    }
                    break;
                case 3:
                    System.out.print("Ingrese el codigo del empleado: ");
                    codigoUsuario = lector.next();
                    lector.nextLine();
                    if (sistema.existeUsuario(codigoUsuario)) {
                        String nombreUsuario = sistema.getNombresLaboral().get(codigoUsuario);
                        String rolUsuario = sistema.getRoles().get(codigoUsuario);
                        if ("Empleado".equals(rolUsuario)) {
                            System.out.print("Ingrese el horario a asignar: ");
                            String horarioAsignar = lector.nextLine();
                            sistema.getHorarios().put(codigoUsuario, horarioAsignar);
                            System.out.println("Horario asignado correctamente.");
                        } else {
                            System.out.println("El usuario no tiene rol Empleado y no se le asigna horario.");
                        }
                    } else {
                        System.out.println("NO existe ningún usuario con el código " + codigoUsuario);
                    }
                    break;
                case 4:
                    System.out.print("Ingrese el codigo del empleado: ");
                    codigoUsuario = lector.next();
                    lector.nextLine();
                    if (sistema.existeUsuario(codigoUsuario)) {
                        String nombreUsuario = sistema.getNombresLaboral().get(codigoUsuario);
                        String rolUsuario = sistema.getRoles().get(codigoUsuario);
                        if ("Empleado".equals(rolUsuario)) {
                            String horariosUsuario = sistema.getHorarios().get(codigoUsuario);
                            if (horariosUsuario != null && !horariosUsuario.isEmpty()) {
                                System.out.println("El horario asignado del empleado "+nombreUsuario+ " es : " + horariosUsuario);
                                System.out.print("Ingrese el nuevo horario: ");
                                String horarioAsignar = lector.nextLine();
                                sistema.getHorarios().put(codigoUsuario, horarioAsignar);
                                System.out.println("Se ha modificado el horario exitosamente");
                            } else {
                                System.out.println("\nEl empleado no tiene parametrizado ningun horario");
                            }
                        } else {
                            System.out.println("El usuario no tiene rol Empleado y no se le asigna horario.");
                        }
                    } else {
                        System.out.println("NO existe ningún usuario con el código " + codigoUsuario);
                    }
                case 5:
                    System.out.print("Ingrese el codigo del empleado: ");
                    codigoUsuario = lector.next();
                    lector.nextLine();
                    if (sistema.existeUsuario(codigoUsuario)) {
                        String nombreUsuario = sistema.getNombresLaboral().get(codigoUsuario);
                        String rolUsuario = sistema.getRoles().get(codigoUsuario);
                        if ("Empleado".equals(rolUsuario)) {
                            String horariosUsuario = sistema.getHorarios().get(codigoUsuario);
                            if (horariosUsuario != null && !horariosUsuario.isEmpty()) {
                                System.out.println("El horario asignado del empleado "+nombreUsuario+ " es : " + horariosUsuario);
                                System.out.print("¿Está seguro que desea eliminar el horario? (si/no): ");
                                String respuesta = lector.nextLine().toLowerCase();
                                if (respuesta.equals("si")) {
                                    sistema.getHorarios().remove(codigoUsuario);
                                    System.out.println("...");
                                    System.out.println("Se ha eliminado el horario exitosamente");
                                } else if (respuesta.equals("no")) {
                                    System.out.println("No se ha eliminado al horario");
                                } else {
                                    System.out.println("Respuesta invalida. Ingrese 'si' o 'no'");
                                }
                            } else {
                                System.out.println("\nEl empleado no tiene parametrizado ningun horario");
                            }
                        } else {
                            System.out.println("El usuario no tiene rol Empleado y no se le asigna horario.");
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