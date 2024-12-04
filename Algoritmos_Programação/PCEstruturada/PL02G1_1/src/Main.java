import javax.xml.transform.Source;
import java.io.*;
import java.sql.SQLOutput;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or

// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        /*
        1. Crie uma aplicação com um menu que permita as seguintes funcionalidades:
            a. Ler um ficheiro de texto para uma única string e o apresente o seu conteúdo.
            b. Ler um ficheiro de texto para um array de strings, em que cada linha é uma posição do array, e o
                apresente o seu conteúdo.
            c. Escrever um texto digitado pelo utilizador e gravar o mesmo num ficheiro.
            d. Preencher um array de strings e escrever cada linha num ficheiro.
         */

        int op = 1;

        do {
            System.out.println("---- Ficheiros ----");
            System.out.println("1- Ler ficheiro: um string");
            System.out.println("2- Ler ficheiro: array strings");
            System.out.println("3- Escrever ficheiro");
            System.out.println("4- Preencher array e Escrever ficheiro");
            System.out.println("0- Sair");
            op = in.nextInt();
            in = new Scanner(System.in);

            switch (op) {
                case 0:
                    break;
                case 1:
                    LeituraS();
                    break;
                case 2:
                    LeituraA();
                    break;
                case 3:
                    Escrever();
                    break;
                case 4:
                    break;
                default:
                    System.out.println("Opção invalida");
            }
        } while (op != 0);
    }

    private static void Escrever() {
        System.out.println("Texto para escrever no ficheiro:");
        String text = in.nextLine();
        if (text.isEmpty()) {
            System.out.println("O campo não pode ser vazio");
            Escrever();
        }

        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("case3.txt", true));
            writer.write(text);
            writer.close();
            System.out.println("Ficheiro atualizado com sucesso!");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }


    private static void LeituraA() {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("case2.txt"));
            //String[] lines = reader.lines().toArray(String[]::new); // Forma facil.

            String[] array = new String[0];
            String linha;
            while ((linha = reader.readLine()) != null) {
                String[] temp = new String[array.length + 1];
                for (int i = 0; i < array.length; i++) {
                    temp[i] = array[i];
                }
                temp[temp.length - 1] = linha;
                array = temp;
            }
            reader.close();
            System.out.println("Array criado com sucesso a partir do ficheiro.\nConteudo:");
            for (String s : array) {
                System.out.println(s);
            }

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void LeituraS() {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("case1.txt"));
            String line, text = "";
            while ((line = reader.readLine()) != null) {
                text += line + " ";
            }
            reader.close();
            System.out.println(text);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}