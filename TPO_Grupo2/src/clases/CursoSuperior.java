package clases;

public class CursoSuperior extends Curso {
    private String codigoBasicoRequerido;
    
    public CursoSuperior(String nombre, String codigo, int limiteAlumnos, String codigoBasicoRequerido) {
        super(nombre, codigo, limiteAlumnos);
        this.codigoBasicoRequerido = codigoBasicoRequerido;
    }

    @Override
    public boolean validarDocente(Docente docente) {
        return docente.getAntiguedad() >= 5; // Requiere 5 años de antiguedad
    }

    @Override
    public boolean inscribirAlumno(Alumno alumno) {
        return alumno.cursoCompletado(codigoBasicoRequerido); // Requiere curso basico 
    }
    
    public String getCodigoBasicoRequerido() {
        return codigoBasicoRequerido;
    }

	public void setCodigoBasicoRequerido(String codigoBasicoRequerido) {
		this.codigoBasicoRequerido = codigoBasicoRequerido;
	}
}
