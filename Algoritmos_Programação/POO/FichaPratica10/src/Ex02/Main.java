package Ex02;

public class Main {
    public static void main(String[] args) {
        Pessoa p1 = new Pessoa("Luis", 15, 900901902,"l@l.com");
        Pessoa p2 = new Pessoa("Jose", 18, 900901902,"l@l.com");
        Pessoa p3 = new Pessoa("Pedro", 20, 900901902,"l@l.com");

        Sorteio jogo1 = new Sorteio();

        jogo1.adicionarParticipante(p1);
        jogo1.adicionarParticipante(p2);
        jogo1.adicionarParticipante(p3);
    }
}
