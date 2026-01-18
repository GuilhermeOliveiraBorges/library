package livrary;

import java.util.List;
import java.util.Scanner;


public class PhysicalBook extends Book{
    private int quantity;

    public PhysicalBook(){
        
    }
    
    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    
    @Override
    public void createBook(List<Book> book){
        //variaveis de titulo, autor e isbn
        String title, author, isbn, type;
        
        Scanner sc = new Scanner(System.in);
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
    
    
}
