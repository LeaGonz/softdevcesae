package Ex01;

import Ex01.Enums.Armas;

import java.util.ArrayList;

public class AviaoCombate extends Aviao {
    private String paisOrigem;
    private boolean camuflagem;
    private ArrayList<Armas> listaArsenal;

    public AviaoCombate(int numSerie, String modelo, int anoFabrico, double peso, double compFuselagem, double envAsas, double alturaCauda, int numMotores, double autonomia, double velMax, double preco, String paisOrigem, boolean camuflagem) {
        super(numSerie, modelo, anoFabrico, peso, compFuselagem, envAsas, alturaCauda, numMotores, autonomia, velMax, preco);
        this.paisOrigem = paisOrigem;
        this.camuflagem = camuflagem;
        this.listaArsenal = new ArrayList<>();
        System.out.println("helo");
    }

    /**
     * Adiciona nova arma ao aviao, maximo 3
     *
     * @param novaArma
     */
    public void addArsenal(Armas novaArma) {
        if (this.listaArsenal.size() < 3) {
            this.listaArsenal.add(novaArma);
            System.out.println(novaArma + " adicionada com sucesso ao " + super.modelo);
        } else {
            System.out.println(super.modelo + " já tem o arsenal completo. Não foi possível adicionar " + novaArma);
        }
    }

    public void vooRaso() {
        System.out.println(this.modelo + " fez um voo raso... VUUUUMMMMMMMMMM");
    }

    /**
     * Remover arsenal do avião de combate, se existe
     *
     * @param novaArma
     */
    public void removeArsenal(Armas novaArma) {
        if (this.listaArsenal.contains(novaArma)) {
            this.listaArsenal.remove(novaArma);
            System.out.println(novaArma + " removida com sucesso do " + super.modelo);
        } else {
            System.out.println(super.modelo + " não tem " + novaArma);
        }
    }

    /**
     * Listar o arsenal do avião de combate
     */
    public void listarArsenal() {
        System.out.println("_*_*_*_*_*_ Listagem do arsenal do Avião " + super.modelo + " _*_*_*_*_*_");
        for (Armas arma : this.listaArsenal) {
            System.out.println("- " + arma);
        }
    }

//    @Override
    public void exibirDetalhes() {
//        super.exibirDetalhes();
        System.out.println("País Origem: " + this.paisOrigem + " | Camuflagem: " + this.camuflagem);
        System.out.println("Arsenal: " + this.listaArsenal);
    }
}
