package interfaz;

import java.awt.Graphics;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Board extends JPanel {

    Dibujar dibujar;

    public Board() {
        dibujar = new Dibujar();
    }

    @Override
    public void paint(Graphics g) {
        this.paintComponent(g);
        int num = 1;
        for (int i = 0; i < 10; i++) {
            dibujar.dibujarBolita(g, num, (i * 50), 30);
            num += 3;
        }
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
