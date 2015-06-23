package Estructuras.AVLTree;

import objetos.Persona;

/**
 * Clase que se encarga de realizar las operaciones correspondientes a un árbol
 * AVL
 *
 * @author Juan Miguel Arias Mejias
 * @author Ana Teresa Quesada Ramírez
 */
public class AvlTree {

    private Nodo raiz; //  raíz del árbol

    private static final int desequilibrio = 1;

    public AvlTree() {
        raiz = null;
    }

    /**
     * Método público que llamar al método insertar privado
     *
     * @param x valor a insertar
     * @throws Estructuras.AVLTree.TreeException si hay problemas al insertar
     */
    public void insertar(Persona x) throws TreeException {
        raiz = insertar(x, raiz);
    }

    /**
     * Método interno para insertar en un subarbol, balancea los nodos al
     * insertar.
     *
     * @param x el valor a insertar
     * @param raiz , nodo raíz del árbol
     * @return la nueva raíz
     */
    private Nodo insertar(Persona x, Nodo raiz) throws TreeException {
        if (raiz == null) {
            raiz = new Nodo(x, null, null);
        } else if (x.getCedula() < raiz.getDato().getCedula()) {
            raiz.setIzq(insertar(x, raiz.getIzq()));
            if (peso(raiz.getIzq()) - peso(raiz.getDer()) == 2) { // si se cumple es porque está desbalanceado
                if (x.getCedula() < raiz.getIzq().getDato().getCedula()) {
                    raiz = rotarConHijoIzquierdo(raiz);
                } else {
                    raiz = dobleConHijoIzq(raiz);
                }
            }
        } else if (x.getCedula() > raiz.getDato().getCedula()) {
            raiz.setDer(insertar(x, raiz.getDer()));
            if (peso(raiz.getDer()) - peso(raiz.getIzq()) == 2) {
                if (x.getCedula() > raiz.getDer().getDato().getCedula()) {
                    raiz = rotarConHijoDerecho(raiz);
                } else {
                    raiz = dobleConHijoDer(raiz);
                }
            }
        } else 
            ; // Duplicate; do nothing
        raiz.setPeso(max(peso(raiz.getIzq()), peso(raiz.getDer())) + 1);
        return raiz;
    }

    /**
     * Método estático que calcula el peso de los nodos en un árbol
     *
     * @param raíz, recibe el nodo raíz a calcular el peso
     */
    private static int peso(Nodo raiz) {
        // retorna el peso de un nodo raiz, si es -1, o si es null
        return raiz == null ? -1 : raiz.getPeso();
    }

    /**
     * Método estático que se encarga de hacer una rotación simple cuando el
     * nodo posee un hijo izquierdo
     *
     * @param raiz2 la raíz la cual modificará
     * @return Retorna una nueva raíz
     */
    private static Nodo rotarConHijoIzquierdo(Nodo raiz2) {
        // rotación simple
        // rota el nodo de un árbol binario con hijo izquierdo (Actualiza pesos, y retorna la nueva raiz)
        Nodo raiz1 = raiz2.getIzq();
        raiz2.setIzq(raiz1.getDer());
        raiz1.setDer(raiz2);
        raiz2.setPeso(max(peso(raiz2.getIzq()), peso(raiz2.getDer())) + 1);
        raiz1.setPeso(max(peso(raiz1.getIzq()), raiz2.getPeso()) + 1);
        return raiz1;
    }

    /**
     * Método estático que se encarga de hacer una rotación simple cuando el
     * nodo posee un hijo derecho
     *
     * @param raiz1 la raíz la cual modificará
     * @return Retorna una nueva raíz
     */
    private static Nodo rotarConHijoDerecho(Nodo raiz1) {
        // rotación simple
        // rota el nodo de un árbol binario con hijo derecho (Actualiza pesos, y retorna la nueva raiz)
        Nodo raiz2 = raiz1.getDer();
        raiz1.setDer(raiz2.getIzq());
        raiz2.setIzq(raiz1);
        raiz1.setPeso(max(peso(raiz1.getIzq()), peso(raiz1.getDer())) + 1);
        raiz2.setPeso(max(peso(raiz2.getDer()), raiz1.getPeso()) + 1);
        return raiz2;
    }

    /**
     * Método estático que se encarga de devolver el máximo de los hijos
     * izquierdos o el de los derechos si se cumple la condición
     *
     * @param maxIzq nodo de la izquierda
     * @param maxDer nodo de la derecha
     */
    private static int max(int maxIzq, int maxDer) {
        // retorna el máximo de los izquierdos y el de los derechos
        return maxIzq > maxDer ? maxIzq : maxDer;
    }

    /**
     * Método estático que hace una doble rotación con un hijo izquierdo
     *
     * @param raiz3 la raíz que se va a rotar
     */
    private static Nodo dobleConHijoIzq(Nodo raiz3) {
        // doble rotación para primero el hijo izq con hijo der luego el nodo raiz3 con el nuevo hijo izq.
        // actualiza pesos, y retorna nueva raíz
        raiz3.setIzq(rotarConHijoDerecho(raiz3.getIzq()));
        return rotarConHijoIzquierdo(raiz3);
    }

