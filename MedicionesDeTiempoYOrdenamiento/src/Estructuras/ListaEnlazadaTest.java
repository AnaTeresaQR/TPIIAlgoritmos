package Estructuras;

import Estructuras.ListaEnlazada.ListaEnlazada;
import Estructuras.ListaEnlazada.ListaException;
import File.FileCenter;
import Interfaces.TimeTester;
import Objetos.Persona;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 * Clase para prueba de las acciones de una lista enlazada
 *
 * @author Juan Miguel Arias Mejias
 * @author Ana Teresa Quesada Ramírez
 */
public class ListaEnlazadaTest implements TimeTester {

    private ListaEnlazada lista;
    private FileCenter file;

    public ListaEnlazadaTest() {
        lista = new ListaEnlazada();
        file = FileCenter.getInstance();
    }

    /**
     * Método que se encarga de insertar ordenado de una persona en la lista
     * enlazada
     *
     * @param persona recibe la persona a insertar
     * @throws Estructuras.ListaEnlazada.ListaException problemas al insertar
     * personas
     */
    public void insert(Persona persona) throws ListaException {

        lista.insertarOrdenado(persona.getCedula());
    }

    /**
     * Método que se encarga de insertar de una lista de personas a la lista
     * enlazada, removiendolo de la lista
     *
     * @param personas  recibe la lista de personas a insertar
     */
    public void insertAll(ArrayList<Persona> personas) {

        while (!personas.isEmpty()) {

            try {
                insert(personas.remove(personas.size() - 1));
            } catch (ListaException ex) {
                System.err.println("Error insertAll() ListaEnlazadaTest\n" + ex.getMessage());
            }
        }
    }

    /**
     * Método que se encarga de obtener el tiempo que duró en ejecutar la
     * inserción de personas en una lista enlazada
     *
     * @return el tiempo de duración
     */
    @Override
    public long getMillisOperation() {
        lista = new ListaEnlazada();
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
     * @return el formato en una hilera de lo que duró la lista en insertar
     */
    @Override
    public String getFormatTime() {
        lista = new ListaEnlazada();
        long time = getMillisOperation();
        return (new SimpleDateFormat("mm:ss:SSS")).format(new Date(time));
    }

    public static void main(String[] args) {

        ListaEnlazadaTest t = new ListaEnlazadaTest();
        System.out.println(t.getMillisOperation());
        System.out.println(t.getFormatTime());
    }

}
