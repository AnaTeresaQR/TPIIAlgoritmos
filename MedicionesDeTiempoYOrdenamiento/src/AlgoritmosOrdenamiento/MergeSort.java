package AlgoritmosOrdenamiento;

import File.FileCenter;
import Interfaces.TimeTester;
import Objetos.Persona;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Clase que se encarga de ordenar el archivo con el algoritmo MergeSort
 *
 * @author Juan Miguel Arias Mejias
 * @author Ana Teresa Quesada Ramírez
 */
public class MergeSort implements TimeTester {

    private FileCenter file; // recibe el archivo que va a ordenar

    public MergeSort() {
        file = FileCenter.getInstance();
    }

    /**
     * Si el número de elementos es 0 o 1, acabar
     *
     * @param a vector comparable
     */
    public void mergeSort(Comparable[] a) {
        Comparable[] tmp = new Comparable[a.length];
        mergeSort(a, tmp, 0, a.length - 1);
    }

    /**
     * Ordenar recursivamente las dos mitades del vector
     */
    private void mergeSort(Comparable[] a, Comparable[] tmp, int left, int right) {
        if (left < right) {
            int center = (left + right) / 2;
            mergeSort(a, tmp, left, center);
            mergeSort(a, tmp, center + 1, right);
            merge(a, tmp, left, center + 1, right);
        }
    }

    /**
     * Se encarga de mezclar las dos mitades ordenadas en un vector ordenado
     */
    private void merge(Comparable[] a, Comparable[] tmp, int left, int right, int rightEnd) {
        int leftEnd = right - 1;
        int k = left;
        int num = rightEnd - left + 1;

        while (left <= leftEnd && right <= rightEnd) {
            if (a[left].compareTo(a[right]) <= 0) {
                tmp[k++] = a[left++];
            } else {
                tmp[k++] = a[right++];
            }
        }

        while (left <= leftEnd) // Copy rest of first half
        {
            tmp[k++] = a[left++];
        }

        while (right <= rightEnd) // Copy rest of right half
        {
            tmp[k++] = a[right++];
        }

        // Copy tmp back
        for (int i = 0; i < num; i++, rightEnd--) {
            a[rightEnd] = tmp[rightEnd];
        }
    }

    /**
     * Método que se encarga de obtener el tiempo que duró en ejecutar la
     * búsqueda con mergeSort por cédula de una persona en el vector
     *
     * @return el tiempo de duración
     */
    @Override
    public long getMillisOperation() {
        file.clearVector();
        long inicio = System.currentTimeMillis();
        Persona[] personas = file.getVector();
        this.mergeSort(personas);
        long fin = System.currentTimeMillis();

        return fin - inicio;
    }

    /**
     * Método que se encarga de darle formato al tiempo de duración del vector
     *
     * @return el formato en una hilera de lo que duró en ordenar
     */
    @Override
    public String getFormatTime() {

        long time = getMillisOperation();
        return (new SimpleDateFormat("mm:ss:SSS")).format(new Date(time));
    }

    public static void main(String[] args) {
        MergeSort m = new MergeSort();;
        System.out.println(m.getMillisOperation());
        System.out.println(m.getFormatTime());
    }

}
