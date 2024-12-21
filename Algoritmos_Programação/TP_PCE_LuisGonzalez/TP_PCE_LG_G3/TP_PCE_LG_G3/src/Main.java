import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

/*
O INE pretende um programa informático para a elaboração das estatísticas e apresentação dos resultados do último ato
eleitoral. Para cada um dos distritos, existe a seguinte informação: o número de votantes inscritos, o número de votos
nulos, o número de votos em branco e o número de votos de cada um dos partidos concorrentes.
Com o intuito de satisfazer as necessidades do INE implemente as seguintes funcionalidades:

1.Leitura - efetua o preenchimento do nome dos distritos, eleitores inscritos, votos nulos, votos brancos e votação
em cada partido. É disponibilizado um ficheiro de texto com a informação da eleição no seguinte formato:
Distrito|inscritos|votantes|nulos|brancos|ad|ps|ch|il|be
2. Visualização - visualiza a informação no seguinte formato:

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
    static ArrayList<String> distrito = new ArrayList<>();
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
            System.out.println("1- Atualizar Base de datos do Sistema Eleitoral");
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

    private static void leituraFicheiro() {

    }

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