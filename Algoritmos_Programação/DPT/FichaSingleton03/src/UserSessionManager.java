import java.util.Random;

public class UserSessionManager {
    private static UserSessionManager instance;
    private int sessionToken;
    private String lastAccess;

    private UserSessionManager(String lastAccess) {
        Random rnd = new Random();
        this.sessionToken = rnd.nextInt();
        this.lastAccess = lastAccess;
    }

    public static UserSessionManager getInstance() {
        if (instance == null) instance = new UserSessionManager(System.currentTimeMillis());
        return instance;
    }
}
