import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        /*
        2. Faça um programa que guarde num vetor os nomes de pelo menos 10 alunos da turma. Deve permitir ao
        utilizador ao inserir o número do aluno (índice do vetor) indicar qual o nome do mesmo.
         */
        Scanner in = new Scanner(System.in);
        String[] nomes = new String[11];
        int id;

        System.out.println("Insira o nome do aluno, por favor.");
        for (int i = 1; i < nomes.length; i++) {
            System.out.print("Aluno " + i + ": ");
            nomes[i] = in.nextLine();
        }
        do {
            System.out.print("Procura de aluno por seu ID: ");
            id = in.nextInt();
            if (id >= 0 && id < nomes.length) {
                System.out.println("O aluno do ID " + id + " é " + nomes[id]);
            } else {
                System.out.println("Aluno com ID " + id + " não existe.");
            }
        } while (id != 0);
    }
}