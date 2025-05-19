package Semana13.BibliotecaExamen;

public class Libro extends Material {
    private String nombreAutor;
    private int numeroPaginas;

    public Libro(String titulo, String codigoUnico, int anoPublicacion, 
                String nombreAutor, int numeroPaginas) {
        super(titulo, codigoUnico, anoPublicacion, "Libro");
        this.nombreAutor = nombreAutor;
        this.numeroPaginas = numeroPaginas;
    }

    @Override
    public String mostrarInformacion() {
        String disponibilidad = estaDisponible() ? "Disponible" : "Prestado";
        return String.format("LIBRO: [%s] %s - Autor: %s, Año: %d, Páginas: %d, Estado: %s", 
                getCodigoUnico(), getTitulo(), nombreAutor, getAnoPublicacion(), 
                numeroPaginas, disponibilidad);
    }


    public String getNombreAutor() {
        return nombreAutor;
    }

    public int getNumeroPaginas() {
        return numeroPaginas;
    }
}
