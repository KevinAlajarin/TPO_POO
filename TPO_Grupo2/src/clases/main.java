package clases;
import java.util.Scanner;

public class main {
    private static GestorAcademico gestor = new GestorAcademico();
    private static Scanner scanner = new Scanner(System.in);
    
    public static void main(String[] args) {
        int option;
        
        gestor.getCursos().add(new CursoBasico("Curso Básico 1", "CB1", 30));
        gestor.getCursos().add(new CursoSuperior("Curso Superior 1", "CS1", 20, "CB1"));
        gestor.getCursos().add(new CursoIngles("Curso Inglés 1", "CI1", 15));
        
    	gestor.getDocentes().add(new Docente("Juan Pérez", "D1", 3, true));
    	gestor.getDocentes().add(new Docente("Ana García", "D2", 7, false));
    	gestor.getDocentes().add(new Docente("Carlos López", "D3", 5, true));
    	
    	gestor.getAlumnos().add(new Alumno("Juan Perez", "A1", "Licenciatura en Ciencias"));
    	gestor.getAlumnos().add(new Alumno("Ana Gómez", "A2", "Ingeniería en Sistemas"));
        
        do {
            showMenu();
            try {
                option = Integer.parseInt(scanner.nextLine());
                switch (option) {
                    case 1:
                        gestionarCursos();
                        break;
                    case 2:
                        gestionarDocentes();
                        break;
                    case 3:
                        gestionarAlumnos();
                        break;
                    case 0:
                        System.out.println("Saliendo...");
                        break;
                    default:
                        System.out.println("Opción no válida.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Entrada no válida. Por favor, ingrese un número.");
                option = -1;
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
                option = -1;
            }
        } while (option != 0);
    }

    private static void showMenu() {
        System.out.println("---- Menu ----");
        System.out.println("1. Cursos");
        System.out.println("2. Docentes");
        System.out.println("3. Alumnos");
        System.out.println("0. Salir");
        System.out.print("Seleccione una opción: ");
    }

    private static void gestionarCursos() {
        int option;
        do {
            System.out.println("---- Cursos ----");
            System.out.println("1. Crear curso básico");
            System.out.println("2. Crear curso superior");
            System.out.println("3. Crear curso de inglés");
            System.out.println("4. Listar cursos");
            System.out.println("5. Eliminar cursos");
            System.out.println("0. Volver al menú principal");
            System.out.print("Seleccione una opción: ");
            try {
                option = Integer.parseInt(scanner.nextLine());
                switch (option) {
                    case 1:
                        cargarCursoBasico();
                        break;
                    case 2:
                        cargarCursoSuperior();
                        break;
                    case 3:
                        cargarCursoIngles();
                        break;
                    case 4:
                        listarCursos();
                        break;
                    case 5:
                        eliminarCurso();
                        break;
                    case 0:
                        System.out.println("Volviendo al menú principal...");
                        break;
                    default:
                        System.out.println("Opción no válida.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Entrada no válida. Por favor, ingrese un número.");
                option = -1;
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
                option = -1;
            }
        } while (option != 0);
    }

    private static void cargarCursoBasico() {
        System.out.print("Ingrese el nombre del curso básico: ");
        String nombre = scanner.nextLine();
        System.out.print("Ingrese el código del curso básico: ");
        String codigo = scanner.nextLine();
        System.out.print("Ingrese el límite de alumnos: ");
        int limiteAlumnos = Integer.parseInt(scanner.nextLine());

        Curso curso = new CursoBasico(nombre, codigo, limiteAlumnos);
        gestor.getCursos().add(curso);
        System.out.println("Curso básico creado exitosamente.");
    }

    private static void cargarCursoSuperior() {
        System.out.print("Ingrese el nombre del curso superior: ");
        String nombre = scanner.nextLine();
        System.out.print("Ingrese el código del curso superior: ");
        String codigo = scanner.nextLine();
        System.out.print("Ingrese el límite de alumnos: ");
        int limiteAlumnos = Integer.parseInt(scanner.nextLine());
        System.out.print("Ingrese el código del curso básico requerido: ");
        String codigoBasicoRequerido = scanner.nextLine();

        Curso curso = new CursoSuperior(nombre, codigo, limiteAlumnos, codigoBasicoRequerido);
        gestor.getCursos().add(curso);
        System.out.println("Curso superior creado exitosamente.");
    }

    private static void cargarCursoIngles() {
        System.out.print("Ingrese el nombre del curso de inglés: ");
        String nombre = scanner.nextLine();
        System.out.print("Ingrese el código del curso de inglés: ");
        String codigo = scanner.nextLine();
        System.out.print("Ingrese el límite de alumnos: ");
        int limiteAlumnos = Integer.parseInt(scanner.nextLine());

        Curso curso = new CursoIngles(nombre, codigo, limiteAlumnos);
        gestor.getCursos().add(curso);
        System.out.println("Curso de inglés creado exitosamente.");
    }

    private static void listarCursos() {
        for (Curso curso : gestor.getCursos()) {
            System.out.println("Nombre: " + curso.getNombre() + " | Código: " + curso.getCodigo() + " | Límite de Alumnos: " + curso.getLimiteAlumnos());
        }
    }

    private static void eliminarCurso() {
        System.out.print("Ingrese el código del curso a eliminar: ");
        String codigo = scanner.nextLine();

        Curso cursoAEliminar = null;
        for (Curso curso : gestor.getCursos()) {
            if (curso.getCodigo().equals(codigo)) {
                cursoAEliminar = curso;
                break;
            }
        }

        if (cursoAEliminar != null) {
            gestor.getCursos().remove(cursoAEliminar);
            System.out.println("Curso eliminado exitosamente.");
        } else {
            System.out.println("Curso no encontrado.");
        }
    }

    private static void gestionarDocentes() {
        int option;
        do {
            System.out.println("---- Docentes ----");
            System.out.println("1. Crear docente");
            System.out.println("2. Listar docentes");
            System.out.println("3. Eliminar docente");
            System.out.println("0. Volver al menú principal");
            System.out.print("Seleccione una opción: ");
            try {
                option = Integer.parseInt(scanner.nextLine());
                switch (option) {
                    case 1:
                        cargarDocente();
                        break;
                    case 2:
                        listarDocentes();
                        break;
                    case 3:
                        eliminarDocente();
                        break;
                    case 0:
                        System.out.println("Volviendo al menú principal...");
                        break;
                    default:
                        System.out.println("Opción no válida.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Entrada no válida. Por favor, ingrese un número.");
                option = -1;
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
                option = -1;
            }
        } while (option != 0);
    }

    private static void cargarDocente() {
        System.out.println("Ingrese el nombre del docente:");
        String nombre = scanner.nextLine();
        System.out.println("Ingrese el ID del docente:");
        String id = scanner.nextLine();
        System.out.println("Ingrese la antigüedad del docente:");
        int antiguedad = Integer.parseInt(scanner.nextLine());
        System.out.println("¿El docente tiene conocimientos de inglés? (true/false):");
        boolean conocimientoIngles = Boolean.parseBoolean(scanner.nextLine());

        // Crear el docente con los datos obtenidos
        Docente docente = new Docente(nombre, id, antiguedad, conocimientoIngles);
        gestor.getDocentes().add(docente);  // Añadir al gestor
        System.out.println("Docente creado exitosamente.");
    }

    // Método para listar los docentes
    private static void listarDocentes() {
        if (gestor.getDocentes().isEmpty()) {
            System.out.println("No hay docentes disponibles.");
        } else {
            for (Docente docente : gestor.getDocentes()) {
                System.out.println("Nombre: " + docente.getNombre() + " | ID: " + docente.getId() + " | Antigüedad: " + docente.getAntiguedad() + " años | Conocimientos de Inglés: " + docente.isConocimientosIngles());
            }
        }
    }

    // Método para eliminar un docente por ID
    private static void eliminarDocente() {
        System.out.println("Ingrese el ID del docente a eliminar:");
        String id = scanner.nextLine();
        boolean eliminado = false;

        for (Docente docente : gestor.getDocentes()) {
            if (docente.getId().equals(id)) {
                gestor.getDocentes().remove(docente);
                System.out.println("Docente eliminado exitosamente.");
                eliminado = true;
                break;
            }
        }

        if (!eliminado) {
            System.out.println("No se encontró un docente con ese ID.");
        }
    }

    private static void gestionarAlumnos() {
        int option;
        do {
            System.out.println("---- Alumnos ----");
            System.out.println("1. Crear alumno");
            System.out.println("2. Listar alumnos");
            System.out.println("3. Eliminar alumno");
            System.out.println("0. Volver al menú principal");
            System.out.print("Seleccione una opción: ");
            try {
                option = Integer.parseInt(scanner.nextLine());
                switch (option) {
                    case 1:
                        cargarAlumno();
                        break;
                    case 2:
                        listarAlumnos();
                        break;
                    case 3:
                        eliminarAlumno();
                        break;
                    case 0:
                        System.out.println("Volviendo al menú principal...");
                        break;
                    default:
                        System.out.println("Opción no válida.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Entrada no válida. Por favor, ingrese un número.");
                option = -1;
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
                option = -1;
            }
        } while (option != 0);
    }

    private static void cargarAlumno() {
        System.out.println("Ingrese el nombre del alumno:");
        String nombre = scanner.nextLine();
        System.out.println("Ingrese el ID del alumno:");
        String id = scanner.nextLine();
        System.out.println("Ingrese el nivel académico del alumno:");
        String nivelAcademico = scanner.nextLine();

        Alumno alumno = new Alumno(nombre, id, nivelAcademico);
        gestor.getAlumnos().add(alumno);
        System.out.println("Alumno creado exitosamente.");
    }

    private static void listarAlumnos() {
        if (gestor.getAlumnos().isEmpty()) {
            System.out.println("No hay alumnos disponibles.");
        } else {
            for (Alumno alumno : gestor.getAlumnos()) {
                System.out.println("ID: " + alumno.getId() + " | Nombre: " + alumno.getNombre() + " | Nivel Académico: " + alumno.getNivelAcademico());
                System.out.println("Cursos inscritos:");
                for (Curso curso : alumno.getCursosInscritos()) {
                    System.out.println("  - " + curso.getNombre() + " (Código: " + curso.getCodigo() + ")");
                }
                System.out.println("Cursos completados:");
                for (Curso curso : alumno.getCursosCompletados()) {
                    System.out.println("  - " + curso.getNombre() + " (Código: " + curso.getCodigo() + ")");
                }
            }
        }
    }

    private static void eliminarAlumno() {
        System.out.println("Ingrese el ID del alumno a eliminar:");
        String id = scanner.nextLine();
        boolean eliminado = gestor.eliminarAlumno(id); // Ahora devuelve un boolean
        if (eliminado) {
            System.out.println("Alumno eliminado exitosamente.");
        } else {
            System.out.println("No se encontró un alumno con ese ID.");
        }
    }
}
