package Main;

import busquedas.AvlTreeTest;
import busquedas.BinaryVectorSearch;
import interfaz.JOP;
import java.io.FileNotFoundException;

/**
 * Clase que se encarga del menu y la interacción correspondiente con el usuario
 *
 * @author Juan Miguel Arias Mejias
 * @author Ana Teresa Quesada Ramírez
 */
public class Menu {

    private AvlTreeTest tree;
    private BinaryVectorSearch vector;

    public Menu() {
        tree = new AvlTreeTest();
        vector = new BinaryVectorSearch();
    }

    /**
     * Método que se encarga de mostrar el menu al usuario y su interacción
     */
    public void mostrar() {
        do {
            try {
                int opcion = JOP.solicitarInt("Digite la opcion deseada\nPara encontrar la cedula\n"
                        + "1. Buscar en el AVLTree\n"
                        + "2. Buscar en un Vector\n"
                        + "3. Salir\n");

                if (opcion == 3) {
                    System.exit(0);
                }
                int cedula = JOP.solicitarInt("Ingrese el número de cédula a buscar");

                switch (opcion) {
                    case 1:
                        JOP.mostrar(tree.searchTime(cedula));
                        break;
                    case 2:
                        JOP.mostrar(vector.searchTime(cedula));
                        break;
                    default:
                        throw new AssertionError();
                }

            } catch (FileNotFoundException e) {
                JOP.mostrar(e.getMessage());
            } catch (NumberFormatException e) {
                JOP.mostrar("Ingrese solo los números disponibles dentro de la opciones");
            }
        } while (true);
    }

}
