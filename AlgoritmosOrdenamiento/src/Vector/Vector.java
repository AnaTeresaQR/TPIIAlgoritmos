/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vector;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.util.Arrays;

/**
 *
 * @author Juan Miguel Arias Mejias
 */
// Originator
public class Vector {

    private Integer[] vector;
    private final int X = 0;
    private final int Y = 1;

    public Vector() {
        vector = new Integer[10];
    }

    public Vector(Integer[] vector) {
        this.vector = vector;
    }

    public Image drawVector() {

        BufferedImage vImage = new BufferedImage(410, 50, BufferedImage.TYPE_INT_RGB);
        Graphics g = vImage.getGraphics();

        final int[] DeltaOval = {40, 0};
        final int[] DeltaNum = {9, 20};
        int[] oval = {10, (vImage.getHeight() / 2) - 13};
        int[] num = {oval[X] + DeltaNum[X], oval[Y] + DeltaNum[Y]};
        final int[] OVALSIZE = {30, 30};

        // Aqui seleccionar el color de la letra
        for (int i = 0; i < vector.length; i++) {

            g.drawOval(oval[X], oval[Y], OVALSIZE[X], OVALSIZE[Y]);
            g.drawString(vector[i] + "", num[X], num[Y]);

            // Move
            oval[X] += DeltaOval[X];
            oval[Y] += DeltaOval[Y];
            num[X] = oval[X] + DeltaNum[X];
            num[Y] = oval[Y] + DeltaNum[Y];
            // Move

        }

        ///// Initial values
        //oval[X] = 10;
        //num[X] = oval[X] + DeltaNum[X];
        //oval[Y] = 20;
        //num[Y] = oval[Y] + DeltaNum[Y];
        //// Initial values
        return vImage;
    }

    public Integer[] getVector() {
        return vector;
    }

    public void setVector(Integer[] vector) {
        this.vector = vector;
    }

    public Vector copy() {
        Vector v = new Vector();
        v.setVector(vector);
        return v;
    }

    @Override
    public String toString() {
        return Arrays.toString(vector);
    }

}
