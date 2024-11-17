package clases;

import java.util.HashSet;
import java.util.Set;

public abstract class Curso implements Validable, Inscribible, Calificable {
    protected String nombre;
    protected String codigo;
    protected Docente docenteAsignado;
    protected Set<Alumno> alumnosInscritos = new HashSet<>();
    protected final int limiteAlumnos; // Ahora es final para evitar que cambie después de la creación

    public Curso(String nombre, String codigo, int limiteAlumnos) {
        this.nombre = nombre;
        this.codigo = codigo;
        this.limiteAlumnos = limiteAlumnos;
    }

    @Override
    public abstract boolean validarDocente(Docente docente);

    @Override
    public boolean inscribirAlumno(Alumno alumno) {
        if (alumnosInscritos.size() < limiteAlumnos && !alumnosInscritos.contains(alumno)) {
            alumnosInscritos.add(alumno);
            return true; // Inscripción exitosa
        }
        return false; // No se pudo inscribir (límite alcanzado o alumno ya inscrito)
    }

    public void asignarDocente(Docente docente) {
        if (validarDocente(docente)) {
            this.docenteAsignado = docente;
        } else {
            System.out.println("El docente no es válido para este curso.");
        }
    }

    @Override
    public void calificar(Curso curso, Docente docente, int calificacionCurso, int calificacionDocente) {
        curso.recibirCalificacion(calificacionCurso);
        docente.recibirCalificacion(calificacionDocente);
    }

    public void recibirCalificacion(int calificacion) {
        // Aquí podrías agregar la lógica de calificación
    }

    // Getters y setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public Docente getDocenteAsignado() {
        return docenteAsignado;
    }

    public void setDocenteAsignado(Docente docenteAsignado) {
        this.docenteAsignado = docenteAsignado;
    }

    public Set<Alumno> getAlumnosInscritos() {
        return alumnosInscritos;
    }

    public int getLimiteAlumnos() {
        return limiteAlumnos;
    }
}
