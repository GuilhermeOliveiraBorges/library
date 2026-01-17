package livrary;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Adm{
    protected String login="Adm";
    protected String password = "0000";
    
    //possível erro!!!!!
    Book book = new Book();
    
    //constructors
    public Adm(){
        
    }
    public Adm(String login, String password){
        this.login = login;
        this.password=password;
    }
    
    //getters and setters

    public Aluno createStudent(){
        //importação do scanner
        Scanner sc = new Scanner(System.in);
        System.out.println("\nDigite o login");
        String login = sc.nextLine();
        System.out.println("Digite a senha");
        String password = sc.nextLine();
        return new Aluno(login, password);
    }
    
    
    public static List<Aluno> createdStudents(){
        //iniciaçao do List
        List<Aluno> studentList = new ArrayList<>();
        
        //adicionando usuarios em List
        studentList.add(new Aluno("Maria", "1111"));
        studentList.add(new Aluno("Pedro", "2222"));
        studentList.add(new Aluno("Roberto", "3333"));
        studentList.add(new Aluno("Priscila", "4444"));
        studentList.add(new Aluno("Claudio", "5555"));
        //retorno dos usuarios
        return studentList;
    }
    
    public void verificarNome(List<Aluno> list){
        //iniciação de Scanner e da lista
        Scanner sc = new Scanner(System.in);
        
        //variavel de verificação
        String login;
        //Exibição de escrever o nome
        System.out.println("\nEscreva o login que quer encontrar:");
        //valor da verificação pelo Scanner
        login = sc.nextLine();
        //booleano de verificação
        boolean verificarStu = true;
        //teste em cada aluno da lista
        for(int i=0; i<list.size(); i++){
            if(login.equals(list.get(i).getLogin())){
                verificarStu=false;
                System.out.println("\nAqui está o perfil de " + list.get(i).getLogin()+ ":");
                System.out.println(list.get(i));
                break;
            }
        }
        //caso o aluno seja não haja Aluno com este login
        if(verificarStu){
            System.out.println("Não há um usuario com este login");
        }
    }
    
    public void removeStudent(List<Aluno> list){
        //iniciação de Scanner e da lista
        Scanner sc = new Scanner(System.in);
      
        //variavel de verificação
        boolean verificar = true;
        //Exibição de escrever o nome
        System.out.println("\nEscreva o login de quem quer remover:");
        //valor da verificação pelo Scanner
        String login = sc.nextLine();
        //teste de todos os elementos da lista
        for(int i=0; i<list.size(); i++){
            //verificando se há alguem com o nome escrito
            if(login.equals(list.get(i).getLogin())){
                verificar = false;
                System.out.println("O usuário" + list.get(i).getLogin() + " foi removido");
                list.remove(i);
                break;
            }
        }
        
        //ações com a verificação
        if(verificar){
            System.out.println("Usuário não encontrado");
        }
    }
    
    public void listStudent(List<Aluno> listAl){
        for(Aluno stu: listAl){
            System.out.println(stu);
        }
    }
    
    public void admLayoutStudent(List<Aluno> listAl){
        Scanner sc = new Scanner(System.in);
        int esc;
        
        do{
            System.out.println("\nEscolha: \n1-Criar usuário \n2-Remover usuário \n3-Listar usuários \n4-Procurar usuário \n5-Voltar");
            esc = sc.nextInt();
            if(esc==1){
                //crando novo usuário
                listAl.add(createStudent());
            }else if(esc==2){
                //removendo usuário da lista
                removeStudent(listAl);
            }else if(esc==3){
                //listando usuarios da lista
                listStudent(listAl);
            }else if(esc==4){
                //verificando se o login pertence a algum usuário da lista
                verificarNome(listAl);
            }else if(esc==5){
            }else{
                System.out.println("Escolha um dos valores exibidos");
            }
            
        }while(esc!=5);
    }
    
    public void admLayoutBook(List<Book> listBook){
        Scanner sc = new Scanner(System.in);
        Book book = new Book("","","","");
        int esc;
        
        do{
            System.out.println("\nEscolha: \n1-Adicionar livro a biblioteca\n2-Remover livro da biblioteca \n3-Listar livros \n4-Procurar livro \n5-Voltar");
            esc = sc.nextInt();
            if(esc==1){
                book.createBook(listBook);
            }else if(esc==2){
                book.removeBook(listBook);
            }else if(esc==3){
                book.listBooks(listBook);
            }else if(esc==4){
                book.searchBook(listBook);
            }else if(esc==5){}
            else if(esc>5){
                System.out.println("Escolha um dos valores exibidos");
            }
            
        }while(esc!=5);
    }
    
    public void admLayout(List<Aluno> listStudent, List<Book> listBook){
        int escolha;
        Scanner sc = new Scanner(System.in);
        
        System.out.println("\nSeja bem vindo a área de administrador!");
        
        do{
            System.out.println("\nEscolha a biblioteca que deseja gerenciar");
            System.out.println("1- Gerenciar Usuário");
            System.out.println("2- Gerenciar biblioteca");
            System.out.println("3- Voltar");
            escolha =sc.nextInt();
            if(escolha==1){
                admLayoutStudent(listStudent);
            }else if(escolha==2){
                admLayoutBook(listBook);
            }else if(escolha==3){
                
            }else{
                System.out.println("Escolha um dos valores exibidos");
            }
        }while(escolha!=3);
    }
    
    public String toString(){
        return login + ", " + password;
    }
    
    //setters and getters
    public String getLogin(){
        return this.login;
    }
    public void setLogin(String l){
        this.login=l;
    }
    public String getPassword(){
        return this.password;
    }
    public void setPassword(String password){
        this.password = password;
    }
}