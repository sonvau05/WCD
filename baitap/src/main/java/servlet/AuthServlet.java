package servlet;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/auth")
public class AuthServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String user = request.getParameter("username");
        String pass = request.getParameter("password");

        if ("admin".equals(user) && "123456".equals(pass)) {

            HttpSession session = request.getSession();
            session.setAttribute("user", user);

            response.sendRedirect("dashboard");
        } else {
            response.sendRedirect("login.html");
        }
    }
}