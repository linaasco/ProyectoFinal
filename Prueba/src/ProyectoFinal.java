import java.util.Scanner;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Set;

public class ProyectoFinal {

    static HashMap<String, String> nombresLaboral = new HashMap<>();
    static HashMap<String, String> roles = new HashMap<>();
    static HashMap<String, String> tiposDocs = new HashMap<>();
    static HashMap<String, String> numCedulas = new HashMap<>();
    static HashMap<String, String> horarios = new HashMap<>();
    static HashMap<String, ArrayList<String>> mensajes = new HashMap<>();

    static String codigo;
    static String nombre;
    static String rol;
    static String tipoDoc;
    static String numCedula;
    static String horario = "";
    static String mensaje = "";
    static String codigoDestinatario;

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\nSistema de Registro de Horarios V 0.7");
            System.out.println("1. Iniciar Sesión");
            System.out.println("2. Registrarse en el Sistema");
            System.out.println("3. Salir");
            System.out.print("Ingrese el numero de la opcion deseada : ");
            int opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    iniciarSesion(scanner);
                    break;
                case 2:
                    registrarUsuario(scanner);
                    break;
                case 3:
                    System.out.print("¿Está seguro de que desea salir? (si/no): ");
                    String respuesta = scanner.nextLine().toLowerCase();

