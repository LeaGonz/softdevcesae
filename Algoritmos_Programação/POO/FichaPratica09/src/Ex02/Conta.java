package Ex02;

public class Conta {
    private String iban;
    private double saldo = 0;
    private String titular;
    private int anoAbertura;
    private double margemEmprestimo;
    private double valorDivida = 0;

    // Metodo construtor
    public Conta(String iban, double saldo, String titular) {
        this.iban = iban;
        this.saldo = saldo;
        this.titular = titular;
    }

    // Metodos instancias
    public void transferencia(double valor, Conta conta) {
        if (this.saldo >= valor) {
            // se tenho saldo, fazemos transferência
            this.saldo -= valor;
            conta.saldo += valor;
            System.out.println("Transferência por " + valor + "€ realizada com sucesso de |" + this.iban + "| para |" + conta.iban + "|");
        } else { // sem saldo
            System.out.println("Saldo insuficiente para: " + this.titular + " |" + this.iban + "|");
        }
    }

    public void depositar(double valor) {
        this.saldo += valor;
        this.mostrarSaldo();
    }

    public void levantar(double valor) {
        if (this.saldo >= valor) {
            this.saldo -= valor;
            this.mostrarSaldo();
        } else {
            System.out.println("Saldo insuficiente para: " + this.titular + " |" + this.iban + "|");
        }
    }

    public boolean pedirEmprestimo(double valor) {
        if (valor <= this.margemEmprestimo && this.valorDivida == 0) {
            this.valorDivida = valor;
            return true; // pode pedir emprestimo
        } else {
            return false; // nao pode pedir
        }
    }

    public void margemEmprestimo() {
        this.margemEmprestimo = this.saldo * 0.9;
    }

    public void mostrarSaldo() {
        margemEmprestimo();
        System.out.println("Saldo da conta: " + this.titular + " |" + this.saldo + " EUR|" + " Margem |" + this.margemEmprestimo + " EUR|"+ " Dividas |" + this.valorDivida + " EUR|");
    }
}