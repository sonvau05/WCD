
package controller;

import dao.DAO;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/product")
public class ProductServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String catId = request.getParameter("catId");
        request.setAttribute("products", new DAO().getProductsByCatId(catId));
        request.getRequestDispatcher("productlist.jsp").forward(request, response);
    }
}
