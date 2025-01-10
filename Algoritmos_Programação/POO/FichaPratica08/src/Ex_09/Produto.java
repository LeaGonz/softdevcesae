package Ex_09;

public class Produto {
    private String nome;
    private double preco;
    private int stock = 0;

    // Construtor
    Produto(String nome, double preco) {
        this.nome = nome;
        this.preco = preco;
    }

    // Metodos instâncias
    public void Comprar(int stock) {
        this.stock += stock;
        System.out.println("Comprado " + stock + " und com sucesso. Stock atual: " + this.stock);
    }

    public void Vender(int stock) {
        if (this.stock > stock) {
            this.stock -= stock;
            System.out.println("Venta " + stock + " und com sucesso. Stock atual: " + this.stock);
        } else {
            System.out.println("Venta " + stock + " und não possivel, stock insuficiente. Stock atual: " + this.stock);
        }
    }

}
