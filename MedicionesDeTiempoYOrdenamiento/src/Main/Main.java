package Main;

import Interfaz.VentanaMediciones;
import javax.swing.JFrame;

/**
 * Clase encargada de ejecutar la visibilidad de la ventana de mediciones
 *
 * @author Juan Miguel Arias Mejias
 * @author Ana Teresa Quesada Ramírez
 */
public class Main {

    public static void main(String[] args) {

        VentanaMediciones v = new VentanaMediciones();
        v.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        v.setLocationRelativeTo(null);
        v.setResizable(false);
        v.setVisible(true);
    }

}
