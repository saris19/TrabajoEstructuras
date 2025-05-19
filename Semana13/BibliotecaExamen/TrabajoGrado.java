package Semana13.BibliotecaExamen;

public class TrabajoGrado extends Material {
    private String nombreEstudianteAutor;
    private String programaAcademico;

    /**
     * Constructor para la clase TrabajoGrado.
     *
     * @param titulo Título del trabajo de grado
     * @param codigoUnico Código único del trabajo
     * @param anoPublicacion Año de publicación
     * @param nombreEstudianteAutor Nombre del estudiante autor
     * @param programaAcademico Programa académico al que pertenece
     */
    public TrabajoGrado(String titulo, String codigoUnico, int anoPublicacion, 
                       String nombreEstudianteAutor, String programaAcademico) {
        super(titulo, codigoUnico, anoPublicacion, "TrabajoGrado");
        this.nombreEstudianteAutor = nombreEstudianteAutor;
        this.programaAcademico = programaAcademico;
    }

    /**
     * Implementación del método abstracto para mostrar información del trabajo de grado.
     *
     * @return String con la información formateada del trabajo de grado
     */
    @Override
    public String mostrarInformacion() {
        String disponibilidad = estaDisponible() ? "Disponible" : "Prestado";
        return String.format("TRABAJO DE GRADO: [%s] %s - Autor: %s, Programa: %s, Año: %d, Estado: %s", 
                getCodigoUnico(), getTitulo(), nombreEstudianteAutor, 
                programaAcademico, getAnoPublicacion(), disponibilidad);
    }

    /**
     * Obtiene el nombre del estudiante autor.
     *
     * @return Nombre del estudiante autor
     */
    public String getNombreEstudianteAutor() {
        return nombreEstudianteAutor;
    }

    /**
     * Obtiene el programa académico.
     *
     * @return Programa académico
     */
    public String getProgramaAcademico() {
        return programaAcademico;
    }
}
