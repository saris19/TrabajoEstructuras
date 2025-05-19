package Semana13.BibliotecaExamen;

public abstract class Material {
    private String titulo;
    private String codigoUnico;
    private int anoPublicacion;
    protected EstadoMaterial estado;
    private String tipo;

    /**
     * Constructor para la clase Material.
     *
     * @param titulo Título del material
     * @param codigoUnico Código único identificador (ISBN, ID, etc.)
     * @param anoPublicacion Año en que fue publicado
     * @param tipo Tipo de material (para serialización JSON)
     */
    public Material(String titulo, String codigoUnico, int anoPublicacion, String tipo) {
        this.titulo = titulo;
        this.codigoUnico = codigoUnico;
        this.anoPublicacion = anoPublicacion;
        this.estado = EstadoMaterial.DISPONIBLE;
        this.tipo = tipo;
    }

    /**
     * Método abstracto para mostrar información del material.
     * Cada subclase debe implementar su propia versión.
     *
     * @return String con la información formateada del material
     */
    public abstract String mostrarInformacion();

    /**
     * Verifica si el material está disponible para préstamo.
     *
     * @return true si está disponible, false si está prestado
     */
    public boolean estaDisponible() {
        return estado == EstadoMaterial.DISPONIBLE;
    }

    /**
     * Cambia el estado del material.
     *
     * @param nuevoEstado Nuevo estado para el material
     */
    protected void cambiarEstado(EstadoMaterial nuevoEstado) {
        this.estado = nuevoEstado;
    }

    /**
     * Obtiene el código único del material.
     *
     * @return Código único identificador
     */
    public String getCodigoUnico() {
        return codigoUnico;
    }

    /**
     * Obtiene el tipo de material.
     * Útil para serialización/deserialización JSON.
     *
     * @return Tipo de material como String
     */
    public String getTipo() {
        return tipo;
    }

    /**
     * Obtiene el título del material.
     *
     * @return Título del material
     */
    public String getTitulo() {
        return titulo;
    }

    /**
     * Obtiene el año de publicación.
     *
     * @return Año de publicación
     */
    public int getAnoPublicacion() {
        return anoPublicacion;
    }

    /**
     * Obtiene el estado actual del material.
     *
     * @return Estado del material
     */
    public EstadoMaterial getEstado() {
        return estado;
    }

    /**
     * Establece el material como prestado.
     */
    public void marcarComoPrestado() {
        this.estado = EstadoMaterial.PRESTADO;
    }

    /**
     * Establece el material como disponible.
     */
    public void marcarComoDisponible() {
        this.estado = EstadoMaterial.DISPONIBLE;
    }
}
