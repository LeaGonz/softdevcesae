package Ex01;

import Ex01.Enums.CategoriaJet;
import Ex01.Enums.InstalacoesJet;

import java.util.ArrayList;

public class JatoParticular extends Aviao {
    private int lotacao;
    private double capacidadeBagagem;
    private CategoriaJet categoria;
    private ArrayList<InstalacoesJet> listaInstalacao;

    public JatoParticular(int numSerie, String modelo, int anoFabrico, double peso, double compFuselagem, double envAsas, double alturaCauda, int numMotores, double autonomia, double velMax, double preco, int lotacao, double capacidadeBagagem, CategoriaJet categoria) {
        super(numSerie, modelo, anoFabrico, peso, compFuselagem, envAsas, alturaCauda, numMotores, autonomia, velMax, preco);
        this.lotacao = lotacao;
        this.capacidadeBagagem = capacidadeBagagem;
        this.categoria = categoria;
        this.listaInstalacao = new ArrayList<>();
    }

    /**
     * Adicionar nova instalacao ao jato
     *
     * @param novaInstalacao
     */
    public void addInstalacaoJet(InstalacoesJet novaInstalacao) {
        this.listaInstalacao.add(novaInstalacao);
        System.out.println(novaInstalacao + " adicionado com sucesso ao " + super.modelo);
    }

    /**
     * Remover instalacões do jato, se existe
     *
     * @param novaInstalacao
     */
    public void removeInstalacaoJet(InstalacoesJet novaInstalacao) {
        if (this.listaInstalacao.contains(novaInstalacao)) {
            this.listaInstalacao.remove(novaInstalacao);
            System.out.println(novaInstalacao + " removido com sucesso do " + super.modelo);
        } else {
            System.out.println(super.modelo + " não tem " + novaInstalacao);
        }
    }

    /**
     * Lista todas as instalações dum Jato
     */
    public void listarInstalacaoJet() {
        System.out.println("_*_*_*_*_*_ Listagem de instalações do Jato " + super.modelo + " _*_*_*_*_*_");
        for (InstalacoesJet instalacao : this.listaInstalacao) {
            System.out.println("- " + instalacao);
        }
    }

    public void demonstracaoLuxo() {
        System.out.println("Este avião é luxo...");
    }

    @Override
    public void exibirDetalhes() {
        super.exibirDetalhes();
        System.out.println("Lotação: " + this.lotacao + " | Cap. Bagagem: " + this.capacidadeBagagem + " cm3 | Categoria: " + this.categoria);
        System.out.println("Instalações: " + this.listaInstalacao);
    }
}
