import java.util.*;

public abstract class Curso implements Calificable {
    protected String nombre;
    protected String codigo;
    protected int limiteAlumnos;
    protected Set<Alumno> alumnosInscritos;
    protected Docente docenteAsignado;
    protected int calificacionPromedio;

    // CONSTRUCTOR
    public Curso(String nombre, String codigo, int limiteAlumnos) {
        this.nombre = nombre;
        this.codigo = codigo;
        this.limiteAlumnos = limiteAlumnos;
        this.alumnosInscritos = new HashSet<>();
        this.calificacionPromedio = 0;
    }

    // METODOS
    public abstract boolean validarDocente(Docente docente);

    public void asignarDocente(Docente docente) {
        if (!validarDocente(docente)) {
            throw new ExcepcionOperacionInvalida("El docente no cumple con los requisitos para este curso.");
        }
        this.docenteAsignado = docente;
    }

    public void inscribirAlumno(Alumno alumno) {
        if (alumnosInscritos.size() >= limiteAlumnos) {
            throw new ExcepcionOperacionInvalida("No hay cupos disponibles en este curso.");
        }
        if (alumnosInscritos.contains(alumno)) {
            throw new ExcepcionOperacionInvalida("El alumno ya está inscrito en este curso.");
        }
        alumnosInscritos.add(alumno);
        alumno.agregarCursoCompletado(this.codigo);
    }

    public void eliminarAlumno(Alumno alumno) {
        alumnosInscritos.remove(alumno);
    }

    public void eliminarDocente() {
        this.docenteAsignado = null;
    }

    // IMPLEMENTACION INTERFAZ

    public void calificar(int nota) {
        if (nota < 0 || nota > 100) {
            throw new IllegalArgumentException("La calificación debe estar entre 0 y 100.");
        }
        this.calificacionPromedio = nota;
        System.out.println("El curso " + nombre + " recibió una calificación promedio de " + nota + ".");
    }


}
