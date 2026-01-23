package Books;

import Books.Book;
import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;

public class PhysicalBook extends Book{
    private int quantity;

    public PhysicalBook(){
        
    }
    
    public PhysicalBook(String title, String author, String isbn, int quantity){
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.quantity = quantity;
        if(quantity <= 0) this.status = false;
        if(quantity > 0) this.status = true;
    }
    
    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    
    
    
    public void createBooks(List<PhysicalBook> books){
        //variaveis de titulo, autor e isbn
        String title, author, isbn, type;
        int quantity;
        
        Scanner sc = new Scanner(System.in);
        
        System.out.println("\nDigite o nome do livro");
        title = sc.nextLine();
        
        System.out.println("Digite o nome do autor");
        author = sc.nextLine();
        
        System.out.println("Digite o isbn");
        isbn = sc.nextLine();
        
        System.out.println("Digite a quantidade de livros");
        quantity = sc.nextInt();
        
        books.add(new PhysicalBook(title, author, isbn, quantity));
    }
    
    public static List<PhysicalBook> createdPhysicalBooks(){
        List<PhysicalBook> books = new ArrayList<>();
        
        books.add(new PhysicalBook("calculus", "michael spivak", "978-65-83421-47-2", 2));
        books.add(new PhysicalBook("Ensaio sobre a cegueira", "José Saramago", "978-85-91234-08-9", 3));
        books.add(new PhysicalBook("Topology", "Munkres", "978-1-4028-9462-6", 1));
        
        return books;
    }
}
