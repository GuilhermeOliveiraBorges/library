package book;

import java.util.List;
import java.util.Scanner;

public class EbookManager{
    
    
    public static void  createEbook(List<Book> books, Scanner sc){
        t
        
        System.out.println("Digite o nome do autor");
        String author = sc.nextLine();
        
        System.out.println("Digite o isbn");
        String isbn = sc.nextLine();
        
        books.add(new Ebook(title, author, isbn));
    }
    
    public static void chooseTitle(List<Book> books, Scanner sc, String title){
        
        do{
            System.out.println("\nDigite o nome do livro");
            title = sc.nextLine();
            if(BookManager.compareTitle(books, title)){
                System.out.println("Este exemplar já pertence a biblioteca");
            }
        }while(BookManager.compareTitle(books, title));
        
    }
}
