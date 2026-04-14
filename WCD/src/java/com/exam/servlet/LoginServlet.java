
package com.exam.servlet;
import com.exam.entity.User;
import javax.persistence.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
 EntityManagerFactory emf=Persistence.createEntityManagerFactory("WCDPU");
 protected void doPost(HttpServletRequest req,HttpServletResponse resp)throws ServletException,IOException{
  EntityManager em=emf.createEntityManager();
  try{
   User u=em.createQuery("SELECT u FROM User u WHERE u.username=:u AND u.password=:p",User.class)
   .setParameter("u",req.getParameter("username"))
   .setParameter("p",req.getParameter("password"))
   .getSingleResult();
   req.getSession().setAttribute("user",u.getUsername());
   resp.sendRedirect("welcome.jsp");
  }catch(Exception e){
   req.setAttribute("error","Invalid");
   req.getRequestDispatcher("login.jsp").forward(req,resp);
  }finally{em.close();}
 }
}
