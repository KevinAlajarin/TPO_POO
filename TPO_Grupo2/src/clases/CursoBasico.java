package clases;

public class CursoBasico extends Curso {
	
    public CursoBasico(String nombre, String codigo, int limiteAlumnos) {
        super(nombre, codigo, limiteAlumnos);
    }
    
    @Override
    public boolean validarDocente(Docente docente) {
        return true; 
    }

    @Override
    public boolean inscribirAlumno(Alumno alumno) {
        return true; 
    }
}
