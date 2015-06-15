package AlgoritmosOrdenamiento;

import File.FileCenter;
import Interfaces.TimeTester;
import Objetos.Persona;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Clase que se encarga de ordenar el archivo con el algoritmo RadixSort
 *
 * @author Juan Miguel Arias Mejias
 * @author Ana Teresa Quesada Ramírez
 */
public class RadixSort implements TimeTester {

    private FileCenter file; // recibe el archivo que va a ordenar

    public RadixSort() {
        file = FileCenter.getInstance();
    }

    /**
     * Método que se encarga de hacer una ordenación con personas de tipo radixSort
     *
     * @param a vector de personas a ordenar
     */
    public void radixSort(Persona[] a) {
        int i, m = a[0].getCedula(), exp = 1, n = a.length;
        Persona[] b = new Persona[10];
        for (i = 1; i < n; i++) {
            if (a[i].getCedula() > m) {
                m = a[i].getCedula();
            }
        }
        while (m / exp > 0) {
            int[] bucket = new int[10];

            for (i = 0; i < n; i++) {
                bucket[(a[i].getCedula() / exp) % 10]++;
            }
            for (i = 1; i < 10; i++) {
                bucket[i] += bucket[i - 1];
            }
            for (i = n - 1; i >= 0; i--) {
                b[--bucket[(a[i].getCedula() / exp) % 10]] = a[i];
            }
            for (i = 0; i < n; i++) {
                a[i] = b[i];
            }
            exp *= 10;
        }
    }

    /**
     * Método que se encarga de obtener el tiempo que duró en ejecutar la
     * búsqueda con radixSort por cédula de una persona en el vector
     *
     * @return el tiempo de duración
     */
    @Override
    public long getMillisOperation() {
        file.clearVector();
        long inicio = System.currentTimeMillis();
        Persona[] personas = file.getVector();
        this.radixSort(personas);
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

        RadixSort s = new RadixSort();
        System.out.println(s.getMillisOperation());
        System.out.println(s.getFormatTime());
    }

}
