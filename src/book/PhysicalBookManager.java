package book;

import java.util.Scanner;
import java.util.List;

public class PhysicalBookManager {
    
    public static void createPhysicalBook(List<Book> books, Scanner sc){
        
        String title = "";
        BookManager.chooseBookTitle(books, sc, title);
        
        System.out.print("Digite o nome do autor: ");
        String author = sc.nextLine();
        
        System.out.print("Digite o isbn do livro: ");
        String isbn = sc.nextLine();
        
        System.out.print("Digite a quantidade de livros que deseja adicionar: ");
        int quantity = sc.nextInt();
    }
    
    
    public static <T extends Book> void addQuantityBooksToLibrary(List<T> books, Scanner sc){
        
        System.out.println("Selecione o titulo do livro que deseja adicionar (ele deve pertencer a biblioteca)");
        String title = sc.nextLine();
        
        if(BookManager.compareTitle(books, title)){
            
            PhysicalBook book = (PhysicalBook)books.stream()
                    .filter(bookFromList -> bookFromList.getTitle().equals(title))
                    .findAny()
                    .get();
            
            System.out.print("Digite a quantidade de livros que deseja adicionar: ");
            int quantity = sc.nextInt();
            
            book.setQuantity(book.getQuantity() + quantity);
        }else{
            System.out.println("O livro não se encontra na biblioteca");
        }    
    }
       
    public void createdPhysicalBooks(List<Book> books){
        books.add(new PhysicalBook("calculus", "michael spivak", "978-65-83421-47-2", 2));
        books.add(new PhysicalBook("Ensaio sobre a cegueira", "José Saramago", "978-85-91234-08-9", 3));
        books.add(new PhysicalBook("Topology", "Munkres", "978-1-4028-9462-6", 1));
        
    }
}
