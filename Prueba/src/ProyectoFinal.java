import java.util.Scanner;

public class ProyectoFinal {

    static String horario = "";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Bienvenido al sistema de administracion de horarios.");

        System.out.print("Ingrese su nombre de usuario: ");
        String usuario = scanner.nextLine();

        System.out.print("Ingrese su rol (administrador/gerente/empleado): ");
        String rol = scanner.nextLine();

        while (true) {
            administrarHorarios(usuario, rol);

            System.out.print("Desea salir del sistema? (si/no): ");
            String opcion = scanner.nextLine();
            if (opcion.equalsIgnoreCase("si")) {
                break;
            }

            System.out.print("Desea cambiar de rol? (si/no): ");
            opcion = scanner.nextLine();
            if (opcion.equalsIgnoreCase("si")) {
                System.out.print("Ingrese su nuevo rol (administrador/gerente/empleado): ");
                rol = scanner.nextLine();
            }
        }

        System.out.println("Hasta Pronto!!");
    }

    public static void administrarHorarios(String usuario, String rol) {
        System.out.println("Usuario: " + usuario);
        System.out.println("Rol: " + rol);

        switch (rol.toLowerCase()) {
            case "administrador" :
                administradorOpciones();
                break;
            case "gerente" :
                gerenteOpciones();
                break;
            case "empleado" :
                empleadoOpciones();
                break;
            default :
                usuarioNoValido();
                break;
        }
    }

    public static void administradorOpciones() {
        Scanner scanner = new Scanner(System.in);
        String nombreg = "";
        String mensaje = "";
        String eliminar = "";

        while (true) {
            System.out.println("\nOpciones disponibles para administradores:");
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
                        System.out.println("El Horario actual es:");
                        System.out.println(horario);
                    }
                    break;
                case 2:
                    System.out.print("Ingrese el horario que desea crear: ");
                    horario = scanner.nextLine();
                    System.out.println("...");
                    System.out.println("Se ha creado el horario exitosamente.");
                    break;
                case 3:
                    if (horario.isEmpty()) {
                        System.out.println("No se ha creado ningún horario.");
                    } else {
                        System.out.println("El Horario actual es: "+(horario));
                        System.out.println("Ingrese el nuevo horario: ");
                        horario = scanner.nextLine();
                        System.out.println("...");
                        System.out.println("Se ha modificado el horario exitosamente.");
                    }
                    break;
                case 4:
                    System.out.print("Esta seguro que desea eliminar el horario? (si/no): ");
                    eliminar = scanner.nextLine();
                    if (eliminar.equalsIgnoreCase("si")) {
                        System.out.println("...");
                        horario = "";
                        System.out.println("Se ha eliminado el horario.");
                    } else {
                        System.out.println("No se ha eliminado el horario.");
                    }
                    break;
                case 5:
                    System.out.print("Ingrese el nombre del Gerente al que desea enviar el mensaje: ");
                    nombreg = scanner.nextLine();
                    System.out.print("Ingrese el mensaje a enviar: ");
                    mensaje = scanner.nextLine();
                    System.out.println("Se ha enviado el mensaje satisfactoriamente a "+nombreg+".");
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
        String cambiohor = "";
        String nombree = "";
        String mensaje2 = "";
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
                    if (horario.isEmpty()) {
                        System.out.println("No se ha creado ningun horario.");
                    } else {
                        System.out.println("El Horario actual es:");
                        System.out.println(horario);
                    }
                    break;
                case 2:
                    System.out.print("Ingresar el horario solicitado: ");
                    cambiohor = scanner.nextLine();
                    System.out.println("...");
                    System.out.println("Se ha enviado la solicitud al administrador del sistema.");
                    break;
                case 3:
                    System.out.print("Ingrese el nombre del empleado al que desea enviar el mensaje: ");
                    nombree = scanner.nextLine();
                    System.out.print("Ingrese el mensaje a enviar: ");
                    mensaje2 = scanner.nextLine();
                    System.out.println("Se ha enviado el mensaje satisfactoriamente a "+nombree+".");
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
                    if (horario.isEmpty()) {
                        System.out.println("No se ha creado ningun horario.");
                    } else {
                        System.out.println("El Horario actual es:");
                        System.out.println(horario);
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

    public static void usuarioNoValido() {
        System.out.println("...");
        System.out.println("Usuario no valido.");
        System.out.println("Por favor revise que el rol este bien escrito o contacte al administrador del sistema.");
    }
}