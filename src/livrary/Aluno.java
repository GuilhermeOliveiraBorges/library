package livrary;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class Aluno{
    private String login;
    private String password;
    private List<Book> books;
    
    
    //imports
    Scanner sc = new Scanner(System.in);
    Book book = new Book("","","","");
    
    //contructors
    public Aluno(){
        
    }
    
    public Aluno(String login, String password){
        this.login = login;
        this.password = password;
        this.books = new ArrayList<>();
    }

   
    //getters and setters methods

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
    
    public List<Book> getBooks(){
        return this.books;
    }
    
    //specific methods
     public void addBook(List<Book> bks){
        getBooks();
        Book book = new Book();
        System.out.println("Escreva o titulo do livro que deseja: ");
        String title = sc.nextLine();
        
        //criação da biblioteca
        
        //booleano de verificação
        boolean verificarStatus= true;
        boolean verificarLivro = true;
        
        for(int i=0; i< bks.size(); i++){
            
            //verificando se o livro está na biblioteca
            if(title.equals(bks.get(i).getTitle())){
                //verificando se o livro está disponível
                if(bks.get(i).isStatus()){
                    //adicionando livro a sua biblioteca
                    this.books.add(bks.get(i));
                    //alterando o statuso do livro para falso
                    bks.get(i).setStatus(false);
                    //exibindo mensagem de sucesso
                    System.out.println("O livro " + bks.get(i).getTitle() + " de " + bks.get(i).getAuthor() + " foi adicionado a sua biblioteca");
                    verificarStatus = false;
                }
            verificarLivro = false;    
            }    
        }
        
        //caso não haja livro
        if(verificarLivro){
            System.out.println("O livro não está na biblioteca");
        }
        //caso esteja indisponível
        else if(verificarStatus){
            System.out.println("O livro já foi emprestado");
        }
    }
    
    public void returnBook(){
        System.out.println("Escreva o nome do livro que quer devolver");
        String name = sc.nextLine();
        
        //boolean de verificação 
        boolean verificarLivro = true;
        
        //teste de cada um dos livros da biblioteca do aluno
        for(int i =0; i < this.books.size(); i++){
            
            //verificando se o livro pertence a biblioteca do aluno
            if(name.equals(books.get(i).getTitle())){
                //trocando os status para true
                books.get(i).setStatus(true);
                
                //exibindo que o livro foi devolvido
                System.out.println("O livro " + books.get(i).getTitle() + " de " + books.get(i).getAuthor() + " foi removido da sua biblioteca");
                
                //devolvendo livro para a biblioteca
                books.remove(i);
                
                //Afirmando que o livro pertence a sua bilioteca
                verificarLivro = false;
            }
            
        }
        
        //caso o livro não pertença a biblioteca
        if(verificarLivro){
            System.out.println("O livro não pertence a sua biblioteca");
        }
    }
     
    public void listBooks(List <Book> books){
        if(books.size()>0){
            System.out.println("------LIVROS------");
            for(Book b: books){
                System.out.println(b.getTitle() + ", " + b.getAuthor() + ";");
            }
        }else{
            System.out.println("Você não possui livros em sua biblioteca");
        }
    }
     
    public void studentLayout(){
        Scanner sca = new Scanner(System.in);
        int esc;
        do{
            System.out.println("\nEscolha: \n1-Adicionar livro \n2-Devolver livro \n3-Listar livros \n4- Voltar");
            esc = sca.nextInt();
            
            if(esc == 1){
                addBook(Main.listBook);
            }else if(esc ==2){
                returnBook();
            }else if(esc ==3){
                listBooks(this.books);
            }else if(esc==4){
            }else{
                System.out.println("Escolha um valor válido");
            }    
        }while(esc!=4);
    }
    
    public String toString(){
        return this.login + ", " + password+";";
    }
    
}
