package Ex01;

public class Main {
    public static void main(String[] args) {
        Musica m1 = new Musica("Sexta feira",
                "Rap",
                "Bossa",
                180);
        Musica m2 = new Musica("APT",
                "Pop",
                "Bruno Mars",
                220);
        Musica m3 = new Musica("1APT",
                "Pop",
                "Bruno Mars",
                220);
        Musica m4 = new Musica("2APT",
                "Pop",
                "Bruno Mars",
                220);
        Musica m5 = new Musica("3APT",
                "Pop",
                "Bruno Mars",
                220);
        Musica m6 = new Musica("4APT",
                "Pop",
                "Bruno Mars",
                220);
        MusicPlayer l1 = new MusicPlayer();

        l1.adicionarMusica(m1);
        l1.adicionarMusica(m2);
        l1.adicionarMusica(m3);
        l1.adicionarMusica(m4);
        l1.adicionarMusica(m5);
        l1.adicionarMusica(m6);

        l1.imprimirRelatorio();
        System.out.println();

        l1.trocarMusica(0, 5);

        l1.imprimirRelatorio();
        System.out.println();

        l1.removerMusica(0);

        l1.imprimirRelatorio();
        System.out.println();

//        l1.removerTodas();
//        l1.imprimirRelatorio();
        System.out.println();

        l1.duracao();
    }
}
