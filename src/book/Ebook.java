package book;

import book.Book;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Ebook extends Book{
    
    
    public Ebook(String title, String author, String isbn){
        super(title,author,isbn);
    }
    
    
    public static void  createEbook(List<Book> books, Scanner sc){
        String title;
        
        do{
            System.out.println("\nDigite o nome do livro");
            title = sc.nextLine();
            if(BookManager.compareTitle(books, title)){
                System.out.println("Este exempar já pertence a biblioteca");
            }
        }while(BookManager.compareTitle(books, title));
            
            
        System.out.println("Digite o nome do autor");
        String author = sc.nextLine();
        
        System.out.println("Digite o isbn");
        String isbn = sc.nextLine();
        
        books.add(new Ebook(title, author, isbn));
    }
    
    public static List<Book> createdEbooks(List<Book> books){
        books.add(new Ebook("Morangos mofados", "Cario Fernando de Abreu", "978-92-34567-11-4"));
        books.add(new Ebook("Analysis 1", "Terence Tao", "978-0-596-52068-7"));
        books.add(new Ebook("Um defeito de cor", "Ana Maria Gonçalves", "978-65-99812-33-1"));
        
        return books;
    }
    /*
    public void createEbook(List<Ebook> book){
        //variaveis de titulo, autor e isbn
        String title, author, isbn, type;
        
        Scanner sc = new Scanner(System.in);
       
        System.out.println("\nDigite o nome do livro");
        title = sc.nextLine();
        
        System.out.println("Digite o nome do autor");
        author = sc.nextLine();
        
        System.out.println("Digite o isbn");
        isbn = sc.nextLine();
        
        //alterar parametros dos construtores!!!!!
        book.add(new Ebook());
    }
    
    public static List<Ebook> createdEbooks(){
        List<Ebook> ebooks = new ArrayList<>();
        
        ebooks.add(new Ebook("Morangos mofados", "Cario Fernando de Abreu", "978-92-34567-11-4"));
        ebooks.add(new Ebook("Analysis 1", "Terence Tao", "978-0-596-52068-7"));
        ebooks.add(new Ebook("Um defeito de cor", "Ana Maria Gonçalves", "978-65-99812-33-1"));
        
        return ebooks;
    }*/
    
}
