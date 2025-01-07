package Ex_02;

public class Main {
    public static void main(String[] args) {
        Cao cao1 = new Cao("Pelambre", "Puddle");
        Cao cao2 = new Cao("Shaerok", "Golden");
        Cao cao3 = new Cao("Paco", "Labrador");

        System.out.println(cao1.getNome());
        System.out.println(cao1.getRaca());
        System.out.println(cao1.getLatido());
        System.out.println();
        System.out.println(cao2.getNome());
        System.out.println(cao2.getRaca());
        System.out.println(cao2.getLatido());
        System.out.println();
        System.out.println(cao3.getNome());
        System.out.println(cao3.getRaca());
        System.out.println(cao3.getLatido());
        System.out.println();

        cao1.setLatido("Woof woof");

        System.out.println(cao1.getNome());
        System.out.println(cao1.getRaca());
        System.out.println(cao1.getLatido());
        System.out.println();
        System.out.println(cao2.getNome());
        System.out.println(cao2.getRaca());
        System.out.println(cao2.getLatido());
        System.out.println();
        System.out.println(cao3.getNome());
        System.out.println(cao3.getRaca());
        System.out.println(cao3.getLatido());
        System.out.println();
    }
}
