package Logica;

import java.util.HashMap;
import java.util.Scanner;

public class SistemaRegistro {
    private HashMap<String, String> nombresLaboral ;
    private HashMap<String, String> tiposDocs;
    private HashMap<String, String> numCedulas;
    private HashMap<String, String> roles;
    private static String codigo;
    private static String nombre;
    private static String tipoDoc;
    private static String numCedula;
    private static String horario;

    public SistemaRegistro() {
        this.nombresLaboral = new HashMap<>();
        this.tiposDocs = new HashMap<>();
        this.numCedulas = new HashMap<>();
        this.roles = new HashMap<>();
    }

    public HashMap<String, String> getNombresLaboral() {
        return nombresLaboral;
    }

    public void setNombresLaboral(HashMap<String, String> nombresLaboral) {
        this.nombresLaboral = nombresLaboral;
    }

    public HashMap<String, String> getTiposDocs() {
        return tiposDocs;
    }

    public void setTiposDocs(HashMap<String, String> tiposDocs) {
        this.tiposDocs = tiposDocs;
    }

    public HashMap<String, String> getNumCedulas() {
        return numCedulas;
    }

    public void setNumCedulas(HashMap<String, String> numCedulas) {
        this.numCedulas = numCedulas;
    }

    public HashMap<String, String> getRoles() {
        return roles;
    }

    public void setRoles(HashMap<String, String> roles) {
        this.roles = roles;
    }

    public void iniciarSesion(Scanner lector) {
        System.out.print("Ingrese su código de usuario: ");
        codigo = lector.next();

        if(existeUsuario(codigo)) {
            nombre = nombresLaboral.get(codigo);
            String rol = roles.get(codigo);


            System.out.println("...");
            System.out.println("Bienvenido al Sistema");
            System.out.println("Nombre: " + nombre);
            System.out.println("Rol: " + rol);

            gestionRoles(rol);

        } else {
            System.out.println("NO existe ningun usuario con el código " + codigo);
        }
    }

    public void registrarUsuario(Scanner lector) {
        System.out.println("\nDiligencie los siguientes datos:");
        System.out.print("\nCodigo de empleado: ");
        codigo = lector.nextLine();
        if(existeUsuario(codigo)) {
            System.out.println("EL codigo " + codigo +" ya esta en uso. Por favor ingrese su codigo unico.");
        } else {
            System.out.print("Nombre Completo: ");
            nombre = lector.nextLine();
            int tipoDocInt;
            while (true) {
                System.out.println("Seleccione su tipo de Documento: ");
                System.out.print("1. Cedula de Ciudadania(CC), 2. Cédula de Extranjería(CE), 3. Pasaporte: ");
                tipoDocInt = Integer.parseInt(lector.nextLine());
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
            numCedula = lector.nextLine();
            int rolInt;
            while (true) {
                System.out.println("Seleccione su Rol: ");
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
            nombresLaboral.put(codigo, nombre);
            tiposDocs.put(codigo, tipoDoc);
            numCedulas.put(codigo, numCedula);
            roles.put(codigo, rol);
            System.out.println("...");
            System.out.println("Usuario creado exitosamente.");
        }
    }

    public boolean existeUsuario(String codigo) {
        return nombresLaboral.containsKey(codigo);
    }

    public void gestionRoles(String rol) {
        Usuario usuario;
        switch (rol) {
            case "Administrador":
                usuario = new Administrador(codigo,nombre,rol,tipoDoc,numCedula,horario, this);
                usuario.menuOpciones();
                break;
            case "Coordinador":
                usuario = new Coordinador(codigo,nombre,rol,tipoDoc,numCedula, horario, this);
                usuario.menuOpciones();
            case "Empleado":
                usuario = new Empleado(codigo,nombre,rol,tipoDoc,numCedula, horario, this);
                usuario.menuOpciones();
        }
    }
}