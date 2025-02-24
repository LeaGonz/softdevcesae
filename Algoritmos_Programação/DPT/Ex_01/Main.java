package Ex_01;

import Ex_01.Produtos.Produto;

public class Main {
    public static void main(String[] args) {
        Produto livro = ProdutoFactory.criarProduto("Livro","HP",25.5);
        Produto roupa = ProdutoFactory.criarProduto("Roupa","zara",25.5);
        Produto eletronico = ProdutoFactory.criarProduto("Eletronico","lenovo",150);

        livro.exibir();
        roupa.exibir();
        eletronico.exibir();

    }
}
