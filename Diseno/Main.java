public class Main {
    public static void main(String[] args) {
        SistemaBiblioteca sistema = new SistemaBiblioteca();

        // Crear y registrar un libro
        JSONObject libroJson = new JSONObject();
        libroJson.put("titulo", "Don Quijote");
        libroJson.put("codigo", "ISBN001");
        libroJson.put("añoPublicacion", 1605);
        libroJson.put("disponible", true);
        libroJson.put("autor", "Miguel de Cervantes");
        libroJson.put("numPaginas", 863);
        
        Libro libro = new Libro(libroJson);
        sistema.registrarMaterial(libro);

        // Crear y registrar un estudiante
        Estudiante estudiante = new Estudiante("Juan Pérez", "EST001");
        sistema.registrarEstudiante(estudiante);
    }
}