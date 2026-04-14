
package com.exam.servlet;
import com.exam.entity.User;
import javax.persistence.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
 EntityManagerFactory emf=Persistence.createEntityManagerFactory("WCDPU");
 protected void doPost(HttpServletRequest req,HttpServletResponse resp)throws ServletException,IOException{
  EntityManager em=emf.createEntityManager();
  try{
   User u=new User(req.getParameter("username"),req.getParameter("email"),req.getParameter("password"));
   em.getTransaction().begin();
   em.persist(u);
   em.getTransaction().commit();
   resp.sendRedirect("login.jsp");
  }catch(Exception e){
   req.setAttribute("error","Error");
   req.getRequestDispatcher("register.jsp").forward(req,resp);
  }finally{em.close();}
 }
}
