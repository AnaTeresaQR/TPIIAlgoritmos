package interfaz;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Arrays;

/**
 * Clase que se encarga de realizar los dibujos en pantalla para la demostración
 * de los ordenamientos
 *
 * @author Juan Miguel Arias Mejias
 * @author Ana Teresa Quesada Ramírez
 */
public class Dibujar {

    public static final int PRIMERA_LINEA = 100;
    public static final int SEGUNDA_LINEA = 220;
    public static final int TERCERA_LINEA = 340;
    public static final int CUARTA_LINEA = 450;

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
     * Se encarga de pintar un círculo que contendrá vectores, y validar si
     * deben resaltarse o no y modificar color
     *
     * @param g componente para pintar
     * @param numero numero a insertar en el círculo
     * @param x la x de ubicación del círculo
     * @param y la y en coordenada donde se encontrará el círculo
     * @param resaltado si es o no un círculo por resaltar en pantalla
     * @param color, para resaltar bolitas
     */
    public void dibujarCirculo(Graphics g, int numero, int x, int y, boolean resaltado, Color color) {
        if (resaltado) {
            g.setColor(color);
        } else {
            g.setColor(Color.black);
        }
        g.drawOval(x, y, 40, 40);
        g.drawString(String.valueOf(numero), x + 14, y + 25);
    }

    /**
     * Se encarga de pintar un círculo que contendrá vectores
     *
     * @param g componente para pintar
     * @param numero numero a insertar en el círculo
     * @param x la x de ubicación del círculo
     * @param y la y en coordenada donde se encontrará el círculo
     */
    public void dibujarCirculo(Graphics g, int numero, int x, int y) {
        g.setColor(Color.black);
        g.drawOval(x, y, 40, 40);
        g.drawString(String.valueOf(numero), x + 14, y + 25);
    }

    /**
     * Se encarga de mandarle los datos necesarios a dibujarCirculo para pintar
     * los círculos y los numeros correspondientes a cada uno y además decidir
     * si deben pintarse o no de otro color y la ubicación del vector
     *
     * @param g componente para pintar
     * @param numeros recibe un vector de numeros para pintar en los círculos
     * @param indexColoreados recibe el índice del dato que debemos resaltar
     * @param linea, la linea donde ubicaremos el arreglo
     */
    public void dibujarVector(Graphics g, int[] numeros, int[] indexColoreados, int linea) {
        Arrays.sort(indexColoreados);
        boolean resaltado = false;
        int index = 0;
        for (int i = 0; i < numeros.length; i++) {
            int numero = numeros[i];
            if (index < indexColoreados.length) {
                if (i == indexColoreados[index] - 1) {
                    resaltado = true;
                    index++;
                } else {
                    resaltado = false;
                }
            } else {
                resaltado = false;
            }
            dibujarCirculo(g, numero, i * 50 + 40, linea, resaltado);
            dibujarIndices(g, i, i * 50 + 40, linea);
            dibujarCirc(g, i * 50 + 50);
        }
    }

    /**
     * Se encarga de mandarle los datos necesarios a dibujarCirculo para pintar
     * los círculos y los numeros correspondientes a cada uno
     *
     * @param g componente para pintar
     * @param numeros recibe un vector de numeros para pintar en los círculos
     * @param linea, la linea donde ubicaremos el arreglo
     */
    public void dibujarVector(Graphics g, int[] numeros, int linea) {
        int index = 0;
        for (int i = 0; i < numeros.length; i++) {
            int numero = numeros[i];
            dibujarCirculo(g, numero, i * 50 + 40, linea, false);
            dibujarIndices(g, i, i * 50 + 40, linea);
//            dibujarCirc(g, i * 50 + 50);
        }
    }

    public void dibujarVectorBandera(Graphics g, int[] numeros, int linea) {
        
    }
    
    public void identificarLinea() {
        
    }

    /**
     * Se encarga de dibujar los índices de los círculos
     *
     * @param g componente para pintar
     * @param num a graficar
     * @param x coordenada de la x
     * @param y coordenada de ubicación en y
     */
    public void dibujarIndices(Graphics g, int num, int x, int y) {
        g.drawString(String.valueOf(num), x + 16, y + 53);
    }

    /**
     * Se encarga de dibujar los índices de los círculos
     *
     * @param g componente para pintar
     * @param num a graficar
     * @param x coordenada de la x
     * @param linea la ubicación en y para colocarse
     */
    public void dibujarBandera(Graphics g, int num, int x, int linea) {
        g.drawString(String.valueOf(num), x + 16, linea);
    }

    public void dibujarCirc(Graphics g, int x) {
        // entre linea cero y uno
        int linea0_1 = (PRIMERA_LINEA ) / 2;
        g.drawOval(x, linea0_1, 40, 40);
        // entre linea uno y dos
        int linea1_2 = (PRIMERA_LINEA + SEGUNDA_LINEA) / 2;
        g.drawOval(x, linea1_2, 40, 40);
        // entre linea dos y tres
        int linea2_3 = (SEGUNDA_LINEA + TERCERA_LINEA) / 2;
        g.drawOval(x, linea2_3, 40, 40);
        // entre tres y cuatro
        int linea3_4 = (TERCERA_LINEA + CUARTA_LINEA) / 2;
        g.drawOval(x, linea3_4, 40, 40);
    }
}
