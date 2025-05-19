package Semana13.BibliotecaExamen;

import java.util.ArrayList;
import java.util.List;


public class Estudiante {
    private String nombre;
    private String codigoEstudiante;
    private List<Material> materialesPrestados;
    private static final int LIMITE_PRESTAMOS = 3;

    public Estudiante(String nombre, String codigoEstudiante) {
        this.nombre = nombre;
        this.codigoEstudiante = codigoEstudiante;
        this.materialesPrestados = new ArrayList<>();
    }

    public Estudiante(String nombre, String codigoEstudiante, List<Material> materialesPrestados) {
        this.nombre = nombre;
        this.codigoEstudiante = codigoEstudiante;
        this.materialesPrestados = materialesPrestados != null ? materialesPrestados : new ArrayList<>();
    }

    public boolean puedeTomarPrestado() {
        return materialesPrestados.size() < LIMITE_PRESTAMOS;
    }


    public boolean agregarMaterialPrestado(Material material) {
        if (!puedeTomarPrestado()) {
            return false;
        }
        materialesPrestados.add(material);
        material.marcarComoPrestado();
        return true;
    }

    public boolean quitarMaterialPrestado(Material material) {
        boolean resultado = materialesPrestados.removeIf(m -> 
                m.getCodigoUnico().equals(material.getCodigoUnico()));
        if (resultado) {
            material.marcarComoDisponible();
        }
        return resultado;
    }


    public List<Material> getMaterialesPrestados() {
        return new ArrayList<>(materialesPrestados);
    }

    public String getCodigoEstudiante() {
        return codigoEstudiante;
    }


    public String getNombre() {
        return nombre;
    }


    public void mostrarPrestamosConsola() {
        if (materialesPrestados.isEmpty()) {
            System.out.println("El estudiante " + nombre + " (Código: " + codigoEstudiante + 
                    ") no tiene materiales prestados actualmente.");
            return;
        }
        
        System.out.println("Materiales prestados al estudiante " + nombre + " (Código: " + 
                codigoEstudiante + "):");
        System.out.println("------------------------------------------------------------");
        for (Material material : materialesPrestados) {
            System.out.println(material.mostrarInformacion());
        }
        System.out.println("Total de materiales prestados: " + materialesPrestados.size() + 
                " de " + LIMITE_PRESTAMOS + " permitidos.");
    }
    
    public boolean tienePrestadoMaterial(String codigoMaterial) {
        return materialesPrestados.stream()
                .anyMatch(m -> m.getCodigoUnico().equals(codigoMaterial));
    }
    
    public List<String> getCodigosMaterialesPrestados() {
        List<String> codigos = new ArrayList<>();
        for (Material material : materialesPrestados) {
            codigos.add(material.getCodigoUnico());
        }
        return codigos;
    }
}
