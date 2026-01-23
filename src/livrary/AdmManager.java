package livrary;

import java.util.Scanner;
import java.util.List;
import java.util.Optional;
import java.util.ArrayList;
import java.util.InputMismatchException;

public class AdmManager {
    
    
    public static void createUser(List<User> listUsers, Scanner sc){
        
        System.out.print("Escreva o novo login: ");
        String login = sc.nextLine();
        System.out.print("Escreva a nova senha: ");
        String password = sc.nextLine();
        
        listUsers.add(new User(login, password));
        System.out.println(login + " foi adicionado a lista de usuarios.");
    }
    
    public static void removeUser(List<User> usersList, Scanner sc){
        System.out.print("Escreva o login do usuário que deseja remover: ");
        String login = sc.nextLine();
        
        Optional<User> userFromList = usersList.stream().filter(user -> user.getLogin().equalsIgnoreCase(login)).findAny();
        
        if(userFromList.isPresent()){
            usersList.remove(userFromList.get());
            System.out.println(login + " foi removido da lista.");
        }
        else{
            System.out.println("O usuário não pertence a lista");
        }
    }
    
    public static void listUsers(List<User> usersList){
        System.out.println("---------- USERS ----------");
        
        for(int userIndex = 0; userIndex < usersList.size(); userIndex++){
            System.out.println(usersList.get(userIndex));
        }
        
        System.out.println("----------------------");
    }
    
    public static void searchUser(List<User> usersList, Scanner sc){
        System.out.print("Digite o login do usuário que quer encontrar: ");
        String login = sc.nextLine();
        
        Optional<User> userFromList = usersList.stream().filter(user -> user.getLogin().equalsIgnoreCase(login)).findAny();
        
        if(userFromList.isPresent()){
            System.out.println(userFromList.get());
        }
        else{
            System.out.println("Não há usuario com este login na lista.");
        }
    }
    
    public static void admLoop(List<User> usersList, Scanner sc){
    int choose;
    
        try{
            
            do{
                System.out.println("\nEscolha: \n1-Criar usuário \n2-Remover usuário \n3-Listar usuários \n4-Procurar usuário \n5-Voltar");
                choose = sc.nextInt();
                if(choose == 1) AdmManager.createUser(usersList, sc);
                if(choose == 2) AdmManager.removeUser(usersList, sc);
                if(choose == 3) AdmManager.listUsers(usersList);
                if(choose == 4) AdmManager.searchUser(usersList, sc);
                if(choose > 5) System.out.println("Escolha um dos valores mencionados");
            }while(choose != 5);
            
        }catch(InputMismatchException error){
            System.out.println("digite apenas numeros");
        }
    }
}
