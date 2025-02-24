import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Logger {
    private static Logger instance;
    private String nomeFicheiro;

    private Logger(String nomeFicheiro) {
        this.nomeFicheiro = nomeFicheiro;
    }

    public static Logger getInstance(String nomeFicheiro) {
        if (instance == null)
            instance = new Logger(nomeFicheiro);
        return instance;
    }

    public void log(String msg) throws IOException {
        //Metodo 1 para escrever no fichiero
        /*try {
            File ficheiro = new File(nomeFicheiro);

            if (!ficheiro.exists()) ficheiro.createNewFile();

            BufferedWriter bw = new BufferedWriter(new FileWriter(ficheiro, true));
            bw.write(msg+"\n");
            bw.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }*/

        //Metodo 2 para escrever no fichiero
        FileWriter fw = new FileWriter((this.nomeFicheiro), true);

        fw.append(msg + "\n");

        fw.close();

    }
}
