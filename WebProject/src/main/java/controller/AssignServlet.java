
package controller;

import dao.DAO;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/assign")
public class AssignServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("categories", new DAO().getAllCategories());
        request.setAttribute("prodId", request.getParameter("prodId"));
        request.setAttribute("prodName", request.getParameter("prodName"));
        request.getRequestDispatcher("assign.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String prodId = request.getParameter("prodId");
        String newCatId = request.getParameter("newCatId");
        new DAO().updateProductCategory(prodId, newCatId);
        response.sendRedirect("product?catId=" + newCatId);
    }
}
