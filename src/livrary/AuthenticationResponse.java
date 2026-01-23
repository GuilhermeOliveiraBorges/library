package livrary;
import java.util.Optional;

public class AuthenticationResponse {
    private boolean isSucefull;
    private String message;
    private Optional<User> user;

    public boolean isIsSucefull() {
        return isSucefull;
    }

    public void setIsSucefull(boolean isSucefull) {
        this.isSucefull = isSucefull;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Optional<User> getUser() {
        return user;
    }

    public void setUser(Optional<User> user) {
        this.user = user;
    }
    
    
    
    AuthenticationResponse(boolean isSucefull, String message, Optional<User> user){
        this.isSucefull = isSucefull;
        this.message = message;
        this.user = user;
    }
}
