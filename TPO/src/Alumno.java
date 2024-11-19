import java.util.*;

public class Alumno implements Calificable{
    private String nombre;
    private String id;
    private Set<String> cursosCompletados;
    private Map<String, Integer> cursosCalificados;

    // CONSTRUCTOR
    public Alumno(String nombre, String id) {
        this.nombre = nombre;
        this.id = id;
        this.cursosCompletados = new HashSet<>();
        this.cursosCalificados = new HashMap<>();
    }

    // METODOS
    public void agregarCursoCompletado(String codigoCurso) {
        cursosCompletados.add(codigoCurso);
    }

    public Set<String> consultarHistorial() {
        return new HashSet<>(cursosCompletados);
    }

    public boolean haCompletadoCurso(String codigoCurso) {
        return cursosCompletados.contains(codigoCurso);
    }

    // Implementacion Interfaz

    public void calificar(int nota) {
        if (nota < 0 || nota > 100) {
            throw new IllegalArgumentException("La nota debe estar entre 0 y 100.");
        }
        cursosCalificados.replaceAll((curso, actual) -> nota);
        System.out.println("Alumno " + nombre + " calificado con " + nota + ".");
    }

    // GETTERS
    public String getNombre() {
        return nombre;
    }
    public String getId() {
        return id;
    }




}


