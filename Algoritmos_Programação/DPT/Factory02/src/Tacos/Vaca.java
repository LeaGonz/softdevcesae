package Tacos;

import java.sql.SQLOutput;

public class Vaca extends Taco {
    public Vaca(String tipo) {
        super(tipo);
    }

    @Override
    public void prepare() {
        System.out.println("A preparar taco de "+this.getTipo());
    }

    @Override
    public void bake() {
        System.out.println("A cozinhar taco de "+this.getTipo());
    }

    @Override
    public void box() {
        System.out.println("A embalar taco de "+this.getTipo());
    }
}
