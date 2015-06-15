/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package threads;

import Vector.StateManager;
import Vector.Vector;
import algoritmos.ShellSort;
import interfaz.Board;
import java.util.Random;

/**
 *
 * @author Juan Miguel Arias Mejias
 */
public class ShellThread extends Thread {

    StateManager states;
    private Board board;
    private ShellSort shellSort;
    private int step = 0;

    public ShellThread(Board board) {
        super("Animation ShellThread");
        this.board = board;
        shellSort = new ShellSort();
    }

    @Override
    public void run() {

        animation();
    }

    public void animation() {

        Vector target = new Vector(this.randInit());
        board.update(target);
        states = shellSort.shellSort(target);
        // ciclo infinito
        // si quiere avanzar una posicion
        // luego de la ultima se debe salir
        while (true) {

            if (step > 1) {

                try {
                    // Vuelve a ser cero
                    step= 0;
                    board.update(states.nextState());

                } catch (IndexOutOfBoundsException ex) {
                    break;
                }
            }

            if (step < -1) {

                try {
                    // Vuelve a ser cero
                    step=0;
                    board.update(states.aboveState());

                } catch (IndexOutOfBoundsException ex) {
                    // No hace nada
                }
            }
        }
    }

    /**
     * Agrega valores random al vector
     *
     * @return
     */
    public Integer[] randInit() {
        Integer[] vector = new Integer[10];
        Random random = new Random();
        for (int i = 0; i < vector.length; i++) {
            vector[i] = random.nextInt(50);
        }
        return vector;
    }

    public void stepForward() {
        step++;
    }

    public void stepBackward() {
        step--;
    }

}
