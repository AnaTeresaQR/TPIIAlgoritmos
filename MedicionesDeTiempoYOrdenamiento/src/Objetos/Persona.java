package Objetos;

/**
 * Clase con los datos correspondientes a una persona con sus respectivos get y
 * set
 *
 * @author Juan Miguel Arias Mejias
 * @author Ana Teresa Quesada Ramírez
 */
public class Persona implements Comparable {

    private String nombre; // nombre de la persona
    private int cedula; // cédula de la persona
    private int edad; // edad de la persona

    public Persona() {
    }

    public Persona(String nombre, int cedula, int edad) {
        this.nombre = nombre;
        this.cedula = cedula;
        this.edad = edad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCedula() {
        return cedula;
    }

    public void setCedula(int cedula) {
        this.cedula = cedula;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    @Override
    public String toString() {
        return "Persona{" + "nombre=" + nombre + ", cedula=" + cedula + ", edad=" + edad + '}';
    }

    /**
     * Método encargado de comparar si la persona a ser comparada es menor que
     * otra
     *
     * @return -1 si la persona que compara es mayor a otra, 0 si son iguales, y
     * 1 si es menor
     */
    @Override
    public int compareTo(Object o) {
        return ((Persona) o).getCedula() > this.cedula ? -1
                : ((Persona) o).getCedula() == this.cedula ? 0 : 1;
    }

//    public static void main(String[] args) {
//        Persona persona1 = new Persona();
//        persona1.setCedula(8);
//        Persona persona2 = new Persona();
//        persona2.setCedula(2);
//        Persona persona3 = new Persona();
//        persona3.setCedula(100);
//        Persona persona4 = new Persona();
//        persona4.setCedula(123);
//        Persona persona5 = new Persona();
//        persona5.setCedula(923);
//        Persona persona6 = new Persona();
//        persona6.setCedula(23);
//
//        Persona[] personas = {persona1, persona2, persona3, persona4, persona5, persona6};
//        Arrays.sort(personas);
//
//        System.out.println(Arrays.toString(personas));;
//    }
}
