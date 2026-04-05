
package controller;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/auth")
public class AuthServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String fname = request.getParameter("fname");
        String lname = request.getParameter("lname");
        String pass1 = request.getParameter("pass1");
        String pass2 = request.getParameter("pass2");

        if(pass1 != null && pass1.equals(pass2)) {
            Cookie cFname = new Cookie("fname", fname);
            Cookie cLname = new Cookie("lname", lname);
            cFname.setMaxAge(60*60);
            cLname.setMaxAge(60*60);
            response.addCookie(cFname);
            response.addCookie(cLname);
            response.sendRedirect("display.jsp");
        } else {
            request.setAttribute("errorMsg", "Two password must be same");
            request.getRequestDispatcher("input.jsp").forward(request, response);
        }
    }
}
