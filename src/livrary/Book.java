package livrary;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class Book {
    private String title, author, type;
    private boolean status;
    private String isbn;
    
    //importação do Scanner 
    Scanner sc = new Scanner(System.in);
    //constructors
    Book(){
        
    }
    
    Book(String title, String author, String type, String isbn){
        this.title=title;
        this.author = author;
        this.isbn = isbn;
        this.status = true;
        this.type=type;
    }
    Book(String title, String author, String type, boolean status, String isbn){
        this.title=title;
        this.author = author;
        this.type=type;
        this.status=status;
        this.isbn = isbn;
    }
    //importação da lista
    List<Book> list = new ArrayList<>();
    //getters and setters methods

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public boolean isStatus() {
        return this.status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }
    
    //especific methods
    public void createBook(List<Book> book){
        //variaveis de titulo, autor e isbn
        String title, author, isbn, type;
        System.out.println("\nDigite o nome do livro");
        title = sc.nextLine();
        System.out.println("Digite o nome do autor");
        author = sc.nextLine();
        System.out.println("Digite o tipo do livro");
        type = sc.nextLine();
        System.out.println("Digite o isbn");
        isbn = sc.nextLine();
        book.add(new Book(title, author, type, isbn));
    }
    
    public static List<Book> createdBooks(){
        List<Book> books = new ArrayList<>();
        books.add(new Book("calculus", "michael spivak", "Físico", "978-65-83421-47-2"));
        books.add(new Book("Ensaio sobre a cegueira", "José Saramago", "Físico", "978-85-91234-08-9"));
        books.add(new Book("Topology", "Munkres", "Físico", "978-1-4028-9462-6"));
        books.add(new Book("Morangos mofados","Cario Fernando de Abreu","Físico","978-92-34567-11-4"));
        books.add(new Book("Analysis 1","Terence Tao","Físico","978-0-596-52068-7"));
        books.add(new Book("Um defeito de cor","Ana Maria Gonçalves","Físico","978-65-99812-33-1"));
        return books;
    }
    
    public void removeBook(List<Book> book){
        //String que chamará o nome do livro
        String titulo;
        System.out.println("Escreva o titulo do livro que voce quer remover");
        //digitação do título
        titulo = sc.nextLine();
        //boolean de verificação
        boolean ver = true;
        
        //verificação se o livro digitado pertence a biblioteca
        for(int i=0; i<book.size(); i++){
            if(titulo.equals(book.get(i).getTitle())){
                ver = false;
                System.out.println(book.get(i).getTitle() + " foi removido");
                book.remove(i);
            }
        }
        //se o livro não pertencer, o método que deve ser exibido
        if(ver){
            System.out.println("Livro não encontrado");
        }
    }
    
    
    public void searchBook(List<Book> book){
        //String que chamará o nome do livro
        String titulo;
        System.out.println("\nEscreva o titulo do livro que voce quer encontrar");
        //digitação do título
        titulo = sc.nextLine();
        //boolean de verificação
        boolean ver = true;
        
        //verificação se o titulo digitado pertence a biblioteca
        for(int i=0; i<book.size(); i++){
            if(titulo.equals(book.get(i).getTitle())){
                ver = false;
                System.out.println("\nAqui está o livro que procura encontrar");
                System.out.println(book.get(i));
            }
        }
        //se o livro não pertencer, o método que deve ser exibido
        if(ver){
            System.out.println("Livro não encontrado");
        }
    }
    
    public void listBooks(List<Book> book){
        if(book.size()>0){
            System.out.println("\n----- LIVROS -----");
            for(Book b: book){
             System.out.println(b);
            }
        }else{
            System.out.println("Ainda não há livros na sua biblioteca");
        }
    }
    
    @Override
    public String toString(){
        return title + ", " + author + ", " + type +", " + isbn + ", status: " + status;
    }
}
