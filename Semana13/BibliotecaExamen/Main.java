package Semana13.BibliotecaExamen;
import java.util.Scanner;
import java.util.UUID;
import java.util.List;


public class Main {
    private static Biblioteca biblioteca;
    private static Scanner scanner;

    public static void main(String[] args) {
        biblioteca = new Biblioteca();
        scanner = new Scanner(System.in);
        
        
        boolean salir = false;
        
        while (!salir) {
            mostrarMenuPrincipal();
            int opcion = leerOpcion();
            
            switch (opcion) {
                case 1:
                    gestionarMateriales();
                    break;
                case 2:
                    gestionarEstudiantes();
                    break;
                case 3:
                    gestionarPrestamos();
                    break;
                case 4:
                    salir = true;
                    System.out.println("¡Gracias por usar el sistema de biblioteca! Hasta pronto.");
                    break;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }
        }
        
        scanner.close();
    }
    

    private static void mostrarMenuPrincipal() {
        System.out.println("\n=== SISTEMA DE GESTIÓN DE BIBLIOTECA UNIVERSITARIA ===");
        System.out.println("1. Gestión de Materiales");
        System.out.println("2. Gestión de Estudiantes");
        System.out.println("3. Gestión de Préstamos");
        System.out.println("4. Salir");
        System.out.print("Seleccione una opción: ");
    }
    

    private static void gestionarMateriales() {
        boolean volver = false;
        
        while (!volver) {
            System.out.println("\n=== GESTIÓN DE MATERIALES ===");
            System.out.println("1. Registrar nuevo material");
            System.out.println("2. Ver todos los materiales");
            System.out.println("3. Ver materiales disponibles");
            System.out.println("4. Buscar material por código");
            System.out.println("5. Volver al menú principal");
            System.out.print("Seleccione una opción: ");
            
            int opcion = leerOpcion();
            
            switch (opcion) {
                case 1:
                    registrarNuevoMaterial();
                    break;
                case 2:
                    biblioteca.mostrarTodosMaterialesConsola();
                    break;
                case 3:
                    biblioteca.mostrarDisponiblesConsola();
                    break;
                case 4:
                    buscarMaterialPorCodigo();
                    break;
                case 5:
                    volver = true;
                    break;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }
        }
    }
    

    private static void gestionarEstudiantes() {
        boolean volver = false;
        
        while (!volver) {
            System.out.println("\n=== GESTIÓN DE ESTUDIANTES ===");
            System.out.println("1. Registrar nuevo estudiante");
            System.out.println("2. Ver todos los estudiantes");
            System.out.println("3. Buscar estudiante por código");
            System.out.println("4. Ver préstamos de un estudiante");
            System.out.println("5. Volver al menú principal");
            System.out.print("Seleccione una opción: ");
            
            int opcion = leerOpcion();
            
            switch (opcion) {
                case 1:
                    registrarNuevoEstudiante();
                    break;
                case 2:
                    biblioteca.mostrarEstudiantesRegistradosConsola();
                    break;
                case 3:
                    buscarEstudiantePorCodigo();
                    break;
                case 4:
                    verPrestamosEstudiante();
                    break;
                case 5:
                    volver = true;
                    break;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }
        }
    }
    
    /**
     * Gestiona el submenú de préstamos.
     */
    private static void gestionarPrestamos() {
        boolean volver = false;
        
        while (!volver) {
            System.out.println("\n=== GESTIÓN DE PRÉSTAMOS ===");
            System.out.println("1. Realizar préstamo");
            System.out.println("2. Realizar devolución");
            System.out.println("3. Ver materiales disponibles");
            System.out.println("4. Ver préstamos de un estudiante");
            System.out.println("5. Volver al menú principal");
            System.out.print("Seleccione una opción: ");
            
            int opcion = leerOpcion();
            
            switch (opcion) {
                case 1:
                    realizarPrestamo();
                    break;
                case 2:
                    realizarDevolucion();
                    break;
                case 3:
                    biblioteca.mostrarDisponiblesConsola();
                    break;
                case 4:
                    verPrestamosEstudiante();
                    break;
                case 5:
                    volver = true;
                    break;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }
        }
    }
    
