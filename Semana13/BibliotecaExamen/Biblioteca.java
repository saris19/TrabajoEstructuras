package Semana13.BibliotecaExamen;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


public class Biblioteca {
    private List<Material> inventarioMateriales;
    private List<Estudiante> estudiantesRegistrados;


    public Biblioteca() {
        this.inventarioMateriales = new ArrayList<>();
        this.estudiantesRegistrados = new ArrayList<>();
    }

    public boolean registrarMaterial(Material material) {
        if (buscarMaterial(material.getCodigoUnico()) != null) {
            return false;
        }
        inventarioMateriales.add(material);
        return true;
    }

    public boolean registrarEstudiante(Estudiante estudiante) {
        if (buscarEstudiante(estudiante.getCodigoEstudiante()) != null) {
            return false;
        }
        estudiantesRegistrados.add(estudiante);
        return true;
    }

    public Material buscarMaterial(String codigoUnico) {
        return inventarioMateriales.stream()
                .filter(m -> m.getCodigoUnico().equals(codigoUnico))
                .findFirst()
                .orElse(null);
    }

    public Estudiante buscarEstudiante(String codigoEstudiante) {
        return estudiantesRegistrados.stream()
                .filter(e -> e.getCodigoEstudiante().equals(codigoEstudiante))
                .findFirst()
                .orElse(null);
    }

    public boolean prestarMaterial(String codigoEstudiante, String codigoMaterial) {
        Estudiante estudiante = buscarEstudiante(codigoEstudiante);
        Material material = buscarMaterial(codigoMaterial);

        if (estudiante == null || material == null) return false;
        if (!material.estaDisponible() || !estudiante.puedeTomarPrestado()) return false;

        material.cambiarEstado(EstadoMaterial.PRESTADO);
        return estudiante.agregarMaterialPrestado(material);
    }

    public boolean devolverMaterial(String codigoEstudiante, String codigoMaterial) {
        Estudiante estudiante = buscarEstudiante(codigoEstudiante);
        Material material = buscarMaterial(codigoMaterial);

        if (estudiante == null || material == null) return false;
        if (!estudiante.tienePrestadoMaterial(codigoMaterial)) return false;

        material.cambiarEstado(EstadoMaterial.DISPONIBLE);
        return estudiante.quitarMaterialPrestado(material);
    }

    public List<Material> consultarMaterialesDisponibles() {
        return inventarioMateriales.stream()
                .filter(Material::estaDisponible)
                .collect(Collectors.toList());
    }

    public List<Material> consultarTodosMateriales() {
        return new ArrayList<>(inventarioMateriales);
    }

    public List<Material> consultarPrestamosEstudiante(String codigoEstudiante) {
        Estudiante estudiante = buscarEstudiante(codigoEstudiante);
        return estudiante == null ? null : estudiante.getMaterialesPrestados();
    }

    public void mostrarDisponiblesConsola() {
        List<Material> disponibles = consultarMaterialesDisponibles();
        if (disponibles.isEmpty()) {
            System.out.println("No hay materiales disponibles para préstamo.");
            return;
        }
        System.out.println("Materiales disponibles para préstamo:");
        disponibles.forEach(m -> System.out.println(m.mostrarInformacion()));
    }

    public void mostrarTodosMaterialesConsola() {
        if (inventarioMateriales.isEmpty()) {
            System.out.println("No hay materiales registrados en el inventario.");
            return;
        }
        System.out.println("Inventario completo de materiales:");
        inventarioMateriales.forEach(m -> System.out.println(m.mostrarInformacion()));
    }

    public void mostrarPrestamosEstudianteConsola(String codigoEstudiante) {
        Estudiante estudiante = buscarEstudiante(codigoEstudiante);
        if (estudiante == null) {
            System.out.println("No se encontró un estudiante con el código: " + codigoEstudiante);
            return;
        }
        estudiante.mostrarPrestamosConsola();
    }

    public void mostrarEstudiantesRegistradosConsola() {
        if (estudiantesRegistrados.isEmpty()) {
            System.out.println("No hay estudiantes registrados en el sistema.");
            return;
        }
        System.out.println("Estudiantes registrados en el sistema:");
        estudiantesRegistrados.forEach(e ->
                System.out.println("Nombre: " + e.getNombre() +
                        ", Código: " + e.getCodigoEstudiante() +
                        ", Materiales prestados: " + e.getMaterialesPrestados().size()));
    }

    public List<Estudiante> obtenerEstudiantesRegistrados() {
        return new ArrayList<>(estudiantesRegistrados);
    }
}
