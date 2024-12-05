import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        /*
        2. Crie uma aplicação que leia o conteúdo de dois ficheiros (a.txt e b.txt) e troque os seus conteúdos (o primeiro
            ficheiro deve ficar com o conteúdo do segundo e vice-versa.
         */
        System.out.println("Leitura e troque dos conteudos dos 2 ficheiros.");

        //Forma facil

        Path dira = Path.of("atxt.txt");
        Path dirb = Path.of("btxt.txt");
        try {
            String txta = Files.readString(dira);
            String txtb = Files.readString(dirb);
            String temp = txta;
            Files.writeString(dira, txtb);
            Files.writeString(dirb, temp);
            System.out.println("Troca feita com sucesso.");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        // Forma larga

        BufferedReader reader;
        BufferedWriter writer;
        try {
            reader = new BufferedReader(new FileReader("atxt.txt"));
            String line, temp = "";
            // ciclo temp = txt A
            while ((line = reader.readLine()) != null) {
                temp += line + " ";
            }
            reader.close();
            // ciclo escritura A = B
            writer = new BufferedWriter(new FileWriter("atxt.txt"));
            reader = new BufferedReader(new FileReader("btxt.txt"));
            while ((line = reader.readLine()) != null) {
                writer.write(line);
                writer.newLine();
            }
            reader.close();
            writer.close();
            // ciclo escritura B = A (temp)
            writer = new BufferedWriter(new FileWriter("btxt.txt"));
            writer.write(temp);
            writer.close();

            System.out.println("Troca feita com sucesso.");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }
}