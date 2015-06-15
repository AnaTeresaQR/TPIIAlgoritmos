/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algoritmos;

import Vector.StateManager;
import Vector.Vector;

/**
 *
 * @author Juan Miguel Arias Mejias
 */
public class ShellSort {

    public StateManager shellSort(Vector v) {
        StateManager states = new StateManager();
        Integer[] a = v.getVector();
        states.saveState(v);

        for (int gap = a.length / 2; gap > 0; gap = gap == 2 ? 1 : (int) (gap / 2.2)) {
            for (int i = gap; i < a.length; i++) {
                int tmp = a[i];
                int j;
                for (j = i; j >= gap && tmp < a[j - gap]; j -= gap) {
                    a[j] = a[j - gap];
                    // Reporta el cambio
                    states.saveState(new Vector(copy(a)));
                }
                a[j] = tmp;
                // Reporta el cambio
                states.saveState(new Vector(copy(a)));
            }
        }

        return states;
    }

    public Integer[] copy(Integer[] vector) {
        Integer[] nuevo = new Integer[vector.length];
        for (int i = 0; i < vector.length; i++) {
            nuevo[i] = vector[i];
        }

        return nuevo;
    }

    public static void main(String[] args) {

        ShellSort s = new ShellSort();
    }

}
