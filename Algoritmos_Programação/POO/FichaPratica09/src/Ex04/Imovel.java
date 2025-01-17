package Ex04;

public class Imovel {
    private String rua;
    private int numero;
    private String cidade;
    private Tipo tipo;
    private Acabamento acabamento;
    private double area;
    private int quartos;
    private int banhos;
    private double areaPiscina;

    public Imovel(String rua, int numero, String cidade, Tipo tipo, Acabamento acabamento, double area, int quartos, int banhos, double areaPiscina) {
        this.rua = rua;
        this.numero = numero;
        this.cidade = cidade;
        this.tipo = tipo;
        this.acabamento = acabamento;
        this.area = area;
        this.quartos = quartos;
        this.banhos = banhos;
        this.areaPiscina = areaPiscina;
    }

    // SET
    public void setAcabamento(Acabamento acabamento) {
        this.acabamento = acabamento;
    }

    // Metodos instancias
    public double valorImovel() {
        // Obtemos o valor do m2 por tipo
        int valorm2 = 0;
        switch (tipo) {
            case APARTAMENTO:
                valorm2 = 1000;
                break;
            case CASA:
                valorm2 = 3000;
                break;
            case MANSAO:
                valorm2 = 5000;
                break;
        }
        double valorFinal = (this.area * valorm2) + (this.quartos * 7500) +
                (this.banhos * 10500) + (this.areaPiscina * 1000);
        return switch (acabamento) {
            case RESTAURO -> valorFinal * 0.5;
            case USADA -> valorFinal - (valorFinal * 0.1);
            case NOVA_COM_ALTO_ACABAMENTO -> valorFinal + (valorFinal * 0.25);
            default -> valorFinal;
        };
    }

    public Imovel compararImoveis(Imovel outroImovel) {
        if (this.valorImovel() > outroImovel.valorImovel()){
            return this;
        } else if (this.valorImovel() < outroImovel.valorImovel()){
            return outroImovel;
        } else {
            return null;
        }
    }

    public void imprimirDescricao() {
        System.out.println("*** Imóvel ***\n" +
                "Tipo: " + this.tipo + "\n" +
                "Acabamento: " + this.acabamento + "\n" +
                "Endereço: " + this.rua + ", " + this.numero + ", " + this.cidade + "\n" +
                "Área: " + this.area + "m2 Quartos: " + this.quartos + " Banho: " + this.banhos);
        if (this.areaPiscina != 0) System.out.println("Piscina: " + this.areaPiscina + "m2");
        else System.out.println("Piscina: imóvel sem piscina");
    }
}
