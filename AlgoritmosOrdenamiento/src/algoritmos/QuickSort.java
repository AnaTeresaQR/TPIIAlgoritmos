/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algoritmos;

/**
 *
 * @author Juan Miguel Arias Mejias
 */
public class QuickSort {

    public void quickSort(Integer[] vector, int inicio, int fin) {
        if (inicio >= fin) {
            return;
        }
        int pivote = vector[inicio];
        int izq = inicio + 1;
        int der = fin;
        while (izq <= der) {
            while (izq <= fin && vector[izq] < pivote) {
                izq++;
            }
            while (der > inicio && vector[der] >= pivote) {
                der--;
            }
            if (izq < der) {
                int tmp = vector[izq];
                vector[izq] = vector[der];
                vector[der] = tmp;
            }
        }
        if (der > inicio) {
            int tmp = vector[inicio];
            vector[inicio] = vector[der];
            vector[der] = tmp;
        }
        quickSort(vector, inicio, der - 1);
        quickSort(vector, der + 1, fin);
    }

    public static void main(String[] args) {

        QuickSort q = new QuickSort();
    }

}
