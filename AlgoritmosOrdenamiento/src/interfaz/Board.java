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
    int[] vector2 = {27, 14, 8, 19, 10, 17, 7};
    int[] vector3 = {27, 14, 8, 19, 10};
    int[] vector4 = {27, 14, 8, 19};

    public Board() {
        dibujar = new Dibujar();
    }

    /**
     * Se encarga de pintar en el JFrame
     */
    @Override
    public void paint(Graphics g) {
        this.paintComponent(g);
        dibujar.dibujarVector(g, vector, new int[]{7, 2, 5}, Dibujar.PRIMERA_LINEA);
        dibujar.dibujarVector(g, vector2, new int[]{7, 2, 5}, Dibujar.SEGUNDA_LINEA);
        dibujar.dibujarVector(g, vector3, new int[]{7, 2, 5}, Dibujar.TERCERA_LINEA);
        dibujar.dibujarVector(g, vector4, new int[]{7, 2, 5}, Dibujar.CUARTA_LINEA);
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
