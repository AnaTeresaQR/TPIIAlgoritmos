package busquedas;

import Estructuras.AVLTree.AvlTree;
import Estructuras.AVLTree.TreeException;
import file.FileCenter;
import interfaces.TimeTester;
import objetos.Persona;
import java.io.FileNotFoundException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 * Clase para prueba de las acciones de un árbol
 *
 * @author Juan Miguel Arias Mejias
 * @author Ana Teresa Quesada Ramírez
 */
public class AvlTreeTest implements TimeTester {

    private AvlTree tree; // clase con las operaciones de árboles AVL
    private FileCenter file; // clase que tiene los vectores y lista de personas

    public AvlTreeTest() {
        tree = new AvlTree();
        file = FileCenter.getInstance();
        this.insertAll(file.getArrayList());
    }

    /**
     * Método que se encarga de insertar una persona en el árbol
     *
     * @param persona recibe la persona a insertar
     * @throws Estructuras.AVLTree.TreeException si hay problemas al insertar
     */
    public void insert(Persona persona) throws TreeException {
        tree.insertar(persona.getCedula());
    }

    /**
     * Método que se encarga de insertar de una lista de personas al árbol,
     * removiendolo de la lista
     *
     * @param personas  recibe la lista de personas a insertar
     */
    public void insertAll(ArrayList<Persona> personas) {

        while (!personas.isEmpty()) {

            try {
                insert(personas.remove(personas.size() - 1));
            } catch (TreeException ex) {
                System.err.println("Error insertAll() AvlTreeTest");
            }
        }
    }

    /**
     * Método que se encarga de obtener el tiempo que duró en ejecutar una
     * búsqueda por cédula de una persona en el árbol
     *
     * @param cedula de la persona a buscar
     * @return el tiempo de duración
     * @throws java.io.FileNotFoundException si hay problemas de búsqueda
     */
    public long getMillisOperation(int cedula) throws FileNotFoundException {
        try {
            // quitar esto
            long inicio = System.currentTimeMillis();
            tree.buscar(cedula);
            long fin = System.currentTimeMillis();

            return fin - inicio;
        } catch (TreeException e) {
            throw new FileNotFoundException("La cedula " + cedula + " no se encuentra");
        }
    }

    /**
     * Método que se encarga de darle formato al tiempo de duración del árbol
     *
     * @param cedula recibe la cédula a buscar
     * @return el formato en una hilera de lo que duró el árbol en buscar
     * @throws java.io.FileNotFoundException si hay problemas al dar el formato
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
     * @return la hilera de texto con la cédula y el formato de duración
     * @throws java.io.FileNotFoundException si hay problemas al buscar
     */
    @Override
    public String searchTime(int cedula) throws FileNotFoundException {
        return "Cedula: " + cedula + "\nEl tiempo de busqueda fue: " + getFormatTime(cedula);
    }

    public static void main(String[] args) {

        try {

            AvlTreeTest t = new AvlTreeTest();
            // Muy a la derecha
            System.out.println(t.searchTime(900140896));
            // Muy a la izquierda
            System.out.println(t.searchTime(111050060));
            // No existe
            System.out.println(t.searchTime(234234812));

        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

}
