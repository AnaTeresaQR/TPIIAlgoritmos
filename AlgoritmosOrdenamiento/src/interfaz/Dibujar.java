package interfaz;

import java.awt.Graphics;

public class Dibujar {

    public void dibujarBolita(Graphics g, int numero, int x, int y) {
        g.drawOval(x, y, 40, 40);
        g.drawString(String.valueOf(numero), x+14, y+25);
    }

}
