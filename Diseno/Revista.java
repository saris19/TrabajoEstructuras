public class Revista extends MaterialBase {
    private int volumen;
    private int numEdicion;

    public Revista(String titulo, String codigo, int añoPublicacion, int volumen, int numEdicion) {
        super(titulo, codigo, añoPublicacion);
        this.volumen = volumen;
        this.numEdicion = numEdicion;
    }

    // Getters y setters específicos
}