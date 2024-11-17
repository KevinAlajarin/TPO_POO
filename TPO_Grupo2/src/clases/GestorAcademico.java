package clases;

import java.util.HashSet;
import java.util.Set;

public class GestorAcademico {
    private Set<Curso> cursos;         // Reemplazo ArrayList por HashSet
    private Set<Docente> docentes;     // Reemplazo ArrayList por HashSet
    private Set<Alumno> alumnos;       // Reemplazo ArrayList por HashSet

    // Constructor
    public GestorAcademico() {
        this.cursos = new HashSet<>();
        this.docentes = new HashSet<>();
        this.alumnos = new HashSet<>();
    }

    // Getters y setters
    public Set<Curso> getCursos() {
        return cursos;
    }

    public void setCursos(Set<Curso> cursos) {
        this.cursos = cursos;
    }

    public Set<Docente> getDocentes() {
        return docentes;
    }

    public void setDocentes(Set<Docente> docentes) {
        this.docentes = docentes;
    }

    public Set<Alumno> getAlumnos() {
        return alumnos;
    }

    public void setAlumnos(Set<Alumno> alumnos) {
        this.alumnos = alumnos;
    }

    // Método para listar cursos
    public void listadoDeCursos() {
        if (cursos.isEmpty()) {
            System.out.println("No hay cursos disponibles.");
        } else {
            // Listar todos los cursos
            for (Curso curso : cursos) {
                System.out.println("Nombre: " + curso.getNombre() + " | Código: " + curso.getCodigo() + " | Límite de Alumnos: " + curso.getLimiteAlumnos());
            }
        }
    }
    // Método para buscar un curso por código
    public Curso buscarCurso(String codigoCurso) {
        // Buscar el curso en la lista de cursos por su código
        for (Curso curso : cursos) {
            if (curso.getCodigo().equals(codigoCurso)) {
                return curso;
            }
        }
        return null; // Retornar null si no se encuentra el curso
    }


    // Método para modificar un curso
    public void modificacionDeCurso(String codigoCurso, Curso cursoModificado) throws Exception {
        Curso cursoActual = buscarCurso(codigoCurso);
        if (cursoActual != null) {
            cursos.remove(cursoActual);
            cursos.add(cursoModificado);
        } else {
            throw new Exception("Curso no encontrado para modificar.");
        }
    }

    // Método para eliminar un curso
    public void eliminarCurso(String codigoCurso) throws Exception {
        // Buscar el curso por código
        Curso curso = buscarCurso(codigoCurso);

        if (curso != null) {
            // Eliminar el curso de la lista
            if (cursos.remove(curso)) {
                System.out.println("Curso eliminado exitosamente.");
            } else {
                throw new Exception("No se pudo eliminar el curso.");
            }
        } else {
            throw new Exception("Curso no encontrado para eliminar.");
        }
    }


    // Método para listar docentes
    public void listadoDeDocentes() {
        for (Docente docente : docentes) {
            System.out.println(docente);
        }
    }

    // Método para buscar un docente por ID
    public Docente buscarDocente(String idDocente) {
        for (Docente docente : docentes) {
            if (docente.getId().equals(idDocente)) {
                return docente;
            }
        }
        return null;
    }

    // Método para modificar un docente
    public void modificacionDeDocente(String idDocente, Docente docenteModificado) throws Exception {
        Docente docenteActual = buscarDocente(idDocente);
        if (docenteActual != null) {
            docentes.remove(docenteActual);
            docentes.add(docenteModificado);
        } else {
            throw new Exception("Docente no encontrado para modificar.");
        }
    }

    // Método para eliminar un docente
    public void eliminarDocente(String idDocente) throws Exception {
        Docente docente = buscarDocente(idDocente);
        if (docente != null) {
            docentes.remove(docente);
        } else {
            throw new Exception("Docente no encontrado para eliminar.");
        }
    }

    // Método para listar alumnos
    public void listadoDeAlumnos() {
        for (Alumno alumno : alumnos) {
            System.out.println(alumno);
        }
    }

    // Método para buscar un alumno por ID
    public Alumno buscarAlumno(String idAlumno) {
        for (Alumno alumno : alumnos) {
            if (alumno.getId().equals(idAlumno)) {
                return alumno;
            }
        }
        return null;
    }

    // Método para modificar un alumno
    public void modificacionDeAlumno(String idAlumno, Alumno alumnoModificado) throws Exception {
        Alumno alumnoActual = buscarAlumno(idAlumno);
        if (alumnoActual != null) {
            alumnos.remove(alumnoActual);
            alumnos.add(alumnoModificado);
        } else {
            throw new Exception("Alumno no encontrado para modificar.");
        }
    }

    // Método para eliminar un alumno
    public boolean eliminarAlumno(String id) {
        Alumno alumnoAEliminar = null;
        for (Alumno alumno : alumnos) {
            if (alumno.getId().equals(id)) {
                alumnoAEliminar = alumno;
                break;
            }
        }

        if (alumnoAEliminar != null) {
            alumnos.remove(alumnoAEliminar); // Elimina el alumno
            return true; // Si el alumno se encuentra y elimina, retorna true
        }
        return false; // Si no se encuentra el alumno, retorna false
    }
}
