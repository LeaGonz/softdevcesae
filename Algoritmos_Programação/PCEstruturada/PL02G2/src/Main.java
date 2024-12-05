import java.util.ArrayList;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    static Scanner in = new Scanner(System.in);
    static ArrayList<String> alunos = new ArrayList<>();
    static ArrayList<Integer> notas = new ArrayList<>();
    static int op = 1;

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

    private static void Inserir() {
        String nome;
        do {
            System.out.println("\n*** CESAE - Controlo de Notas ***");
            System.out.println("0- Voltar ao menu principal");
            System.out.println("-- Inserir Aluno --");
            System.out.print("Nome: ");
            nome = in.nextLine();

            if (!nome.equals("0")) {
                alunos.add(nome);
                System.out.println("Aluno " + (alunos.indexOf(alunos.getLast()) + 1) + ". " + alunos.getLast() + " inserido com sucesso!");
            }
        } while (!nome.equals("0"));
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