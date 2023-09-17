import java.util.HashMap;
import java.util.Scanner;

public class ProyectoFinal {

    static HashMap<String, String> nombre_laboral = new HashMap<>();
    static HashMap<String, String> roles = new HashMap<>();
    static HashMap<String, String> cedulas = new HashMap<>();
    static HashMap<String, String> horarios = new HashMap<>();
    static HashMap<String, String> mensajes = new HashMap<>();

    static String nombre;
    static String codigo;
    static String rol;
    static String cedula;
    static String chat;
    static String horario = "";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nSistema de Registro de Horarios V 0.5");
            System.out.println("1. Iniciar Sesión");
            System.out.println("2. Registrarse en el Sistema");
            System.out.println("3. Salir");

            System.out.print("Ingrese el numero de la opcion deseada : ");
            int opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    IniciarSesion(scanner);
                    break;

                case 2:
                    RegistrarUsuario(scanner);
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

    public static void IniciarSesion(Scanner scanner) {
        System.out.print("Ingrese su código de usuario: ");
        codigo = scanner.next();
        if (nombre_laboral.containsKey(codigo)) {
            nombre = nombre_laboral.get(codigo);
            rol = roles.get(codigo);
            System.out.println("...");
            System.out.println("\nBienvenido al sistema");
            System.out.println("Nombre: " + nombre);
            System.out.println("Cedula: " + cedula);
            System.out.println("Rol : " + rol);


            administrarHorarios(nombre, rol); //

        } else {
            System.out.println("...");
            System.out.println("NO existe ningun usuario con el código " + codigo);
        }
    }

    public static void RegistrarUsuario(Scanner scanner) {
        System.out.print("Ingrese su codigo de Empleado asignado: ");
        codigo = scanner.nextLine();

        if (!nombre_laboral.containsKey(codigo)) {
            System.out.print("Ingrese su nombre: ");
            nombre = scanner.nextLine();
            System.out.print("Ingrese su cedula: ");
            cedula = scanner.nextLine();

            int rolInt;

            do {
                System.out.println("Seleccione su Rol: ");
                System.out.print("1. Administrador, 2. para Coordinador, 3. para Empleado: ");
                rolInt = Integer.parseInt(scanner.nextLine());

                if (rolInt >= 1 && rolInt <= 3) {
                    break;
                } else {
                    System.out.println("Opcion Invalida. Seleccione 1, 2 o 3");
                }
            } while (true);

            String rol;
            switch (rolInt) {
                case 1:
                    rol = "Administrador";
                    break;
                case 2:
                    rol = "Coordinador";
                    break;
                case 3:
                    rol = "Empleado";
                    break;
                default:
                    rol = "Desconocido";
                    break;
            }

            nombre_laboral.put(codigo, nombre);
            cedulas.put(codigo, cedula);
            roles.put(codigo, rol);
            System.out.println("...");
            System.out.println("Usuario creado exitosamente.");
        } else {
            System.out.println("EL codigo " + codigo +" ya esta en uso. Por favor ingrese un codigo valido.");
        }
    }

    public static void administrarHorarios(String nombre, String rol) {

        switch (rol.toLowerCase()) {
            case "administrador":
                administradorOpciones();
                break;
            case "gerente":
                gerenteOpciones();
                break;
            case "empleado":
                empleadoOpciones();
                break;

        }
    }

    public static void administradorOpciones() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\nOpciones para Administradores:");
            System.out.println("1. Ver Horario");
            System.out.println("2. Crear Horario");
            System.out.println("3. Modificar horario");
            System.out.println("4. Eliminar horario");
            System.out.println("5. Enviar mensaje a un gerente");
            System.out.println("6. Salir");

