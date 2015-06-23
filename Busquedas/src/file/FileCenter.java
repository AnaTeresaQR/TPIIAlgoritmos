package file;

import objetos.Persona;
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
        initVector();
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
    private void initVector() {
        file.loadToArray();
    }

    /**
     * Método que se encarga de obtener un vector con personas
     *
     * @return el vector de personas
     */
    public Persona[] getArray() {
        return file.getArray();
    }

    /**
     * Método que se encarga de obtener un array con personas
     *
     * @return el array de personas
     */
    public ArrayList<Persona> getArrayList() {
        return file.getArrayList();
    }

    /**
     * Obtener una lista
     *
     * @return la lista de personas
     */
    public List<Persona> getList() {
        return file.getList();
    }

}
