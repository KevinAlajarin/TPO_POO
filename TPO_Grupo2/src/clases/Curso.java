package clases;
import java.util.HashSet;
import java.util.Set;

public abstract class Curso implements Validable, Inscribible, Calificable {
    protected String nombre;
    protected String codigo;
    protected Docente docenteAsignado;
    protected Set<Alumno> alumnosInscritos = new HashSet<>();
    protected int limiteAlumnos;
    
    public Curso(String nombre, String codigo, int limiteAlumnos) {
        this.nombre = nombre;
        this.codigo = codigo;
        this.limiteAlumnos = limiteAlumnos;
    }

    
    @Override
    public abstract boolean validarDocente(Docente docente);
    
    @Override
    public abstract boolean inscribirAlumno(Alumno alumno);

    // Metodo para asignar docente al curso
    public void asignarDocente(Docente docente) {
        if (validarDocente(docente)) {
            this.docenteAsignado = docente;
        }
    } 

    // Metodo para calificar al curso y al docente
    @Override
    public void calificar(Curso curso, Docente docente, int calificacionCurso, int calificacionDocente) {
        curso.recibirCalificacion(calificacionCurso);
        docente.recibirCalificacion(calificacionDocente);
    }

    // Metodo para recibir calificacion 
    public void recibirCalificacion(int calificacion) {
    }


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


	public void setAlumnosInscritos(Set<Alumno> alumnosInscritos) {
		this.alumnosInscritos = alumnosInscritos;
	}


	public int getLimiteAlumnos() {
		return limiteAlumnos;
	}


	public void setLimiteAlumnos(int limiteAlumnos) {
		this.limiteAlumnos = limiteAlumnos;
	}
}
