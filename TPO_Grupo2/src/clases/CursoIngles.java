package clases;

public class CursoIngles extends Curso {
	
    public CursoIngles(String nombre, String codigo, int limiteAlumnos) {
        super(nombre, codigo, limiteAlumnos);
    }
    
    @Override
    public boolean validarDocente(Docente docente) {
        return docente.tieneConocimientosIngles(); // Requiere conocimientos de ingles
    }

    @Override
    public boolean inscribirAlumno(Alumno alumno) {
        return true; 
    }
}
