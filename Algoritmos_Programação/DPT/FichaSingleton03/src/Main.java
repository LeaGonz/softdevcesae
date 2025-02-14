//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        UserSessionManager sessionManager = UserSessionManager.getInstance();
        System.out.println("Token de Acesso: "+ sessionManager.getSessionToken());
        System.out.println("Último Acesso: "+ sessionManager.getLastAccess());

        sessionManager.updateLastAccessTime();

        System.out.println("Token de Acesso: "+ sessionManager.getSessionToken());
        System.out.println("Último Acesso: "+ sessionManager.getLastAccess());
    }
}