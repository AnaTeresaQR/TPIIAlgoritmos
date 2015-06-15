package interfaz;

import javax.swing.JOptionPane;

/**
 * Clase que se encarga de pedir datos en diferentes tipos
 *
 * @author Juan Miguel Arias Mejias
 * @author Ana Teresa Quesada Ramírez
 */
public class JOP {

    /**
     * Se encarga de mostrar en pantalla mensajes
     *
     * @param mensaje recibe el mensaje a mostrar
     */
    public static void mostrar(String mensaje) {
        JOptionPane.showMessageDialog(null, mensaje);
    }

    /**
     * Se encarga de pedir datos al usuario en formato String
     *
     * @param pregunta recibe la pregunta que espera que el usuario responda
     * @return la pregunta con un espacio para ingreso de datos
     */
    public static String solicitarString(String pregunta) {
        return JOptionPane.showInputDialog(pregunta);
    }

    /**
     * Se encarga de pedir datos al usuario en formato de número
     *
     * @param pregunta recibe la pregunta que espera que el usuario responda
     * @return la pregunta con un espacio para ingreso de datos
     */
    public static int solicitarInt(String pregunta) {
        return Integer.parseInt(JOptionPane.showInputDialog(pregunta));
    }
}
