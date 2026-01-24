package book;

import java.util.List;
import java.util.Scanner;
import java.util.Optional;

public class BookManager {
    
    public void createBook(List<Book> booksList, Scanner sc){
        
    }
    
    public static boolean compareTitle(List <Book> booksList, String newTitle){
        
        Optional<Book> optionalBookFromList = booksList.stream().filter(book -> book.getTitle().equals(newTitle)).findAny();
        
        Book bookFromList = optionalBookFromList.get();
        
        String bookTitle = bookFromList.getTitle();
        
        return bookTitle.equals(newTitle);
    }
}
