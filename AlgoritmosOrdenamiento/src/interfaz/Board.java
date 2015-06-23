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

    public Board() {
        dibujar = new Dibujar();
    }

    /**
     * Se encarga de pintar en el JFrame
     */
    @Override
    public void paint(Graphics g) {
        this.paintComponent(g);
        dibujar.dibujarVector(g, vector, 4);
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
        frame.setSize(550, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
    }
}
