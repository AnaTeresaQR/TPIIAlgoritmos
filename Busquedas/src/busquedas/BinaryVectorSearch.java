package busquedas;

import file.FileCenter;
import interfaces.TimeTester;
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
public class BinaryVectorSearch implements TimeTester {

    private FileCenter file; // clase que tiene los vectores y lista de personas
    private int[] vector; // crea un vector

    public BinaryVectorSearch() {
        file = FileCenter.getInstance();
        vector = null;
    }

    /**
     * Método que se encarga de insertar personas en un vector
     *
     * @param personas recibe una lista con personas para ingresarlas al vector
     */
    public void insertAll(ArrayList<Persona> personas) {

        vector = new int[personas.size()];

        for (int i = 0; i < vector.length; i++) {

            vector[i] = personas.remove(personas.size() - 1).getCedula();
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
    public int binarySearch(int searchItem, int[] intVector) {

        //Creo un rango entre los 2 indices
        int startIndex = 0; // indice para empezar
        int endIndex = intVector.length - 1; // indice para terminar
        int currentItem;

        while (startIndex <= endIndex) {
            currentItem = (startIndex + endIndex) / 2;
            if (intVector[currentItem] == searchItem) {
                return currentItem;
            } else {
                if (intVector[currentItem] < searchItem) {
                    startIndex = currentItem + 1;
                } else {
                    endIndex = currentItem - 1;
                }
            }

        }
        return -1;
    }

    /**
     * Método que se encarga de obtener el tiempo que duró en ejecutar una
     * búsqueda por cédula de una persona en el vector
     *
     * @param cedula de la persona a buscar
     * @return el tiempo de duración
     * @throws java.io.FileNotFoundException si no se encuentra la cedula
     */
    public long getMillisOperation(int cedula) throws FileNotFoundException {

        insertAll(file.getArrayList());
        long inicio = System.currentTimeMillis();
        int result = binarySearch(cedula, vector);
        long fin = System.currentTimeMillis();

        // Si no se encuentra
        if (result == -1) {
            throw new FileNotFoundException("La cedula " + cedula + " no se encuentra");
        }

        return fin - inicio;

    }

    /**
     * Método que se encarga de darle formato al tiempo de duración del vector
     *
     * @param cedula recibe la cédula a buscar
     * @return el formato en una hilera de lo que duró el árbol en buscar
     * @throws java.io.FileNotFoundException si no se encuentra la cedula
     */
    public String getFormatTime(int cedula) throws FileNotFoundException {

        long time = getMillisOperation(cedula);
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
    @Override
    public String searchTime(int cedula) throws FileNotFoundException {
        return "Cedula: " + cedula + "\nEl tiempo de busqueda fue: " + getFormatTime(cedula);
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

            System.out.println(b.searchTime(900140896));
            System.out.println(b.searchTime(111050060));
            // No existe
            System.out.println(b.searchTime(234234812));

        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }

    }
}
