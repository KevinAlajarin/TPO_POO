package clases;
import java.util.Set;
import java.util.HashSet;

public class Alumno {
 private String nombre;
 private String id;
 private String nivelAcademico;
 private Set<Curso> cursosCompletados = new HashSet<>();
 private Set<Curso> cursosInscritos = new HashSet<>();

 public Alumno(String nombre, String id, String nivelAcademico) {
     this.nombre = nombre;
     this.id = id;
     this.nivelAcademico = nivelAcademico;
 }

 public boolean cursoCompletado(String codigoCurso) {
     return cursosCompletados.stream().anyMatch(c -> c.codigo.equals(codigoCurso));
 }

 public void inscribirEnCurso(Curso curso) {
     if (curso.inscribirAlumno(this)) {
         cursosInscritos.add(curso);
     }
 }

 public void agregarCursoCompletado(Curso curso) {
     cursosCompletados.add(curso);
  }

public String getNombre() {
	return nombre;
}

public void setNombre(String nombre) {
	this.nombre = nombre;
}

public String getId() {
	return id;
}

public void setId(String id) {
	this.id = id;
}

public String getNivelAcademico() {
	return nivelAcademico;
}

public void setNivelAcademico(String nivelAcademico) {
	this.nivelAcademico = nivelAcademico;
}

public Set<Curso> getCursosCompletados() {
	return cursosCompletados;
}

public void setCursosCompletados(Set<Curso> cursosCompletados) {
	this.cursosCompletados = cursosCompletados;
}

public Set<Curso> getCursosInscritos() {
	return cursosInscritos;
}

public void setCursosInscritos(Set<Curso> cursosInscritos) {
	this.cursosInscritos = cursosInscritos;
}
}
