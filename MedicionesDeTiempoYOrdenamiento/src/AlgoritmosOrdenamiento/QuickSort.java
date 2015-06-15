package AlgoritmosOrdenamiento;

import File.FileCenter;
import Interfaces.TimeTester;
import Objetos.Persona;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Clase que se encarga de ordenar el archivo con el algoritmo QuickSort
 *
 * @author Juan Miguel Arias Mejias
 * @author Ana Teresa Quesada Ramírez
 */
public class QuickSort implements TimeTester {

    private FileCenter file; // recibe el archivo que va a ordenar

    public QuickSort() {
        file = FileCenter.getInstance();
    }

    /**
     * Algoritmo recursivo de ordenamiento , que se encarga de hacer una
     * ordenación con personas de tipo quickSort
     *
     * @param vector de personas a ordenar
     * @param inicio el elemento cuyo indice es 0 en el vector
     * @param fin el último elemento del vector
     */
    public void quickSort(Persona[] vector, int inicio, int fin) {
        if (inicio >= fin) {
            return;
        }
        Persona pivote = vector[inicio];
        int izq = inicio + 1;
        int der = fin;
        while (izq <= der) {
            while (izq <= fin && vector[izq].getCedula() < pivote.getCedula()) {
                izq++;
            }
            while (der > inicio && vector[der].getCedula() >= pivote.getCedula()) {
                der--;
            }
            if (izq < der) {
                Persona tmp = vector[izq];
                vector[izq] = vector[der];
                vector[der] = tmp;
            }
        }
        if (der > inicio) {
            Persona tmp = vector[inicio];
            vector[inicio] = vector[der];
            vector[der] = tmp;
        }
        quickSort(vector, inicio, der - 1);
        quickSort(vector, der + 1, fin);
    }

    /**
     * Método que se encarga de obtener el tiempo que duró en ejecutar la
     * búsqueda con QuickSort por cédula de una persona en el vector
     *
     * @return el tiempo de duración
     */
    @Override
    public long getMillisOperation() {
        file.clearVector();
        long inicio = System.currentTimeMillis();
        Persona[] personas = file.getVector();
        this.quickSort(personas, 0, file.getVector().length - 1);
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

        QuickSort q = new QuickSort();
        System.out.println(q.getMillisOperation());
        System.out.println(q.getFormatTime());
    }

}
