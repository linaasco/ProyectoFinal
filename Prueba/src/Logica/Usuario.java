package Logica;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Usuario {
    private SistemaRegistro sistema;
    private String codigo;
    private String nombre;
    private String rol;
    private String tipoDoc;
    private String numCedula;
    private String mensaje;
    private String horario;
    private HashMap<String, List<String>> horarios;
    private HashMap<String, List<String>> mensajes;

    public Usuario(String codigo, String nombre, String rol, String tipoDoc, String numCedula, String horario, SistemaRegistro sistema) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.rol = rol;
        this.tipoDoc = tipoDoc;
        this.numCedula = numCedula;
        this.mensajes = new HashMap<>();
        this.mensaje = "";
        this.horarios = new HashMap<>();
        this.horario = "";
        this.sistema = sistema;

    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public String getTipoDoc() {
        return tipoDoc;
    }

    public void setTipoDoc(String tipoDoc) {
        this.tipoDoc = tipoDoc;
    }

    public String getNumCedula() {
        return numCedula;
    }

    public void setNumCedula(String numCedula) {
        this.numCedula = numCedula;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public HashMap<String, List<String>> getHorarios() {
        return horarios;
    }

    public void setHorarios(HashMap<String, List<String>> horarios) {
        this.horarios = horarios;
    }

    public void menuOpciones() {
    }

    public void verDatos() {
        System.out.println("\nCódigo: " + getCodigo());
        System.out.println("Nombre: " + sistema.getNombresLaboral().get(codigo));
        System.out.println("Rol: "+ sistema.getRoles().get(codigo));
        System.out.println("Tipo de Documento: " + sistema.getTiposDocs().get(codigo));
        System.out.println("Número de Cédula: " + sistema.getNumCedulas().get(codigo));
    }
    public void revisarMensajes() {
        if (mensajes.containsKey(codigo)) {
            List<String> listaMensajes = mensajes.get(codigo);
            System.out.println("Tiene los siguientes mensajes:");
            for (String mensaje : listaMensajes) {
                System.out.println("- " + mensaje);
            }
        } else {
            System.out.println("\nNo tiene mensajes");
        }
    }
    public void enviarMensajes() {
        Scanner lector = new Scanner(System.in);
        System.out.print("Ingrese el código del destinatario: ");
        String codigoDestinatario  = lector.nextLine();
        if (sistema.existeUsuario(codigoDestinatario )) {
            nombre = sistema.getNombresLaboral().get(codigo);
            System.out.print("Ingrese el mensaje: ");
            mensaje = lector.nextLine();
            String mensajeCompleto = "De: " + nombre + ". Mensaje: " + mensaje;
            if (mensajes.containsKey(codigoDestinatario)) {
                mensajes.get(codigoDestinatario).add(mensajeCompleto);
            } else {
                List<String> listaMensajes = new ArrayList<>();
                listaMensajes.add(mensajeCompleto);
                mensajes.put(codigoDestinatario, listaMensajes);
            }
            System.out.println("Mensaje enviado correctamente.");
        } else {
            System.out.println("No existe ningún usuario con el código " + codigoDestinatario);
        }
    }
}