package Ex04;

public class Main {
    public static void main(String[] args) {
        Imovel remax = new Imovel("boa vista", 12, "porto", Tipo.APARTAMENTO,
                Acabamento.NOVA_COM_ALTO_ACABAMENTO, 270, 2, 2, 0);
        Imovel zome = new Imovel("boa vista", 8, "braga", Tipo.CASA,
                Acabamento.RESTAURO, 325, 3, 2, 50);

        System.out.println(remax.valorImovel());
        remax.setAcabamento(Acabamento.NOVA);
        System.out.println(remax.valorImovel());
        //remax.imprimirDescricao();
        if (remax.compararImoveis(zome) == null) {
            System.out.println("Os 2 imóveis têm o mesmo preço: " + remax.valorImovel());
        } else {
            System.out.println("O imóvel mais caro com preço final: "
                    + (remax.compararImoveis(zome)).valorImovel() + " é:");
            (remax.compararImoveis(zome)).imprimirDescricao();
        }
    }
}
