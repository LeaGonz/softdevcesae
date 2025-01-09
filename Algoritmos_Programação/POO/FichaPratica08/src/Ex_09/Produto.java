package Ex_09;

public class Produto {
    private String nome;
    private double preco;
    private int stock = 0;

    // Construtor
    Produto(String nome, double preco, int stock) {
        this.nome = nome;
        this.preco = preco;
        this.stock = stock;
    }
    // Metodos instâncias
    public void Comprar(int stock) {
        if (this.stock > stock) {
            this.stock -= stock;
            System.out.println("Compra com sucesso. Stock atual: " + this.stock);
        } else {
            System.out.println("Stock insuficiente, atual: " + this.stock);
        }
    }

    public void Vender(int stock) {

    }

}
