public class TrabajoDeGrado extends MaterialBase {
    private String estudiante;
    private String programa;

    public TrabajoDeGrado(String titulo, String codigo, int añoPublicacion, String estudiante, String programa) {
        super(titulo, codigo, añoPublicacion);
        this.estudiante = estudiante;
        this.programa = programa;
    }

    // Getters y setters específicos
}