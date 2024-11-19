public class Docente implements Calificable{
    private String nombre;
    private String id;
    private int antiguedad;
    private boolean conocimientoIngles;
    private int calificacion;

    // CONSTRUCTOR
    public Docente(String nombre, String id, int antiguedad, boolean conocimientoIngles) {
        this.nombre = nombre;
        this.id = id;
        this.antiguedad = antiguedad;
        this.conocimientoIngles = conocimientoIngles;
        this.calificacion = 0;
    }

    //METODOS

    public boolean tieneConocimientoIngles() {
        return conocimientoIngles;
    }

    //GETTERS
    public String getNombre() {
        return nombre;
    }

    public String getId() {
        return id;
    }

    public int getAntiguedad() {
        return antiguedad;
    }


    // IMPLEMENTACION INTERFAZ
    public void calificar(int nota) {
        if (nota < 0 || nota > 100) {
            throw new IllegalArgumentException("La nota debe estar entre 0 y 100.");
        }
        this.calificacion = nota;
        System.out.println("Docente " + nombre + " calificado con " + nota + ".");
    }

}