    /**
     * Método estático que hace una doble rotación con un hijo derecho
     *
     * @param raiz1 la raíz que se va a rotar
     */
    private static Nodo dobleConHijoDer(Nodo raiz1) {
        // doble rotación para primero el hijo der con hijo izquierdo luego el nodo raiz1 con el nuevo hijo der.
        // actualiza pesos, y retorna nueva raíz
        raiz1.setDer(rotarConHijoIzquierdo(raiz1.getDer()));
        return rotarConHijoDerecho(raiz1);
    }

    /**
     * Método privado recursivo que se encarga de imprimir en PreOrden
     *
     * @param raiz recibe un Nodo raíz
     * @return un String con los valores en ese orden
     */
    private String imprimirpreOrden(Nodo raiz) throws TreeException {
        if (raiz == null) {
            throw new TreeException("árbol vacío");
        }
        String hilera = "";
        hilera += " " + raiz.getDato();
        if (raiz.getIzq() != null) {
            hilera += "" + imprimirpreOrden(raiz.getIzq());
        }
        if (raiz.getDer() != null) {
            hilera += "" + imprimirpreOrden(raiz.getDer());
        }
        return hilera;
    }

    /**
     * Método que llama al imprimir PreOrden privado
     *
     * @return una hilera con los valores en PreOrden
     * @throws Estructuras.AVLTree.TreeException si hay problemas al imprimir
     */
    public String imprimirPreOrden() throws TreeException {
        return imprimirpreOrden(raiz);
    }

    /**
     * Método privado recursivo que se encarga de imprimir en postOrden
     *
     * @param raiz recibe un Nodo raíz
     * @return un String con los valores en ese orden
     */
    private String imprimirpostOrden(Nodo raiz) throws TreeException {
        if (raiz == null) {
            throw new TreeException("árbol vacío");
        }
        String hilera = "";
        if (raiz.getIzq() != null) {
            hilera += "" + imprimirpostOrden(raiz.getIzq());
        }
        if (raiz.getDer() != null) {
            hilera += "" + imprimirpostOrden(raiz.getDer());
        }
        hilera += " " + raiz.getDato();
        return hilera;
    }

    /**
     * Método que llama al imprimir postOrden privado
     *
     * @return una hilera con los valores en PostOrden
     * @throws Estructuras.AVLTree.TreeException si hay problemas al imprimir
     */
    public String imprimirPostOrden() throws TreeException {
        return imprimirpostOrden(raiz);
    }

    /**
     * Método privado recursivo que se encarga de imprimir en InOrden
     *
     * @param raiz recibe un Nodo raíz
     * @return un String con los valores en ese orden
     */
    private String imprimirordenSim(Nodo raiz) throws TreeException {
        if (raiz == null) {
            throw new TreeException("árbol vacío");
        }
        String hilera = "";
        if (raiz.getIzq() != null) {
            hilera += "" + imprimirordenSim(raiz.getIzq());
        }
        hilera += " " + raiz.getDato();
        if (raiz.getDer() != null) {
            hilera += "" + imprimirordenSim(raiz.getDer());
        }
        return hilera;
    }

    /**
     * Método que llama al imprimir en ordenSim privado
     *
     * @return una hilera con los valores en InOrden
     * @throws Estructuras.AVLTree.TreeException si hay problemas al imprimir
     */
    public String imprimirOrdenSim() throws TreeException {
        return imprimirordenSim(raiz);
    }

    /**
     * Método privado que se encarga de buscar un nodo con un respectiv valor en
     * el árbol
     *
     * @param x el valor del dato que se busca
     * @param raiz la raíz del árbol
     * @return el nodo buscado
     */
    private Persona buscarNodo(int x, Nodo raiz) throws TreeException {
        while (raiz != null) {
            if (x < raiz.getDato().getCedula()) {
                raiz = raiz.getIzq();
            } else if (x > raiz.getDato().getCedula()) {
                raiz = raiz.getDer();
            } else {
                return raiz.getDato();
            }
        }
        throw new TreeException("Elemento no encontrado");
    }

    /**
     * Método público que busca un dato en el árbol, llama al respectivo método
     * privado
     *
     * @param x recibe el dato a buscar
     * @return el dato buscado
     * @throws Estructuras.AVLTree.TreeException si hay errores al buscar
     */
    public Persona buscar(int x) throws TreeException {
        return buscarNodo(x, raiz);
    }

    /**
     * Método que busca el valor mínimo en el árbol
     *
     * @param raiz recibe la raíz del árbol
     * @return el nodo encontrado
     */
    private Nodo buscarmin(Nodo raiz) throws TreeException {
        if (raiz == null) {
            throw new TreeException("buscarMin de árbol búsqueda no encontrado, subárbol vacío");
        }
        while (raiz.getIzq() != null) {
            raiz = raiz.getIzq();
        }
        return raiz;
    }

