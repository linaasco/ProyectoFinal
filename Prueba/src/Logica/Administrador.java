package Logica;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Administrador extends Usuario {

    private SistemaRegistro sistema;

    public Administrador(String codigo, String nombre, String rol, String tipoDoc, String numCedula, String horario, SistemaRegistro sistema) {
        super(codigo, nombre, rol, tipoDoc, numCedula, horario, sistema);
        this.sistema = sistema;

    }

    @Override
    public void menuOpciones() {
        Scanner lector = new Scanner(System.in);
        while (true) {
            System.out.println("\nOpciones para Administradores:");
            System.out.println("1. Ver mis datos");
            System.out.println("2. Consultar datos empleado");
            System.out.println("3. Consultar todos los empleados");
            System.out.println("4. Modificar datos de empleado");
            System.out.println("5. Eliminar empleado");
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
                        String tipoDocUsuario = sistema.getTiposDocs().get(codigoUsuario);
                        String numCedulaUsuario = sistema.getNumCedulas().get(codigoUsuario);
                        System.out.println("\nNombre: " + nombreUsuario);
                        System.out.println("Rol : " + rolUsuario);
                        System.out.println("Tipo de Documento: " + tipoDocUsuario);
                        System.out.println("Numero de Documento: " + numCedulaUsuario);

                    } else {
                        System.out.println("NO existe ningun usuario con el código " + codigoUsuario);
                    }
                    break;
                case 3:
                    HashMap<String, String> usuarios = sistema.getNombresLaboral();
                    System.out.println();
                    System.out.println("Numero de empleados registrados: " + usuarios.size());
                    for (Map.Entry<String, String> entry : usuarios.entrySet()) {
                        String codigo = entry.getKey();
                        String nombre = entry.getValue();
                        String rol = sistema.getRoles().get(codigo);
                        System.out.println();
                        System.out.println("- Nombre: " + nombre + ". Codigo: " + codigo + ". Rol: " + rol);
                    }
                    break;
                case 4:
                    System.out.print("Ingrese el codigo del empleado: ");
                    codigoUsuario = lector.next();
                    if(sistema.existeUsuario(codigoUsuario)) {
                        System.out.println("Seleccione qué aspecto desea modificar:");
                        System.out.println("1. Nombre");
                        System.out.println("2. Tipo de Documento");
                        System.out.println("3. Número de Documento");
                        System.out.println("4. Rol");
                        int opcionModificar = lector.nextInt();
                        lector.nextLine();
                        switch (opcionModificar) {
                            case 1:
                                System.out.print("Ingrese el nuevo nombre del empleado: ");
                                String nombre = lector.nextLine();
                                sistema.getNombresLaboral().put(codigoUsuario, nombre);
                                System.out.println("Nombre modificado con éxito.");
                                break;
                            case 2:
                                int tipoDocInt;
                                while (true) {
                                    System.out.println("Seleccione su tipo de Documento: ");
                                    System.out.print("1. Cedula de Ciudadania(CC), 2. Cédula de Extranjería(CE), 3. Pasaporte: ");
                                    tipoDocInt = Integer.parseInt(lector.nextLine());
                                    if (tipoDocInt >= 1 && tipoDocInt <= 3) {
                                        break;
                                    } else {
                                        System.out.println("Opcion Invalida. Seleccione 1, 2 o 3");
                                    }
                                }
                                String tipoDoc = switch (tipoDocInt) {
                                    case 1 -> "Cedula de Ciudadania(CC)";
                                    case 2 -> "Cédula de Extranjería(CE)";
                                    case 3 -> "Pasaporte";
                                    default -> "desconocido";
                                };
                                sistema.getTiposDocs().put(codigoUsuario, tipoDoc);
                                System.out.println("Tipo de documento modificado con éxito.");
                                break;
                            case 3:
                                System.out.print("Ingrese el nuevo numero de documento: ");
                                String numCedula = lector.nextLine();
                                sistema.getNumCedulas().put(codigoUsuario, numCedula);
                                System.out.println("Numero de documento modificado con éxito.");
                                break;
                            case 4:
                                int rolInt;
                                while (true){
                                    System.out.println("Seleccione el nuevo Rol: ");
                                    System.out.print("1. Administrador, 2. Coordinador, 3. Empleado: ");
                                    rolInt = Integer.parseInt(lector.nextLine());
                                    if (rolInt >= 1 && rolInt <= 3) {
                                        break;
                                    } else {
                                        System.out.println("Opcion Invalida. Seleccione 1, 2 o 3");
                                    }
                                }
                                String rol = switch (rolInt) {
                                    case 1 -> "Administrador";
                                    case 2 -> "Coordinador";
                                    case 3 -> "Empleado";
                                    default -> "desconocido";
                                };
                                sistema.getRoles().put(codigoUsuario, rol);
                                System.out.println("Rol modificado con éxito.");
                                break;
                        }
                    } else {
                        System.out.println("NO existe ningun usuario con el código " + codigoUsuario);
                    }

                    break;
                case 5:
                    System.out.print("Ingrese el codigo del empleado: ");
                    codigoUsuario = lector.nextLine();
                    if(sistema.existeUsuario(codigoUsuario)) {
                        System.out.print("¿Está seguro que desea eliminar al empleado? (si/no): ");
                        String respuesta = lector.nextLine().toLowerCase();

                        if (respuesta.equals("si")) {
                            sistema.getNombresLaboral().remove(codigoUsuario);
                            sistema.getRoles().remove(codigoUsuario);
                            sistema.getTiposDocs().remove(codigoUsuario);
                            sistema.getNumCedulas().remove(codigoUsuario);
                            System.out.println("...");
                            System.out.println("Se ha eliminado el empleado exitosamente");
                        } else if (respuesta.equals("no")) {
                            System.out.println("No se ha eliminado al usuario");
                        } else {
                            System.out.println("Respuesta invalida. Ingrese 'si' o 'no'");
                        }
                    } else {
                        System.out.println("NO existe ningun usuario con el código " + codigoUsuario);
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