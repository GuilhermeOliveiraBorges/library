package livrary;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class User {
    protected String login, password;

    static List<Aluno> studentList = new ArrayList<>();
    static List<Book> bookList = new ArrayList<>();
    
    
    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    
    public static void passwordLoop(){
        int choose;
        Scanner scanner = new Scanner(System.in);
        bookList=Book.createdBooks();
        //student = new Aluno();
        
        try{
            do{
                System.out.println("\nIniciando programa... \n1-Entrar \n2-Fechar");
                choose=scanner.nextInt();
                
                if(choose == 1){
                    passwordSystem();
                }else if (choose > 2){
                    System.out.println("Escolha um dos valores exibidos");
                }
            }while(choose != 2);
        }
        catch(InputMismatchException error){
            System.out.println("Digite apenas números");
             
        }
    }    
    
    
    public static void passwordSystem(){
       
            //instanciando pre requisitos
            Scanner sc = new Scanner(System.in);
        
            Adm adm =new Adm("Adm","0000");
            Book book = new Book("","","","");
            
            //chamada de login e senha
            System.out.println("\nDigite o seu login:");
            String login = sc.nextLine();
            System.out.println("Digite sua senha:");
            String password = sc.nextLine();
        
            //booleano de verificação
            boolean verificarLogin = true;
            boolean verificarPassword = true;
            
            //acesso ao administrador
            if(login.equals(adm.getLogin())){
                verificarLogin=false;
                if(password.equals(adm.getPassword())){
                    verificarPassword=false;
                    adm.admLayout(studentList, bookList);
                }
            }
        
            //acesso ao usuário
            //testando cada usuário da lista
            for(int i=0; i<studentList.size(); i++){
                //verificando cada login de usuário
                if(login.equals(studentList.get(i).getLogin())){
                    
                    //verificando cada senha de usuário
                    verificarLogin=false;
                    if(password.equals(studentList.get(i).getPassword())){
                        verificarPassword=false;
                        studentList.get(i).studentLayout();
                        break;
                    }
                }
            }
        
            //caso o usuário nao seja encontrado
            if(verificarLogin){
                System.out.println("Usuário não encontrado");
            }else if(verificarPassword){
                System.out.println("Senha invalida");
            }
            
    }
}
