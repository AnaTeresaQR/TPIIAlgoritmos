package Estructuras;

import Estructuras.AVLTree.AvlTree;
import Estructuras.AVLTree.TreeException;
import File.FileCenter;
import Interfaces.TimeTester;
import Objetos.Persona;
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

    private AvlTree tree;
    private FileCenter file;

    public AvlTreeTest() {
        tree = new AvlTree();
        file = FileCenter.getInstance();
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
     * @param personas recibe la lista de personas a insertar
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
     * Método que se encarga de obtener el tiempo que duró en ejecutar la
     * inserción de personas en un árbol
     *
     * @return el tiempo de duración
     */
    @Override
    public long getMillisOperation() {
        tree = new AvlTree();
        file.clearVector();
        long inicio = System.currentTimeMillis();
        ArrayList<Persona> personas = file.getArrayList();
        this.insertAll(personas);
        long fin = System.currentTimeMillis();

        return fin - inicio;
    }

    /**
     * Método que se encarga de darle formato al tiempo de duración
     *
     * @return el formato en una hilera de lo que duró el árbo en insertar
     */
    @Override
    public String getFormatTime() {

        tree = new AvlTree();
        long time = getMillisOperation();
        return (new SimpleDateFormat("mm:ss:SSS")).format(new Date(time));
    }

    public static void main(String[] args) {

        AvlTreeTest t = new AvlTreeTest();
        System.out.println(t.getMillisOperation());
        System.out.println(t.getFormatTime());
    }

}
