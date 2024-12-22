import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

/*
O INE pretende um programa informático para a elaboração das estatísticas e apresentação dos resultados do último ato
eleitoral. Para cada um dos distritos, existe a seguinte informação: o número de votantes inscritos, o número de votos
nulos, o número de votos em branco e o número de votos de cada um dos partidos concorrentes.
Com o intuito de satisfazer as necessidades do INE implemente as seguintes funcionalidades:

3. Total de Votantes por Distrito - acrescenta informação relativa ao total de votantes por distrito e retorna o distrito
com maior número de votos depositados nas urnas. Ter em atenção que pode ser mais do que um distrito.
4. Total de Votos em outros Partidos – acrescenta informação relativa ao total de votantes noutros partidos, em
cada distrito.
5. Partido com mais Votos - partido que obteve mais votos no total, indicando o nome desse partido, o número de
votos obtidos e a sua percentagem de votos total. Ter em atenção que pode ser mais do que um partido.
6. Distrito/Partido com mais Votos - para cada distrito, qual o partido que ganhou, indicando a sua percentagem.
7. Ordenação - ordena os distritos de forma descendente do número de votos no partido que ganhou as eleições
no país.
8. Atualização - atualiza a informação de um distrito, de acordo com os resultados de uma freguesia em que as
eleições tiveram de se realizar num dia posterior.
9. Email - imprime o endereço de correio eletrónico do distrito com mais votos inválidos (nulos e brancos). Ter em
atenção que pode ser mais do que um distrito. Considerar que o endereço do distrito é composto pela 1ª, 2ª,
penúltima e última letra do distrito + "@ine.pt".
10. Guardar Informacao - guarda no ficheiro de texto “distritos.txt” e em linhas diferentes a informação disponível
de cada um dos distritos no formato da alínea 1.
11. Validador:
a. Não é possível que o somatório dos votos de um distrito ser superior aos inscritos;
b. Sempre que haja uma alteração num valor das colunas inscritos, votantes, nulos, brancos, ad, ps, ch, il
ou be, a diferença tem de ser calculada nos outros.
c. Quando um ficheiro é carregado tem de ser verificado se os valores inseridos são ou não válidos (inscritos
não podem ser menos que total de votantes; votantes tem de ser igual a soma de nulos, brancos, ad, ps,
ch, il, be e outros).
 */
public class Main {
    static Scanner in = new Scanner(System.in);
    static Random rnd = new Random();
    // Colores
    static final String reset = "\033[0m";
    static final String vermelho = "\033[0;31m";
    static final String verde = "\033[0;32m";
    static final String amarelo = "\033[0;33m";
    // Variaveis principais
    static ArrayList<Integer> indices = new ArrayList<>();
    static ArrayList<String> distritos = new ArrayList<>();
    static ArrayList<Integer> inscritos = new ArrayList<>();
    static ArrayList<Integer> votantes = new ArrayList<>();
    static ArrayList<Integer> nulos = new ArrayList<>();
    static ArrayList<Integer> brancos = new ArrayList<>();
    static ArrayList<Integer> ad = new ArrayList<>();
    static ArrayList<Integer> ps = new ArrayList<>();
    static ArrayList<Integer> ch = new ArrayList<>();
    static ArrayList<Integer> il = new ArrayList<>();
    static ArrayList<Integer> be = new ArrayList<>();
    static ArrayList<Integer> outros = new ArrayList<>();
    static ArrayList<Integer> total = new ArrayList<>();

    public static void main(String[] args) {
        int op;
        do {
            System.out.println(verde + "\nINE | Instituto Nacional de Estatística " + reset);
            System.out.println("1- Atualizar Base de dados do Sistema Eleitoral");
            if (!distritos.isEmpty()) {
                System.out.println("2- Visualizar dados do Sistema Eleitoral");
            }
            System.out.println("0- Sair");
            op = validarOpcao();

            switch (op) {
                case 0:
                    System.out.println(vermelho + "INE | Até breve.");
                    break;
                case 1:
                    leituraFicheiro();
                    break;
                case 2:
                    visualizarDados();
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    break;
                default:
                    System.out.println(amarelo + "Opção invalida!" + reset);
            }
        } while (op != 0);
    }

    private static boolean visualizarDados() {
        System.out.println(verde + "\nDados do Sistema Eleitoral" + reset);
        // Listamos tabela de dados
        if (!distritos.isEmpty()) {
            System.out.printf(amarelo + "%-10s| %-10s| %-10s| %-6s| %-10s| %-8s| %-8s| %-8s| %-8s| %-8s| %-10s| %-10s%n" + reset,
                    "Distrito", "Inscritos", "Votantes", "Nulos", "Brancos", "AD", "PS", "CH", "IL", "BE", "Outros", "Total");
            System.out.println("-".repeat(125));
            for (int i = 0; i < distritos.size(); i++) {
                System.out.printf(verde + "%-10s" + reset + "| %-10d| %-10d| %-6d| %-10d| %-8d| %-8d| %-8d| %-8d| %-8d| %-10d| %-10d%n",
                        distritos.get(i), inscritos.get(i), votantes.get(i), nulos.get(i), brancos.get(i), ad.get(i), ps.get(i), ch.get(i)
                        , il.get(i), be.get(i), 0, 0);
            }
            return true;
        } else {
            System.out.println(amarelo + "Não existem ouvintes para mostrar! Pode inserir na opção 1 do menu." + reset);
            return false;
        }
    }

    private static void leituraFicheiro() {
        System.out.println(verde + "\nINE | Atualizar Base de dados do Sistema Eleitoral" + reset);

        try {
            Path dirBD = Path.of("distritos.txt");
            List<String> linhas = Files.readAllLines(dirBD);
            // Verificamos si o ficheiro tem informação
            if (!linhas.isEmpty()) {
                // Limpamos as listas para receber nova informação
                limparDados();
                // Ciclo para preencher cada variável
                for (String linha : linhas) {
                    String[] lines = linha.split(";");
                    distritos.add(lines[0]);
                    inscritos.add(Integer.parseInt(lines[1]));
                    votantes.add(Integer.parseInt(lines[2]));
                    nulos.add(Integer.parseInt(lines[3]));
                    brancos.add(Integer.parseInt(lines[4]));
                    ad.add(Integer.parseInt(lines[5]));
                    ps.add(Integer.parseInt(lines[6]));
                    ch.add(Integer.parseInt(lines[7]));
                    il.add(Integer.parseInt(lines[8]));
                    be.add(Integer.parseInt(lines[9]));
                }
                System.out.println(verde + "Ficheiro lido com sucesso. Base de dados atualizada!" + reset);
            } else {
                System.out.println(amarelo + "Não existem dados no ficheiro." + reset);
            }
        } catch (IOException e) {
            System.out.println(vermelho + "Não existe o ficheiro: " + e.getMessage() + reset);
        }
    }

    private static void limparDados() {
        indices.clear();
        distritos.clear();
        inscritos.clear();
        votantes.clear();
        nulos.clear();
        brancos.clear();
        ad.clear();
        ps.clear();
        ch.clear();
        il.clear();
        be.clear();
        outros.clear();
        total.clear();
    } // validado

    private static int validarOpcao() {
        boolean validar = true;
        int op = 0;
        do {
            try {
                System.out.print("Opção: ");
                op = in.nextInt();
                in = new Scanner(System.in);
                validar = false;
            } catch (InputMismatchException e) {
                System.out.println(amarelo + "Opção invalida! Por favor, deve inserir um número do menu!\n" + reset);
                in = new Scanner(System.in);
            }
        } while (validar);
        return op;
    } // validado
}