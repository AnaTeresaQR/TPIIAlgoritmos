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
public class RadixSort {

    /**
     * Radix Sort function
     *
     *
     * @param a vector de personas
     */
    public void radixSort(Integer[] a) {
        int i, m = a[0], exp = 1, n = a.length;
        int[] b = new int[10];
        for (i = 1; i < n; i++) {
            if (a[i] > m) {
                m = a[i];
            }
        }
        while (m / exp > 0) {
            Integer[] bucket = new Integer[10];

            for (i = 0; i < n; i++) {
                bucket[(a[i] / exp) % 10]++;
            }
            for (i = 1; i < 10; i++) {
                bucket[i] += bucket[i - 1];
            }
            for (i = n - 1; i >= 0; i--) {
                b[--bucket[(a[i] / exp) % 10]] = a[i];
            }
            for (i = 0; i < n; i++) {
                a[i] = b[i];
            }
            exp *= 10;
        }
    }

    public static void main(String[] args) {

        RadixSort s = new RadixSort();
    }

}
