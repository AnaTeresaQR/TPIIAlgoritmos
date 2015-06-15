package File;

import Objetos.Persona;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Clase que se encarga de la carga del archivo a una estructura y manejo de
 * listas con personas
 *
 * @author Juan Miguel Arias Mejias
 * @author Ana Teresa Quesada Ramirez
 */
public class SolveFile {

    private Persona[] vector; // vector de personas
    private int size; // cantidad de personas
    private File archivo; // archivo txt de personas

    public SolveFile() {

        LoadFile loadFile = new LoadFile();
        archivo = loadFile.getFile();
        initSize();
        vector = new Persona[size];

    }

    /**
     * Se encarga de inicializar el vector creando una nueva instancia de
     * persona
     */
    private void initVector() {
        for (int i = 0; i < vector.length; i++) {
            vector[i] = new Persona();
        }
    }

    /**
     * Se encarga de limpiar el vector, es decir vaciarlo
     */
    public void clearVector() {

        for (int i = 0; i < vector.length; i++) {
            vector[i] = null;
        }
    }

    /**
     * Cuenta la cantidad de lineas que hay en el archivo para poder inicializar
     * el vector
     */
    private void initSize() {

        BufferedReader br = null;
        String line = "";

        int cont = 0;
        try {
            br = new BufferedReader(new FileReader(archivo));
            while ((line = br.readLine()) != null) {

                cont++;
            }

            this.size = cont;

        } catch (IOException ex) {
            System.err.println("Error en initSize() clase SolveFile");
        }
    }

    /**
     * Método que se encarda leer el archivo y de cargar los datos del archivo
     * de personas a un vector de Personas
     */
    public void loadToArray() {

        initVector();
        BufferedReader br = null;
        String line = "";
        int index = 0;
        String data = "";
        int counter = 0;

        try {
            br = new BufferedReader(new FileReader(archivo));
            while ((line = br.readLine()) != null) {

                // 502260983,SANDRA GOMEZ,22
                char current;
                index = 0;

                // Get ID
                while (true) {
                    current = line.charAt(index);
                    if (current == ',') {
                        index++;
                        break;
                    } else {
                        data += current;
                    }
                    index++;
                }

                // Save ID
                int id = Integer.parseInt(data.trim());
                vector[counter].setCedula(id);
                data = "";

                // Get name
                while (true) {

                    current = line.charAt(index);
                    if (current == ',') {
                        index++;
                        break;
                    } else {
                        data += current;
                    }
                    index++;
                }

                // Save ID
                vector[counter].setNombre(data.trim());
                data = "";

                // Save Age
                data = line.substring(index, line.length());
                vector[counter].setEdad(Integer.parseInt(data.trim()));

                data = "";
                index = 0;
                current = ' ';
                counter++;
            }
        } catch (IOException ex) {

        } finally {
            data = null;
            index = 0;
            counter = 0;
        }
    }

    /**
     * Método encargado de imprimir un vector
     *
     * @return una hilera con los datos del vector
     * @throws java.lang.Exception problemas al imprimir
     */
    public String imprimir() throws Exception {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < vector.length; i++) {
            sb.append(vector[i]);
            sb.append("\n");
        }

        return sb.toString();
    }

    /**
     * Obtener un vector de personas
     *
     * @return vector de personas
     */
    public Persona[] getArray() {
        return vector;
    }

    /**
     * Obtener una lista
     *
     * @return la lista de personas
     */
    public List<Persona> getList() {
        return Arrays.asList(vector);
    }

    public ArrayList<Persona> getArrayList() {

        return new ArrayList(getList());
    }

//    public static void main(String[] args) throws Exception {
//
//        SolveFile s = new SolveFile();
//        System.out.println(s.imprimir());
//        System.out.println(s.getList().size());
//        System.out.println(s.getArrayList().size());
//
//    }
}
