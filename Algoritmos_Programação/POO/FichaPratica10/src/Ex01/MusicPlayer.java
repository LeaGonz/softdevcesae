package Ex01;

import java.util.ArrayList;

public class MusicPlayer {
    private ArrayList<Musica> listaMusicas;

    // construtor
    public MusicPlayer() {
        this.listaMusicas = new ArrayList<>();

    }

    /**
     * Método para adicionar músicas ao ArrayList
     * @param musica
     */
    public void adicionarMusica(Musica musica) {
        this.listaMusicas.add(musica);
    }

    /**
     * Método para trocar músicas ao ArrayList
     * @param from
     * @param to
     */
    public void trocarMusica(int from, int to) {
        Musica mfrom = this.listaMusicas.get(from);
        this.listaMusicas.set(from, this.listaMusicas.get(to));
        this.listaMusicas.set(to, mfrom);
    }

    /**
     * Método para remover músicas ao ArrayList
     * @param idMusica
     */
    public void removerMusica(int idMusica) {
        this.listaMusicas.remove(idMusica);
    }

    /**
     * Método para remover todas as músicas ao ArrayList
     */
    public void removerTodas(){
        this.listaMusicas.clear();
    }

    /**
     * Método para calcular a duração total da playlist em
     * formato hh:mm:ss
     */
    public void duracao(){
        int totalseg = 0;
        for (Musica musica : this.listaMusicas) {
            totalseg += musica.getDuracao();
        }
        int hora = totalseg / 3600;
        int minutos = (totalseg / 60) - (hora * 60);
        int segundos = totalseg - (minutos * 60);

        System.out.println("Duração total da Playlist: " + hora + ":" + minutos + ":" + segundos);
    }

    /**
     * Metodo para mostrar a listagem de musicas
     */
    public void imprimirRelatorio() {
        int contador = 1;
        for (Musica musica : this.listaMusicas) {
            System.out.print("Musica " + contador++ + ": ");
            musica.exibirMusica();
        }
    }
}
