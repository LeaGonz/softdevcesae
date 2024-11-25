import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    // Variable global, se debe colocar el static
    static Scanner in = new Scanner(System.in);

    private static void Calculadora() {
        int op = 1;
        while (op != 0) {
            System.out.println("Aplicação 1: Calculadora");
            System.out.println("1- Somar");
            System.out.println("2- Subtrair");
            System.out.println("0- Voltar ao menu anterior");
            op = in.nextInt();

            switch (op) {
                case 0:
                    break;
                case 1:
                    Somar();
                    break;
                case 2:
                    Subtrair();
                    break;
                default:
                    System.out.println("Opção invalida");
            }
        }
    }
    private static void Somar() {
        System.out.println("Insira um número");
        double numero1 = in.nextDouble();

        System.out.println("Insira outro número");
        double numero2 = in.nextDouble();

        double soma = numero1 + numero2;
        System.out.println("A soma é: " + soma);
    }
    private static void Subtrair() {
        System.out.println("Insira um número");
        double numero1 = in.nextDouble();

        System.out.println("Insira outro número");
        double numero2 = in.nextDouble();

        double subtracao = numero1 - numero2;
        System.out.println("A substração é: " + subtracao);
    }
    private static void ListaNumeros() {
        System.out.println("Aplicação 2: Lista de números");
        System.out.println("Insira o inicio da lista:");
        int numero1 = in.nextInt();
        System.out.println("Insira o final da lista:");
        int numero2 = in.nextInt();
        String lista = "";
        if (numero1 < numero2) {
            for (int i = numero1; i < numero2; i++) {
                lista += i + ",";
            }
        }
        if (numero1 > numero2) {
            for (int i = numero1; i > numero2; i--) {
                lista += i + ",";
            }
        }
            System.out.println("Lista: " + lista + numero2);
    }
        public static void main (String[]args){
            int op;

            do {
                System.out.println("Bem-vindo");
                System.out.println("Escolha uma das seguintes opções:");
                System.out.println("1- Calculadora");
                System.out.println("2- Lista de números");
                System.out.println("0 - Sair");
                op = in.nextInt();

                if (op == 0) {
                    return;
                } else if (op == 1) {
                    Calculadora();
                } else if (op == 2) {
                    ListaNumeros();
                } else {
                    System.out.println("Opção invalida");
                }
            } while (op != 0);
        }
}

