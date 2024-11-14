package clases;

public class main {
    public static void main(String[] args) {
        // Crear docentes
        Docente docente1 = new Docente("Juan", 10, true);
        Docente docente2 = new Docente("Ana", 3, false);
        Docente docente3 = new Docente("Carlos", 6, true);

        // Crear alumnos
        Alumno alumno1 = new Alumno("Pedro", "12345", "1er Año");
        Alumno alumno2 = new Alumno("Lucia", "54321", "2do Año");
        Alumno alumno3 = new Alumno("Sofia", "67890", "3er Año");

        // Crear cursos
        CursoBasico cursoBasico = new CursoBasico("Matemáticas Básicas", "B001", 30);
        CursoSuperior cursoSuperior = new CursoSuperior("Física Avanzada", "S001", 20, "B001");
        CursoIngles cursoIngles = new CursoIngles("Inglés Intermedio", "I001", 25);

        // Asignar docentes a los cursos
        cursoBasico.asignarDocente(docente1);
        cursoSuperior.asignarDocente(docente3);
        cursoIngles.asignarDocente(docente2);

        // Intentar inscribir alumnos en los cursos
        System.out.println("Inscripción de alumnos:");
        System.out.println("Alumno1 en Curso Básico: " + cursoBasico.inscribirAlumno(alumno1));
        System.out.println("Alumno2 en Curso Básico: " + cursoBasico.inscribirAlumno(alumno2));
        System.out.println("Alumno3 en Curso Superior: " + cursoSuperior.inscribirAlumno(alumno3));
        System.out.println("Alumno1 en Curso Superior (sin completar el curso básico): " + cursoSuperior.inscribirAlumno(alumno1));

        // Añadir curso basico completado para Alumno1 y reintentar inscripcion en curso superior
        alumno1.agregarCursoCompletado(cursoBasico);
        System.out.println("Alumno1 en Curso Superior (después de completar Curso Básico): " + cursoSuperior.inscribirAlumno(alumno1));

        // Validacion de docentes para los cursos
        System.out.println("\nValidación de docentes:");
        System.out.println("Validación Docente1 en Curso Básico: " + cursoBasico.validarDocente(docente1));
        System.out.println("Validación Docente3 en Curso Superior: " + cursoSuperior.validarDocente(docente3));
        System.out.println("Validación Docente2 en Curso Inglés: " + cursoIngles.validarDocente(docente2));

        // Calificacion de cursos y docentes
        System.out.println("\nCalificación de cursos:");
        cursoBasico.calificar(cursoBasico, docente1, 8, 9);
        cursoSuperior.calificar(cursoSuperior, docente3, 7, 8);
        cursoIngles.calificar(cursoIngles, docente2, 6, 5);

        // Mostrar cursos asignados a los docentes
        System.out.println("\nCursos asignados a Docente1:");
        for (Curso curso : docente1.getCursosAsignados()) {
            System.out.println(curso.getNombre());
        }

        System.out.println("\nCursos asignados a Docente3:");
        for (Curso curso : docente3.getCursosAsignados()) {
            System.out.println(curso.getNombre());
        }

        System.out.println("\nCursos completados por Alumno1:");
        for (Curso curso : alumno1.getCursosCompletados()) {
            System.out.println(curso.getNombre());
        }
    }
}