    /**
     * Registra un nuevo material en el sistema.
     */
    private static void registrarNuevoMaterial() {
        System.out.println("\n=== REGISTRO DE NUEVO MATERIAL ===");
        System.out.println("Seleccione el tipo de material:");
        System.out.println("1. Libro");
        System.out.println("2. Revista");
        System.out.println("3. Trabajo de Grado");
        System.out.print("Opción: ");
        
        int tipoMaterial = leerOpcion();
        if (tipoMaterial < 1 || tipoMaterial > 3) {
            System.out.println("Tipo de material no válido.");
            return;
        }
        
        System.out.print("Título: ");
        String titulo = scanner.nextLine();
        
        // Generar código único (o permitir ingresarlo)
        String codigoUnico = generarCodigoUnico();
        System.out.println("Código único asignado: " + codigoUnico);
        
        System.out.print("Año de publicación: ");
        int anoPublicacion = leerEntero();
        
        Material nuevoMaterial = null;
        
        switch (tipoMaterial) {
            case 1: // Libro
                System.out.print("Nombre del autor: ");
                String nombreAutor = scanner.nextLine();
                System.out.print("Número de páginas: ");
                int numeroPaginas = leerEntero();
                
                nuevoMaterial = new Libro(titulo, codigoUnico, anoPublicacion, nombreAutor, numeroPaginas);
                break;
                
            case 2: // Revista
                System.out.print("Volumen: ");
                int volumen = leerEntero();
                System.out.print("Número de edición: ");
                int numeroEdicion = leerEntero();
                
                nuevoMaterial = new Revista(titulo, codigoUnico, anoPublicacion, volumen, numeroEdicion);
                break;
                
            case 3: // Trabajo de Grado
                System.out.print("Nombre del estudiante autor: ");
                String nombreEstudianteAutor = scanner.nextLine();
                System.out.print("Programa académico: ");
                String programaAcademico = scanner.nextLine();
                
                nuevoMaterial = new TrabajoGrado(titulo, codigoUnico, anoPublicacion, 
                                                nombreEstudianteAutor, programaAcademico);
                break;
        }
        
        if (nuevoMaterial != null) {
            boolean registrado = biblioteca.registrarMaterial(nuevoMaterial);
            if (registrado) {
                System.out.println("Material registrado correctamente.");
            } else {
                System.out.println("Error: Ya existe un material con ese código.");
            }
        }
    }
    
    /**
     * Registra un nuevo estudiante en el sistema.
     */
    private static void registrarNuevoEstudiante() {
        System.out.println("\n=== REGISTRO DE NUEVO ESTUDIANTE ===");
        System.out.print("Nombre del estudiante: ");
        String nombre = scanner.nextLine();
        
        // Generar código único (o permitir ingresarlo)
        String codigoEstudiante = "E" + UUID.randomUUID().toString().substring(0, 6);
        System.out.println("Código de estudiante asignado: " + codigoEstudiante);
        
        Estudiante nuevoEstudiante = new Estudiante(nombre, codigoEstudiante);
        boolean registrado = biblioteca.registrarEstudiante(nuevoEstudiante);
        
        if (registrado) {
            System.out.println("Estudiante registrado correctamente.");
        } else {
            System.out.println("Error: Ya existe un estudiante con ese código.");
        }
    }
    
    /**
     * Busca un material por su código y muestra su información.
     */
    private static void buscarMaterialPorCodigo() {
        System.out.println("\n=== BÚSQUEDA DE MATERIAL ===");
        System.out.print("Ingrese el código del material: ");
        String codigo = scanner.nextLine();
        
        Material material = biblioteca.buscarMaterial(codigo);
        if (material != null) {
            System.out.println("Material encontrado:");
            System.out.println(material.mostrarInformacion());
        } else {
            System.out.println("No se encontró un material con el código: " + codigo);
        }
    }
    
    /**
     * Busca un estudiante por su código y muestra su información.
     */
    private static void buscarEstudiantePorCodigo() {
        System.out.println("\n=== BÚSQUEDA DE ESTUDIANTE ===");
        System.out.print("Ingrese el código del estudiante: ");
        String codigo = scanner.nextLine();
        
        Estudiante estudiante = biblioteca.buscarEstudiante(codigo);
        if (estudiante != null) {
            System.out.println("Estudiante encontrado:");
            System.out.println("Nombre: " + estudiante.getNombre());
            System.out.println("Código: " + estudiante.getCodigoEstudiante());
            System.out.println("Materiales prestados: " + estudiante.getMaterialesPrestados().size());
        } else {
            System.out.println("No se encontró un estudiante con el código: " + codigo);
        }
    }
    
