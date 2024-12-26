import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

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
                System.out.println("7- Correio eletrónico do distrito com mais votos inválidos");
                System.out.println("8- Guardar dados no ficheiro");
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
                case 7:
                    correioEletronico();
                    break;
                case 8:
                    guardarFicheiro();
                    break;
                default:
                    System.out.println(amarelo + "Opção invalida!" + reset);
            }
        } while (op != 0);
    }

    private static void guardarFicheiro() {
        System.out.println(verde + "\nGuardar dados do Sistema Eleitoral no ficheiro" + reset);

        // Path do ficheiro distrito.txt
        Path dir = Path.of("distritos.txt");

        // Ciclo para ler linhas e criar string com o formato solicitado
        try {
            String lines = "";
            for (int i = 0; i < distritos.size(); i++) {
                // Criamos cada linha no formato solicitado
                lines += (distritos.get(i) + ";" +
                        inscritos.get(i) + ";" +
                        votantes.get(i) + ";" +
                        nulos.get(i) + ";" +
                        brancos.get(i) + ";" +
                        ad.get(i) + ";" +
                        ps.get(i) + ";" +
                        ch.get(i) + ";" +
                        il.get(i) + ";" +
                        be.get(i) + "\n");
            }
            // Escrevemos no ficheiro
            Files.writeString(dir, lines);
            System.out.println(amarelo + "Ficheiro criado com sucesso!" + reset);
        } catch (IOException e) {
            System.out.println(vermelho + e.getMessage() + reset);
        }
    }

    private static void correioEletronico() {
        // Somamos os nulos/brancos por distrito, logo chamamos o metodo para criar
        // e-mail no formato solicitado. Se o nome do distrito só tem 4 letras ou menos
        // o e-mail vai ser igual ao nome do distrito

        System.out.println(verde + "\nCorreio eletrónico do distrito com mais votos inválidos" + reset);

        // Somamos os nulos e brancos de cada distrito e armazenamos num arraylist temp
        ArrayList<Integer> invalidos = new ArrayList<>();
        for (int i = 0; i < distritos.size(); i++) {
            invalidos.add(nulos.get(i) + brancos.get(i));
        }
        // Obtemos o maior
        int maior = Collections.max(invalidos);

        // Geramos o(s) email(s) do(s) maior(es)
        for (int i = 0; i < distritos.size(); i++) {
            if (invalidos.get(i) == maior) {
                String distrito = distritos.get(i).trim().toLowerCase();
                String email = gerarEmail(distrito);
                System.out.println(distritos.get(i) + ": " + amarelo + email + reset);
            }
        }
    }

    private static String gerarEmail(String distrito) {
        // Metodo para criar o e-mail. Se o nome do distrito só tem 4 letras ou menos
        // O e-mail vai ser igual ao nome do distrito
        String email = "";
        if (distrito.length() > 4) {
            email = distrito.substring(0, 2);
            email += distrito.substring(distrito.length() - 2);
        } else {
            email = distrito;
        }
        email += "@ine.pt";
        return email;
    }

    private static void atualizarVotos() {
        // Ciclo do menu principal
        int op;
        do {
            System.out.println(verde + "\nAtualização de votos" + reset);
            System.out.println("1- Editar informação dum distrito");
            System.out.println("0- Voltar ao menu principal");
            op = validarOpcao();

            switch (op) {
                case 0:
                    System.out.println(amarelo + "Voltando ao menu anterior..." + reset);
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
        // Ciclo menu dos distritos, mostramos a listagem dos distritos e selecionamos por ID
        while (true) {
            System.out.println();
            System.out.println("-".repeat(15));
            System.out.printf(amarelo + "%-3s| %-12s%n" + reset, "ID", "Distritos");
            System.out.println("-".repeat(15));
            // Mostro o listado dos distritos e ID
            for (int i = 0; i < distritos.size(); i++) {
                System.out.printf(verde + "%-3d|" + reset + " %-12s%n", i + 1, distritos.get(i));
            }

            // Solicito o ID do distrito, se utilizador escrever 0, voltamos ao menu anterior
            System.out.println("\nInsira o ID do distrito a editar. (zero(0) para voltar ao menu anterior) ");
            int id = validarOpcao();

            // Validamos se ID é valido e passamos o id do distrito a atualizar ao metodo 'atualizarDadosDistrito'
            if (id > 0 && id <= distritos.size()) {
                atualizarDadosDistrito((id - 1));
                break;
            } else if (id == 0) {
                System.out.println(amarelo + "Voltando ao menu anterior..." + reset);
                break;
            } else {
                System.out.println(amarelo + "Não existe distrito com o ID indicado. Insira um da listagem:" + reset);
            }
        }
    }

    private static void atualizarDadosDistrito(int id) {
        /* Variáveis temporais, usamos só para ter os dados antes de passar as variáveis principais
        deste modo não atualizo a informação sem o utilizador estar completamente seguro de o fazer */
        ArrayList<Integer> votantesTemp = new ArrayList<>(votantes);
        ArrayList<Integer> nulosTemp = new ArrayList<>(nulos);
        ArrayList<Integer> brancosTemp = new ArrayList<>(brancos);
        ArrayList<Integer> adTemp = new ArrayList<>(ad);
        ArrayList<Integer> psTemp = new ArrayList<>(ps);
        ArrayList<Integer> chTemp = new ArrayList<>(ch);
        ArrayList<Integer> ilTemp = new ArrayList<>(il);
        ArrayList<Integer> beTemp = new ArrayList<>(be);
        ArrayList<Integer> outrosTemp = new ArrayList<>(outros);
        /* -----------------------------------------------------------------------------------------*/

        System.out.println(verde + "\nAtualizar dados do distrito: " + amarelo + distritos.get(id) + reset);

        // Ciclo do menu
        System.out.println("Selecione os votos a atualizar | " + amarelo + "Instruções:" + reset + " o novo valor será " +
                "somado ao valor atual, portanto, só deve inserir os novos votos da freguesia restante.\n" +
                "Inserir zero(0) no caso de não haver novos votos.\n");

        // Criamos uma lista com as variáveis temporais e nomes, assim damos melhor manuseio no ciclo
        List<ArrayList<Integer>> temporais = List.of(nulosTemp, brancosTemp, adTemp, psTemp, chTemp, ilTemp,
                beTemp, outrosTemp, votantesTemp);
        String[] nomes = {"nulos", "brancos", "AD", "PS", "CH", "IL", "BE", "outros"};

        /* Inicio ciclo principal, vamos até (temporais −1) porque não é preciso atualizar votantesTemp
         manualmente, os dados de votantes são calculados de maneira automática */

        int valor;
        for (int i = 0; i < temporais.size() - 1; i++) {
            System.out.println("Votos " + nomes[i] + " atuais: " + amarelo + temporais.get(i).get(id) + reset +
                    " | Votantes atuais: " + amarelo + votantesTemp.get(id) + reset +
                    " | Total inscritos: " + vermelho + inscritos.get(id) + reset);
            // Verificamos que seja um valor numérico
            valor = validarValor(nomes[i]);

            int novoValor = (valor + temporais.get(i).get(id));
            // Validamos se novo (valor + votantes), é ou não maior aos inscritos
            int validarInscritos = valor + votantesTemp.get(id);

            if (validarInscritos <= inscritos.get(id)) {
                System.out.println("Novos votos " + nomes[i] + ": " + novoValor + "\n");
                // Atualizamos votantes e votos atuais da opção escolhida
                votantesTemp.set(id, validarInscritos);
                temporais.get(i).set(id, novoValor);

                /* Se quantidade de votantes igual à quantidade de inscritos, saímos do ciclo
                e não é possível inserir mais votos */

                if (votantesTemp.get(id).equals(inscritos.get(id))) {
                    System.out.println(amarelo + "Total de votantes igual ao total de inscritos, não é possível inserir mais votos.\n" + reset);
                    break;
                }
            } else {
                System.out.println(amarelo + "\nQuantidade de votos invalida. O total de votos não pode ser maior ao total de " +
                        "inscritos: " + vermelho + inscritos.get(id) + reset + "\n");
                i--;
            }
        } // Fim ciclo principal

        // Mostramos novos dados inseridos pelo utilizador.
        mostrarTabelaTemp(id, temporais);

        // Perguntamos se os dados são validos, se sim, atualizamos arrayList principais
        while (true) {
            System.out.println("\nOs dados inseridos são corretos? S/N");
            String confirmar = in.nextLine().trim().toUpperCase();
            if ("S".equals(confirmar)) {
                // Atualizamos todos os arrayList principais com os temporais
                ArrayList<Integer> index = new ArrayList<>();
                List<ArrayList<Integer>> principais = List.of(nulos, brancos, ad, ps, ch, il, be, outros, votantes);
                for (int i = 0; i < principais.size(); i++) {
                    principais.get(i).set(id, temporais.get(i).get(id));
                }

                // Atualizamos total de votos com o metodo "totalSoma"
                total.set(id, totalSoma(id));
                System.out.println(verde + "Dados atualizados com sucesso para o distrito: "
                        + amarelo + distritos.get(id) + reset);

                // Mostramos tabela principal com todos os dados atualizados
                mostrarTabela(index);
                break;
            } else if ("N".equals(confirmar)) {
                System.out.println(vermelho + "Os dados não foram atualizados. Pode inserir novamente." + reset);
                break;
            } else {
                System.out.println("Opção invalida!");
            }
        }
    }

    private static void mostrarTabelaTemp(int id, List<ArrayList<Integer>> temporais) {
        System.out.println(verde + "Novos votos para o distrito: " + amarelo + distritos.get(id) + reset);
        System.out.println("-".repeat(100));
        System.out.printf(amarelo + "%-10s| %-6s| %-10s| %-8s| %-8s| %-8s| %-8s| %-8s| %-10s%n" + reset,
                "Votantes", "Nulos", "Brancos", "AD", "PS", "CH", "IL", "BE", "Outros");
        System.out.println("-".repeat(100));
        System.out.printf("%-10s| %-6s| %-10s| %-8s| %-8s| %-8s| %-8s| %-8s| %-10s%n", temporais.getLast().get(id),
                temporais.getFirst().get(id), temporais.get(1).get(id), temporais.get(2).get(id),
                temporais.get(3).get(id), temporais.get(4).get(id), temporais.get(5).get(id),
                temporais.get(6).get(id), temporais.get(7).get(id));
    }

    private static int validarValor(String nome) {
        int valor = 0;
        while (true) {
            try {
                System.out.print("Nova quantidade de votos " + nome + ": ");
                valor = in.nextInt();
                in = new Scanner(System.in);
                if (valor >= 0) break;
                else System.out.println(amarelo + "O valor não pode ser negativo.\n" + reset);
            } catch (InputMismatchException e) {
                System.out.println(amarelo + "O valor não é valido!\n" + reset);
                in = new Scanner(System.in);
            }
        }
        return valor;
    }

    private static void distritosPartidosMaisVotos() {
        // Lista dos nomes dos partidos
        listaPartidos();
        System.out.println(verde + "\nPartido por distrito com maior número de votos" + reset);

        // Comparamos cada partido por distrito
        List<ArrayList<Integer>> listas = List.of(ad, ps, ch, il, be, outros);
        // Criamos um arrayList para guardar os indices dos partidos com maior votos
        ArrayList<Integer> indicesTemp = new ArrayList<>();

        // Percorremos cada distrito (i)
        for (int i = 0; i < distritos.size(); i++) {
            int maior = 0;
            double soma = 0;

            /* Percorremos cada partido(j) do mesmo distrito (i) e somamos os votos validos (sem nulos nem brancos)
            Guardamos o(s) índice(s) do(s) ganhador(es) */

            for (int j = 0; j < listas.size(); j++) {
                soma += listas.get(j).get(i);
                /* Verificamos qual é o maior e se há empates, sempre que exista um maior, limpamos temp e
                guardamos o novo índice */
                if (listas.get(j).get(i) > maior) {
                    maior = listas.get(j).get(i);
                    indicesTemp.clear();
                    indicesTemp.add(j);
                } else if (listas.get(j).get(i) == maior) {
                    indicesTemp.add(j);
                }
            }

            /* Mostramos o distrito (i) e o(s) partido(s) com maior votos */
            for (Integer index : indicesTemp) {
                System.out.printf(amarelo + "- %s" + reset + ": ganhou %s com %d votos e uma percentagem de %.2f%%%n",
                        distritos.get(i), partidos.get(index), maior, ((maior / soma) * 100));
            }
        }
    }

    private static void partidoMaisVotos() {
        ArrayList<Integer> index = new ArrayList<>();
        // Lista dos nomes dos partidos
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

        // Obtemos o partido com maior números de votos
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
        // Passamos o arrayLit para ordenar decrescente o arrayList "indices"
        ordenDecrescente(total);

        // Temporal para guardar índices dos partidos com mais votos
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
        // Neste metodo validamos se o input é numérico e valido
        int op = 0;
        while (true) {
            try {
                System.out.print("Opção: ");
                op = in.nextInt();
                in = new Scanner(System.in);
                break;
            } catch (InputMismatchException e) {
                System.out.println(amarelo + "Opção invalida! Por favor, deve inserir um número do menu!\n" + reset);
                in = new Scanner(System.in);
            }
        }
        return op;
    }
}