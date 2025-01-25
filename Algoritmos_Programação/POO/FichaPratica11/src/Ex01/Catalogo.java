package Ex01;

import java.util.ArrayList;

public class Catalogo {
    private ArrayList<Aviao> listaAvioes;

    public Catalogo() {
        this.listaAvioes = new ArrayList<>();
    }

    /**
     * Adiciona novo avião ao catálogo
     *
     * @param novoAviao
     */
    public void adquirirAviao(Aviao novoAviao) {
        this.listaAvioes.add(novoAviao);
    }

    /**
     * Apaga um avião do catálogo, se existir
     *
     * @param novoAviao
     */
    public void venderAviao(Aviao novoAviao) {
        if (this.listaAvioes.contains(novoAviao)) {
            this.listaAvioes.remove(novoAviao);
        } else {
            System.out.println("O avião não está no catálogo");
        }
    }

    /**
     * Metodo mostra os detalhes dos aviões do catãlogo
     */
    public void exibirDetalhes() {
        for (Aviao aviao : this.listaAvioes) {
            aviao.exibirDetalhes();
            System.out.println();

            // Modo abreviado
            if (aviao instanceof JatoParticular jato) {
                jato.demonstracaoLuxo();
                // Modo da clase
            } else if (aviao instanceof AviaoCombate) {
                AviaoCombate combate = (AviaoCombate) aviao;
                combate.vooRaso();
            }

        }
    }

    /**
     * Listar os aviões do catálogo
     */
    public void listarCatalogo() {
        System.out.println("_*_*_*_*_*_ Listado de Aviões a venda _*_*_*_*_*_");
        for (Aviao aviao : this.listaAvioes) {
            System.out.println("- " + aviao.getModelo() + " | Preço: " + aviao.getPreco());
        }
    }

    /**
     * Calcula o total em € dos aviões do catálogo
     * @return
     */
    public double calcularTotal() {
        double total = 0;
        for (Aviao aviao : this.listaAvioes) {
            total += aviao.getPreco();
        }
        return total;
    }
}
