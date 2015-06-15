package Estructuras.ListaEnlazada;

/**
 * Clase encargada de todo el manejo de inserción, eliminación búsqueda e
 * impresión de listas doblemente enlazadas
 *
 * @author Juan Miguel Arias Mejias
 * @author Ana Teresa Quesada Ramírez
 */
public class ListaEnlazada {

    private int tamanno;
    private Nodo cabeza;

    /**
     * constructor vacío que establece los valores por defecto
     */
    public ListaEnlazada() {
        tamanno = 0;
        cabeza = null;
    }

    /**
     * Método que dice si está o no vacía
     *
     * @return true si se cumple que tamaño es igual a ceros
     */
    public boolean isEmpty() {
        return tamanno == 0;
    }

    /**
     * Método que imprime el tamaño de la lista
     */
    private int size() {
        if (isEmpty()) {
            return 0;
        } else {
            return tamanno;
        }
    }

    /**
     * Método que dice si hay o no un determinado elemento insertado en la lista
     *
     * @param dato recibe el dato para buscar si está en la lista
     * @return true si lo encuentra, false en caso contrario
     * @throws Estructuras.ListaEnlazada.ListaException si ocurre un problema al
     * buscar
     */
    public boolean buscar(int dato) throws ListaException {
        if (isEmpty()) {
            throw new ListaException("Lista vacía\nNO SE PUEDE BUSCAR");
        }
        Nodo actual = cabeza;
        do {
            if (actual.getDato() == dato) {
                return true;
            }
            actual = actual.getSiguiente();
        } while (actual != cabeza);
        return false;

    }

    /**
     * Método para imprimir de inicio a fin en la lista
     *
     * @return el String con todos los elementos insertados
     * @throws Estructuras.ListaEnlazada.ListaException si ocurre error al imprimir de inicio a fin
     */
    public String imprimirInicioFin() throws ListaException {
        StringBuilder sb = new StringBuilder();
        if (isEmpty()) {
            throw new ListaException("Lista vacía\n NO SE PUEDE IMPRIMIR");
        } else {
            Nodo actual = cabeza;
            do {
                sb.append(" ").append(actual.getDato());
                actual = actual.getSiguiente();
            } while (actual != cabeza);
            return sb.toString();
        }
    }

    /**
     * Método que imprime desde el primer elemento hasta el último en una lista
     *
     * @return El String con los elementos insertados en reversa
     * @throws Estructuras.ListaEnlazada.ListaException  si ocurre error al imprimir de fin a inicio
     */
    public String imprimirFinInicio() throws ListaException {
        StringBuilder sb = new StringBuilder();
        if (isEmpty()) {
            throw new ListaException("Lista vacía\n NO SE PUEDE IMPRIMIR");
        } else {
            Nodo actual = cabeza.getAnterior();
            do {
                sb.append("").append(actual.getDato()).append(" ");
                actual = actual.getAnterior();
            } while (actual != cabeza.getAnterior());
            return sb.toString();
        }
    }

    /**
     * Método para eliminar un determinado elemento de la lista
     *
     * @param dato recibe el dato a eliminar
     * @return el dato que fue eliminado
     * @throws Estructuras.ListaEnlazada.ListaException si no se puede eliminar
     */
    public int eliminarPorID(int dato) throws ListaException {
        if (isEmpty()) {
            throw new ListaException("Lista vacía\nNO SE PUEDE ELIMINAR");
        }
        if (!buscar(dato)) {
            throw new ListaException("Dato no encontrado para eliminar");
        }
        if (cabeza.getAnterior() == cabeza && cabeza.getSiguiente() == cabeza) {
            cabeza = null;
            tamanno--;
            return dato;
        }
        Nodo actual = cabeza;
        do {
            if (cabeza.getDato() == dato) {
                eliminarPrimero();
                return dato;
            }
            if (actual.getSiguiente().getDato() == dato) {
                actual.setSiguiente(actual.getSiguiente().getSiguiente());
                actual.getSiguiente().setAnterior(actual);
                tamanno--;
                return dato;
            }
            actual = actual.getSiguiente();
        } while (actual != cabeza);
        throw new ListaException("Dato no eliminado");
    }

    /**
     * Método que se encarga de insertar ordenadamente en la lista
     *
     * @param datoNuevo, recibe el dato a insertar
     * @return el dato insertado
     * @throws Estructuras.ListaEnlazada.ListaException si hay elementos repetidos
     */
    public int insertarOrdenado(int datoNuevo) throws ListaException {
        Nodo nuevo = new Nodo(datoNuevo);
        if (isEmpty()) {
            cabeza = nuevo;
            cabeza.setSiguiente(cabeza);
            cabeza.setAnterior(cabeza);
            tamanno++;
            return datoNuevo;
        }
        if (buscar(datoNuevo)) {
            throw new ListaException("Dato encontrado\nNO SE PERMITEN ELEMENTOS REPETIDOS");
        } else {
            Nodo actual = cabeza;
            // recorre para verificar hasta donde está ordenada la lista
            while ((actual.getSiguiente() != cabeza) && (actual.getDato() < datoNuevo)) {
                actual = actual.getSiguiente();
            }
            if ((actual.getSiguiente() == cabeza) && (actual.getDato() < datoNuevo)) {
                actual.setSiguiente(nuevo);
                nuevo.setAnterior(actual);
                nuevo.setSiguiente(cabeza);
                cabeza.setAnterior(nuevo);
                tamanno++;
                return datoNuevo;
            } else {
                Nodo temp = actual.getAnterior();
                nuevo.setAnterior(temp);
                temp.setSiguiente(nuevo);
                nuevo.setSiguiente(actual);
                actual.setAnterior(nuevo);
                tamanno++;
                if ((actual == cabeza) && (cabeza.getDato() > datoNuevo)) {
                    cabeza = nuevo;
                }
                return datoNuevo;
            }
        }
    }

    /**
     * Se encarga de eliminar al primer elemento de la lista, modificando la
     * cabeza
     */
    private boolean eliminarPrimero() {
        Nodo actual = cabeza;
        if (cabeza.getSiguiente() == cabeza && cabeza.getAnterior() == cabeza) {
            cabeza = null;
            tamanno--;
            return true;
        } else {
            actual = cabeza.getSiguiente();
            cabeza.getAnterior().setSiguiente(actual);
            actual.setAnterior(cabeza.getAnterior());
            cabeza = actual;
            tamanno--;
            return true;
        }
    }

//    public static void main(String[] args) throws ListaException {
//        ListaEnlazada c = new ListaEnlazada();
//        c.insertarOrdenado(1);
//        c.insertarOrdenado(5);
//        c.insertarOrdenado(3);
//        c.insertarOrdenado(4);
//        c.insertarOrdenado(2);
//        c.insertarOrdenado(6);
//        System.out.println("" + c.imprimirInicioFin());
//        System.out.println("tamaño: " + c.size());
//        c.insertarOrdenado(-1);
//        System.out.println("" + c.imprimirInicioFin());
//        System.out.println("tamaño: " + c.size());
//        c.insertarOrdenado(-2);
//        c.insertarOrdenado(-7);
//        c.insertarOrdenado(-5);
//        System.out.println("" + c.imprimirInicioFin());
//        System.out.println("tamaño: " + c.size());
//    }
}// fin de clase
