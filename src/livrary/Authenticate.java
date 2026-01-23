package livrary;

import java.util.Optional;
import java.util.List;

public class Authenticate {
    
    public static AuthenticationResponse authenticate(List<User> users, String login, String password){
        
        Optional<User> user = users.stream()
                .filter(u -> u.getLogin().equals(login))
                .findFirst();
        
        if(user.isPresent()){
            if(user.get().getPassword().equals(password)){
                return new AuthenticationResponse(true, "Seja bem vindo", user);
            }else{
                user = Optional.empty();
                return new AuthenticationResponse(false, "Senha invalida", user);
            }
        }
        return new AuthenticationResponse(false, "Usuário não existe", user);
        
    }
    
    
}
