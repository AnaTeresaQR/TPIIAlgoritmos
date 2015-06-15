package File;

import Objetos.Persona;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase con instancia única que se encarga del manejo de la lista y del vector
 * que se llenarán con personas
 *
 * @author Juan Miguel Arias Mejias
 * @author Ana Teresa Quesada Ramírez
 */
public class FileCenter {

    private static FileCenter unique; // variable que inicializará la instancia de clase
    private SolveFile file;

    private FileCenter() {
        file = new SolveFile();
    }

    /**
     * Metodo estático que devuelve instancia de clase
     *
     * @return una única instancia de clase
     */
    public static FileCenter getInstance() {
        if (unique == null) {
            unique = new FileCenter();
            return unique;
        } else {
            return unique;
        }
    }

    /**
     * Inicializa el vector cargado del archivo con personas
     */
    public void initVector() {
        file.loadToArray();
    }

    /**
     * Método que se encarga de obtener un vector con personas, primero
     * inicializa el vector con personas
     *
     * @return el vector de personas
     */
    public Persona[] getVector() {
        initVector();
        return file.getArray();
    }

    /**
     * Método que se encarga de obtener un array con personas, primero
     * inicializa el vector con personas
     *
     * @return el array de personas
     */
    public ArrayList<Persona> getArrayList() {
        initVector();
        return file.getArrayList();
    }

    /**
     * Obtener una lista, primero inicializa el vector con personas
     *
     * @return la lista de personas
     */
    public List<Persona> getList() {
        initVector();
        return file.getList();
    }

    /**
     * Se encarga de limpiar el vector de personas
     */
    public void clearVector() {
        file.clearVector();
    }

}
