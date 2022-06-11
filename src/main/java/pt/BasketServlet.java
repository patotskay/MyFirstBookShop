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
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@WebServlet(urlPatterns = "/basket")

public class BasketServlet extends HttpServlet {
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



        String bName = request.getParameter(NAME);



        Book sb = books.get(bName);


        Object mb = request.getSession().getAttribute("MyBasket");

       /* List<Book> list = new ArrayList<>();
        list.add(sb);
        request.getSession().setAttribute("MyBasket", list);
*/
        if (mb != null) {
            List<Book> list = (List<Book>) mb;
            list.add(sb);

            System.out.println(">>>>>>>>>>>>>"+ list);
        } else {
            List<Book> list = new ArrayList<>();
            list.add(sb);
            request.getSession().setAttribute("MyBasket", list);
            System.out.println(">>>>>>>>>>>>>"+ list);

        }
        response.getWriter().append(HTML_BEGIN);
        response.getWriter().append("Book added!");
        response.getWriter().append(HTML_RETURN);
        response.getWriter().append(HTML_END);


    }




}
