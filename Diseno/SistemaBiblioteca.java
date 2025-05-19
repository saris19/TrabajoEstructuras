import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SistemaBiblioteca {
    private static final String MATERIALES_FILE = "data/materiales.json";
    private static final String ESTUDIANTES_FILE = "data/estudiantes.json";
    private JSONObject materialesData;
    private JSONObject estudiantesData;

    public SistemaBiblioteca() {
        cargarDatos();
    }

    private void cargarDatos() {
        JSONParser parser = new JSONParser();
        try {
            materialesData = (JSONObject) parser.parse(new FileReader(MATERIALES_FILE));
            estudiantesData = (JSONObject) parser.parse(new FileReader(ESTUDIANTES_FILE));
        } catch (Exception e) {
            materialesData = new JSONObject();
            estudiantesData = new JSONObject();
            inicializarArchivos();
        }
    }

    private void guardarDatos() {
        try (FileWriter file = new FileWriter(MATERIALES_FILE)) {
            file.write(materialesData.toJSONString());
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (FileWriter file = new FileWriter(ESTUDIANTES_FILE)) {
            file.write(estudiantesData.toJSONString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void registrarMaterial(MaterialBase material) {
        JSONArray lista;
        if (material instanceof Libro) {
            lista = (JSONArray) materialesData.get("libros");
            lista.add(((Libro) material).toJSON());
        } else if (material instanceof Revista) {
            lista = (JSONArray) materialesData.get("revistas");
            lista.add(((Revista) material).toJSON());
        } else if (material instanceof TrabajoDeGrado) {
            lista = (JSONArray) materialesData.get("trabajosGrado");
            lista.add(((TrabajoDeGrado) material).toJSON());
        }
        guardarDatos();
    }

    public void registrarEstudiante(Estudiante estudiante) {
        JSONArray estudiantes = (JSONArray) estudiantesData.get("estudiantes");
        estudiantes.add(estudiante.toJSON());
        guardarDatos();
    }

    // ... otros métodos ...
}