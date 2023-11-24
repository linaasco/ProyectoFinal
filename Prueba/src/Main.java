import Logica.SistemaRegistro;
import Presentacion.VentanaPrincipal;
    public class Main {
        public static void main(String[] args) {

            SistemaRegistro sistema = new SistemaRegistro();

            VentanaPrincipal ventanaPrincipal = new VentanaPrincipal(sistema);

            ventanaPrincipal.setVisible(true);
        }
    }

