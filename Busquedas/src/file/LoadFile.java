package file;

import java.io.File;
import java.net.URISyntaxException;
import java.net.URL;

/**
 * Clase encargada del manejo del archivo de personas
 *
 * @author Juan Miguel Arias Mejias
 * @author Ana Teresa Quesada Ramírez
 */
public class LoadFile {

    /**
     * Metodo encargado de obtener el archivo de las personas
     *
     * @return el documento
     */
    public File getFile() {
        try {
            // Se obtiene del paquete
            URL url = getClass().getResource("Listade1000000personas.txt");
            // Se retorna
            return new File(url.toURI());
        } catch (URISyntaxException ex) {
            // Error
            System.err.println("Error al cargar el archivo");
            return null;
        }
    }
} // End class
