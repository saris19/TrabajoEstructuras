public class Cat extends Mammal {
    public Cat(String especie) {
        super(especie);
    }

    public void saludar() {
        System.out.println("Miau");
    }

    @Override
    public String toString() {
        return "Gato[" + super.toString() + "]";
    }
}