                    if (respuesta.equals("si")) {
                        System.out.println("Hasta Pronto!!");
                        return;
                    } else if (respuesta.equals("no")) {
                        break;
                    } else {
                        System.out.println("Respuesta invalida. Ingrese 'si' o 'no'");
                    }
                    break;
                default:
                    System.out.println("Opcion invalida. Seleccione nuevamente");
                    break;
            }
        }
    }

    public static void iniciarSesion(Scanner scanner) {

        System.out.print("Ingrese su código de usuario: ");
        codigo = scanner.next();
        if (nombresLaboral.containsKey(codigo)) {
            nombre = nombresLaboral.get(codigo);
            tipoDoc = tiposDocs.get(codigo);
            numCedula = numCedulas.get(codigo);
            rol = roles.get(codigo);
            System.out.println("...");
            System.out.println("\nBienvenido al Sistema");
            System.out.println("Nombre: " + nombre);
            System.out.println("Tipo de Documento: " + tipoDoc);
            System.out.println("Numero de Documento: " + numCedula);
            System.out.println("Rol : " + rol);
            gestionRoles(rol);
        } else {
            System.out.println("...");
            System.out.println("NO existe ningun usuario con el código " + codigo);
        }
    }

    public static void registrarUsuario(Scanner scanner) {
        System.out.println("\nDiligencie los siguientes datos:");
        System.out.print("\nCodigo de empleado: ");
        codigo = scanner.nextLine();
        if (!nombresLaboral.containsKey(codigo)) {
            System.out.print("Nombre Completo: ");
            nombre = scanner.nextLine();
            int tipoDocInt;
            while (true){
                System.out.println("Seleccione su tipo de Documento: ");
                System.out.print("1. Cedula de Ciudadania(CC), 2. Cédula de Extranjería(CE), 3. Pasaporte: ");
                tipoDocInt = Integer.parseInt(scanner.nextLine());
                if (tipoDocInt >=1 && tipoDocInt <= 3) {
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
            System.out.print("Numero de Identificacion: ");
            numCedula = scanner.nextLine();
            int rolInt;
            while (true) {
                System.out.println("Seleccione su Rol: ");
                System.out.print("1. Administrador, 2. Coordinador, 3. Empleado: ");
                rolInt = Integer.parseInt(scanner.nextLine());
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
            nombresLaboral.put(codigo, nombre);
            tiposDocs.put(codigo, tipoDoc);
            numCedulas.put(codigo, numCedula);
            roles.put(codigo, rol);
            System.out.println("...");
            System.out.println("Usuario creado exitosamente.");
        } else {
            System.out.println("EL codigo " + codigo +" ya esta en uso. Por favor ingrese un codigo valido.");
        }
    }

    public static void gestionRoles(String rol) {

        switch (rol) {
            case "Administrador":
                administradorOpciones();
                break;
            case "Coordinador":
                coordinadorOpciones();
                break;
            case "Empleado":
                empleadoOpciones();
                break;
        }
    }

    public static void administradorOpciones() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\nOpciones para Administradores:");
            System.out.println("1. Consultar datos empleado");
            System.out.println("2. Consultar todos los empleados");
            System.out.println("3. Modificar datos de empleado");
            System.out.println("4. Eliminar empleado");
            System.out.println("5. Revisar mensajes");
            System.out.println("6. Enviar mensaje a coordinador");
            System.out.println("7. Salir");
            System.out.print("Ingrese el numero de la opcion deseada: ");
            int opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese el codigo del empleado: ");
                    codigo = scanner.next();
                    scanner.nextLine();
                    if (nombresLaboral.containsKey(codigo)) {
                        nombre = nombresLaboral.get(codigo);
                        tipoDoc = tiposDocs.get(codigo);
                        numCedula = numCedulas.get(codigo);
                        rol = roles.get(codigo);
                        System.out.println("\nNombre: " + nombre);
                        System.out.println("Tipo de Documento: " + tipoDoc);
                        System.out.println("Numero de Documento: " + numCedula);
                        System.out.println("Rol : " + rol);
                    } else {
                        System.out.println("...");
                        System.out.println("NO existe ningun usuario con el código " + codigo);
                    }
                    break;
                case 2:
                    Set<String> codigos = nombresLaboral.keySet();
                    System.out.println();
                    System.out.println("Numero de empleados registrados: " + codigos.size());
                    for (String codigo : codigos) {
                        nombre = nombresLaboral.get(codigo);
                        rol = roles.get(codigo);
                        System.out.println();
                        System.out.println("- Nombre: " + nombre + ". Codigo: " + codigo + ". Rol: " + rol);
                    }
                    break;
                case 3:
                    System.out.print("Ingrese el codigo del empleado: ");
                    codigo = scanner.next();
                    scanner.nextLine();
                    if (nombresLaboral.containsKey(codigo)) {
                        System.out.println("Seleccione qué aspecto desea modificar:");
                        System.out.println("1. Nombre");
                        System.out.println("2. Tipo de Documento");
                        System.out.println("3. Número de Documento");
                        System.out.println("4. Rol");
                        int opcionModificar = scanner.nextInt();
                        scanner.nextLine();

                        switch (opcionModificar) {
                            case 1:
                                System.out.print("Ingrese el nuevo nombre del empleado: ");
                                nombre = scanner.nextLine();
                                nombresLaboral.put(codigo, nombre);
                                System.out.println("Nombre modificado con éxito.");
                                break;
                            case 2:
                                int tipoDocInt;
                                while (true){
                                    System.out.println("Seleccione el nuevo tipo de documento: ");
                                    System.out.print("1. Cedula de Ciudadania(CC), 2. Cédula de Extranjería(CE), 3. Pasaporte: ");
                                    tipoDocInt = Integer.parseInt(scanner.nextLine());
                                    if (tipoDocInt >=1 && tipoDocInt <= 3) {
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
                                tiposDocs.put(codigo, tipoDoc);
                                System.out.println("Tipo de documento modificado con éxito.");
                                break;
                            case 3:
                                System.out.print("Ingrese el nuevo numero de documento: ");
                                numCedula = scanner.nextLine();
                                numCedulas.put(codigo, numCedula);
                                System.out.println("Numero de documento modificado con éxito..");
                                break;
                            case 4:
                                int rolInt;
                                while (true) {
                                    System.out.println("Seleccione el nuevo Rol: ");
                                    System.out.print("1. Administrador, 2. Coordinador, 3. Empleado: ");
                                    rolInt = Integer.parseInt(scanner.nextLine());
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
                                roles.put(codigo, rol);
                                System.out.println("Rol modificado con éxito.");
                                break;
                            default:
                                System.out.println("Opción inválida.");
                                break;
                        }
                    } else {
                        System.out.println("No existe un empleado con el código " + codigo);
                    }
                    break;
                case 4:
                    System.out.print("Ingrese el codigo del empleado: ");
                    codigo = scanner.next();
                    scanner.nextLine();
                    if (nombresLaboral.containsKey(codigo)) {
                        System.out.print("¿Está seguro que desea eliminar al empleado? (si/no): ");
                        String respuesta = scanner.nextLine().toLowerCase();
                        if (respuesta.equals("si")) {
                            nombresLaboral.remove(codigo);
                            tiposDocs.remove(codigo);
                            numCedulas.remove(codigo);
                            roles.remove(codigo);
                            System.out.println("...");
                            System.out.println("Se ha eliminado el empleado exitosamente");
                        } else if (respuesta.equals("no")) {
                            System.out.println("No se ha eliminado al usuario");
                        } else {
                            System.out.println("Respuesta invalida. Ingrese 'si' o 'no'");
                        }
                    } else {
                        System.out.println("...");
                        System.out.println("NO existe ningun usuario con el código " + codigo);
                    }
                    break;
                case 5:
                    if (mensajes.containsKey(codigo)) {
                        ArrayList<String> listaMensajes = mensajes.get(codigo);
                        System.out.println("Tiene los siguientes mensajes:");
                        for (String mensaje : listaMensajes) {
                            System.out.println("- " + mensaje);
                        }
                    } else {
                        System.out.println("\nNo tiene mensajes");
                    }
                    break;
                case 6:
                    System.out.print("Ingrese el codigo del Coordinador: ");
                    codigoDestinatario = scanner.next();
                    if (nombresLaboral.containsKey(codigoDestinatario)) {
                        nombre = nombresLaboral.get(codigo);
                        scanner.nextLine();
                        System.out.print("Ingrese el mensaje: ");
                        mensaje = scanner.nextLine();
                        String mensajeCompleto = "De: " + nombre + ". Mensaje: " + mensaje;
                        if (mensajes.containsKey(codigoDestinatario)) {
                            mensajes.get(codigoDestinatario).add(mensajeCompleto);
                        } else {
                            ArrayList <String> listaMensajes = new ArrayList<>();
                            listaMensajes.add(mensajeCompleto);
                            mensajes.put(codigoDestinatario, listaMensajes);
                        }
                        System.out.println("Se envió el mensaje.");
                    } else {
                        System.out.println("...");
                        System.out.println("NO existe ningun usuario con el código " + codigoDestinatario);
                    }
                    break;
                case 7:
                    return;
                default:
                    System.out.println("Opcion invalida. Por favor, seleccione una opción valida.");
                    break;
            }
        }
    }

    public static void coordinadorOpciones() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\nOpciones para Coordinadores:");
            System.out.println("1. Ver Horario de Empleado");
            System.out.println("2. Registrar Horario");
            System.out.println("3. Modificar Horario");
            System.out.println("4. Eliminar  Horario");
            System.out.println("5. Revisar mensajes");
            System.out.println("6. Enviar mensaje a Administrador");
            System.out.println("7. Enviar mensaje a Empleado");
            System.out.println("8. Salir");
            System.out.print("Ingrese el numero de la opcion deseada: ");
            int opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese el codigo del Empleado : ");
                    codigo = scanner.next();
                    scanner.nextLine();
                    if (nombresLaboral.containsKey(codigo)) {
                        nombre = nombresLaboral.get(codigo);
                        horario = horarios.get(codigo);
                        if (horario != null) {
                            System.out.println("\nEl empleado " + nombre + " tiene asignado el horario: "+ horario);
                        } else {
                            System.out.println("\nEl empleado " + nombre + " NO tiene asignado ningun horario");
                        }
                    } else {
                        System.out.println("No existe un empleado con el código " + codigo);
                    }
                    break;
                case 2:
                    System.out.print("Ingrese el codigo del Empleado : ");
                    codigo = scanner.next();
                    scanner.nextLine();
                    if (nombresLaboral.containsKey(codigo)) {
                        System.out.print("Ingrese el horario a asignar: ");
                        horario = scanner.nextLine();
                        horarios.put(codigo, horario);
                        System.out.println("Se ha asignado el horario exitosamente");
                    } else {
                        System.out.println("No existe un empleado con el código " + codigo);
                    }
                    break;
                case 3:
                    System.out.print("Ingrese el codigo del Empleado : ");
                    codigo = scanner.nextLine();
                    if (nombresLaboral.containsKey(codigo)) {
                        nombre = nombresLaboral.get(codigo);
                        if (horario != null) {
                            horario = horarios.get(codigo);
                            System.out.println("El horario asignado del empleado "+nombre+ " es : " + horario);
                            System.out.print("Ingrese el nuevo horario: ");
                            horario = scanner.nextLine();
                            horarios.put(codigo, horario);
                            System.out.println("Se ha modificado el horario exitosamente");
                        } else {
                            System.out.println("\nEl empleado no tiene parametrizado ningun horario");
                        }
                    } else {
                        System.out.println("No existe un empleado con el código " + codigo);
                    }
                    break;
                case 4:
                    System.out.print("Ingrese el codigo del empleado: ");
                    codigo = scanner.next();
                    scanner.nextLine();
                    if (nombresLaboral.containsKey(codigo)) {
                        nombre = nombresLaboral.get(codigo);
                        if (horario != null) {
                            horario = horarios.get(codigo);
                            System.out.println("\nEl empleado " + nombre + " tiene asignado el horario: "+ horario);
                            System.out.print("¿Está seguro que desea eliminar el horario? (si/no): ");
                            String respuesta = scanner.nextLine().toLowerCase();
                            if (respuesta.equals("si")) {
                                horarios.remove(codigo);
                                System.out.println("...");
                                System.out.println("Se ha eliminado el horario exitosamente");
                            } else if (respuesta.equals("no")) {
                                System.out.println("No se ha eliminado al horario");
                            } else {
                                System.out.println("Respuesta invalida. Ingrese 'si' o 'no'");
                            }
                        } else {
                            System.out.println("\nEl empleado no tiene asignado ningun horario");
                        }
                    } else {
                        System.out.println("...");
                        System.out.println("NO existe ningun usuario con el código " + codigo);
                    }
                    break;
                case 5:
                    if (mensajes.containsKey(codigo)) {
                        ArrayList<String> listaMensajes = mensajes.get(codigo);
                        System.out.println("Tiene los siguientes mensajes:");
                        for (String mensaje : listaMensajes) {
                            System.out.println("- " + mensaje);
                        }
                    } else {
                        System.out.println("\nNo tiene mensajes");
                    }
                    break;
                case 6:
                    System.out.print("Ingrese el codigo del Administrador: ");
                    codigoDestinatario = scanner.next();
                    if (nombresLaboral.containsKey(codigoDestinatario)) {
                        nombre = nombresLaboral.get(codigo);
                        scanner.nextLine();
                        System.out.print("Ingrese el mensaje: ");
                        mensaje = scanner.nextLine();
                        String mensajeCompleto = "De: " + nombre + ". Mensaje: " + mensaje;
                        if (mensajes.containsKey(codigoDestinatario)) {
                            mensajes.get(codigoDestinatario).add(mensajeCompleto);
                        } else {
                            ArrayList <String> listaMensajes = new ArrayList<>();
                            listaMensajes.add(mensajeCompleto);
                            mensajes.put(codigoDestinatario, listaMensajes);
                        }
                        System.out.println("Se envió el mensaje.");
                    } else {
                        System.out.println("...");
                        System.out.println("NO existe ningun usuario con el código " + codigoDestinatario);
                    }
                    break;
                case 7:
                    System.out.print("Ingrese el codigo del Empleado: ");
                    codigoDestinatario = scanner.next();
                    if (nombresLaboral.containsKey(codigoDestinatario)) {
                        nombre = nombresLaboral.get(codigo);
                        scanner.nextLine();
                        System.out.print("Ingrese el mensaje: ");
                        mensaje = scanner.nextLine();
                        String mensajeCompleto = "De: " + nombre + ". Mensaje: " + mensaje;
                        if (mensajes.containsKey(codigoDestinatario)) {
                            mensajes.get(codigoDestinatario).add(mensajeCompleto);
                        } else {
                            ArrayList <String> listaMensajes = new ArrayList<>();
                            listaMensajes.add(mensajeCompleto);
                            mensajes.put(codigoDestinatario, listaMensajes);
                        }
                        System.out.println("Se envió el mensaje.");
                    } else {
                        System.out.println("...");
                        System.out.println("NO existe ningun usuario con el código " + codigoDestinatario);
                    }
                    break;
                case 8:
                    return;
                default:
                    System.out.println("Opcion invalida. Por favor, seleccione una opción valida.");
                    break;
            }
        }
    }

    public static void empleadoOpciones() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\nOpciones para Empleados:");
            System.out.println("1. Ver horario");
            System.out.println("2. Revisar mensajes");
            System.out.println("3. Enviar mensaje a coordinador");
            System.out.println("4. Salir");
            System.out.print("Ingrese el numero de la opcion deseada: ");
            int opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    horario = horarios.get(codigo);
                        if (horario != null) {
                            System.out.println("\nSu Horario es: " + horario);
                        } else {
                            System.out.println("\nUsted no tiene parametrizado ningun horario");
                        }
                    break;
                case 2:
                    if (mensajes.containsKey(codigo)) {
                        ArrayList<String> listaMensajes = mensajes.get(codigo);
                        System.out.println("Tiene los siguientes mensajes:");
                        for (String mensaje : listaMensajes) {
                            System.out.println("- " + mensaje);
                        }
                    } else {
                        System.out.println("\nNo tiene mensajes");
                    }
                    break;
                case 3:
                    System.out.print("Ingrese el codigo del Coordinador: ");
                    codigoDestinatario = scanner.next();
                    if (nombresLaboral.containsKey(codigoDestinatario)) {
                        nombre = nombresLaboral.get(codigo);
                        scanner.nextLine();
                        System.out.print("Ingrese el mensaje: ");
                        mensaje = scanner.nextLine();
                        String mensajeCompleto = "De: " + nombre + ". Mensaje: " + mensaje;
                        if (mensajes.containsKey(codigoDestinatario)) {
                            mensajes.get(codigoDestinatario).add(mensajeCompleto);
                        } else {
                            ArrayList <String> listaMensajes = new ArrayList<>();
                            listaMensajes.add(mensajeCompleto);
                            mensajes.put(codigoDestinatario, listaMensajes);
                        }
                        System.out.println("Se envió el mensaje.");
                    } else {
                        System.out.println("...");
                        System.out.println("NO existe ningun usuario con el código " + codigoDestinatario);
                    }
                    break;
                case 4:
                    return;
                default:
                    System.out.println("Opcion invalida. Por favor, seleccione una opción valida.");
                    break;
            }
        }
    }
}