package Ex_11;

public class Conta {
    private String iban;
    private double saldo = 0;
    private String titular;

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

    public void mostrarSaldo() {
        System.out.println("Saldo da conta: " + this.titular + " |" + this.saldo + " EUR|");
    }
}