    /**
     * Método que busca el mínimo en el árbol, llama al método privado a que se
     * ejecute
     *
     * @return el dato mínimo encontrado
     * @throws Estructuras.AVLTree.TreeException problemas al buscar el mínimo
     */
    public Persona buscarMin() throws TreeException {
        return buscarmin(raiz).getDato();
    }

    /**
     * Método que busca el valor máximo en el árbol
     *
     * @param raiz recibe la raíz del árbol
     * @return el nodo encontrado
     */
    private Nodo buscarmax(Nodo raiz) throws TreeException {
        if (raiz == null) {
            throw new TreeException("buscarMax de árbol búsqueda, subárbol vacío");
        }
        while (raiz.getDer() != null) {
            raiz = raiz.getDer();
        }
        return raiz;
    }

    /**
     * Método que busca el máximo en el árbol, llama al método privado a que se
     * ejecute
     *
     * @return el dato máximo encontrado
     * @throws Estructuras.AVLTree.TreeException problemas al buscar el mínimo
     */
    public Persona buscarMax() throws TreeException {
        return buscarmax(raiz).getDato();
    }

    /**
     * Método que verifica si un árbol está o no vacío
     *
     * @return true si el árbol es vacío, false de lo contrario
     */
    public boolean esVacio() {
        return raiz == null;
    }

    /**
     * Método que se encarga de vaciar el árbol
     */
    public void vaciar() {
        raiz = null;
    }

    /**
     * Método privado que se encarga de eliminar en un árbol, al eliminar
     * balancea
     *
     * @param x recibe el valor que se va a eliminar
     * @param raiz recibe la raíz del árbol
     * @return el Nodo eliminado
     */
    private Nodo eliminarNodo(Persona x, Nodo raiz) throws TreeException {
        if (raiz == null) {
            throw new TreeException("eliminar de árbol búsqueda, vacío");
        }
        if (x.getCedula() < raiz.getDato().getCedula()) {
            raiz.setIzq(eliminarNodo(x, raiz.getIzq()));
        } else if (x.getCedula() > raiz.getDato().getCedula()) {
            raiz.setDer(eliminarNodo(x, raiz.getDer()));
        } else if (raiz.getIzq() != null && raiz.getDer() != null) { // Dos hijos
            raiz.setDato(buscarmin(raiz.getDer()).getDato());
            raiz.setDer(eliminarmin(raiz.getDer()));
        } else { // Cambio de raíz
            raiz = (raiz.getIzq() != null) ? raiz.getIzq() : raiz.getDer();
        }
        return balanceado(raiz);
    }

    /**
     * Método que se encarga de eliminar un nodo en el árbol, llama al método
     * privado a que se ejecute
     *
     * @param x recibe el valor del dato a eliminar
     * @throws Estructuras.AVLTree.TreeException si hay problemas al eliminar
     */
    public void eliminar(Persona x) throws TreeException {
        raiz = eliminarNodo(x, raiz);
    }

    /**
     * Método privado que se encarga de eliminar en un árbol el valor mínimo
     *
     * @param raiz recibe la raíz del árbol
     * @return el Nodo eliminado
     */
    private Nodo eliminarmin(Nodo raiz) throws TreeException {
        if (raiz == null) {
            throw new TreeException("eliminarMin de árbol búsqueda, subárbol vacío");
        }
        if (raiz.getIzq() != null) {
            raiz.setIzq(eliminarmin(raiz.getIzq()));
        } else {
            raiz = raiz.getDer();
        }
        return raiz;
    }

    /**
     * Método que se encarga de eliminar un nodo mínimo en el árbol, llama al
     * método privado a que se ejecute
     *
     * @throws Estructuras.AVLTree.TreeException si hay problemas al eliminar
     */
    public void eliminarMin() throws TreeException {
        raiz = eliminarmin(raiz);
    }

    /**
     * Método privado que se encarga de balancear el árbol, este se ejecuta para
     * el método eliminar
     *
     * @param raiz recibe la raíz del árbol
     * @return un nodo
     */
    private Nodo balanceado(Nodo raiz) {
        if (raiz == null) {
            return raiz;
        }
        if (peso(raiz.getIzq()) - peso(raiz.getDer()) > desequilibrio) {
            if (peso(raiz.getIzq().getIzq()) >= peso(raiz.getIzq().getDer())) {
                raiz = rotarConHijoIzquierdo(raiz);
            } else {
                raiz = dobleConHijoIzq(raiz);
            }
        } else if (peso(raiz.getDer()) - peso(raiz.getIzq()) > desequilibrio) {
            if (peso(raiz.getDer().getDer()) >= peso(raiz.getDer().getIzq())) {
                raiz = rotarConHijoDerecho(raiz);
            } else {
                raiz = dobleConHijoDer(raiz);
            }
        }

        raiz.setPeso(Math.max(peso(raiz.getIzq()), peso(raiz.getDer())) + 1);
        return raiz;
    }

}
