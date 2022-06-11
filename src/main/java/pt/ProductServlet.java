package pt;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import pt.book.Book;
import pt.book.BookService;

import java.io.IOException;
import java.util.Map;

@WebServlet(urlPatterns = "/products")

public class ProductServlet extends HttpServlet {
    public static final String HTML_BEGIN = "<html><head>\n</head><body>";
    public static final String HTML_END = "</body></html>";
    public static final String HTML_RETURN = "<p><a href=\"./\">Back</a</p>";
    public static final String NAME = "name";
    public static final String AUTHOR = "author";
    public static final String PRICE = "price";
    public static final String CATEGORY = "category";
    public static final String NUMBER_OF_PAGES = "numberOfPages";
    private Map<String, Book> books = null;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        books = BookService.getBooks();

    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException {

        String id = request.getParameter(NAME);
        Book findBook = books.get(id);
        response.getWriter().append(HTML_BEGIN);

        if (findBook != null) {
            response.getWriter().append("<p> Name : " + findBook.getName() + " Author : " + findBook.getAuthor() + " Price : " + findBook.getPrice() + " Category : "
                    + findBook.getCategory() + " Pages : " + findBook.getNumberofPages());
            response.getWriter().append("<p><p><a href=\"./basket?name=" + findBook.getName() + "\">Add to basket<a></p>");
        } else {
            response.getWriter().append("Unknown product");

        }
        response.getWriter().append(HTML_RETURN);
        response.getWriter().append(HTML_END);


    }



    protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws IOException{



        String bName = request.getParameter(NAME);
        String bAuthor = request.getParameter(AUTHOR);
        String bPrice = request.getParameter(PRICE);
        String bCategory = request.getParameter(CATEGORY);
        String bNumberOfPages = request.getParameter(NUMBER_OF_PAGES);

        Book book = new Book(bName, bAuthor, Double.valueOf(bPrice), bCategory,Integer.valueOf(bNumberOfPages));
        BookService.add(book);


        response.getWriter().append("<p>Book Added!</p>");
        response.getWriter().append(HTML_RETURN);
        response.getWriter().append(HTML_END);

    }
}
