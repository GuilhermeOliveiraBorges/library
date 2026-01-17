package livrary;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class Main {
    
    static List<Aluno> listStudent = new ArrayList<>();
    static List<Book> listBook = new ArrayList<>();
    //static Aluno student;    
            
    
    public static void passwordLoop(){
        int choose;
        Scanner scanner = new Scanner(System.in);
        listBook=Book.createdBooks();
        //student = new Aluno();
        
            do{
                System.out.println("\nIniciando programa... \n1-Entrar \n2-Fechar");
                choose=scanner.nextInt();
                
                if(choose==1){
                    passwordSystem();
                }else if (choose>2){
                    System.out.println("Escolha um dos valores exibidos");
                }
            }while(choose!=2);
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
                    adm.admLayout(listStudent, listBook);
                }
            }
        
            //acesso ao usuário
            //testando cada usuário da lista
            for(int i=0; i<listStudent.size(); i++){
                //verificando cada login de usuário
                if(login.equals(listStudent.get(i).getLogin())){
                    
                    //verificando cada senha de usuário
                    verificarLogin=false;
                    if(password.equals(listStudent.get(i).getPassword())){
                        verificarPassword=false;
                        listStudent.get(i).studentLayout();
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
    
    
    public static void main(String[] args) {
        passwordLoop();
    }
}
