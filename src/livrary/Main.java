package livrary;

import java.util.List;
import java.util.Scanner;
import java.util.Optional;

public class Main {
    
    static List<User> listUsers;
    
    
    public static void passwordSystem(){
        Scanner sc = new Scanner(System.in);
        
        Optional<User> user;
        user = Optional.empty();
        
        AuthenticationResponse aut;
        
        System.out.println("Escreva seu login");
        String login = sc.nextLine();
        System.out.println("Escreva sua senha");
        String password = sc.nextLine();
        
        aut = Authenticate.authenticate(listUsers, login, password);
        
        System.out.println(aut.getMessage());
    }
    
    public static void passwordLoop(){
        Scanner sc = new Scanner(System.in);
        
        listUsers = User.createdUsers();
        int esc;
        do{
            System.out.println("Escolha \n1- entrar \n2-fechar");
            esc = sc.nextInt();
            if(esc==1) passwordSystem();
        }while(esc !=2);
        
        sc.close();
    }
    
    public static void main(String[] args) {
       ;
    }
    
}
