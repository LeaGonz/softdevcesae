package Ex02;

import Ex02.Enums.TipoCombustivel;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class Mota extends Veiculo {
    //construtor
    public Mota(String marca, String modelo, int anoFabricacao, int potencia, int cc, TipoCombustivel combustivel, double litros100km) {
        super(marca, modelo, anoFabricacao, potencia, cc, combustivel, litros100km);
    }

    /**
     * Metodo para mostrar conteúdo do txt
     */
    public void imprimirMota() {
        try {
            System.out.println("_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_* " + this.getModelo() + " _*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*");
            Path txt = Path.of("src/Ex02/Mota.txt");
            List<String> lines = Files.readAllLines(txt);
            for (String linha : lines) {
                System.out.println(linha);
            }
            System.out.println("\n_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_* " + this.getModelo() + " _*_*_*_*_*_*_*_*_*_*_*_*_" +
                    "*_*_*_*");
        } catch (IOException e) {
            System.out.println("Não existe o ficheiro: " + e.getMessage());
        }
    }
}
