package interfaz;

import java.awt.Graphics;
import javax.swing.JPanel;

/**
 * Clase que se encarga de visualizar en pantalla los elementos dibujados para
 * explicar ordenamientos
 *
 * @author Juan Miguel Arias Mejias
 * @author Ana Teresa Quesada Ramírez
 */
public class Board extends JPanel implements Runnable {

    Dibujar dibujar; // llama a la clase que se encarga de Dibujar los elementos para explicación
    int[] vector = {27, 14, 8, 19, 10, 17, 12, 11, 22, 24}; // vector que se va a ser ordenado
    int[] vector1 = {27};
    int[][] matriz = {
        {27, 14, 8, 19, 10, 17, 12, 11, 22, 24},
        {14, 8, 10, 12, 11},
        {27, 19, 22, 24},
        {8},
        {14, 12, 11},
        {19},
        {24, 27},
        {11},
        {14},
        {24},
        {27},
        {8, 10, 11, 12, 14, 17, 19, 22, 24, 27}};
    
    

    int row;
    int index;
    Thread hilo;

    public Board() {
        dibujar = new Dibujar();
        hilo = new Thread(this);
    }

    /**
     * Se encarga de pintar en el JFrame
     */
    @Override
    public void paint(Graphics g) {
        this.paintComponent(g);
        dibujar.dibujarVector(g, matriz[row], Dibujar.LINEAS[index]);
    }

    public void pintarQuick(Graphics g) {
        try {
            int[] v1 = matriz[0];
            int[] v2 = matriz[1];
            int[] v3 = matriz[2];
            int[] v4 = matriz[3];
            dibujar.dibujarVector(g, v1, new int[]{6}, Dibujar.PRIMERA_LINEA);
            repaint();
            dibujar.dibujarVector(g, v2, new int[]{3, 7}, Dibujar.SEGUNDA_LINEA);
            repaint();
            dibujar.dibujarVector(g, v3, new int[]{2, 7}, Dibujar.TERCERA_LINEA);
            Thread.sleep(3000);
            repaint();
            dibujar.dibujarVector(g, v4, new int[]{1, 2}, Dibujar.CUARTA_LINEA);
            repaint();

        } catch (InterruptedException ex) {
            System.out.println("");
        }
    }

    @Override
    public void run() {
        for (int i = 0; i < matriz.length; i++) {
            try {
                repaint();
                Thread.sleep(3000);
                row++;
                index = dibujar.getIndex();

            } catch (InterruptedException ex) {
                System.out.println("");
            }
        }
    }

    /**
     * Se encarga de actualizar en pantalla
     */
    public void update() {
        repaint();
    }

    public void start() {
        hilo.start();
    }

    public static void main(String[] args) {
//        JFrame frame = new JFrame();
//        Board b = new Board();
//        frame.add(b);
//        frame.setVisible(true);
//        frame.setSize(600, 600);
//        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        frame.setLocationRelativeTo(null);
//        hilo.start();

    }

}
