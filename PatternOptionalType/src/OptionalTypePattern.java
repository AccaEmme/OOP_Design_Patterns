import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

class Book {
    private int id;
    private String title;

    public Book(int id, String title) {
        this.id = id;
        this.title = title;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}



class BookDB {
    private List<Book> books;

    public BookDB() {
        this.books = new ArrayList<>();
    }

    // il metodo optional entra in gioco quando posso ritornare o meno un valore
    public Optional<Book> getBookById(int id){
        for (Book book : books)
            if (book.getId() == id){
                return Optional.of(book);
            }
        return Optional.empty();
    }

    public void add(Book book) {
        books.add(book);
    }
}

public class OptionalTypePattern {
    public static void main(String[] args) {
        BookDB booksArchive = new BookDB();
        // se il libro cercato viene trovato, si ritorna un optional "pieno" altrimenti uno vuoto
        booksArchive.add(new Book(2,"titolo libro"));

        /** shit example from Internet
        if (booksArchive.getBookById(2).isEmpty()){
            System.out.println("no book found");
        }
        else
        	System.out.println("book found");
        */
        
        
        // @AccaEmme personal example below:
        Optional<Book> b = booksArchive.getBookById(1);
        try {
        	System.out.println( b.orElseThrow().getTitle() );
        } catch(Exception e) {
        	System.out.println( "Libro non presente" );
        }
    }
}
