package interfaces;

import java.io.FileNotFoundException;

/**
 * Interface con método que deberán dar cuerpo clases que implementen de la
 * interfaz
 *
 * @author Juan Miguel Arias Mejias
 * @author Ana Teresa Quesada Ramírez
 */
public interface TimeTester {

    String searchTime(int cedula) throws FileNotFoundException;

}
