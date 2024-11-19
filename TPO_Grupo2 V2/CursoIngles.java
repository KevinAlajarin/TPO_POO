public class CursoIngles extends Curso {

    //CONSTRUCTOR
    public CursoIngles(String nombre, String codigo, int limiteAlumnos) {
        super(nombre, codigo, limiteAlumnos);
    }

    //METODOS
    @Override
    public boolean validarDocente(Docente docente) {
        return docente.tieneConocimientoIngles(); // Requiere que el docente tenga conocimientos de inglés
    }

    @Override
    public void inscribirAlumno(Alumno alumno) {
        if (alumnosInscritos.contains(alumno)) {
            throw new ExcepcionNegocio("El alumno ya está inscrito en este curso.");
        }
        super.inscribirAlumno(alumno); // Realiza la inscripción desde la clase base
    }

}
