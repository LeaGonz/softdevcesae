import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

/*
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
    static ArrayList<String> distritos = new ArrayList<>();
    static ArrayList<String> partidos = new ArrayList<>();
    static ArrayList<Integer> indices = new ArrayList<>();
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
                System.out.println("3- Distrito(s) com maior número de votos");
                System.out.println("4- Partido(s) com maior número de votos");
                System.out.println("5- Partido por distrito com maior número de votos");
                System.out.println("6- Atualização de votos por distrito");
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
                    distritosMaisVotos();
                    break;
                case 4:
                    partidoMaisVotos();
                    break;
                case 5:
                    distritosPartidosMaisVotos();
                    break;
                case 6:
                    atualizarVotos();
                    break;
                default:
                    System.out.println(amarelo + "Opção invalida!" + reset);
            }
        } while (op != 0);
    }

    private static void atualizarVotos() {
        // Ciclo do menu
        int op;
        do {
            System.out.println(verde + "\nAtualização de votos" + reset);
            System.out.println("1- Editar informação dum distrito");
            System.out.println("0- Voltar ao menu principal");
            op = validarOpcao();

            switch (op) {
                case 0:
                    break;
                case 1:
                    selecionarDistrito();
                    break;
                default:
                    System.out.println(amarelo + "Opção invalida!" + reset);
            }
        } while (op != 0);

    }

    private static void selecionarDistrito() {
        // Ciclo para novos valores
        while (true) {
            System.out.println();
            System.out.println("-".repeat(15));
            System.out.printf(amarelo + "%-3s| %-12s%n" + reset, "ID", "Distritos");
            System.out.println("-".repeat(15));
            // Mostro o listado dos distritos
            for (int i = 0; i < distritos.size(); i++) {
                System.out.printf(verde + "%-3d|" + reset + " %-12s%n", i + 1, distritos.get(i));
            }
            // Solicito o id do distrito
            System.out.println("\nInsira o ID do distrito a editar. (zero(0) para voltar ao menu anterior) ");
            int id = validarOpcao();
            // Validamos se ID é valido
            if (id > 0 && id <= distritos.size()) {
                atualizarDadosDistrito((id - 1));
                break;
            } else if (id == 0) {
                break;
            } else {
                System.out.println(amarelo + "Não existe distrito com o ID indicado. Insira um do listado:" + reset);
            }
        }
    }

    private static void atualizarDadosDistrito(int id) {
        // Variaveis temporais
        ArrayList<Integer> votantesTemp = new ArrayList<>(votantes);
        ArrayList<Integer> nulosTemp = new ArrayList<>(nulos);
        ArrayList<Integer> brancosTemp = new ArrayList<>(brancos);
        ArrayList<Integer> adTemp = new ArrayList<>(ad);
        ArrayList<Integer> psTemp = new ArrayList<>(ps);
        ArrayList<Integer> chTemp = new ArrayList<>(ch);
        ArrayList<Integer> ilTemp = new ArrayList<>(il);
        ArrayList<Integer> beTemp = new ArrayList<>(be);
        ArrayList<Integer> outrosTemp = new ArrayList<>(outros);

        System.out.println(verde + "\nAtualizar dados do distrito: " + amarelo + distritos.get(id) + reset);
        // Ciclo do menu
        int valor;
        System.out.println("Selecione os votos a atualizar | " + amarelo + "Instruções:" + reset + " o novo valor será " +
                "somado ao valor atual, portanto, só deve inserir os novos votos da freguesia faltante. " +
                "Inserir zero(0) no caso de não haver novos votos.\n");

        // Ciclo para solicitar cada valor
        List<ArrayList<Integer>> votos = List.of(nulosTemp, brancosTemp, adTemp, psTemp, chTemp, ilTemp, beTemp, outrosTemp);
        String[] nomes = {"nulos", "brancos", "AD", "PS", "CH", "IL", "BE", "outros"};

        for (int i = 0; i < votos.size(); i++) {
            System.out.println("Votos " + nomes[i] + " atuais: " + amarelo + votos.get(i).get(id) + reset);
            // Verificamos que seja um valor numérico
            valor = validarValor();

            // Validamos se novo (valor + votos atuais) + votantes, não é maior a inscritos
            int somaValor = (valor + votos.get(i).get(id));
            int validarInscritos = somaValor + votantes.get(id);
            if (validarInscritos <= inscritos.get(id)) {
                System.out.println("Novos votos " + nomes[i] + ": " + somaValor + "\n");
            }
        }

    }

    private static int validarValor() {
        boolean validar = true;
        int valor = 0;
        do {
            try {
                System.out.print("Nova quantidade de votos: ");
                valor = in.nextInt();
                in = new Scanner(System.in);
                if (valor > 0) validar = false;
                else System.out.println(amarelo + "O valor não pode ser negativo.\n" + reset);
            } catch (InputMismatchException e) {
                System.out.println(amarelo + "O valor deve ser numérico!\n" + reset);
                in = new Scanner(System.in);
            }
        } while (validar);
        return valor;
    } // validado


    private static void distritosPartidosMaisVotos() {
        listaPartidos();

        System.out.println(verde + "\nPartido por distrito com maior número de votos" + reset);

        // Comparamos cada partido por distrito
        List<ArrayList<Integer>> listas = List.of(ad, ps, ch, il, be, outros);
        ArrayList<Integer> indicesTemp = new ArrayList<>();
        // Percorremos cada distrito (i)
        for (int i = 0; i < distritos.size(); i++) {
            int maior = 0;
            double soma = 0;
            // Percorremos cada partido(j) do mesmo distrito (i) e somamos os votos validos (sem nulos nem brancos)
            // Guardamos o(s) índice(s) do(s) ganhador(es)
            for (int j = 0; j < listas.size(); j++) {
                soma += listas.get(j).get(i);
                // Verificamos qual é o maior e se há empates
                if (listas.get(j).get(i) > maior) {
                    maior = listas.get(j).get(i);
                    indicesTemp.clear();
                    indicesTemp.add(j);
                } else if (listas.get(j).get(i) == maior) {
                    indicesTemp.add(j);
                }
            }
            for (Integer index : indicesTemp) {
                System.out.printf(amarelo + "- %s" + reset + ": ganhou %s com %d votos e uma percentagem de %.2f%%%n",
                        distritos.get(i), partidos.get(index), maior, ((maior / soma) * 100));
            }
        }
    } // validado

    private static void partidoMaisVotos() {
        ArrayList<Integer> index = new ArrayList<>();
        // Lista dos partidos
        listaPartidos();

        // Lista com todos os partidos
        List<ArrayList<Integer>> partido = List.of(ad, ps, ch, il, be, outros);
        // Arraylist para guardar soma dos votos por partido
        ArrayList<Integer> votos = new ArrayList<>();
        // Ciclo para calcular soma total por partido
        for (ArrayList<Integer> partidos : partido) {
            int soma = 0;
            for (Integer votoPartido : partidos) {
                soma += votoPartido;
            }
            votos.add(soma);
        }
        // Ordenamos e Obtemos o partido com maior números de votos
        int maior = Collections.max(votos);
        // Soma do total de votos validos, VVE — votos validamente expressos (total - (nulos + brancos))
        double somaT = somaVVE();
        // Mostramos o(s) partido(s) com mais votos
        System.out.println(verde + "\nPartido(s) com maior número de votos | Total de votos validamente expressos: " + reset + somaT);
        for (int i = 0; i < partidos.size(); i++) {
            if (votos.get(i) == maior) {
                System.out.printf(amarelo + "- %s" + reset + " com %d votos e uma percentagem de %.2f%%%n",
                        partidos.get(i), votos.get(i), ((maior / somaT) * 100));
                // Ordenamos os indices em ordem do partido que ganhou
                ordenDecrescente(partido.get(partidos.indexOf(partidos.get(i))));
                // Mostramos em ordem descendente
                mostrarTabela(index);
            }
        }
    }

    private static void distritosMaisVotos() {
        ordenDecrescente(total);
        ArrayList<Integer> index = new ArrayList<>();
        // Mostramos os distritos com mais votos
        System.out.println(verde + "\nDistrito(s) com maior número de votos" + reset);
        for (int i = 0; i < total.size(); i++) {
            if (total.get(i).equals(total.get(indices.getFirst()))) {
                System.out.println(amarelo + "- " + distritos.get(i) + reset + " com " + total.get(i) + " votos.");
                index.add(i);
            }
        }
        // Mostramos em ordem descendente
        mostrarTabela(index);
    }

    private static void ordenDecrescente(ArrayList<Integer> arraylist) {
        // Metodo recebe os índices para ordenar de maneira decrescente.
        // Uso um ArrayList temporal, para só ordenar os indices e mostrar, assim não modifico os indices
        // dos ArrayList principais.

        // Limpamos e preenchemos indices antes de ordenar
        indices.clear();
        for (int i = 0; i < arraylist.size(); i++) {
            indices.add((i));
        }

        // Ciclo ordem decrescente
        ArrayList<Integer> temp = new ArrayList<>(arraylist);
        for (int i = 0; i < temp.size(); i++) {
            for (int j = i + 1; j < temp.size(); j++) {
                if (temp.get(i) < temp.get(j) || temp.get(i).equals(temp.get(j))) {
                    // Ordenamos temp
                    int tempOrder = temp.get(i);
                    temp.set(i, temp.get(j));
                    temp.set(j, tempOrder);

                    // Ordenamos indices com base ao temp
                    int tempIndex = indices.get(i);
                    indices.set(i, indices.get(j));
                    indices.set(j, tempIndex);
                }
            }
        }
    }

    private static void visualizarDados() {
        ArrayList<Integer> index = new ArrayList<>();
        System.out.println(verde + "\nDados do Sistema Eleitoral" + reset);
        // Listamos tabela de dados
        Collections.sort(indices);
        mostrarTabela(index);
    }

    private static void leituraFicheiro() {
        System.out.println(verde + "\nINE | Atualizar Base de dados do Sistema Eleitoral" + reset);

        try {
            Path dirBD = Path.of("distritos.txt");
            List<String> linhas = Files.readAllLines(dirBD);
            // Verificamos se o ficheiro tem informação
            if (!linhas.isEmpty()) {
                // Limpamos as listas para receber nova informação
                limparDados();
                // Lista dos arraylist
                List<ArrayList<Integer>> listas = List.of(inscritos, votantes, nulos, brancos, ad, ps, ch, il, be);
                // Ciclo para preencher cada variável
                for (String linha : linhas) {
                    String[] lines = linha.split(";");
                    distritos.add(lines[0]);
                    // Preenchemos cada arraylist
                    for (int i = 0; i < listas.size(); i++) {
                        listas.get(i).add(Integer.parseInt(lines[i + 1]));
                    }
                }
                // Atualizo votos outros partidos, total de votos e os indices
                for (int i = 0; i < distritos.size(); i++) {
                    outros.add(outrosValor(i));
                    total.add(totalSoma(i));
                    indices.add((i));
                }

                System.out.println(verde + "Ficheiro lido com sucesso." + reset + " Base de dados atualizada!");
            } else {
                System.out.println(amarelo + "Não existem dados no ficheiro." + reset);
            }
        } catch (IOException e) {
            System.out.println(vermelho + "Não existe o ficheiro: " + e.getMessage() + reset);
        }
    }

    private static void mostrarTabela(ArrayList<Integer> index) {
        if (!distritos.isEmpty()) {
            System.out.println("-".repeat(130));
            System.out.printf(amarelo + "%-10s| %-10s| %-10s| %-6s| %-10s| %-8s| %-8s| %-8s| %-8s| %-8s| %-10s| %-10s%n" + reset,
                    "Distrito", "Inscritos", "Votantes", "Nulos", "Brancos", "AD", "PS", "CH", "IL", "BE", "Outros", "Total (VVE)");
            System.out.println("-".repeat(130));
            for (int i : indices) {
                if (index.contains(i)) {
                    System.out.printf(verde + "%-10s| %-10d| %-10d| %-6d| %-10d| %-8d| %-8d| %-8d| %-8d| %-8d| %-10d| %-10d%n" + reset,
                            distritos.get(i), inscritos.get(i), votantes.get(i), nulos.get(i), brancos.get(i), ad.get(i), ps.get(i), ch.get(i)
                            , il.get(i), be.get(i), outros.get(i), total.get(i));
                } else {
                    System.out.printf(verde + "%-10s" + reset + "| %-10d| %-10d| %-6d| %-10d| %-8d| %-8d| %-8d| %-8d| %-8d| %-10d| %-10d%n",
                            distritos.get(i), inscritos.get(i), votantes.get(i), nulos.get(i), brancos.get(i), ad.get(i), ps.get(i), ch.get(i)
                            , il.get(i), be.get(i), outros.get(i), total.get(i));
                }
            }
        } else {
            System.out.println(amarelo + "Não existem ouvintes para mostrar! Pode inserir na opção 1 do menu." + reset);
        }
    } // Validado

    private static double somaVVE() {
        double soma = 0;
        for (Integer n : total) {
            soma += n;
        }
        for (Integer n : nulos) {
            soma -= n;
        }
        for (Integer n : brancos) {
            soma -= n;
        }
        return soma;
    } // validado

    private static int totalSoma(int i) {
        List<ArrayList<Integer>> listas = List.of(nulos, brancos, ad, ps, ch, il, be, outros);
        int somaTotal = 0;
        for (ArrayList<Integer> list : listas) {
            somaTotal += list.get(i);
        }
        return somaTotal;
    }

    private static int outrosValor(int i) {
        List<ArrayList<Integer>> listas = List.of(nulos, brancos, ad, ps, ch, il, be);
        int somaOutros = 0;
        for (ArrayList<Integer> list : listas) {
            somaOutros += list.get(i);
        }
        return votantes.get(i) - somaOutros;
    }

    private static void listaPartidos() {
        partidos.clear();
        partidos.add("AD");
        partidos.add("PS");
        partidos.add("CH");
        partidos.add("IL");
        partidos.add("BE");
        partidos.add("Outros");
    } // validado

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