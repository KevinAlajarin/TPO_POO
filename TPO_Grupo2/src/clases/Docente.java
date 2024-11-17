package clases;
import java.util.ArrayList;
import java.util.List;

public class Docente {
    private String nombre;
    private String id;
    private int antiguedad;
    private boolean conocimientosIngles;
    private List<Integer> calificaciones = new ArrayList<>();
    private List<Curso> cursosAsignados = new ArrayList<>();

    public Docente(String nombre, String id, int antiguedad, boolean conocimientosIngles) {
        this.nombre = nombre;
        this.id = id;
        this.antiguedad = antiguedad;
        this.conocimientosIngles = conocimientosIngles;
    }

    public int getAntiguedad() {
        return antiguedad;
    }

    public boolean tieneConocimientosIngles() {
        return conocimientosIngles;
    }

    public void recibirCalificacion(int calificacion) {
        calificaciones.add(calificacion);
    }

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public boolean isConocimientosIngles() {
		return conocimientosIngles;
	}

	public void setConocimientosIngles(boolean conocimientosIngles) {
		this.conocimientosIngles = conocimientosIngles;
	}

	public List<Integer> getCalificaciones() {
		return calificaciones;
	}

	public void setCalificaciones(List<Integer> calificaciones) {
		this.calificaciones = calificaciones;
	}

	public void setAntiguedad(int antiguedad) {
		this.antiguedad = antiguedad;
	}
	
    public void asignarCurso(Curso curso) {
        cursosAsignados.add(curso);
    }
    
    public List<Curso> getCursosAsignados() {
        return cursosAsignados;
    }

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setCursosAsignados(List<Curso> cursosAsignados) {
		this.cursosAsignados = cursosAsignados;
	}
}
