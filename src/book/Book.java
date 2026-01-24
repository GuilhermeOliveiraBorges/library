package book;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Book {
    protected String title, author, type;
    protected boolean status;
    protected String isbn;
    
    //constructors
    Book(String title, String author, String isbn){
        this.title=title;
        this.author = author;
        this.isbn = isbn;
        this.status = true;
        
    }
    
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
    
    /*
    
    public void typeBook(List<Ebook> ebooks, List<PhysicalBook> books){
        Scanner sc = new Scanner(System.in);
        
        TypeBook typeEbook = TypeBook.EBOOK;
        TypeBook typeFisico = TypeBook.FISICO;
        
        Ebook ebook = new Ebook();
        PhysicalBook fisico = new PhysicalBook();
        
        String ebookName = typeEbook.toString();
        String fisicoName = typeFisico.toString();
        
        
        do{
            System.out.println("Selecione o tipo do livro");
            type = sc.nextLine();
            
            if(type.equalsIgnoreCase(ebookName)) ebook.createEbook(ebooks);
            if(type.equalsIgnoreCase(fisicoName)) fisico.createBooks(books);
            if(!type.equalsIgnoreCase(fisicoName) && !type.equalsIgnoreCase(ebookName)) System.out.println("Escolha entre fisico e ebook");
       }while(!type.equalsIgnoreCase(fisicoName) && !type.equalsIgnoreCase(ebookName));
        
    }
    
    public void layoutBook(List<Ebook> ebooks, List<PhysicalBook> books){
        Scanner sc = new Scanner(System.in);
        int esc;
            do{
                System.out.println("\nEscolha: \n1-Adicionar livro a biblioteca\n2-Remover livro da biblioteca \n3-Listar livros \n4-Procurar livro \n5-Voltar");
                esc = sc.nextInt();
                if(esc == 1) typeBook(ebooks, books);
                if(esc == 2) removeBook(listBook);
                if(esc == 3) listBooks(listBook);
                if(esc == 4) searchBook(listBook);
                if(esc > 5) System.out.println("Escolha um dos valores exibidos");
            }while(esc!=5);
            
    }
    
    public void removeBook(List<Ebook> ebooks, List<PhysicalBook> books){
        Scanner sc = new Scanner(System.in);
        String titulo;
        
        System.out.println("Digite o titulo do livro que quer remover");
        titulo = sc.nextLine();
        
        ebooks.stream()
        .filter(b -> b.title.equals(titulo))
        .forEach(b -> ebooks.remove(b));
        
        
        
        Optional<PhysicalBook> book = books.stream()
                .filter(b -> b.title.equals(titulo))
                .findFirst();
        
        
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
    */
}
