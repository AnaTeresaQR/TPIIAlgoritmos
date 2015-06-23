package interfaz;

import java.awt.Color;
import java.awt.Graphics;

/**
 * Clase que se encarga de realizar los dibujos en pantalla para la demostración
 * de los ordenamientos
 *
 * @author Juan Miguel Arias Mejias
 * @author Ana Teresa Quesada Ramírez
 */
public class Dibujar {

    /**
     * Se encarga de pintar un círculo que contendrá vectores, y validar si
     * deben resaltarse o no
     *
     * @param g componente para pintar
     * @param numero numero a insertar en el círculo
     * @param x la x de ubicación del círculo
     * @param y la y en coordenada donde se encontrará el círculo
     * @param resaltado si es o no un círculo por resaltar en pantalla
     */
    public void dibujarCirculo(Graphics g, int numero, int x, int y, boolean resaltado) {
        if (resaltado) {
            g.setColor(Color.red);
        } else {
            g.setColor(Color.black);
        }
        g.drawOval(x, y, 40, 40);
        g.drawString(String.valueOf(numero), x + 14, y + 25);
    }

    /**
     * Se encarga de mandarle los datos necesarios a dibujarCirculo para pintar
     * los círculos y los numeros correspondientes a cada uno y además decidir
     * si deben pintarse o no de otro color
     *
     * @param g componente para pintar
     * @param numeros recibe un vector de numeros para pintar en los círculos
     * @param index recibe el índice del dato que debemos resaltar
     */
    public void dibujarVector(Graphics g, int[] numeros, int index) {
        boolean resaltado = false;
        for (int i = 0; i < numeros.length; i++) {
            int numero = numeros[i];
            if (i == index - 1) {
                resaltado = true;
            } else {
                resaltado = false;
            }
            dibujarCirculo(g, numero, i * 50, 30, resaltado);
        }
    }
}
