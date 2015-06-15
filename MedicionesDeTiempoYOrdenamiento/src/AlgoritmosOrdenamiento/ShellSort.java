package AlgoritmosOrdenamiento;

import File.FileCenter;
import Interfaces.TimeTester;
import Objetos.Persona;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Clase que se encarga de ordenar el archivo con el algoritmo ShellSort
 *
 * @author Juan Miguel Arias Mejias
 * @author Ana Teresa Quesada Ramírez
 */
public class ShellSort implements TimeTester{

    private FileCenter file; // recibe el archivo que va a ordenar

    public ShellSort() {
        file = FileCenter.getInstance();
    }

    /**
     * Ordenación por inserción pero se divide el vector en intervalos que se
     * van ordenando como si fuera un sub­array cuenta el total de elementos del
     * vector y se divide este número por la mitad, k=n/2 donde n es la cantidad
     * de elementos del vector , Cada elemento a comparar estará separado del
     * otro, por k elementos
     *
     * @param a vector de personas a ordenar
     */
    public void shellSort(Persona a[]) {
        for (int gap = a.length / 2; gap > 0; gap = gap == 2 ? 1 : (int) (gap / 2.2)) {
            for (int i = gap; i < a.length; i++) {
                Persona tmp = a[i];
                int j;
                for (j = i; j >= gap && tmp.getCedula() < a[j - gap].getCedula(); j -= gap) {
                    a[j] = a[j - gap];
                }
                a[j] = tmp;
            }
        }
    }

    /**
     * Método que se encarga de obtener el tiempo que duró en ejecutar la
     * búsqueda con shellSort por cédula de una persona en el vector
     *
     * @return el tiempo de duración
     */
    public long getMillisOperation() {
        long inicio = System.currentTimeMillis();
        file.initVector();
        Persona[] personas = file.getVector();
        this.shellSort(personas);
        long fin = System.currentTimeMillis();

        return fin - inicio;
    }

    /**
     * Método que se encarga de darle formato al tiempo de duración del vector
     *
     * @return el formato en una hilera de lo que duró en ordenar
     */
    public String getFormatTime() {

        long time = getMillisOperation();
        return (new SimpleDateFormat("mm:ss:SSS")).format(new Date(time));
    }

    public static void main(String[] args) {

        ShellSort s = new ShellSort();
        System.out.println(s.getMillisOperation());
        System.out.println(s.getFormatTime());
    }

}
