public class Libro extends MaterialBase {
    private String autor;
    private int numPaginas;

    public Libro(String titulo, String codigo, int añoPublicacion, String autor, int numPaginas) {
        super(titulo, codigo, añoPublicacion);
        this.autor = autor;
        this.numPaginas = numPaginas;
    }

    // Getters y setters específicos
}