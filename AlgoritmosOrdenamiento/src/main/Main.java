

package main;

import Vector.Vector;
import interfaz.Board;
import javax.swing.JFrame;
import threads.ShellThread;

/**
 *
 * @author Juan Miguel Arias Mejias
 */
public class Main {

    public static void main(String[] args) {
        Vector v = new Vector();
        JFrame f = new JFrame();
        Board board = new Board();
        board.update(v);
        f.add(board);
        ShellThread hilo = new ShellThread(board);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setSize(500, 300);
        hilo.start();
        f.setVisible(true);
    }

}
