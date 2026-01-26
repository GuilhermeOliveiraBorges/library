package book;

import java.util.List;
import java.util.Scanner;
import java.util.Optional;

public class BookManager {
    
    
    public static <T extends Book> boolean compareTitle(List <T> booksList, String newTitle){
        
        Optional<T> optionalBookFromList = booksList.stream().filter(book -> book.getTitle().equals(newTitle)).findAny();
        
        Book bookFromList = optionalBookFromList.get();
        
        String bookTitle = bookFromList.getTitle();
        
        return bookTitle.equals(newTitle);
    }
    
    
    
    public static <T extends Book> void chooseBookTitle(List<T> books, Scanner sc, String title){
        
        do{
            System.out.println("\nDigite o nome do livro");
            title = sc.nextLine();
            if(BookManager.compareTitle(books, title)){
                System.out.println("Este exemplar já pertence a biblioteca");
            }
        }while(BookManager.compareTitle(books, title));
        
    }
    
    public static void removeBook(List<Book> books, Scanner sc){
        
        System.out.print("Escreva o titulo do livro que deseja remover: ");
        String title = sc.nextLine();
        
        if(compareTitle(books, title)){
            
            Book bookFromList = books.stream().filter(book -> book.getTitle().equals(title)).findFirst().get();
            books.remove(bookFromList);
            
            System.out.println(title + " foi removido da biblioteca");
            
        }else{
            System.out.println("O livro não se encontra na biblioteca");
        }
    }
    
    
    public static void listBooks(List<Book> books){
        for(Book bookFromList: books){
            System.out.println(bookFromList);
        }
    }
    
    public static void searchBook(List<Book> books, Scanner sc){
        String title;
        System.out.print("Escreva o titulo do livro que deseja encontrar: ");
        title = sc.nextLine();
        
        if(compareTitle(books, title)){
            Book book = books.stream().filter(bookFromList -> bookFromList.getTitle().equals(title)).findAny().get();
            System.out.println(book);
        }else{
            System.out.println("O livro não se encontra na biblioteca");
        }
    }
}