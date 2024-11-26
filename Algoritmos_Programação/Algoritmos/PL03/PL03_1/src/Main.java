import java.util.Scanner;

public class Main {
    // Variable global, se debe colocar el static
    static Scanner in = new Scanner(System.in);

    private static void Calculadora() {
        int op = 1;
        while (op != 0) {
            System.out.println("Aplicação 1: Calculadora");
            System.out.println("1- Somar");
            System.out.println("2- Subtrair");
            System.out.println("3- Multiplicação");
            System.out.println("4- Divisão");
            System.out.println("0- Voltar ao menu anterior");
            op = in.nextInt();

            switch (op) {
                case 0:
                    break;
                case 1:
                    //Somar();
                    Operacoes("+");
                    break;
                case 2:
                    //Subtrair();
                    Operacoes("-");
                    break;
                case 3:
                    Operacoes("*");
                    break;
                case 4:
                    Operacoes("/");
                    break;
                default:
                    System.out.println("Opção invalida");
            }
        }
    }
    private static double PedirNumero(){
        System.out.println("Insira um número");
        return in.nextDouble();
    }
    private static void Operacoes(String operacao){
        double numero1 = PedirNumero();
        double numero2 = PedirNumero();
        double resultado = switch (operacao){
            case "+" -> numero1 + numero2;
            case "-" -> numero1 - numero2;
            case "*" -> numero1 * numero2;
            default -> numero1 / numero2;
        };
        System.out.println(numero1 + operacao + numero2 + " = " + resultado);
    }
    private static void Somar() {
        double numero1 = PedirNumero();
        double numero2 = PedirNumero();

        double soma = numero1 + numero2;
        System.out.println("A soma é: " + soma);
    }
    private static void Subtrair() {
        double numero1 = PedirNumero();
        double numero2 = PedirNumero();

        double subtracao = numero1 - numero2;
        System.out.println("A substração é: " + subtracao);
    }
    private static void ListaNumeros() {
        int op = 1;
        do{
            System.out.println("Aplicação 2: Lista de números");
            System.out.println("Insira o inicio da lista:");
            int numero1 = in.nextInt();
            System.out.println("Insira o final da lista:");
            int numero2 = in.nextInt();
            String lista = "";
            if (numero1 < numero2) {
                for (int i = numero1; i < numero2 +1; i++) {
                    lista += i + ",";
                    //System.out.println(i + "\t");
                }
            } else {
                for (int i = numero1; i > numero2; i--) {
                    lista += i + ",";
                }
            }
            System.out.println("Lista: " + lista + numero2);
            
            System.out.println("Deseja criar uma nova lista?");
            System.out.println("1- Sim");
            System.out.println("0- Não");
            op = in.nextInt();
            if (op != 1 && op != 0) {
                System.out.println("Opção invalida. Insira a correta:");
                op = in.nextInt();
            }
        } while (op != 0);
    }
        public static void main (String[]args){
            int op;
            do {
                System.out.println("Bem-vindo");
                System.out.println("Escolha uma das seguintes opções:");
                System.out.println("1- Calculadora");
                System.out.println("2- Lista de números");
                System.out.println("4- Jogo: Adivinhe o Número");
                System.out.println("0 - Sair");
                op = in.nextInt();

                if (op == 0) {
                    return;
                } else if (op == 1) {
                    Calculadora();
                } else if (op == 2) {
                    ListaNumeros();
                } else if (op == 4) {
                    //AdivinheNumero();
                } 
                else {
                    System.out.println("Opção invalida");
                }
            } while (op != 0);
        }
}

