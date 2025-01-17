package Ex03;

public class Main {
    public static void main(String[] args) {
        Animal perro = new Animal("Bobby","cao","Venezuela",
                5.23,new String[]{"Frango","Carne","Purina"});

        perro.comer("Carne",1000);
        perro.exibirDetalhes();
        perro.comer("Carne",200);
        perro.exibirDetalhes();
    }
}
