import Tacos.Taco;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Taco carne = TacoFactory.getTaco("Carne");
        Taco frango = TacoFactory.getTaco("Frango");
        Taco vegetarian = TacoFactory.getTaco("Vegetariano");

        carne.bake();
        frango.bake();
        vegetarian.bake();

        carne.prepare();
        frango.prepare();
        vegetarian.prepare();

        carne.box();
        frango.box();
        vegetarian.box();
    }
}