            System.out.print("Ingrese el numero de la opcion deseada: ");
            int opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    if (horario.isEmpty()) {
                        System.out.println("No se ha creado ningun horario.");
                    } else {
                        System.out.print("Ingrese el codigo del empleado : ");
                        codigo = scanner.next();
                        if (nombre_laboral.containsKey(codigo)) {
                            nombre = nombre_laboral.get(codigo);
                            horario = horarios.get(codigo);
                            System.out.println("Los datos del usuario con código: " + codigo);
                            System.out.println("Nombre: " + nombre);
                            System.out.println("El horario actual es: " + horario);
                        }
                    }
                    break;
                case 2:
                    System.out.print("Ingrese el codigo del empleado : ");
                    codigo = scanner.next();
                    if (nombre_laboral.containsKey(codigo)) {
                        System.out.println("Registre el horario");
                        horario = scanner.next();
                        horarios.put(codigo, horario);
                    }
                    System.out.println("Se ha creado el horario exitosamente.");
                    break;
                case 3:
                    if (horario.isEmpty()) {
                        System.out.println("No se ha creado ningún horario.");
                    } else {
                        System.out.print("Ingrese el codigo del empleado : ");
                        codigo = scanner.next();
                        if (nombre_laboral.containsKey(codigo)) {
                            System.out.println("El Horario actual es: " + (horario));
                            System.out.println("Ingrese el nuevo horario: ");
                            horario = scanner.nextLine();
                            System.out.println("...");
                            System.out.println("Se ha modificado el horario exitosamente.");
                        }
                    }
                    break;
                case 4:
                    System.out.print("Esta seguro que desea eliminar el horario? (si/no): ");
                    String eliminar = scanner.nextLine();
                    if (eliminar.equalsIgnoreCase("si")) {
                        System.out.println("Ingrese el código del usuario");
                        codigo = scanner.next();
                        horarios.remove(codigo);
                        break;
                    } else {
                        System.out.println("No se ha eliminado el horario.");
                    }
                    break;
                case 5:
                    System.out.print("Ingrese el codigo del gerente : ");
                    codigo = scanner.next();
                    if (nombre_laboral.containsKey(codigo)) {
                        System.out.println("Ingrese el mensaje a enviar");
                        scanner.nextLine();
                        chat = scanner.nextLine();
                        mensajes.put(codigo, chat);
                    }
                    System.out.println("Se ha enviado el mensaje satisfactoriamente a " + codigo + ".");
                    break;
                case 6:
                    return;
                default:
                    System.out.println("Opcion invalida. Por favor, seleccione una opción valida.");
                    break;
            }
        }
    }

    public static void gerenteOpciones() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nOpciones disponibles para gerentes:");
            System.out.println("1. Ver horario");
            System.out.println("2. Solicitar cambios en el horario");
            System.out.println("3. Enviar mensaje a un empleado");
            System.out.println("4. Salir");

            System.out.print("Ingrese el numero de la opcion deseada: ");
            int opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese el codigo del empleado : ");
                    codigo = scanner.next();
                    if (nombre_laboral.containsKey(codigo)) {
                        nombre = nombre_laboral.get(codigo);
                        horario = horarios.get(codigo);
                        System.out.println("Los datos del usuario con código: " + codigo);
                        System.out.println("Nombre: " + nombre);
                        System.out.println("El horario actual es: " + horario);

                    }
                    break;
                case 2:
                    System.out.print("Ingrese el codigo del administrador : ");
                    codigo = scanner.next();
                    if (nombre_laboral.containsKey(codigo)) {

                        System.out.println("Ingrese el mensaje a enviar");
                        chat = scanner.nextLine();
                        mensajes.put(codigo, chat);
                        System.out.println("El mensaje se envio con exito a " + codigo);
                    }
                    break;
                case 3:
                    System.out.print("Ingrese el codigo del empleado : ");
                    codigo = scanner.next();

                    if (nombre_laboral.containsKey(codigo)) {

                        scanner.nextLine();

                        System.out.println("Ingrese el mensaje a enviar");
                        chat = scanner.nextLine();
                        mensajes.put(codigo, chat);
                        System.out.println("El mensaje se envio con exito a " + codigo);
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

    public static void empleadoOpciones() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nOpciones disponibles para empleados:");
            System.out.println("1. Ver horario");
            System.out.println("2. Salir");

            System.out.print("Ingrese el numero de la opcion deseada: ");
            int opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese su código : ");
                    codigo = scanner.next();
                    if (nombre_laboral.containsKey(codigo)) {
                        nombre = nombre_laboral.get(codigo);
                        horario = horarios.get(codigo);
                        if (horario.isEmpty()) {
                            System.out.println("Aún no se ha creado un horario para este usuario.");
                        } else {
                            System.out.println("Visualizando horario...");
                            System.out.println("Los datos del usuario con código: " + codigo);
                            System.out.println("Nombre: " + nombre);
                            System.out.println("El horario actual es: " + horario);
                        }
                    }
                    break;
                case 2:
                    return;
                default:
                    System.out.println("Opcion invalida. Por favor, seleccione una opción valida.");
                    break;
            }
        }
    }
}

