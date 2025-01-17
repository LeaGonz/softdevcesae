package Ex01;

public class Musica {
    private String titulo;
    private String genero;
    private String artista;
    private int duracao;

    //construtor
    public Musica(String titulo, String genero, String artista, int duracao) {
        this.titulo = titulo;
        this.genero = genero;
        this.artista = artista;
        this.duracao = duracao;
    }

    public void exibirMusica() {
        System.out.println("Titulo - " + this.titulo +
                " Genero - " + this.genero +
                " Artista - " + this.artista +
                " Duracao - " + this.duracao);
    }

    public int getDuracao() {
        return this.duracao;
    }
}
