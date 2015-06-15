/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaz;

import Vector.Vector;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.JPanel;

/**
 *
 * @author AnaTere
 */
public class Board extends JPanel {

    Image vectorImg;
    private Vector vector;

    public Board() {
    }

    @Override
    public void paint(Graphics g) {
        this.paintComponent(g);
        g.drawImage(vectorImg, 0, 0, this);
    }

    public void update(Vector vector) {
        this.vector = vector;
        vectorImg = vector.drawVector();
        repaint();
    }
}
