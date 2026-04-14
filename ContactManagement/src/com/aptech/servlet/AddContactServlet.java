package com.aptech.servlet;
import javax.servlet.*;import javax.servlet.http.*;import javax.servlet.annotation.*;
import java.io.IOException;
import com.aptech.dao.*;import com.aptech.entity.*;
@WebServlet("/AddContactServlet")
public class AddContactServlet extends HttpServlet{
 protected void doPost(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException{
  String f=req.getParameter("firstName");
  String l=req.getParameter("lastName");
  String p=req.getParameter("phoneNumber");
  int gid=Integer.parseInt(req.getParameter("groupId"));
  if(f.isEmpty()||l.isEmpty()||p.isEmpty()||!p.matches("\\d+")){
   res.sendRedirect("AddContact.jsp"); return;
  }
  GroupDAO gdao=new GroupDAO();
  Group g=gdao.getAll().stream().filter(x->x.getId()==gid).findFirst().get();
  Contact c=new Contact();
  c.setFirstName(f);c.setLastName(l);c.setPhoneNumber(p);c.setGroup(g);
  new ContactDAO().add(c);
  res.sendRedirect("ListContacts.jsp");
 }
}
