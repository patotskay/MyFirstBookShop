package pt.book;

import java.util.HashMap;
import java.util.Map;

public class BookService {

    public static Map<String, Book> books = new HashMap<>();

   static  {   books.put("murder",new Book("murder", "dontsova", 1.25, "PulpFiction",123) );
        books.put("Carrie", new Book("Carrie", "king", 5.99, "Horror",666));
        books.put("tuhless", new Book("tuhless","minaev",0.99,"Pulpfiction", 423));
        books.put("The Iron Heel", new Book("The Iron Heel", "london", 7.99, "Classical", 542));
        books.put("metro", new Book("metro","gluhovsky",0.99, "Pulpfiction", 311));
    }

    public static synchronized Map<String, Book> getBooks() {

        return books;
    }

    public static synchronized void add(Book book){

        books.put(book.getName(), book);
    };
}
