package livrary;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class Book {
    protected String title, author, type;
    protected boolean status;
    protected String isbn;
    
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
    
    Book(String title, String author, String isbn){
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.status = true;
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
        
        Scanner sc = new Scanner(System.in);
       
        System.out.println("\nDigite o nome do livro");
        title = sc.nextLine();
        
        System.out.println("Digite o nome do autor");
        author = sc.nextLine();
        
        System.out.println("Digite o isbn");
        isbn = sc.nextLine();
        
        System.out.println("Digite o tipo do livro");
        type = sc.nextLine();
        
        book.add(new Book(title, author, type, isbn));
    }
    
    public void typeBook(List<Book> book){
        Scanner sc = new Scanner(System.in);
        
        TypeBook typeEbook = TypeBook.EBOOK;
        TypeBook typeFisico = TypeBook.FISICO;
        
        Ebook ebook = new Ebook();
        PhysicalBook fisico = new PhysicalBook();
        
        String ebookName = typeEbook.toString();
        String fisicoName = typeFisico.toString();
        
        String type;
        
        do{
            System.out.println("Selecione o tipo do livro");
            type = sc.nextLine();
            
            if(type.equalsIgnoreCase(ebookName)) ebook.createBook(book);
            if(type.equalsIgnoreCase(fisicoName)) fisico.createBook(book);
            if(!type.equalsIgnoreCase(fisicoName) && !type.equalsIgnoreCase(ebookName)) System.out.println("Escolha entre fisico e ebook");
       }while(!type.equalsIgnoreCase(fisicoName) && !type.equalsIgnoreCase(ebookName));
        
    }
    
    public void layoutBook(List<Book> listBook){
        Scanner sc = new Scanner(System.in);
        int esc;
            do{
                System.out.println("\nEscolha: \n1-Adicionar livro a biblioteca\n2-Remover livro da biblioteca \n3-Listar livros \n4-Procurar livro \n5-Voltar");
                esc = sc.nextInt();
                if(esc == 1) typeBook(listBook);
                if(esc == 2) removeBook(listBook);
                if(esc == 3) listBooks(listBook);
                if(esc == 4) searchBook(listBook);
                if(esc > 5) System.out.println("Escolha um dos valores exibidos");
            }while(esc!=5);
            
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
        
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Escreva o titulo do livro que voce quer remover");
        //digitação do título
        titulo = sc.nextLine();
        //boolean de verificação
        boolean isBookExist = true;
        
        //verificação se o livro digitado pertence a biblioteca
        for(int i=0; i<book.size(); i++){
            if(titulo.equals(book.get(i).getTitle())){
                isBookExist = false;
                System.out.println(book.get(i).getTitle() + " foi removido");
                book.remove(i);
            }
        }
        //se o livro não pertencer, o método que deve ser exibido
        if(isBookExist){
            System.out.println("Livro não encontrado");
        }
        
    }
    
    
    public void searchBook(List<Book> book){
        //String que chamará o nome do livro
        String titulo;
        
        Scanner sc = new Scanner(System.in);
        
        System.out.println("\nEscreva o titulo do livro que voce quer encontrar");
        //digitação do título
        titulo = sc.nextLine();
        //boolean de verificação
        boolean isBookExist = true;
        
        //verificação se o titulo digitado pertence a biblioteca
        for(int i=0; i<book.size(); i++){
            if(titulo.equals(book.get(i).getTitle())){
                isBookExist = false;
                System.out.println("\nAqui está o livro que procura encontrar");
                System.out.println(book.get(i));
            }
        }
        //se o livro não pertencer, o método que deve ser exibido
        if(isBookExist){
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