    /**
     * Muestra los préstamos de un estudiante específico.
     */
    private static void verPrestamosEstudiante() {
        System.out.println("\n=== PRÉSTAMOS DE ESTUDIANTE ===");
        System.out.print("Ingrese el código del estudiante: ");
        String codigo = scanner.nextLine();
        
        biblioteca.mostrarPrestamosEstudianteConsola(codigo);
    }
    
    /**
     * Realiza un préstamo de material a un estudiante.
     */
    private static void realizarPrestamo() {
        System.out.println("\n=== REALIZAR PRÉSTAMO ===");
        
        // Mostrar estudiantes disponibles para selección
        List<Estudiante> estudiantes = biblioteca.obtenerEstudiantesRegistrados();
        if (estudiantes.isEmpty()) {
            System.out.println("No hay estudiantes registrados en el sistema.");
            return;
        }
        
        System.out.println("Estudiantes registrados:");
        for (Estudiante e : estudiantes) {
            System.out.println(e.getCodigoEstudiante() + " - " + e.getNombre());
        }
        
        System.out.print("Ingrese el código del estudiante: ");
        String codigoEstudiante = scanner.nextLine();
        
        Estudiante estudiante = biblioteca.buscarEstudiante(codigoEstudiante);
        if (estudiante == null) {
            System.out.println("No se encontró un estudiante con ese código.");
            return;
        }
        
        if (!estudiante.puedeTomarPrestado()) {
            System.out.println("El estudiante ya tiene el máximo de 3 materiales prestados.");
            return;
        }
        
        // Mostrar materiales disponibles
        List<Material> disponibles = biblioteca.consultarMaterialesDisponibles();
        if (disponibles.isEmpty()) {
            System.out.println("No hay materiales disponibles para préstamo.");
            return;
        }
        
        System.out.println("Materiales disponibles para préstamo:");
        for (Material m : disponibles) {
            System.out.println(m.getCodigoUnico() + " - " + m.getTitulo());
        }
        
        System.out.print("Ingrese el código del material a prestar: ");
        String codigoMaterial = scanner.nextLine();
        
        boolean prestado = biblioteca.prestarMaterial(codigoEstudiante, codigoMaterial);
        
        if (prestado) {
            System.out.println("Préstamo realizado correctamente.");
        } else {
            System.out.println("No se pudo realizar el préstamo. Verifique los códigos y la disponibilidad.");
        }
    }
    
    /**
     * Realiza la devolución de un material prestado.
     */
    private static void realizarDevolucion() {
        System.out.println("\n=== REALIZAR DEVOLUCIÓN ===");
        System.out.print("Ingrese el código del estudiante: ");
        String codigoEstudiante = scanner.nextLine();
        
        Estudiante estudiante = biblioteca.buscarEstudiante(codigoEstudiante);
        if (estudiante == null) {
            System.out.println("No se encontró un estudiante con ese código.");
            return;
        }
        
        List<Material> prestados = estudiante.getMaterialesPrestados();
        if (prestados.isEmpty()) {
            System.out.println("El estudiante no tiene materiales prestados.");
            return;
        }
        
        System.out.println("Materiales prestados a " + estudiante.getNombre() + ":");
        for (Material m : prestados) {
            System.out.println(m.getCodigoUnico() + " - " + m.getTitulo());
        }
        
        System.out.print("Ingrese el código del material a devolver: ");
        String codigoMaterial = scanner.nextLine();
        
        boolean devuelto = biblioteca.devolverMaterial(codigoEstudiante, codigoMaterial);
        
        if (devuelto) {
            System.out.println("Devolución realizada correctamente.");
        } else {
            System.out.println("No se pudo realizar la devolución. Verifique los códigos.");
        }
    }
    
    /**
     * Lee una opción numérica desde la consola.
     *
     * @return Opción seleccionada como entero
     */
    private static int leerOpcion() {
        try {
            return Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            return 0; // Opción inválida
        }
    }
    
    /**
     * Lee un valor entero desde la consola con manejo de errores.
     *
     * @return Valor entero leído
     */
    private static int leerEntero() {
        while (true) {
            try {
                return Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.print("Valor no válido. Ingrese un número entero: ");
            }
        }
    }
    
    /**
     * Genera un código único para materiales.
     *
     * @return Código único generado
     */
    private static String generarCodigoUnico() {
        return UUID.randomUUID().toString().substring(0, 8);
    }
}
