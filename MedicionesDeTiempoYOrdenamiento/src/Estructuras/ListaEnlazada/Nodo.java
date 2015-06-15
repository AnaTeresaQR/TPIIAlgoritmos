package Estructuras.ListaEnlazada;

/**
 * Clase encargado de los datos correspondientes a los nodos de una lista
 * enlazada con sus respetivos metodos get y set de atributos
 *
 * @author Juan Miguel Arias Mejias
 * @author Ana Teresa Quesada Ramírez
 */
public class Nodo {

    private int dato;
    private Nodo siguiente;
    private Nodo anterior;

    public Nodo(int dato) {
        this.dato = dato;
    }

    public int getDato() {
        return dato;
    }

    public void setDato(int dato) {
        this.dato = dato;
    }

    public Nodo getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(Nodo siguiente) {
        this.siguiente = siguiente;
    }

    public Nodo getAnterior() {
        return anterior;
    }

    public void setAnterior(Nodo anterior) {
        this.anterior = anterior;
    }

}
