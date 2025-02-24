import Tacos.Frango;
import Tacos.Taco;
import Tacos.Vaca;
import Tacos.Vegetariano;

public class TacoFactory {
    public static Taco getTaco(String tipo) {
        switch (tipo) {
            case "Carne":
                return new Vaca("Carne");
            case "Frango":
                return new Frango("Frango");
            case "Vegetariano":
                return new Vegetariano("Vegetariano");
            default:
                throw new IllegalArgumentException("Taco de tipo inválido: " + tipo);

        }
    }
}
