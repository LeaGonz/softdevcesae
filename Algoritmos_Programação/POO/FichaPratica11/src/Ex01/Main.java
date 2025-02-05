package Ex01;

import Ex01.Enums.Armas;
import Ex01.Enums.CategoriaJet;
import Ex01.Enums.InstalacoesJet;

public class Main {
    public static void main(String[] args) {
        JatoParticular cessna = new JatoParticular(12345, "Ibiza", 2005, 1500, 12, 6, 1.5, 2, 2200, 675, 10000, 8, 500, CategoriaJet.LIGHT_JET);
        cessna.addInstalacaoJet(InstalacoesJet.WC);
        cessna.addInstalacaoJet(InstalacoesJet.WIFI);
        cessna.addInstalacaoJet(InstalacoesJet.TOMADAS);

        cessna.removeInstalacaoJet(InstalacoesJet.COZINHA);

        JatoParticular gulfstream = new JatoParticular(11223, "Leon", 2012, 1450, 13.5, 6.9, 1.8, 2, 2900, 780, 15000, 10, 1000, CategoriaJet.MIDSIZE_JET);
        gulfstream.addInstalacaoJet(InstalacoesJet.WC);
        gulfstream.addInstalacaoJet(InstalacoesJet.SUITE);
        gulfstream.addInstalacaoJet(InstalacoesJet.WIFI);
        gulfstream.addInstalacaoJet(InstalacoesJet.CINEMA);
        gulfstream.addInstalacaoJet(InstalacoesJet.COZINHA);

        gulfstream.removeInstalacaoJet(InstalacoesJet.COZINHA);

        gulfstream.listarInstalacaoJet();
        System.out.println();

        JatoParticular boeing = new JatoParticular(99887, "747", 2020, 8800, 30, 12.5, 2.3, 4, 5200, 980, 50000, 90, 6000, CategoriaJet.HEAVY_JET);
        boeing.addInstalacaoJet(InstalacoesJet.WC);
        boeing.addInstalacaoJet(InstalacoesJet.WC);
        boeing.addInstalacaoJet(InstalacoesJet.WIFI);
        boeing.addInstalacaoJet(InstalacoesJet.TOMADAS);

        AviaoCombate f16 = new AviaoCombate(101, "F16", 2015, 900, 6.5, 4, 1, 1, 1650, 1200, 20000, "USA", false);
        f16.addArsenal(Armas.BOMBAS);
        f16.addArsenal(Armas.FOGUETES);

        f16.listarArsenal();
        System.out.println();

        AviaoCombate ac147 = new AviaoCombate(200, "C147", 1999, 6500, 25, 8.5, 2, 4, 8000, 900, 19500, "China", true);
        ac147.addArsenal(Armas.BOMBAS);
        ac147.addArsenal(Armas.FOGUETES);
        ac147.addArsenal(Armas.MISSEIS);
        ac147.addArsenal(Armas.METRALHADORAS);
        ac147.addArsenal(Armas.TORPEDOS);

        Catalogo catalogo = new Catalogo();
        catalogo.adquirirAviao(f16);
        catalogo.adquirirAviao(boeing);
        catalogo.venderAviao(ac147);

        System.out.println();
        ac147.exibirDetalhes();

        System.out.println("Valor total do catálogo: " + catalogo.calcularTotal() + " €");
    }
}
