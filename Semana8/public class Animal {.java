public class Animal {
    private String especie;

    public Animal(String especie) {
        this.especie = especie;
    }

    @Override
    public String toString() {
        return "Animal[especie=\"" + especie + "\"]";
    }

    public String getEspecie() {
        return especie;
    }
}