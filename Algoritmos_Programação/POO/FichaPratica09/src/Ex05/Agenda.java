package Ex05;

public class Agenda {
    private Pessoa[] listaPessoas = new Pessoa[100];

    public Agenda(Pessoa pessoa) {
        for (int i = 0; i < this.listaPessoas.length; i++) {
            if (this.listaPessoas[i] == null) {
            this.listaPessoas[i] = pessoa;
            return;
            }
        }
    }

    // Metodos instancias
    public void exibirAgenda() {
        System.out.println("***** AGENDA *****");
        for (int i = 0; i < this.listaPessoas.length
                && this.listaPessoas[i] != null; i++) {
            this.listaPessoas[i].exibirPessoa();
            System.out.println("----------------");
        }
    }
}
