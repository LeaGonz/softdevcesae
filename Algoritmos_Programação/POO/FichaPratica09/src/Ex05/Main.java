package Ex05;

public class Main {
    public static void main(String[] args) {
        Pessoa p1 = new Pessoa("Luis",
                33,
                "luis@luis.com",
                939939939);

        p1.exibirPessoa();
        Agenda a1 = new Agenda(p1);

        a1.exibirAgenda();
    }
}
