import org.json.simple.JSONObject;

public abstract class MaterialBase {
    protected String titulo;
    protected String codigo;
    protected int añoPublicacion;
    protected boolean disponible;

    public MaterialBase(JSONObject json) {
        this.titulo = (String) json.get("titulo");
        this.codigo = (String) json.get("codigo");
        this.añoPublicacion = ((Long) json.get("añoPublicacion")).intValue();
        this.disponible = (Boolean) json.get("disponible");
    }

    public JSONObject toJSON() {
        JSONObject json = new JSONObject();
        json.put("titulo", titulo);
        json.put("codigo", codigo);
        json.put("añoPublicacion", añoPublicacion);
        json.put("disponible", disponible);
        return json;
    }

    // ... métodos existentes ...
}