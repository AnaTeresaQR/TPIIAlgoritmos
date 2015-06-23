package interfaz;

import java.awt.Graphics;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Board extends JPanel {

    Dibujar dibujar;
    int[] vector = {27, 14, 8, 19, 10, 17, 12, 11, 22, 24};

    public Board() {
        dibujar = new Dibujar();
    }

    @Override
    public void paint(Graphics g) {
        this.paintComponent(g);
        dibujar.dibujarVector(g, vector, 4);
    }

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
