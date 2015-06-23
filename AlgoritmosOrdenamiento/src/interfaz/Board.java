package interfaz;

import java.awt.Graphics;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * Clase que se encarga de visualizar en pantalla los elementos dibujados para
 * explicar ordenamientos
 *
 * @author Juan Miguel Arias Mejias
 * @author Ana Teresa Quesada Ramírez
 */
public class Board extends JPanel {

    Dibujar dibujar; // llama a la clase que se encarga de Dibujar los elementos para explicación
    int[] vector = {27, 14, 8, 19, 10, 17, 12, 11, 22, 24}; // vector que se va a ser ordenado
    int[][] matriz = {{27, 14, 8, 19, 10, 17, 12, 11, 22, 24}, {14, 8, 10, 12, 11, 17, 27, 19, 22, 24}, {8, 10, 11, 12, 14, 19, 27, 22, 24}, {8, 10, 12, 14, 17, 19, 22, 24, 27}};

    public Board() {
        dibujar = new Dibujar();
    }

    /**
     * Se encarga de pintar en el JFrame
     */
    @Override
    public void paint(Graphics g) {
        this.paintComponent(g);
        pintarQuick(g);
    }

    public void pintarQuick(Graphics g) {
        this.paintComponent(g);
            int[] v1 = matriz[1];
            int[] v2 = matriz[2];
            int[] v3 = matriz[3];
            int[] v4 = matriz[4];
            dibujar.dibujarVector(g, v1, new int[]{}, Dibujar.PRIMERA_LINEA);
            dibujar.dibujarVector(g, v2, new int[]{}, Dibujar.SEGUNDA_LINEA);
            dibujar.dibujarVector(g, v3, new int[]{}, Dibujar.TERCERA_LINEA);
            dibujar.dibujarVector(g, v4, new int[]{}, Dibujar.CUARTA_LINEA);
    }

    /**
     * Se encarga de actualizar en pantalla
     */
    public void update() {
        repaint();
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        Board b = new Board();
        frame.add(b);
        frame.setVisible(true);
        frame.setSize(600, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
    }
}
