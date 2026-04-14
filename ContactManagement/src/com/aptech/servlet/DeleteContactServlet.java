package com.aptech.servlet;
import javax.servlet.*;import javax.servlet.http.*;import javax.servlet.annotation.*;
import java.io.IOException;
import com.aptech.dao.ContactDAO;
@WebServlet("/DeleteContactServlet")
public class DeleteContactServlet extends HttpServlet{
 protected void doGet(HttpServletRequest req,HttpServletResponse res)throws IOException{
  int id=Integer.parseInt(req.getParameter("id"));
  new ContactDAO().delete(id);
  res.sendRedirect("ListContacts.jsp");
 }
}
