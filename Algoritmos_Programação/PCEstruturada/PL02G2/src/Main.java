import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    static Scanner in = new Scanner(System.in);
    static ArrayList<String> dataGeral = new ArrayList<>();
    static ArrayList<String> alunos = new ArrayList<>();
    static ArrayList<Integer> nota1 = new ArrayList<>();
    static ArrayList<Integer> nota2 = new ArrayList<>();
    static ArrayList<Integer> exame = new ArrayList<>();
    static Path dir = Path.of("DataGeral.txt");

    public static void main(String[] args) {
        /*
        Pretende-se uma aplicação que permita classificar cada um dos N alunos de uma disciplina com a seguinte estrutura de
        avaliação:
        Trabalho 1 – 20% da nota
        Trabalho 2 - 20% da nota
        Exame – 60 % da nota
        Para cada aluno obter o seu nome e as notas de cada um dos elementos de avaliação (validadas entre 0 e 20), calculando
        de seguida a nota final. A classificação deve ser indicada mediante a seguinte tabela:

        Nota Comentário
        De 0 a 4,9 Muito fraco
        De 5 a 9,9 Fraco
        De 10 a 12,9 Suficiente
        De 13 a 16,9 Bom
        De 17 a 20 Muito bom

        Deve ser também indicada o valor da melhor e pior nota final bem como a percentagem de notas positivas em cada um
        dos itens de avaliação (trabalho 1, trabalho 2 e exame) e as suas respetivas médias. Indicar ainda o total de alunos com
        classificação “Muito Bom”.
        A saída do programa (“output”) deve ser apresentada da seguinte forma:
        Nome do aluno Classificação
        João Bom
        Luis Muito Bom
        Manuel Fraco
        … ….
        *********************************************
        MELHOR NOTA FINAL: 18 valores
        PIOR NOTA FINAL: 2 valores
        PERCENTAGENS DE NOTAS POSITIVAS:
        Trabalho 1: 63%
        Trabalho 2: 45%
        Exame: 54%
        Final: 51%
        MÉDIAS DAS NOTAS:
        Trabalho 1: 13,4 valores
        Trabalho 2: 10,7 valores
        Exame: 12,6 valores
        6 alunos com classificação MUITO BOM
        A aplicação deve conter um menu que permita:
        1. Inserir, editar e eliminar alunos e notas (no formato numérico);
        2. Imprimir os dados da turma (output acima – deve ser recalculado sempre que haja nova alteração);
        3. Ler e gravar os dados em ficheiro
         */
        // Preenchemos arrays
        AtualizarArrays();

        int op = 1;
        do {
            System.out.println("*** CESAE - Controlo de Notas ***");
            System.out.println("0- Sair");
            System.out.println("Menu Alunos:");
            System.out.println("1- Inserir    |  2- Editar  |  3- Eliminar  |  4- Imprimir dados da Turma");
            System.out.println("Menu Ficheiros:");
            System.out.println("5- Ler dados  |  6- Gravar dados");
            op = in.nextInt();
            in = new Scanner(System.in);

            switch (op) {
                case 0:
                    break;
                case 1:
                    Inserir();
                    break;
                case 2:
                    Editar();
                    break;
                case 3:
                    Eliminar();
                    break;
                case 4:
                    Imprimir();
                    break;
                case 5:
                    Ler();
                    break;
                case 6:
                    Gravar();
                    break;
                default:
                    System.out.println("Opção invalida.");
            }
        } while (op != 0);
    }

    private static boolean Mostrar() {
        if (alunos.isEmpty()) {
            System.out.println("Base de dados de Alunos vazia.\n");
            return true;
        } else {
            System.out.println("Lista de Alunos");
            System.out.println("ID\t-\tAluno\t-\tTrabalho 1\t-\tTrabalho 2\t-\tExame");
            for (int i = 0; i < alunos.size(); i++) {
                System.out.println((i + 1) + ".\t\t" + alunos.get(i) + "\t\t\t" + nota1.get(i) + "\t\t\t\t" + nota2.get(i) + "\t\t\t\t" + exame.get(i));
            }
            System.out.println();
            return false;
        }
    }

    private static void AtualizarTxt() {
        // Preencher TXT
        ArrayList<String> linha = new ArrayList<>();
        for (int i = 0; i < alunos.size(); i++) {
            linha.add(alunos.get(i) + ";" + nota1.get(i) + ";" + nota2.get(i) + ";" + exame.get(i));
        }
        try {
            Files.write(dir, linha);
            System.out.println("\nBase de dados atualizada.");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void AtualizarArrays() {
        // Preenchemos arrays
        try {
            List<String> temp = Files.readAllLines(dir);
            for (String linha : temp) {
                String[] linhaArray = linha.split(";");
                alunos.add(linhaArray[0]);
                nota1.add(Integer.parseInt(linhaArray[1]));
                nota2.add(Integer.parseInt(linhaArray[2]));
                exame.add(Integer.parseInt(linhaArray[3]));
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void Inserir() {
        String datos;
        do {
            System.out.println("\n*** CESAE - Controlo de Notas - Módulo Inserir ***");
            System.out.println("0- Voltar ao menu principal\n");
            System.out.println("-- Inserir Aluno --");
            System.out.print("Nome: ");
            datos = in.nextLine();

            if (!datos.equals("0")) {
                alunos.add(datos);
                // Validação numerica
                System.out.println("-- Inserir Notas --");
                for (int i = 1; i <= 3; i++) {
                    try {
                        if (i == 3) {
                            System.out.print("Exame: ");
                            datos = in.nextLine();
                            exame.add(Integer.parseInt(datos));
                        } else if (i == 1) {
                            System.out.print("Trabalho " + i + ": ");
                            datos = in.nextLine();
                            nota1.add(Integer.parseInt(datos));
                        } else {
                            System.out.print("Trabalho " + i + ": ");
                            datos = in.nextLine();
                            nota2.add(Integer.parseInt(datos));
                        }
                    } catch (NumberFormatException e) {
                        i--;
                        System.out.println("Valor inválido, deve de ser numérico.");
                    }
                }

                AtualizarTxt();
                System.out.println("Aluno inserido com sucesso!");
            }
        }
        while (!datos.equals("0"));
        System.out.println("Saiu do modulo Inserir");
    }

    private static void Editar() {
        int id = 1, op;
        do {

            System.out.println("\n*** CESAE - Controlo de Notas - Módulo Editar ***");
            System.out.println("0- Voltar ao menu principal\n");
            System.out.println("-- Editar dados dos Alunos --");
            if (Mostrar()) {
                return;
            }
            System.out.print("Insira o ID do aluno a editar: ");
            id = in.nextInt();

            if (id != 0 && id <= alunos.size()) {
                System.out.println("Que informação quer editar do aluno: " + alunos.get(id - 1) + "?");
                System.out.println("0- Voltar ao menu anterior");
                System.out.println("1- Nome\t| Notas: 2- Trabalho 1\t3- Trabalho 2\t4- Exame");
                op = in.nextInt();
                in = new Scanner(System.in);

                do {
                    try {
                        switch (op) {
                            case 0:
                                break;
                            case 1:
                                System.out.print("Novo nome: ");
                                alunos.set(id - 1, in.nextLine());
                                break;
                            case 2:
                                System.out.print("Nova nota trabalho 1: ");
                                nota1.set(id - 1, in.nextInt());
                                break;
                            case 3:
                                System.out.print("Nova nota trabalho 2: ");
                                nota2.set(id - 1, in.nextInt());
                                break;
                            case 4:
                                System.out.print("Nova nota exame: ");
                                exame.set(id - 1, in.nextInt());
                                break;
                            default:
                                System.out.println("Opção invalida.");
                        }
                        op = 0;
                        AtualizarTxt();
                        System.out.println("Aluno (" + alunos.get(id-1) + ") editado com sucesso!");
                    } catch (InputMismatchException e) {
                        in = new Scanner(System.in);
                        System.out.println("Valor inválido, deve de ser numérico.");
                    }
                } while (op != 0);
            }

        } while (id != 0);
    }

    private static void Eliminar() {
        int id = 1;
        do {
            System.out.println("\n*** CESAE - Controlo de Notas - Módulo Eliminar ***");
            System.out.println("0- Voltar ao menu principal\n");
            System.out.println("-- Eliminar Aluno --");
            if (Mostrar()) {
                return;
            }
            System.out.print("Insira o ID do aluno a eliminar: ");
            id = in.nextInt();
            if (id != 0 && id <= alunos.size()) {
                // Remove dos arrays
                alunos.remove(id - 1);
                nota1.remove(id - 1);
                nota2.remove(id - 1);
                exame.remove(id - 1);

                AtualizarTxt();
                System.out.println("Aluno com ID (" + id + ") eliminado com sucesso!");
            }
        } while (id != 0);
        System.out.println("Saiu do modulo Eliminar");
    }

    private static void Imprimir() {
    }

    private static void Ler() {
        System.out.println("\n*** CESAE - Controlo de Notas ***");
        Mostrar();
    }

    private static void Gravar() {
        System.out.println("\n*** CESAE - Controlo de Notas ***");
        AtualizarTxt();
    }
}