import java.util.Scanner;
import Logica.SistemaRegistro;


public class Principal {
    public static void main(String[] args) {


        Scanner lector = new Scanner(System.in);
        SistemaRegistro sistema = new SistemaRegistro();
        while (true) {
            System.out.println("\nSistema de Registro de Horarios V 0.7");
            System.out.println("1. Iniciar Sesión");
            System.out.println("2. Registrarse en el Sistema");
            System.out.println("3. Salir");
            System.out.print("Ingrese el numero de la opcion deseada : ");

            int opcion = lector.nextInt();
            lector.nextLine();

            switch (opcion) {
                case 1:
                    sistema.iniciarSesion(lector);
                    break;
                case 2:
                    sistema.registrarUsuario(lector);
                    break;
                case 3:
                    System.out.print("¿Está seguro de que desea salir? (si/no): ");
                    String respuesta = lector.nextLine().toLowerCase();

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
}