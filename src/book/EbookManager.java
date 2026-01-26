package book;

import java.util.List;
import java.util.Scanner;

public class EbookManager{
    
    
    public static void  createEbook(List<Book> books, Scanner sc){
        String title = "";
        
        BookManager.chooseBookTitle(books, sc, title);
        
        System.out.println("Digite o nome do autor");
        String author = sc.nextLine();
        
        System.out.println("Digite o isbn do livro");
        String isbn = sc.nextLine();
        
        books.add(new Ebook(title, author, isbn));
    }
    
    
    
    
    public static void createdEbooks(List<Book> books){
        books.add(new Ebook("Morangos mofados", "Cario Fernando de Abreu", "978-92-34567-11-4"));
        books.add(new Ebook("Analysis 1", "Terence Tao", "978-0-596-52068-7"));
        books.add(new Ebook("Um defeito de cor", "Ana Maria Gonçalves", "978-65-99812-33-1"));
        
    }
    
    
}
