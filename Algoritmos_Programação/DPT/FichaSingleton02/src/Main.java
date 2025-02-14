//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Logger log = Logger.Logger("application_log.txt");
        Logger log2 = Logger.Logger("programa_log.txt");

        log.log("Mensagem de log 1");
        log.log("Mensagem de log 2");
        log.log("Mensagem de log 3");
        log.log("Mensagem de log 4");
        log.log("Mensagem de log 5");

        log2.log("Mensagem de log 1");
        log2.log("Mensagem de log 2");
        log2.log("Mensagem de log 3");
        log2.log("Mensagem de log 4");
        log2.log("Mensagem de log 5");
    }
}