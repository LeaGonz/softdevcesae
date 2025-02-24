//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws InterruptedException {
        UserSessionManager sessionManager = UserSessionManager.getInstance();

        System.out.println("Token de Acesso: "+ sessionManager.getSessionToken());
        System.out.println("Último Acesso: "+ sessionManager.getLastAccess());

        Thread.sleep(5000);
        sessionManager.updateLastAccessTime();

        System.out.println("Token de Acesso: "+ sessionManager.getSessionToken());
        System.out.println("Último Acesso: "+ sessionManager.getLastAccess());
    }
}