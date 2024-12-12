import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or

// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.

public class Main {
    static Scanner in = new Scanner(System.in);
    static int[] numeros = new int[0];

    public static void main(String[] args) {
        int op = 1;
        do {
            System.out.println("1- Ex01");
            System.out.println("2- Ex02");
            System.out.println("3- Ex03");
            System.out.println("4- Ex04");
            System.out.println("5- Ex05");
            System.out.println("6- Ex06");
            System.out.println("7- Ex07");
            System.out.println("8- Ex08");
            System.out.println("0- Sair");
            System.out.println("Escolha um exercicio:");
            op = in.nextInt();
            switch (op) {
                case 0:
                    break;
                case 1:
                    ex01();
                    break;
                case 2:
                    ex02();
                    break;
                case 3:
                    ex03();
                    break;
                case 4:
                    ex04();
                    break;
                case 5:
                    ex05();
                    break;
                case 6:
                    break;
                case 7:
                    break;
                case 8:
                    break;
                default:
                    System.out.println("Opção invalida.");
            }

        } while (op != 0);
    }

    private static void ex05() {
        ArrayList<String> compras = new ArrayList<>();
        boolean validar = true;
        String produtos;
        do {
            System.out.println("Inserir produtos");
            in = new Scanner(System.in);
            produtos = in.nextLine();
            if (Objects.equals(produtos, "sair")) {
                validar = false;
            }
            compras.add(produtos);
        } while (validar);
        int op = 1;
        do {
            System.out.println("1- inserir novo produto");
            System.out.println("2- editar produto");
            System.out.println("3- eliminar produto");
            System.out.println("4- Mostrar produtos");
            System.out.println("0- sair");
            op = in.nextInt();
            in = new Scanner(System.in);

            switch (op) {
                case 0:
                    break;
                case 1:
                    System.out.println("Novo produto:");
                    compras.add(in.nextLine());
                    System.out.println("Produto inserido com sucesso!");
                    break;
                case 2:
                    System.out.println("lista de produtos");
                    for (int i = 0; i < compras.size(); i++) {
                        System.out.println((i + 1) + ". " + compras.get(i));
                    }
                    ;
                    System.out.println("Qual quer editar");
                    op = in.nextInt();
                    in = new Scanner(System.in);
                    System.out.println("Novo nome do produto:");
                    produtos = in.nextLine();
                    compras.set((op - 1), produtos);
                    break;
                case 3:
                    System.out.println("Qual produto quer eliminar?");
                    System.out.println("lista de produtos");
                    for (int i = 0; i < compras.size(); i++) {
                        System.out.println((i + 1) + ". " + compras.get(i));
                    }
                    op = in.nextInt();
                    compras.remove((op - 1));
                    in = new Scanner(System.in);
                    break;
                case 4:
                    System.out.println("lista de produtos");
                    for (int i = 0; i < compras.size(); i++) {
                        System.out.println((i + 1) + ". " + compras.get(i));
                    }

                    break;
                default:
                    System.out.println("Opcao invalida.");
            }
        } while (op != 0);
    }

    private static void ex04() {
        int[] numeros = new int[5];
        for (int i = 0; i < 5; i++) {
            System.out.println("Número: " + (i + 1));
            numeros[i] = in.nextInt();
        }
        System.out.println("Numero a buscar: ");
        int n = in.nextInt();
        for (int i = 0; i < 5; i++) {
            if (numeros[i] == n) {
                System.out.println("Numero encontrado " + numeros[i]);
                return;
            } else if (i == 4) {
                System.out.println("Numero no existe");
            }
        }
    }

    private static void ex03() {
        BufferedReader reader;
        BufferedWriter writer;
        int count = 0;
        try {
            reader = new BufferedReader(new FileReader("entrada.txt"));
            String line;
            StringBuilder temp = new StringBuilder();
            while ((line = reader.readLine()) != null) {
                if (line.equals("importante")) {
                    temp.append(line).append(" ");
                    count++;
                }
            }
            reader.close();

            writer = new BufferedWriter(new FileWriter("entrada.txt"));
            reader = new BufferedReader(new FileReader("saida.txt"));
            while ((line = reader.readLine()) != null) {
                writer.write(line);
                writer.newLine();
            }
            reader.close();
            writer.close();

            writer = new BufferedWriter(new FileWriter("saida.txt"));
            writer.write(temp.toString());
            writer.close();

            System.out.println("Lineas = " + count);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }

    private static void ex02() {
        int numero;
        do {
            int[] temp = new int[numeros.length + 1];
            System.out.println("Insira números:");
            numero = in.nextInt();
            if (numero < 0) {
                break;
            }

            for (int i = 0; i < numeros.length; i++) {
                temp[i] = numeros[i];
            }
            temp[numeros.length] = numero;
            numeros = temp;
        } while (numero >= 0);

        // ordenar
        for (int i = 0; i < numeros.length - 1; i++) {
            for (int j = i + 1; j < numeros.length; j++) {
                if (numeros[i] < numeros[j]) {
                    int temp = numeros[i];
                    numeros[i] = numeros[j];
                    numeros[j] = temp;
                }
            }
        }
        // mostrar
        for (int i = 0; i < numeros.length; i++) {
            System.out.println(numeros[i]);
        }
    }

    private static void ex01() {
        ArrayList<Integer> numeros = new ArrayList<>();
        int par = 0, impar = 0, soma = 0;
        while (numeros.size() < 10) {
            System.out.println("Número " + (numeros.size() + 1));
            numeros.add(in.nextInt());
            soma += numeros.getLast();
        }
        // par e impar
        for (int n : numeros) {
            if ((n % 2) == 0) {
                par++;
            } else {
                impar++;
            }
        }
        System.out.println(par + " números pares");
        System.out.println(impar + " números impares.");
        // suma
        System.out.println("A soma de todos os números é: " + soma);
        // media
        System.out.println("A media de todos os números é: " + (soma / numeros.size()));
        System.out.println();
    }
}