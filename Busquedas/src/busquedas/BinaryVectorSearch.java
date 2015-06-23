package busquedas;

import file.FileCenter;
import objetos.Persona;
import java.io.FileNotFoundException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

/**
 * Clase para prueba de operaciones para búsquedas binarias en un vector
 *
 * @author Juan Miguel Arias Mejias
 * @author Ana Teresa Quesada Ramírez
 */
public class BinaryVectorSearch {

    private FileCenter file; // clase que tiene los vectores y lista de personas
    private Persona[] vector; // crea un vector

    public BinaryVectorSearch() {
        file = FileCenter.getInstance();
        vector = null;
        insertAll(file.getArrayList());
    }

    /**
     * Método que se encarga de insertar personas en un vector
     *
     * @param personas recibe una lista con personas para ingresarlas al vector
     */
    public void insertAll(ArrayList<Persona> personas) {

        vector = new Persona[personas.size()];

        for (int i = 0; i < vector.length; i++) {

            vector[i] = personas.remove(personas.size() - 1);
        }
        Arrays.sort(vector);
    }

    /**
     * Metodo que se encarga de realizar búsqueda binaria en un vector
     *
     * @param searchItem elemento a buscar
     * @param intVector el vector en donde se realizara la busqueda
     * @return indice del valor encontrado en caso de no ser encontrado -1
     */
    public Persona binarySearch(int searchItem, Persona[] intVector) {

        //Creo un rango entre los 2 indices
        int startIndex = 0; // indice para empezar
        int endIndex = intVector.length - 1; // indice para terminar
        int currentItem;

        while (startIndex <= endIndex) {
            currentItem = (startIndex + endIndex) / 2;
            if (intVector[currentItem].getCedula() == searchItem) {
                return intVector[currentItem];
            } else {
                if (intVector[currentItem].getCedula() < searchItem) {
                    startIndex = currentItem + 1;
                } else {
                    endIndex = currentItem - 1;
                }
            }

        }
        return null;
    }

    /**
     * Método que se encarga de obtener el tiempo que duró en ejecutar una
     * búsqueda por cédula de una persona en el vector
     *
     * @param inicio es el inicio
     * @param fin es el fin
     * @return el tiempo de duración
     * @throws java.io.FileNotFoundException si no se encuentra la cedula
     */
    public long getMillisOperation(long inicio, long fin) throws FileNotFoundException {

        return fin - inicio;

    }

    /**
     * Método que se encarga de darle formato al tiempo de duración del vector
     *
     * @param time a dar formato
     * @return el formato en una hilera de lo que duró el árbol en buscar
     * @throws java.io.FileNotFoundException si no se encuentra la cedula
     */
    public String getFormatTime(long time) throws FileNotFoundException {

        return (new SimpleDateFormat("mm:ss:SSS")).format(new Date(time));
    }

    /**
     * Metodo que devuelve la hilera completa de la cédula que buscó y su tiempo
     * en el formato dado
     *
     * @param cedula la cedula a buscar
     * @return la hilera de texto con la cédula y e formato de duración
     * @throws java.io.FileNotFoundException si no se encuentra la cedula
     */
    public String searchTime(int cedula) throws FileNotFoundException {

        long inicio = System.currentTimeMillis();
        System.out.println("Long de inicio: " + inicio);
        Persona result = binarySearch(cedula, vector);
        long fin = System.currentTimeMillis();
        System.out.println("Long de fin: " + fin);

        if (result == null) {

            throw new FileNotFoundException("La cedula " + cedula + " no se encuentra");
        }

        return "Cedula: " + result.toString() + "\nEl tiempo de busqueda fue: " + getFormatTime(this.getMillisOperation(inicio, fin));
    }

    /**
     * Se encarga de imprimir el vector
     *
     * @return una hilera de texto con los datos del vector
     */
    public String printVector() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < vector.length; i++) {
            sb.append(vector[i]).append("\n");
        }

        return sb.toString();
    }

    public static void main(String[] args) {

        BinaryVectorSearch b = new BinaryVectorSearch();

        try {

            System.out.println(b.searchTime(701890319));
            System.out.println(b.searchTime(107430035));
            // No existe
            System.out.println(b.searchTime(234234812));

        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }

    }
}
