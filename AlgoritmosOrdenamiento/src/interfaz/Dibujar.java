package interfaz;

import java.awt.Color;
import java.awt.Graphics;

public class Dibujar {

    public void dibujarBolita(Graphics g, int numero, int x, int y, boolean resaltado) {
        if (resaltado) {
            g.setColor(Color.red);
        } else {
            g.setColor(Color.black);
        }
        g.drawOval(x, y, 40, 40);
        g.drawString(String.valueOf(numero), x + 14, y + 25);
    }

    public void dibujarVector(Graphics g, int[] numeros, int index) {
        boolean resaltado = false;
        for (int i = 0; i < numeros.length; i++) {
            int numero = numeros[i];
            if (i == index - 1) {
                resaltado = true;
            } else {
                resaltado = false;
            }
            dibujarBolita(g, numero, i * 50, 30, resaltado);
        }
    }
}
