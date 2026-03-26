package servlet;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import jakarta.persistence.EntityManager;

import model.User;
import util.JPAUtil;

import java.io.IOException;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String pass = request.getParameter("password");

        if (name.isEmpty() || email.isEmpty() || pass.isEmpty()) {
            request.setAttribute("msg", "Không được để trống!");
            request.getRequestDispatcher("register.jsp").forward(request,response);
            return;
        }

        EntityManager em = JPAUtil.getEMF().createEntityManager();

        em.getTransaction().begin();

        User user = new User();
        user.setName(name);
        user.setEmail(email);
        user.setPassword(pass);

        em.persist(user);

        em.getTransaction().commit();
        em.close();

        request.setAttribute("msg", "Đăng ký thành công!");
        request.getRequestDispatcher("register.jsp").forward(request,response);
    }
}