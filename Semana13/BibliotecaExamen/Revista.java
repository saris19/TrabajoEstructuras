package Semana13.BibliotecaExamen;

public class Revista extends Material {
    private int volumen;
    private int numeroEdicion;

    /**
     * Constructor para la clase Revista.
     *
     * @param titulo Título de la revista
     * @param codigoUnico Código único de la revista
     * @param anoPublicacion Año de publicación
     * @param volumen Volumen de la revista
     * @param numeroEdicion Número de edición de la revista
     */
    public Revista(String titulo, String codigoUnico, int anoPublicacion, 
                  int volumen, int numeroEdicion) {
        super(titulo, codigoUnico, anoPublicacion, "Revista");
        this.volumen = volumen;
        this.numeroEdicion = numeroEdicion;
    }

    /**
     * Implementación del método abstracto para mostrar información de la revista.
     *
     * @return String con la información formateada de la revista
     */
    @Override
    public String mostrarInformacion() {
        String disponibilidad = estaDisponible() ? "Disponible" : "Prestado";
        return String.format("REVISTA: [%s] %s - Vol. %d, Edición: %d, Año: %d, Estado: %s", 
                getCodigoUnico(), getTitulo(), volumen, numeroEdicion, 
                getAnoPublicacion(), disponibilidad);
    }

    /**
     * Obtiene el volumen de la revista.
     *
     * @return Volumen de la revista
     */
    public int getVolumen() {
        return volumen;
    }

    /**
     * Obtiene el número de edición de la revista.
     *
     * @return Número de edición
     */
    public int getNumeroEdicion() {
        return numeroEdicion;
    }
}