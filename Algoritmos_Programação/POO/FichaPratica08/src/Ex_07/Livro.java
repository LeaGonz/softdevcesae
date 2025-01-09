package Ex_07;

public class Livro {
    // Atributos
    private String titulo;
    private String autor;
    private Categorias categoria;
    private int paginas;
    private int isbn;

    // Metodo construtor
    Livro(String titulo, String autor, Categorias categoria, int paginas, int isbn) {
        this.titulo = titulo;
        this.autor = autor;
        this.categoria = categoria;
        this.paginas = paginas;
        this.isbn = isbn;
    }

    public enum Categorias {
        DRAMA, TERROR, POLITICA, NOVELAS, FANTASIA
    }

    // Metodo de instâncias
    public void exibirDetalhes() {
        System.out.println("Detalhes do Livro");
        System.out.println("Titulo: " + this.titulo);
        System.out.println("Autor: " + this.autor);
        System.out.println("Categoria: " + this.categoria);
        System.out.println("Paginas: " + this.paginas);
        System.out.println("ISBN: " + this.isbn);
    }
}
