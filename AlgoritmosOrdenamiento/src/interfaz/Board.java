package interfaz;

import java.awt.Graphics;
import java.awt.Image;
import javax.swing.JPanel;

public class Board extends JPanel {

    Image vectorImg;

    public Board() {
    }

    @Override
    public void paint(Graphics g) {
        this.paintComponent(g);
        g.drawImage(vectorImg, 0, 0, this);
    }

    public void update() {

        repaint();
    }
}
