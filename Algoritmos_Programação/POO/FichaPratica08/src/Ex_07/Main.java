package Ex_07;

public class Main {
    public static void main(String[] args) {
        Livro livro1 = new Livro("Harry Potter","JK", Livro.Categorias.FANTASIA,250,111111111);
        Livro livro2 = new Livro("Diario de Ana Frank","Ana Frank", Livro.Categorias.POLITICA,250,2222222);

        livro1.exibirDetalhes();
        System.out.println();
        livro2.exibirDetalhes();
    }
}
