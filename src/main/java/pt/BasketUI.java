package pt;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import pt.book.Book;

import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/basketUI")
public class BasketUI extends HttpServlet {

    public static final String HTML_BEGIN = "<html><head>\n</head><body>";
    public static final String HTML_END = "</body></html>";
    public static final String HTML_RETURN = "<p><a href=\"./\">Back</a</p>";

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException {

        response.getWriter().append(HTML_BEGIN);
        HttpSession httpSession = request.getSession();
        List<Book> myBasket = (List<Book>) httpSession.getAttribute("MyBasket");

        if (myBasket != null && myBasket.size() != 0) {

            response.getWriter().append("<p>Basket:</p>");

            for (Book b : myBasket) {

                response.getWriter().append("<p> Name : " + b.getName() + " Author : " + b.getAuthor() + " Price : " + b.getPrice() + " Category : "
                        + b.getCategory() + " Pages : " + b.getNumberofPages() + "</p>");
            }

        } else {

            response.getWriter().append("<p>Basket is empty</p>");
        }


        response.getWriter().append(HTML_RETURN);
        response.getWriter().append(HTML_END);



                }

}
