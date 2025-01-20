package Ex02;

public class Main {
    public static void main(String[] args) {
        Pessoa p1 = new Pessoa("Luis", 15, 900901902, "l5@l.com");
        Pessoa p2 = new Pessoa("Jose", 18, 900901901, "l4@l.com");
        Pessoa p3 = new Pessoa("Pedro", 20, 900901903, "l3@l.com");
        Pessoa p4 = new Pessoa("Andrea", 28, 900901904, "l2@l.com");
        Pessoa p5 = new Pessoa("Joao", 45, 900901905, "l1@l.com");

        Sorteio jogo1 = new Sorteio();

        jogo1.adicionarParticipante(p1);
        jogo1.adicionarParticipante(p2);
        jogo1.adicionarParticipante(p3);
        jogo1.adicionarParticipante(p4);
        jogo1.adicionarParticipante(p5);
        System.out.println();
        jogo1.mostrarParticipantes();
        System.out.println();
        System.out.println("O ganhador do sorteio é: " + jogo1.sortear().getNome());
    }
}
