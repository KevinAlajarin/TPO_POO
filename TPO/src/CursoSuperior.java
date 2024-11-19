public class CursoSuperior extends Curso {
    private final String codigoBasicoRequerido;

    //CONSTRUCTOR
    public CursoSuperior(String nombre, String codigo, int limiteAlumnos, String codigoBasicoRequerido) {
        super(nombre, codigo, limiteAlumnos);
        this.codigoBasicoRequerido = codigoBasicoRequerido;
    }

    //METODOS
    @Override
    public boolean validarDocente(Docente docente) {
        return docente.getAntiguedad() >= 3; // Requiere antigüedad mínima de 3 años
    }

    @Override
    public void inscribirAlumno(Alumno alumno) {
        if (!alumno.haCompletadoCurso(codigoBasicoRequerido)) {
            throw new ExcepcionNegocio("El alumno no ha completado el curso básico requerido (" + codigoBasicoRequerido + ").");
        }
        if (alumnosInscritos.contains(alumno)) {
            throw new ExcepcionNegocio("El alumno ya está inscrito en este curso.");
        }
        super.inscribirAlumno(alumno); // Realiza la inscripción desde la clase base
    }

}
