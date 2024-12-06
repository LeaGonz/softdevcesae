import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
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
        int op = 1;
        do {
            System.out.println("*** CESAE - Controlo de Notas ***");
            System.out.println("Menu Alunos:");
            System.out.println("1- Inserir    |  2- Editar  |  3- Eliminar  |  4- Imprimir dados da Turma");
            System.out.println("Menu Ficheiros:");
            System.out.println("5- Ler dados  |  6- Gravar dados");
            System.out.println("0- Sair");
            op = in.nextInt();
            in = new Scanner(System.in);

            switch (op) {
                case 0:
                    break;
                case 1:
                    Inserir();
                    Atualizar();
                    Mostrar();
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

    private static void Mostrar() {
        System.out.println("*** CESAE - Controlo de Notas ***");
        System.out.println("Lista de Alunos");
        System.out.println("ID\t-\tAluno\t-\tTrabalho 1\t-\tTrabalho 2\t-\tExame");
        for (int i = 0; i < alunos.size(); i++) {
            System.out.println((i+1) + ".\t\t" + alunos.get(i) + "\t\t\t" + nota1.get(i) + "\t\t\t\t" + nota2.get(i) + "\t\t\t\t" + exame.get(i));
        }
    }

    private static void Atualizar() {
        // Preenchemos arrays
        try {
            List<String> temp = Files.readAllLines(Path.of("DataGeral.txt"));
            for(int i = 0; i < temp.size(); i++){
                String linha = temp.get(i);
                String[] dados = linha.split(";");
                alunos.add(dados[0]);
                nota1.add(Integer.parseInt(dados[1]));
                nota2.add(Integer.parseInt(dados[2]));
                exame.add(Integer.parseInt(dados[3]));
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());        }
    }

    private static void Inserir() {
        String datos;
        do {
            System.out.println("\n*** CESAE - Controlo de Notas ***");
            System.out.println("0- Voltar ao menu principal\n");
            System.out.println("-- Inserir Aluno --");
            System.out.print("Nome: ");
            datos = in.nextLine();
            alunos.add(datos);

            if (!datos.equals("0")) {
                System.out.println("-- Inserir Notas --");
                for (int i = 1; i <= 3; i++) {
                    if (i == 3) {
                        System.out.print("Exame: ");
                        datos = in.nextLine();
                        exame.add(Integer.parseInt(datos));
                    } else if (i == 1){
                        System.out.print("Trabalho " + i + ": ");
                        datos = in.nextLine();
                        nota1.add(Integer.parseInt(datos));
                    } else {
                        System.out.print("Trabalho " + i + ": ");
                        datos = in.nextLine();
                        nota2.add(Integer.parseInt(datos));
                    }
                }
                System.out.println("Aluno inserido com sucesso!");
            }
        } while (!datos.equals("0"));
    }

    private static void Editar() {
    }

    private static void Eliminar() {
    }

    private static void Imprimir() {
    }

    private static void Ler() {
    }

    private static void Gravar() {
    }
}