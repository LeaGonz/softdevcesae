import javax.xml.transform.Source;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;
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
                    EscreverA();
                    break;
                default:
                    System.out.println("Opção invalida");
            }
        } while (op != 0);
    }

    private static void EscreverA() {
        // Forma facil
        ArrayList<String> text = new ArrayList<>();
        text.add("Ejemplo 1");
        text.add("Ejemplo 2");
        text.add("Ejemplo 3");
        text.add("Ejemplo 4");
        try {
            Files.write(Path.of("case1.txt"), text);
            System.out.println("Ficheiro atualizado com sucesso!");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        //Falta forma larga
    }

    private static void Escrever() {
        System.out.println("Texto para escrever no ficheiro:");
        String text = in.nextLine();

        Path dir = Path.of("case3.txt");
        try {
            Files.writeString(dir, text);
            System.out.println("Ficheiro atualizado com sucesso!");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        /*
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
        }*/
    }


    private static void LeituraA() {
        // Forma mas rapida
        Path dir = Path.of("case2.txt");
        try {
            List<String> text = Files.readAllLines(dir);
            System.out.println("Array criado com sucesso a partir do ficheiro.\nConteudo:");
            for (int i = 0; i < text.size(); i++) {
                System.out.println("Linha " + (i + 1) + ": " + text.get(i));
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        /*
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
            for (int i = 0; i < array.length; i++) {
                System.out.println("Linha " + (i + 1) + ": " + array[i]);
            }

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }*/
    }

    private static void LeituraS() {
        // Forma mas rapida
        try {
            String text = Files.readString(Path.of("case1.txt"));
            if (text.isEmpty()) {
                System.out.println("Ficheiro vacio.");
            } else {
                System.out.println("Conteudo do ficheiro:");
                System.out.println(text);
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }


        /*
        try {
            BufferedReader reader = new BufferedReader(new FileReader("case1.txt"));
            String line, text = "";
            while ((line = reader.readLine()) != null) {
                text += line + " ";
                //text.append(line).append(" ");
            }
            reader.close();
            if (text.isEmpty()) {
                System.out.println("Ficheiro vacio.");
            } else {
                System.out.println("Conteudo do ficheiro:");
                System.out.println(text);
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }*/
    }
}