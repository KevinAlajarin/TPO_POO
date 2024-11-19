public class CursoBasico extends Curso {

    // CONSTRUCTOR
    public CursoBasico(String nombre, String codigo, int limiteAlumnos) {
        super(nombre, codigo, limiteAlumnos);
    }

    // METODOS
    @Override
    public boolean validarDocente(Docente docente) {
        return true; // Cualquier docente puede impartir un curso básico
    }

    @Override
    public void inscribirAlumno(Alumno alumno) {
        if (alumnosInscritos.contains(alumno)) {
            throw new ExcepcionNegocio("El alumno ya está inscrito en este curso.");
        }
        super.inscribirAlumno(alumno); // Realiza la inscripción desde la clase base
    }

}
