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
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        dibujar.mostrarMsj(g, "Vector a ordenar", Dibujar.LINEA0_1);
        dibujar.dibujarVector(g, matriz[0], new int[]{5}, Dibujar.PRIMERA_LINEA);
        dibujar.mostrarMsj(g, "Se selecciona la mitad menor a 17 y la mayor a la derecha", Dibujar.LINEA1_2);
        dibujar.dibujarVector(g, matriz[1], new int[]{2}, Dibujar.SEGUNDA_LINEA);
        dibujar.vectorDer(g, matriz[2], this.getWidth() / 2, Dibujar.TERCERA_LINEA);

    }

    @Override
    public void run() {
        for (int i = 0; i < matriz.length; i++) {
            try {
                repaint();
                Thread.sleep(3000);

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
//Graphics2D g2d = (Graphics2D) g;
    //     g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
}
